public class LC27RemoveElement {
    public static int removeElement(int[] nums, int val) {
      int k = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] == val) {
          while (nums[i] == val) {
            leftShift(nums, i);
            k++;
          }
        }
      }
      return nums.length - k;
    }

    public static void leftShift(int[] nums, int index) {
      for (int i = index; i < nums.length; i++) {
        if (i == nums.length - 1) {
          nums[i] = -1;
        } else {
          nums[i] = nums[i + 1];
        }
      }
    }

    public static void main(String[] args) {

    }
}