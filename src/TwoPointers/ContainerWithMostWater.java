package TwoPointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(container(height));
    }

    public static int container(int[] height) {
        int pL, water;
        pL = water = 0;
        int pR = height.length - 1;
        int maxLeft = height[pL];
        int maxRight = height[pR];
        int biggestContainer = Math.min(maxLeft, maxRight) * (pR - pL);

        while (pL < pR) {
            if (maxLeft < maxRight) {
                pL++;
                maxLeft = Math.max(maxLeft, height[pL]);
                water = Math.min(maxLeft, maxRight) * (pR - pL);
                biggestContainer = Math.max(water, biggestContainer);
            } else {
                pR--;
                maxRight = Math.max(maxRight, height[pR]);
                water = Math.min(maxLeft, maxRight) * (pR - pL);
                biggestContainer = Math.max(water, biggestContainer);
            }
        }
        return biggestContainer;
    }
}
