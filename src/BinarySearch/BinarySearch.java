package BinarySearch;

public class BinarySearch {

    public static void main(String[] args) {
//        int[] numbers = {-1, 0, 3, 5, 9, 12};
//        int[] numbers = {-1, 0, 3, 5, 9, 12};
        int[] numbers = {5};
        System.out.println(search(numbers, 5));
    }

    public static int search(int[] nums, int target) {
        int p1 = 0;
        int p2 = nums.length - 1;
        int pm;

        while (p2 >= p1) {
            pm = p1 + ((p2 - p1) / 2);
            if (target == nums[pm])
                return pm;

            if (target > nums[pm]) {
                p1 = pm + 1;
            } else {
                p2 = pm - 1;
            }
        }

        return -1;
    }
}
