package leetcode.backup;

/**
 * Created by xwz on 2017/6/1.
 Given an array of 2n integers, your task is to group these integers into n pairs of integer,
 say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n
 as large as possible.

 Example 1:
 Input: [1,4,3,2]

 Output: 4
 Explanation: n is 2, and the maximum sum of pairs is 4.
 Note:
 n is a positive integer, which is in the range of [1, 10000].
 All the integers in the array will be in the range of [-10000, 10000].
 */
public class Solution561 {
    static int[] input = {7,3,1,0,0,6};
    public static void main(String[] args) {
        Solution561 solution = new Solution561();
        System.out.print(solution.arrayPairSum(input));
    }
    public int arrayPairSum(int[] nums) {
        quickSort(nums,0,nums.length-1);
        int result = 0;
        for(int i = 0; i<nums.length;i+=2) {
            result += nums[i];
        }
        return result;
    }

    public static void quickSort(int[] nums,int start, int end) {
        if(start == end) {
            return;
        }
        int povit = nums[end];
        int i = start;
        int j = end;
        while (i<j) {
            while(i<j) {
                if(nums[i] > povit) {
                    swap(nums,i,j--);
                    break;
                }
                i++;
            }
            while(i<j) {
                if(nums[j]< povit) {
                    swap(nums,i++,j);
                    break;
                }
                j--;
            }
        }

        if(i>start) {
            quickSort(nums,start,i-1);
        }
        if(j<end) {
            quickSort(nums,j+1,end);
        }


    }

    private static void swap(int[] nums,int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

}
