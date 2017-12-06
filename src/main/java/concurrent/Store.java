package concurrent;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by wangminghui on 2017/3/6.
 */
public class Store {
    private final int MAXNUM = 100;

    Queue<String> list = new LinkedBlockingQueue<String>();

    public static void mian(String[] args) {
        
    }
}
