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
        for(Integer val :new Solution442().findDuplicates1(nums)){
            System.out.println(val);
        }
    }
    public List<Integer> findDuplicates(int[] nums) {
        Set<String> set = new HashSet<String>();
        List<Integer> result = new ArrayList<Integer>();
        for(int val : nums) {
            String valStr = String.valueOf(val);
            if(set.contains(valStr)) {
                result.add(val);
            }else {
                set.add(valStr);
            }
        }
        return result;
    }

    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++){
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0) {
                res.add(Math.abs(nums[i]));
            } else {
                nums[idx] = - nums[idx];
            }
        }
        return res;
    }
}
