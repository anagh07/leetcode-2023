package TwoPointers;

public class TrapRainWater {

    public static void main(String[] args) {
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int water, pL;
        int pR = height.length - 1;
        water = pL = 0;
        int maxLeft = height[pL];
        int maxRight = height[pR];

        while (pL < pR) {
            if (maxLeft < maxRight) {
                pL++;
                maxLeft = Math.max(maxLeft, height[pL]);
                water += maxLeft - height[pL];
            } else {
                pR--;
                maxRight = Math.max(maxRight, height[pR]);
                water += maxRight - height[pR];
            }
        }
        return water;
    }
}
