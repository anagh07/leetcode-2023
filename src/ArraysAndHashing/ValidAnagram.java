package ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {

    public static void main(String[] args) {
        // Input: s = "anagram", t = "nagaram"
        // s = "rat", t = "car"
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isEfficientAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        ArrayList<String> letters = new ArrayList<>(Arrays.asList(s.split("")));
        for (String letter : letters) {
            if (!t.contains(letter)) {
                return false;
            } else {
                t = t.replaceFirst(letter, "");
            }
        }
        return true;
    }

    public static boolean isEfficientAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            map.computeIfPresent(sChar, (key, val) -> val += 1);
            map.computeIfAbsent(sChar, (key) -> 1);
            map.computeIfPresent(tChar, (key, val) -> val -= 1);
            map.computeIfAbsent(tChar, (key) -> -1);
        }

        for (Character letter : map.keySet()) {
            if (map.get(letter) != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isAlsoAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> wordS = new HashMap<Character, Integer>();
        HashMap<Character, Integer> wordT = new HashMap<Character, Integer>();
        for (Character letter : s.toCharArray()) {
            if (wordS.containsKey(letter)) {
                wordS.put(letter, wordS.get(letter) + 1);
            } else {
                wordS.put(letter, 1);
            }
        }
        for (Character letter : t.toCharArray()) {
            if (wordT.containsKey(letter)) {
                wordT.put(letter, wordT.get(letter) + 1);
            } else {
                wordT.put(letter, 1);
            }
        }
        if (!wordS.equals(wordT)) {
            return false;
        }
        return true;
    }
}
