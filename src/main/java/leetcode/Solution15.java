package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Solution15 {

    public static void main(String[] args) {
        int[] input = {-1, 0, 1, 2, -1, -4};
        ;
        System.out.println("[");
        for (List<Integer> list : threeSum(input)) {
            System.out.println("\t" + Arrays.toString(list.toArray()));
        }
        System.out.println("]");
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int mark = nums[i] + nums[left] + nums[right];
                if (mark == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    while (left < right && nums[left + 1] == nums[left]) left++;
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (mark < 0) {
                    left++;
                } else {
                    right--;
                }

            }

        }
        return result;

    }


}
