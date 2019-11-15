package leetcode;

public class Solution657 {
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) {
            return true;
        }
        if (moves.length() % 2 == 1) {
            return false;
        }
        int x = 0;
        int y = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'U':
                    y += 1;
                    break;
                case 'D':
                    y -= 1;
                    break;
                case 'R':
                    x += 1;
                    break;
                case 'L':
                    x -= 1;
                    break;
            }
            if (x + y > moves.length()) {
                return false;
            }
        }
        if (x == 0 && y == 0) {
            return true;
        }
        return false;

    }
}
