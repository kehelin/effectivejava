package algorithm.sort;

public class QuickSort3 {
	public static void main(String[] args) {
		int[] input = {123, 54,2134,7645,8865,9,43};
		quickSort(input,0,input.length-1);

		for(int i : input) {
			System.out.print(i+",");
		}
	}

	public static void quickSort(int[] input, int start, int end) {
		if (input == null || input.length == 0) {
			return;
		}
		if (end <= start) {
			return;
		}
		int mark = end;
		int left = start;
		int right = end;
		while (left < right) {
			for (;left < right;left++) {
				if (input[mark] < input[left]) {
					swap(input,mark,left);
					mark = left;
					right--;
					break;
				}
			}
			for (;left<right;right--) {
				if(input[mark]> input[right]) {
					swap(input,mark,right);
					mark = right;
					left++;
					break;
				}
			}
		}
		if(mark-1>start){
			quickSort(input,start,mark-1);
		}
		if(mark+1<end) {
			quickSort(input,mark+1,end);
		}
	}

	public static void swap(int[] input, int i, int j) {
		input[i] = input[i] + input[j];
		input[j] = input[i] - input[j];
		input[i] = input[i] - input[j];
	}
}
