package pattern.strategy;

public class Test {
	public static void main(String[] args) {
//		int[] a = {9,5,3,7,1};


		Cat[] a = {new Cat(1,1),new Cat(5,5), new Cat(3,3)};
		DataSouter.sort(a);
		DataSouter.p(a);
	}
}
