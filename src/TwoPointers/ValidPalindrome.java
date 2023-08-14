package TwoPointers;

public class ValidPalindrome {

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = "race a car";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        String word = s.toLowerCase().replace(" ", "").replaceAll("[^a-zA-Z0-9]", "");
        int start = 0;
        int end = word.length() - 1;
        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
