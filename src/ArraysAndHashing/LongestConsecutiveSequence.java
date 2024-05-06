package ArraysAndHashing;

import java.util.*;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
//        int[] nums = {};
//        int[] nums = {100,4,200,1,3,2};
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutiveOptimized(nums));
    }

    public static int longestConsecutiveOptimized(int[] nums) {
        // Convert to Set
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        // Every element that does not have a preceding element is a starting point
        int result = 0;
        for (int num : numSet) {
            int count = 0;
            if (!numSet.contains(num - 1)) {
                count++;
                while (numSet.contains(num + count)) {
                    count++;
                }
            }
            result = Math.max(count, result);
        }

        return result;
    }

    public static int longestConsecutive(int[] nums) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (Integer number : nums) {
            numbers.add(number);
        }
        Collections.sort(numbers);
        if (numbers.isEmpty()) return 0;
        int maxSequenceLength = 1;
        int currentSequenceLength = 1;
        int pointer = 0;
        while (pointer < numbers.size() - 1) {
            if (numbers.get(pointer) + 1 == numbers.get(pointer + 1)) {
                currentSequenceLength++;
                maxSequenceLength = Math.max(currentSequenceLength, maxSequenceLength);
            } else if (!numbers.get(pointer).equals(numbers.get(pointer + 1))) {
                currentSequenceLength = 1;
            }
            pointer++;
        }
        return maxSequenceLength;
    }
}
