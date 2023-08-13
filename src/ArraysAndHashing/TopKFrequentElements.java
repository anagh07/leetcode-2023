package ArraysAndHashing;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        // nums = [1,1,1,2,2,3], k = 2
        int nums[] = {1, 1, 1, 2, 2, 3};
        int k = 1;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
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
        numCountsArray.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        // Return first k elements
        int[] solution = new int[k];
        for (int i = 0; i < k; i++) {
            solution[i] = numCountsArray.get(i).getKey();
        }
        return solution;
    }
}
