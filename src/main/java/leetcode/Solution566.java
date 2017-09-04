package leetcode;

/**
 * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.

 You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.

 The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

 If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

 Example 1:
 Input:
 nums =
 [[1,2],
 [3,4]]
 r = 1, c = 4
 Output:
 [[1,2,3,4]]
 Explanation:
 The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
 Example 2:
 Input:
 nums =
 [[1,2],
 [3,4]]
 r = 2, c = 4
 Output:
 [[1,2],
 [3,4]]
 Explanation:
 There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
 */
public class Solution566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums.length* nums[1].length != r * c) {
            return nums;
        }
        int[][] newNums = new int[r][c];
        int row = 0;
        int colum = 0;
        for(int i =0;i<nums.length;i++) {
            for(int j=0; j<nums[i].length;j++) {
                newNums[row][colum++] = nums[i][j];
                if(colum == c) {
                    row++;
                    colum=0;
                }
            }
        }
        return newNums;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2},{3,4}};
        print(nums);
        print(new Solution566().matrixReshape(nums,1,4));

    }

    public static void print(int[][] nums) {
        if(nums == null) {
            System.out.println("null");
        }
        for(int i=0;i<nums.length;i++) {
            System.out.print("[");
            for (int j=0;j<nums[i].length;j++) {
                System.out.print(nums[i][j]);
                if(j != nums[i].length-1) {
                    System.out.print(",");
                }else {
                    System.out.println("]");
                }
            }
        }
    }
}
