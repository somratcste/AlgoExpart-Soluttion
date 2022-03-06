package stacks;

import java.util.*;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] array) {
        int[] result = new int[array.length];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * array.length; i++) {
            int circularIndex = i % array.length;

            while (stack.size() > 0 && array[stack.peek()] < array[circularIndex]) {
                int top = stack.pop();
                result[top] = array[circularIndex];
            }
            stack.push(circularIndex);
        }
        return result;
    }
}


