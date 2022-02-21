package binarySearchTree;

import java.util.*;

public class ReconstructBST {
    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    // O(n power 2) time | O(n) space
    public BST reconstructBst(List<Integer> preOrderTraversalValues) {
        if (preOrderTraversalValues.size() == 0) {
            return null;
        }

        int currentValue = preOrderTraversalValues.get(0);
        int rightSubtreeRootIdx = preOrderTraversalValues.size();

        for (int idx = 1; idx < preOrderTraversalValues.size(); idx++) {
            int value = preOrderTraversalValues.get(idx);
            if (value >= currentValue) {
                rightSubtreeRootIdx = idx;
                break;
            }
        }

        BST leftSubtree = reconstructBst(preOrderTraversalValues.subList(1, rightSubtreeRootIdx));
        BST rightSubtree = reconstructBst (
                preOrderTraversalValues.subList(rightSubtreeRootIdx, preOrderTraversalValues.size())
        );

        BST bst = new BST(currentValue);
        bst.left = leftSubtree;
        bst.right = rightSubtree;

        return bst;
    }
}
