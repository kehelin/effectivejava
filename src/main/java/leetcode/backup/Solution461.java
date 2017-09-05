package leetcode.backup;

/**
 * Created by xwz on 2017/6/1.
 *  The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

 Given two integers x and y, calculate the Hamming distance.
 Note:
 0 ≤ x, y < 231.

 Example:
 Input: x = 1, y = 4
 Output: 2

 Explanation:
 1   (0 0 0 1)
 4   (0 1 0 0)
        ↑   ↑
 The above arrows point to positions where the corresponding bits are different.
 */
public class Solution461 {
    public static void main(String[] args) {
        Solution461 solution = new Solution461();
        System.out.println(solution.hammingDistance(255,16));
    }
    public int hammingDistance(int x, int y) {
        int temp = x ^ y;
        int result = 0;
        while(temp != 0) {
            if((temp%2)==1){
                result++;
            }
            temp>>=1;
        }
        return result;
    }
}
