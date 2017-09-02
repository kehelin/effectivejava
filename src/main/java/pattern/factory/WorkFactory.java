package pattern.factory;

/**
 * Created by wangminghui on 2017/3/11.
 */
public class WorkFactory {
    public IWork getWork(String name) {
        if (name == null) {
            return null;
        }
        if(name == "A") {
            return new WorkA();
        }else if(name == "B") {
            return new WorkB();
        }
        return null;
    }
}
