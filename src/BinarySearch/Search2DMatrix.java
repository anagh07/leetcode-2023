package BinarySearch;

public class Search2DMatrix {

    public static void main(String[] args) {
//        int[][] numbers = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//        int[][] numbers = {{1,3}};
//        int[][] numbers = {{1},{3}};
        int[][] numbers = {{1}};
        System.out.println(searchMatrix(numbers, 1));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int p1 = 0;
        int p2 = matrix.length - 1;
        int pM;

        // Binary search to find which row the data is in.
        while (p1 <= p2) {
            pM = p1 + ((p2 - p1)/2);

            if (target > matrix[pM][matrix[pM].length - 1]) {
                p1 = pM + 1;
            } else if (target < matrix[pM][0]) {
                p2 = pM - 1;
            } else {
                // Bin search only one row = the row where the data might be.
                return binSearch(matrix[pM], target) > -1;
            }
        }
        return false;
    }

    public static int binSearch(int[] data, int target) {
        int pL = 0;
        int pR = data.length - 1;
        int pM;

        while (pL <= pR) {
            pM = pL + ((pR - pL)/2);

            if (data[pM] < target) {
                pL = pM + 1;
            } else if (data[pM] > target) {
                pR = pM - 1;
            } else {
                return pM;
            }
        }
        return -1;
    }
}
