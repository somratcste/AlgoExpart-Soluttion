package Arrays;

import java.util.*;

public class FirstDuplicateValue {
    // O( n power 2) time | O(1) space
    /*public int firstDuplicateValue(int[] array) {
        int minimumSecondIdex = array.length;
        for (int i = 0; i<array.length; i++) {
            int value = array[i];
            for (int j = i+1; j<array.length; j++) {
                int valueToCompare = array[j];
                if (value == valueToCompare) {
                    minimumSecondIdex = Math.min(minimumSecondIdex, j);
                    break;
                }
            }
        }

        if (minimumSecondIdex == array.length) return -1;
        return array[minimumSecondIdex];
    }*/

    // O(n) time | O(n) space
    public int firstDuplicateValue(int[] array) {
        HashSet<Integer> seen = new HashSet<Integer>();
        for (int value: array) {
            if (seen.contains(value)) return value;
            seen.add(value);
        }
        return -1;
    }

    // Solution 3
    // O(n) time | O(1) space
    /* public int firstDuplicateValue(int[] array) {
        for (int value: array) {
            int absValue = Math.abs(value);
            if(array[absValue-1] < 0) return absValue;
            array[absValue-1] *= -1;
        }
        return -1;
    }*/


}
