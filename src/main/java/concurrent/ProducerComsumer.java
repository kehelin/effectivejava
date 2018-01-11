package concurrent;

import sun.nio.ch.ThreadPool;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

/**
 * Created by wangminghui on 2017/3/6.
 */

public class ProducerComsumer {
    BlockingQueue<String> queue = new LinkedTransferQueue<>();

    public void run() {
        for(int i = 0; i<10;i++ ) {
            new Thread( () ->{
                queue.put
            },"Producer" + i).start();
        }
        }



}
