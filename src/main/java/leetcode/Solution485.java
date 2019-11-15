package leetcode;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * <p>
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 * Note:
 * <p>
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 */
public class Solution485 {
    public static void main(String[] args) {
        int[] input = {1};
        System.out.println(new Solution485().findMaxConsecutiveOnes(input));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                if (count > result) result = count;
                if (i + result > nums.length) {
                    break;
                }
                count = 0;
            }
        }
        return result > count ? result : count;
    }
}
