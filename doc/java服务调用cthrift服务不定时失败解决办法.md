#1.背景
在服务中通过java调用cthrift服务的过程中，发现调用会不定时的调用失败，影响整体接口成功率，调用端错误日志如下

    2019-01-02 17:03:51.955 - - [ERROR] qtp357653585-37 RenderToolsServiceProxy #XMDT#{__traceId__=385068503538490424}#XMDT# renderToolsService.put报错
    org.apache.thrift.TException: mtthrift remote(10.32.225.40:8420) invoke(put) Exception
    at com.meituan.service.mobile.mtthrift.client.invoker.MTThriftMethodInterceptor.wrapException(MTThriftMethodInterceptor.java:652) ~[mtthrift-1.8.5.9.jar!/:1.8.5.9]
    at com.meituan.service.mobile.mtthrift.client.invoker.MTThriftMethodInterceptor.syncRpcInvoke(MTThriftMethodInterceptor.java:464) ~[mtthrift-1.8.5.9.jar!/:1.8.5.9]
    at com.meituan.service.mobile.mtthrift.client.invoker.MTThriftMethodInterceptor.getRpcResult(MTThriftMethodInterceptor.java:360) ~[mtthrift-1.8.5.9.jar!/:1.8.5.9]
    at com.meituan.service.mobile.mtthrift.client.invoker.MTThriftMethodInterceptor.doInvoke(MTThriftMethodInterceptor.java:259) ~[mtthrift-1.8.5.9.jar!/:1.8.5.9]
    at com.meituan.dorado.rpc.handler.filter.InvokeChainBuilder$1.handle(InvokeChainBuilder.java:40) ~[mtthrift-1.8.5.9.jar!/:1.8.5.9]

#2. 原因分析
经调用端日志发现在调用过程中调用端直接报错断开连接，而服务端回写返回数据时连接已经断开

#3. 解决方案
经咨询thrift支持同学给的建议按照Cthrift统一协议使用指南方式配置统一协议，最终解决了不定时调用失败问题
调用端应按照文档要求升级thrift端版本（文档提供版本1.8.4.2，建议使用最新稳定版）同时开启使用netty io,在客户端超时的情况下不断开连接
服务端使用新发布的cthrift rpm包，version >= 2.6.3
    
    yum localinstall cthrift-2.7.0

设置接口名，这个是idl文件里面使用的java的namespace + servivcename，CthriftSvr的构造函数里面进行设置。

#4. 注意事项
在使用统一协议过程中java调用端在开启nettyio时遇到一个容易错误的点，在使用springboot注解注入bean时要注意thriftClientProxy.setNettyIO(true);的位置一定要在thriftClientProxy.afterPropertiesSet();之前，否则会导致配置失效，示例如下
    
    @Bean(value = "renderTools", destroyMethod = "destroy")
    public ThriftClientProxy renderTools() throws Exception {
        ThriftClientProxy thriftClientProxy = new ThriftClientProxy();
        thriftClientProxy.setAppKey(appName);
        thriftClientProxy.setServiceInterface(com.meituan.map.render.rendertools.thrift.rendertools_service.class);
        thriftClientProxy.setRemoteAppkey("com.sankuai.map.render.rendertools");
        thriftClientProxy.setRemoteUniProto(true);
        thriftClientProxy.setTimeout(1000);
        thriftClientProxy.setNettyIO(true);
        thriftClientProxy.afterPropertiesSet();
        return thriftClientProxy;
    }
