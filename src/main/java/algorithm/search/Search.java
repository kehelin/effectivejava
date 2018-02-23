package algorithm.search;

public class Search {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,6,7,8,9,10};
		int target = 5;
		System.out.println(search(nums,target));
	}
	static int search(int[] num, int i) {
		if(num == null || num.length == 0) {
			return -1;
		}
		int start = 0;
		int end = num.length-1;
		int count = 0;
		while (start <= end) {
			int mid = (start+end)/2;
			if (num[mid] == i) {
				return mid;
			}else if(num[mid] >i) {
				end = mid-1;
			}else {
				start = mid+1;
			}
			System.out.println(++count);
		}
		return -1;
	}
}
