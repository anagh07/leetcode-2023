package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LC424LongestRepeatingCharReplacement {

    public static void main(String[] args) {
//        String s = "AABABBA";
//        int k = 1;

//        String s = "ABAB";
//        int k = 2;

        String s = "A";
        int k = 0;

        System.out.println(characterReplacement(s, k));
        System.out.println(characterReplacementOptimized(s, k));
    }

    public static int characterReplacement(String s, int k) {
        /*
        Use sliding window (two pointer) over the string.
        - keep incrementing right-pointer until (substring.len - feq.element) <= k
         */
        int l = 0, result = 0;
        Map<Character, Integer> count = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            count.computeIfPresent(s.charAt(r), (key, value) -> value + 1);
            count.putIfAbsent(s.charAt(r), 1);

            if ((r - l + 1) - calcFreqElement(count) > k) {
                count.computeIfPresent(s.charAt(l), (key, value) -> value - 1);
                l++;
            } else {
                result = Math.max(result, r - l + 1);
            }
        }

        return result;
    }

    /*
    This is the optimized solution from @Neetcode which uses ascii values of characters
    and a trick to find the max occurring character
     */
    public static int characterReplacementOptimized(String s, int k) {
        int[] arr = new int[26];
        int ans = 0;
        int max = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            arr[s.charAt(j) - 'A']++;
            max = Math.max(max, arr[s.charAt(j) - 'A']);
            if (j - i + 1 - max > k) {
                arr[s.charAt(i) - 'A']--;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    private static int calcFreqElement(Map<Character, Integer> count) {
        int max = 0;
        for (Character character : count.keySet()) {
            max = Math.max(max, count.get(character));
        }
        return max;
    }
}
