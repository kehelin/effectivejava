package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                tempMap.put(target - nums[i], i);
                continue;
            }
            if (tempMap.containsKey(nums[i])) {
                int[] result = {tempMap.get(nums[i]), i};
                return result;
            } else {
                tempMap.put(target - nums[i], i);
            }
        }
        int[] result = {};
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Solution1 solution = new Solution1();
        System.out.println(solution.twoSum(nums, target).toString());
    }
}
