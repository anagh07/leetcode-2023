package SlidingWindow;

import java.util.Arrays;

public class LC567PermutationInString {

    public static void main(String[] args) {
//        String s1 = "ab", s2 = "eidbaooo";
//        String s1 = "ab", s2 = "eidboaoo";
        String s1 = "adc", s2 = "dcda";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        int[] s1Count = new int[26];
        int[] s2SubStrings = new int[26];
        Arrays.fill(s2SubStrings, 0);
        Arrays.fill(s1Count, 0);

        for (int i = 0; i < s1.length(); i++) {
            s1Count[(int) s1.charAt(i) - 97]++;
            s2SubStrings[(int) s2.charAt(i) - 97]++;
        }

        for (int pr = s1.length(), pl = 0; pr < s2.length(); pl++, pr++) {
            if (Arrays.equals(s1Count, s2SubStrings)) return true;
            s2SubStrings[(int) s2.charAt(pl) - 97]--;
            s2SubStrings[(int) s2.charAt(pr) - 97]++;
        }
        return Arrays.equals(s1Count, s2SubStrings);
    }
}
