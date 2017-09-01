package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangminghui on 2017/6/2.
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
        return null;
    }
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Solution1 solution = new Solution1();
        System.out.println(solution.twoSum(nums, target).toString());
    }
}
