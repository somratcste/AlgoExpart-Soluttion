package Arrays.twoNumberSum;

import java.util.*;

/**
 * O(nlog(n)) time
 * O(1) space
 */
class Solution {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while(left < right) {
            int currentSum = array[left] + array[right];
            if(currentSum == targetSum) {
                return new int[] {array[left], array[right]};
            } else if (currentSum < targetSum) {
                left++;
            } else if (currentSum > targetSum) {
                right--;
            }
        }

        return new int[0];
    }
}
