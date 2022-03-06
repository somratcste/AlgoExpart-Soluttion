package stacks;

import java.util.*;

public class BalancedBrackets {
    // O(n) time | O(n) space
    public static boolean balancedBrackets(String str) {
        String openingBrackets = "([{";
        String closingBrackets = ")]}";
        Map<Character, Character> matchingBrackets = new HashMap<Character, Character>();
        matchingBrackets.put(')', '(');
        matchingBrackets.put(']', '[');
        matchingBrackets.put('}', '{');
        List<Character> stack = new ArrayList<>();
        for (int i=0; i<str.length();i++) {
            char letter = str.charAt(i);
            if(openingBrackets.indexOf(letter) != -1) {
                stack.add(letter);
            } else if (closingBrackets.indexOf(letter) != -1) {
                if(stack.size() == 0) {
                    return false;
                }
                if(stack.get(stack.size() -1) == matchingBrackets.get(letter)) {
                    stack.remove(stack.size()-1);
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
