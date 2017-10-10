package jvm;
/**
 * 模拟栈内存溢出
 * -Xss128k 256k
 */
public class T05 {
	static int count=0;
	static void r() {
		count++;
		r();
	}
	public static void main(String[] args) {
		try{
			r();
		} catch(Throwable t) {
			System.out.println(count++);
//			t.printStackTrace();
		}
	}
}
