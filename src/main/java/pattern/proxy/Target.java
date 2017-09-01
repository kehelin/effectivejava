package pattern.proxy;

/**
 * Created by wangminghui on 2017/3/11.
 */
public class Target implements ITarget {
    public void work() {
        System.out.println("tar");
    }
}
