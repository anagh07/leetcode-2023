package ArraysAndHashing;

import java.util.Arrays;

public class ProductArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int[] solution = new int[nums.length];

        for (int i=0; i < nums.length; i++) {
            prefix[i] = (i == 0) ? 1 : prefix[i-1] * nums[i-1];
        }

        for (int i=nums.length-1; i >= 0; i--) {
            postfix[i] = (i == nums.length-1) ? 1 : postfix[i+1] * nums[i+1];
            solution[i] = prefix[i] * postfix[i];
        }

        return solution;
    }
}
