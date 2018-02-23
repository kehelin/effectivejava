
import sun.awt.Mutex;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
	public static void main(String[] args) {
		new Test().test();
		Integer i = new Integer(1);
		System.out.print(i);
		ReentrantLock lock = new ReentrantLock();
		lock.lock();
		lock.unlock();
		ThreadPoolExecutor pool = new ThreadPoolExecutor(1,1,0,null,new ArrayBlockingQueue<Runnable>(100));
		pool.submit(() -> {
			try{
				Thread.sleep(1000);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		});

	}
	static void change(Integer i) {
		i = 2;
	}
	public void test() {
		Bean i = new Bean(1);
		change(i);
		System.out.println(i.i);

	}
	void change(Bean i){
		i = new Bean(2);
	}
	class Bean{
		int i;
		Bean(int i){
			this.i = i;
		}

	}
}
