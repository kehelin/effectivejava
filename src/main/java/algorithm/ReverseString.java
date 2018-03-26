package algorithm;

import java.util.Arrays;

public class ReverseString {
	public static String input = "abcd e sdf ghijkl";

	public static void main(String[] args) {
		System.out.println(reverseWord(input));

	}

	public static String reverseWord(String input) {
		char[] charArray = input.toCharArray();
		int current = 0;
		int mark = -1;
		while (current < charArray.length) {
			if ((charArray[current] >='a'&& charArray[current] <= 'z')
				|| (charArray[current] >= 'A' && charArray[current] <= 'Z')) {
				if (mark < 0) {
					mark = current;
				}
				current++;
				continue;
			} else {
				if (mark >= 0 && current > mark + 1) {
					reverse(charArray, mark, current - 1);
					mark = -1;

				}else {
					mark=-1;
				}
				current++;
			}

		}
		if (mark > 0 && current > mark + 1) {
			reverse(charArray, mark, current - 1);
		}
		reverse(charArray, 0, charArray.length - 1);
		return String.valueOf(charArray);
	}

	public static char[] reverse(char[] input, int start, int end) {
		if (input == null || input.length <= 1) {
			return input;
		}

		while (start < end) {
			char temp = input[start];
			input[start] = input[end];
			input[end] = temp;
			start++;
			end--;
		}
		return input;
	}

}
