package pattern.proxy;

/**
 * Created by wangminghui on 2017/3/11.
 */
public class Proxy implements ITarget{
    private ITarget target;
    Proxy(ITarget target) {
        this.target  = target;
    }
    public void work() {
        this.work();
    }
}
