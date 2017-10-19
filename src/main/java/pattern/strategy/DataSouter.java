package pattern.strategy;

public class DataSouter {
	public static void sort(int[] a) {
		for(int i=a.length-1;i>0;i--) {
			for(int j=0;j<i;j++){
				if(a[j] > a[j+1]) {
					swap(a,j,j+1);
				}
			}
		}
	}
	private static void swap(int[] a,int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void sort(Object[] a) {
		for(int i=a.length-1;i>0;i--) {
			for(int j=0;j<i;j++){
				Comparable o1 = (Comparable) a[j];
				Comparable o2 = (Comparable) a[j+1];
				if(o1.compareTo(o2)>0) {
					swap(a,j,j+1);
				}
			}
		}
	}

	private static void swap(Object[] a,int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	private static void swap(Cat[] a,int i, int j) {
		Cat temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	public static void p(Object[] a){
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i] + " ");
		}
	}
}
