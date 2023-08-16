package TwoPointers;

import java.util.Arrays;

public class TwoSumII {

    public static void main(String[] args) {
        int[] numbers = { 2, 7, 11, 15 };
        int target = 0;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int p1 = 0;
        int p2 = numbers.length - 1;

        while (p1 < p2) {
            int sum = numbers[p1] + numbers[p2];
            if (sum == target) {
                return new int[]{p1 + 1, p2 + 1};
            } else if (sum < target) {
                p1++;
            } else {
                p2--;
            }
        }
        return new int[]{p1 + 1, p2 + 1};
    }
}
