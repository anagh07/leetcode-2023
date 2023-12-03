package BinarySearch;

public class LC153FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] inputs = {4, 5, 6, 7, 0, 1, 2};
//        int[] inputs = {11, 13, 15, 17};
//        int[] inputs = {1, 2};
        System.out.println(findMin(inputs));
    }

    public static int findMin(int[] nums) {
        int pL = 0, pR = nums.length - 1;
        int pM = 0;

        //bin search
        while (pL <= pR) {
            //not-rotated & fully sorted
            if (nums[pL] <= nums[pR])
                return nums[pL];

            //mid
            pM = (pL + pR) / 2;

            if (nums[pM] >= nums[pL]) {
                pL = pM + 1;
            } else {
                pR = pM;
            }
        }

        return nums[pM];
    }
}
