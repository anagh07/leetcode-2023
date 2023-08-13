package ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = {};
//        int[] nums = {100,4,200,1,3,2};
//        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        List<Integer> numbers = new ArrayList<>();
        for (Integer number : nums) {
            numbers.add(number);
        }
        Collections.sort(numbers);
        if (numbers.size() == 0) return 0;
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
