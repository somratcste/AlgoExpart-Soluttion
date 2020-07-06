package Arrays.twoNumberSum;

import java.util.*;

/**
 * O(n) time
 * O(n) space
 **/
class Program {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        Map<Integer, Boolean> nums = new HashMap<>();
        for (int number: array) {
            int match = targetSum - number;
            if(nums.containsKey(match)) {
                return new int[] {match, number};
            } else {
                nums.put(number, true);
            }
        }
        return new int[0];
    }
}