package BinarySearch;

import java.util.Arrays;

public class LC875KokoEatingBananas {
    /*
    Time complexity = O(N logN)
    Optimized
     */
    public static void main(String[] args) {
//        int[] piles = {3,6,7,11};
        int[] piles = {312884470};
        System.out.println(minEatingSpeed(piles, 312884469));
//        System.out.println(minEatingSpeed(piles, 8));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        // bin search for correct k in the solutions array
        int value1 = 1;
        int value2 = Arrays.stream(piles).max().getAsInt();
        int k = 1, calculatedH;
        while (value2 > value1) {
            k = value1 + (value2 - value1)/2;
            calculatedH = calcH(piles, k);

            if (calculatedH > h) {
                value1 = k + 1;
            } else {
                value2 = k;
            }
        }
        return value2;
    }

    private static int calcH(int[] piles, int k) {
        int h = 0;
        for (int pile : piles) {
            h = pile % k > 0 ? (h + (pile / k + 1)) : (h + pile / k);
        }
        return h;
    }
}
