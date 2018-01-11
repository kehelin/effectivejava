package concurrent;

import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by wangminghui on 2017/3/6.
 */
public class PrintInt {
	private final int MAXNUM = 100;

	//	static Queue<String> list = new LinkedBlockingQueue<String>();
	static Object lock = new Object();
	static volatile int count = 1;
	static CountDownLatch cdl = new CountDownLatch(2);

	public static void main(String[] args) {
		new Thread(() -> {

			while (count <= 100) {
					synchronized (lock) {
						if (count % 2 == 0) {
							System.out.println(Thread.currentThread().getName() + ":" + count);
							count++;
							lock.notify();
						} else {
							try {
								lock.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}


						}

				}

			}
			cdl.countDown();

		}).start();
		new Thread(() -> {

			while (count <= 100) {
				synchronized (lock) {
					if (count % 2 == 1) {
						System.out.println(Thread.currentThread().getName() + ":" + count);
						count++;
						lock.notify();
					} else {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}


					}
				}

			}

			cdl.countDown();


		}).start();
		try {
			cdl.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
