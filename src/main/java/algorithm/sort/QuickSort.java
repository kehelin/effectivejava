package algorithm.sort;

public class QuickSort {
//	static int[] input = {23,4,7,9,24,32,87,6,5,32,45,4,5,6,7,7};
	private static int[] input = {3,2};
	private static int count;

	public static void main(String args[]) {

		for(int value : input) {
			System.out.print(value + ",");
		}
		System.out.println();
		quickSort(input,0,input.length-1);
		for(int value : input) {
			System.out.print(value + ",");
		}
	}

	public static void quickSort(int[] nums,int start, int end) {
		if(start == end) {
			return;
		}
		int povit = nums[end];
		int i = start;
		int j = end;
		while (i<j) {
			while(i<j) {
				if(nums[i] > povit) {
					swap(nums,i,j--);
					break;
				}
				i++;
			}
			while(i<j) {
				if(nums[j]< povit) {
					swap(nums,i++,j);
					break;
				}
				j--;
			}
		}

		if(i>start) {
			quickSort(nums,start,i-1);
		}
		if(j<end) {
			quickSort(nums,j+1,end);
		}


	}

	private static void swap(int[] nums,int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
		count++;
	}


}
