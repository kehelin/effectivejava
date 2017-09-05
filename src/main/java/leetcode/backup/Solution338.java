package leetcode.backup;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

 Example:
 For num = 5 you should return [0,1,1,2,1,2].

 Follow up:

 It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 Space complexity should be O(n).
 Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 Credits:
 Special thanks to @ syedee for adding this problem and creating all test cases.
 */
public class Solution338 {
    public static void main(String[] args) {
        for(int i : new Solution338().countBits(8)){
            System.out.println(i);
        }
    }
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        result[0] = 0;
        for(int i=1;i<=num;i++) {
            int level = getLevel(i);
            result[i] = 1 + result[i&(level-1)];
        }
        return result;
    }

    public int getLevel(int num) {
        if(num ==0) {
            return 0;
        }
        int level = 1;
        while(num >1) {
            num = num>>1;
            level <<=1;
        }
        return level;
    }
}
