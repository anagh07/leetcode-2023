package ArraysAndHashing;

import java.util.Arrays;

public class LC88MergeSortedArray {
    /*
    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two
    integers m and n, representing the number of elements in nums1 and nums2 respectively.
    Merge nums1 and nums2 into a single array sorted in non-decreasing order.
    The final sorted array should not be returned by the function, but instead be stored inside the
    array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote
    the elements that should be merged, and the last n elements are set to 0 and should be ignored.
    nums2 has a length of n.

    Example 1:
    Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    Output: [1,2,2,3,5,6]
    Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
    The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

    Example 2:
    Input: nums1 = [1], m = 1, nums2 = [], n = 0
    Output: [1]
    Explanation: The arrays we are merging are [1] and [].
    The result of the merge is [1].
     */

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int pR = m + n - 1;

        if (nums2.length == 0) {
            return;
        }

        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[pR] = nums1[p1];
                p1--;
            } else {
                nums1[pR] = nums2[p2];
                p2--;
            }

            pR--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.print(Arrays.toString(nums1));
    }
}
