package ArraysAndHashing;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagramsOptimized(words));
        System.out.println((int) 'a');
    }

    public static List<List<String>> groupAnagramsOptimized(String[] strs) {
        // HashMap where the key is array of characters (a-z) and value is the word
        Map<List<Integer>, List<String>> grouped = new HashMap<>();

        for (String word : strs) {
            // Array a-z count { 0, 0 .... 0 }
            List<Integer> letterCount = new ArrayList<>(Collections.nCopies(26, 0));
            for (Character letter : word.toCharArray()) {
                // Use ASCII values to find position
                // a - a = 0, a = 97, b = 98...
                int position = (int) letter - (int) 'a';
                letterCount.set(position, letterCount.get(position) + 1);
            }

            if (grouped.containsKey(letterCount)) {
                grouped.get(letterCount).add(word);
            } else {
                grouped.put(letterCount, new ArrayList<>(Collections.singleton(word)));
            }
        }

        return new ArrayList<>(grouped.values());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> solution = new ArrayList<>();
        boolean[] checked = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            if (checked[i]) {
                continue;
            }
            List<String> anagrams = new ArrayList<>();
            anagrams.add(strs[i]);
            checked[i] = true;
            for (int j = i + 1; j < strs.length; j++) {
                if (validAnagram(strs[i], strs[j])) {
                    anagrams.add(strs[j]);
                    checked[j] = true;
                }
            }
            solution.add(anagrams);
        }

        return solution;
    }

    private static boolean validAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> wordS = new HashMap<>();
        HashMap<Character, Integer> wordT = new HashMap<>();
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
