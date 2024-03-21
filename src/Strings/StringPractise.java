package Strings;

public class StringPractise {

    public static void main(String[] args) {

        /**
         * Strings are immutable
         *
         * Scenario #1 O(n^2)
         * Add to existing string. Every time string is modified, new string is created, and new char is added
         */
        String sequence = "";
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            sequence += ch;
        }
        System.out.println(sequence);


        /**
         * Strings are immutable - STRING BUILDER
         *
         * Scenario #2 O(n)
         * Use a String Builder
         */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            sb.append(ch);
        }
        System.out.println(sb);
    }
}
