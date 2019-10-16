package leetcode;

import java.util.HashMap;

/**
 * @author wangminghui
 * @since 2019/5/6
 * <p>
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Solution3 {
    public static void main(String[] args) {
        String input = "tmmzuxt";
        System.out.println("input:" + input + "\nresult:" + lengthOfLongestSubstring3(input));
    }


    public static int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 1, n = s.length();
        HashMap<Character, Integer> sMap = new HashMap(16, 0.8F);
        for (int i = 0, j = 0; j < n; j++) {
            if (sMap.containsKey(s.charAt(j))) {
                int target = sMap.get(s.charAt(j));
                result = j - i > result ? j - i : result;
                for (int temp = i; temp < target; temp++) {
                    sMap.remove(s.charAt(temp));
                }
                sMap.put(s.charAt(j), j);
                i = target + 1;
            } else if (j == s.length() - 1) {
                return Math.max(result, j - i + 1);
            } else {
                sMap.put(s.charAt(j), j);
            }
            if (n - i < result) {
                return result;
            }
        }
        return result;
    }

    public static int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int result = 0;
        int i = 0;
        while (i < s.length()) {
            int j = i + 1;
            int preIndex;
            while (j < s.length()) {
                preIndex = checkChar(s, i, j);
                if (preIndex >= 0) {
                    if (j - i > result) {
                        result = j - i;
                    }
                    i = preIndex;
                    break;
                } else if (j == s.length() - 1) {
                    return Math.max(result, j - i + 1);
                }
                j++;
            }
            i++;
            if (s.length() - i <= result) {
                return result;
            }
        }
        return result;
    }

    public static int checkChar(String s, int i, int j) {
        for (int temp = i; temp < j; temp++) {
            if (s.charAt(temp) == s.charAt(j)) {
                return temp;
            }
        }
        return -1;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int result = 1;

        int i = 0;

        while (i < s.length()) {
            int j = i + 1;
            HashMap<Character, Integer> charMap = new HashMap<>();
            charMap.put(s.charAt(i), i);
            while (j < s.length()) {
                if (charMap.containsKey(s.charAt(j))) {
                    result = result > j - i ? result : j - i;
                    i = charMap.get(s.charAt(j));
                    break;
                } else if (j == s.length() - 1) {
                    return result > j - i + 1 ? result : j - i + 1;
                }
                charMap.put(s.charAt(j), j);
                j++;
            }
            if (result > s.length() - i) {
                return result;
            }
            i++;
        }
        return result;
    }
}
