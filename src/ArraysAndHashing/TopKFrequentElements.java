package ArraysAndHashing;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        // nums = [1,1,1,2,2,3], k = 2
        int[] nums = {1, 1, 1, 2, 2, 3};
//        int[] nums = {1};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequesntOptimized(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // Use hashmap to count the number of occurrences of each element
        HashMap<Integer, Integer> numCounts = new HashMap<>();
        for (int num : nums) {
            numCounts.compute(num, (key, value) -> (value == null) ? 1 : value + 1);
        }

        // Convert the hashmap to a array of key-value pairs
        // Sort the list of key-value pairs
        List<Map.Entry<Integer, Integer>> numCountsArray = new ArrayList<>(numCounts.entrySet());
        numCountsArray.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        // Return first k elements
        int[] solution = new int[k];
        for (int i = 0; i < k; i++) {
            solution[i] = numCountsArray.get(i).getKey();
        }
        return solution;
    }

    public static int[] topKFrequesntOptimized(int[] nums, int k) {

        // Count occurrence of each number
        HashMap<Integer, Integer> countmap = new HashMap<>();
        for (int num : nums) {
            countmap.compute(num, (key, val) -> val == null ? 1 : val+1);
        }

        // Group numbers by count
        // Array = index = count, value = number
        List<Integer>[] grouped = new ArrayList[nums.length + 1];
        for (int num : countmap.keySet()) {
            int count = countmap.get(num);
            if (grouped[count] == null) {
                grouped[count] = new ArrayList<>(Arrays.asList(num));
            } else {
                grouped[count].add(num);
            }
        }

        // Add k elements to the result array
        // Start from last of grouped array
        int kCount = 0;
        int[] result = new int[k];
        int iterator = grouped.length - 1;
        while (kCount < k && iterator > 0) {
            if (grouped[iterator] != null) {
                for (Integer num : grouped[iterator]) {
                    result[kCount] = num;
                    kCount++;
                    if (kCount >= k) return result;
                }
            }
            iterator--;
        }
        return result;
    }
}
