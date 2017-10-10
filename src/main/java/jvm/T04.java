package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/wangminghui/jvm.dump -Xms10m -Xmx10m -XX:+PrintGCDetails
 * 模拟内存溢出
 */
public class T04 {
	public static void main(String[] args) {
		List temp = new ArrayList();
		for(int i=0;i<1000000000;i++) {
			System.out.println("i:"+ i);
			temp.add(new byte[1024*1024]);
		}

	}
}
