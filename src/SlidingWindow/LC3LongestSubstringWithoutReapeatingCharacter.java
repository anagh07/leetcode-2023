package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LC3LongestSubstringWithoutReapeatingCharacter {

    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 1, max = 0;
        Set<Character> charSet = new HashSet<>();

        if (s.length() < 2) return s.length();
        charSet.add(s.charAt(l));

        while (r < s.length()) {
            if (!charSet.contains(s.charAt(r))) {
                charSet.add(s.charAt(r));
                max = Math.max(charSet.size(), max);
                r++;
            } else {
                charSet.remove(s.charAt(l));
                l++;
            }
        }

        return max;
    }
}
