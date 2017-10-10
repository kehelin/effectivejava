package jvm;

/**
 * -XX:-DoEscapeAnalysis -XX:-EliminateAllocations -XX:-UseTLAB -XX:+PrintGC
 * 关闭逃逸分析，关闭标量替换，关闭线程本地内存，打印gc
 */

public class T01 {
	class User{
		int id;
		String name;
		User(int id,String name) {
			this.id = id;
			this.name = name;
		}
	}
	void alloc(int i) {
		User u = new User(i,"name"+i);
	}
	public static void main(String[] args) {
		T01 t = new T01();
		long t1 = System.currentTimeMillis();
		for(int i=0;i<10000000;i++){
			t.alloc(i);
		}
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);

	}
}
