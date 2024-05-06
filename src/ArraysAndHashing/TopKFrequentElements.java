package ArraysAndHashing;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        // nums = [1,1,1,2,2,3], k = 2
        int[] nums = {1, 1, 1, 2, 2, 3};
//        int[] nums = {1};
        int k = 3;
        System.out.println(Arrays.toString(topKFrequestOptimized(nums, k)));
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

    public static int[] topKFrequestOptimized(int[] nums, int k) {

        // Count occurrence of each number
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.compute(num, (key, val) -> val == null ? 1 : val + 1);
        }

        // Array where index = occurrence count AND value = array of nums
        ArrayList<Integer>[] occurrences = new ArrayList[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            occurrences[i] = new ArrayList<>();
        }
        for (int num : count.keySet()) {
            int key = count.get(num);
            occurrences[key].add(num);
        }

        // Add k elements starting from end of occurrences array
        int kCount = 0;
        int iterate = occurrences.length - 1;
        int[] solution = new int[k];
        while (kCount < k && iterate >= 0) {
            if (occurrences[iterate] != null && !occurrences[iterate].isEmpty()) {
                for (int num : occurrences[iterate]) {
                    solution[kCount] = num;
                    kCount++;
                    if (kCount >= k)
                        break;
                }
            }
            iterate--;
        }

        return solution;
    }
}
