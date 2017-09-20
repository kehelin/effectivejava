package leetcode.backup;

public class Solution647 {
    public static void main(String[] args){
        System.out.println(new Solution647().countSubstrings("fdsklf"));
    }
    public int countSubstrings(String s){
        if(s ==null|| s.length()==0) {
            return 0;
        }
        int totalcount = s.length();
        for(int i=1;i<s.length();i++){
            int x=1;
            while(i+x<s.length()&&i-x>=0){
                if(s.charAt(i+x) != s.charAt(i-x)){
                    break;
                }
                totalcount++;
                x++;
            }
            x=0;
            while(i+x<s.length()&&i-x-1>=0){
                if(s.charAt(i+x) != s.charAt(i-x-1)){
                    break;
                }
                totalcount++;
                x++;
            }

        }
        return totalcount;
    }
    public int countSubstrings1(String s) {
        int count=s.length();
        int i=0;
        while(i<s.length()-1){
            for(int j=s.length()-1;j>i;j--){
                if(s.charAt(i)== s.charAt(j)){
                    int x=i+1;
                    int y=j-1;
                    boolean flag =true;
                    while(x<y){
                        if(s.charAt(x)!=s.charAt(y)){
                            flag =false;
                            break;
                        }
                        x++;
                        y--;
                    }
                    if(flag){
                        count+=1;
                    }

                }
            }
            i++;
        }
        return count;
    }


}
