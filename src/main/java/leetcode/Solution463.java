package leetcode;

public class Solution463 {

    public static void main(String[] args) {
        int[][] input = {{0, 1}, {1, 1}};
        System.out.println(new Solution463().islandPerimeter(input));
    }

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int colum = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            if (grid[i][0] == 1) {
                count++;
            }
            for (int j = 1; j < colum; j++) {
                if (grid[i][j - 1] != grid[i][j]) {
                    count++;
                }
            }
            if (grid[i][colum - 1] == 1) {
                count++;
            }
        }

        for (int j = 0; j < colum; j++) {
            if (grid[0][j] == 1) {
                count++;
            }
            for (int i = 1; i < row; i++) {
                if (grid[i - 1][j] != grid[i][j]) {
                    count++;
                }
            }
            if (grid[row - 1][j] == 1) {
                count++;
            }
        }
        return count;
    }
}
