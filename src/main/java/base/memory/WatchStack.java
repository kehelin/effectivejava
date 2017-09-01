package base.memory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangminghui on 2017/3/12.
 */
public class WatchStack {
    public static void main(String[] args) throws Throwable{
        Map a = new HashMap();
        int value = 0;
        while (true) {
            a.put(String.valueOf(value),value);
            value++;
            Thread.sleep(50);

        }
    }
}
