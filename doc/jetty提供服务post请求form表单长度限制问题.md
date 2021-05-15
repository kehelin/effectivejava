##背景
通过springboot启动jetty服务提供restful接口服务时，使用接口推送数据的场景下发现服务器会返回如下错误

    {
        "timestamp": "2019-01-04 15:03:43",
        "status": 400,
        "error": "Bad Request",
        "message": "Unable to parse form content",
        "path": "/render/tools/put"
    }
经分析是由于post表单过长超过了jetty服务对表单长度的限制导致的问题

系统环境说明：

jetty版本：9.4.7

springboot版本：2.0.0.M7

web启动器：spring-boot-starter-jetty

##原因分析
在http协议中post默认提交方式Content-Type: application/x-www-form-urlencoded方式提交时会将键值对拼接成字符串，作为content发送到server端

通过调试分析发现在org.eclipse.jetty.server.Request类中存在如下代码

    int maxFormContentSize = -1;
    int maxFormKeys = -1;

    if (_context != null)
    {
        maxFormContentSize = _context.getContextHandler().getMaxFormContentSize();
        maxFormKeys = _context.getContextHandler().getMaxFormKeys();
    }

    if (maxFormContentSize < 0)
    {
        Object obj = _channel.getServer().getAttribute("org.eclipse.jetty.server.Request.maxFormContentSize");
        if (obj == null)
            maxFormContentSize = 200000;
        else if (obj instanceof Number)
        {
            Number size = (Number)obj;
            maxFormContentSize = size.intValue();
        }
        else if (obj instanceof String)
        {
            maxFormContentSize = Integer.valueOf((String)obj);
        }
    }

    if (maxFormKeys < 0)
    {
        Object obj = _channel.getServer().getAttribute("org.eclipse.jetty.server.Request.maxFormKeys");
        if (obj == null)
            maxFormKeys = 1000;
        else if (obj instanceof Number)
        {
            Number keys = (Number)obj;
            maxFormKeys = keys.intValue();
        }
        else if (obj instanceof String)
        {
            maxFormKeys = Integer.valueOf((String)obj);
        }
    }

    int contentLength = getContentLength();
    if (contentLength > maxFormContentSize && maxFormContentSize > 0)
    {
        throw new IllegalStateException("Form too large: " + contentLength + " > " + maxFormContentSize);
    }
jetty会从系统中获取post表单的长度进行检查，当post表单过大是便会抛出异常导致请求失败

##解决方案
https://wiki.eclipse.org/Jetty/Howto/Configure_Form_Size官方文档关于文档长度限制的说明给出了三个方案

通过上述代码分析考虑通过设置调大表单的限制，默认配置content长度限制为200000 约一次表单200k数据限制，解决办法

###方案一：
针对单web生效

    <Configure class="org.eclipse.jetty.webapp.WebAppContext">
      <!-- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -->
      <!-- Max Form Size                                                   -->
      <!-- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -->
      <Set name="maxFormContentSize">200000</Set>
    </Configure>
###方案二：
server全局生效

    <configure class="org.eclipse.jetty.server.Server">
          <Call name="setAttribute">
          <Arg>org.eclipse.jetty.server.Request.maxFormContentSize</Arg>
          <Arg>200000</Arg>
        </Call>
    </configure>
###方案三：

java启动脚本中增加

    -Dorg.eclipse.jetty.server.Request.maxFormContentSize=2000000
    
简单粗暴

##结论
因项目采用无xml模式配置，因此选择了方案三，直接在启动参数中添加了配置项，经测试解决表单限制问题，满足当前需求

需要注意的是，不同版本的jetty对于form表单长度限制的参数和生效方式是不同的，可以借鉴本文中的方式定位到相应处理逻辑中，可反推如何在其他版本中设置相应参数