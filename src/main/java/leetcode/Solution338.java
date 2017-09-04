package leetcode;

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
