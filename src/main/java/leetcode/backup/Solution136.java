package leetcode.backup;

import java.util.HashSet;
import java.util.Set;

public class Solution136 {
    public int singlenumber( int[] nums) {
        Set set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        return (Integer)(set.toArray()[0]);
    }
}
