package leetcode;

public class Solution495 {
    public static void main(String[] args) {
        int[] time = {1,2};
        int duration = 2;
        System.out.print(new Solution495().findPoisonedDuration(time,duration));
    }
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries == null || timeSeries.length ==0) {
            return 0;
        }
        int time = 0;
        for(int i=0;i<timeSeries.length-1;i++){
            if(timeSeries[i+1]-timeSeries[i] >=duration){
                time += duration;
            }else {

                time += timeSeries[i+1]-timeSeries[i];
            }
        }
        return time + duration;
    }
}
