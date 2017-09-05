package leetcode;

import java.util.*;

/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

 Find all the elements that appear twice in this array.

 Could you do it without extra space and in O(n) runtime?

 Example:
 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [2,3]
 */
public class Solution442 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        for(Integer val :new Solution442().findDuplicates(nums)){
            System.out.println(val);
        }
    }
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++) {
            int temp = Math.abs(nums[i])-1;
            if(nums[temp]<0) {
                result.add(Math.abs(nums[i]));
            }else {
                nums[temp] = -nums[temp];
            }
        }
        return result;
    }

}
