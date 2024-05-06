package ArraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> traversedIndices = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (traversedIndices.get(target - nums[i]) == null) {
                traversedIndices.put(nums[i], i);
            } else {
                return new int[]{traversedIndices.get(target - nums[i]), i};
            }
        }
        return new int[]{};
    }
}
