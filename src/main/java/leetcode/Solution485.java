package leetcode;

public class Solution485 {
    public static void main(String[] args) {
        System.out.println(new Solution485().findMaxConsecutiveOnes(new int[1]));
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==1) {
                count++;
            } else {
                if(count>result) result = count;
                if(i+result>nums.length) {
                    break;
                }
                count=0;
            }
        }
        return result;
    }
}
