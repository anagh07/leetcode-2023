package BinarySearch;

public class LC33SearchInRotatedSortedArray {
    public static void main(String[] args){
        int[] numbers = {4, 5, 6, 0, 1, 2, 3};
        System.out.println(search(numbers, 5));
    }

    public static int search(int[] numbers, int target) {
        // find pivot
        int ps = 0;
        int pe = numbers.length - 1;
        int pm = (ps + pe) / 2;

        while (ps < pe) {
            pm = (ps + pe) / 2;
            if (numbers[pm] > numbers[pm+1]) {
                break;
            }
            // pm in LH
            if (numbers[pm] > numbers[pe]) {
                ps = pm + 1;
            }
            // pm in RH
            else if (numbers[pm] <= numbers[pe]) {
                pe = pm;
            }
        }

        // if target >= first elem = search first half
        if (target >= numbers[0]) {
            return binSearch(numbers, target, 0, pm);
        }
        // if target < first elem = search last half
        else {
            return binSearch(numbers, target, pm, numbers.length - 1);
        }
    }

    public static int binSearch(int[] numbers, int target, int start, int end) {
        int pm;

        while (end >= start) {
            pm = start + ((end - start) / 2);
            if (target == numbers[pm])
                return pm;

            if (target > numbers[pm]) {
                start = pm + 1;
            } else {
                end = pm - 1;
            }
        }

        return -1;
    }
}