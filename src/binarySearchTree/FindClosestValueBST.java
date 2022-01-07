package binarySearchTree;

import java.util.*;

class FindClosestValueBST {
    // O(log(n)) time | O(1) space - average
    // O(n) time | O(1) space - worst
    public static int findClosestValueInBst(BST tree, int target) {
        return findClosestValueInBst(tree, target, tree.value);
    }

    public static int findClosestValueInBst(BST tree, int target, int closest) {
        BST currentNode = tree;
        while (currentNode != null) {
            if (Math.abs(target - closest) > Math.abs(target-currentNode.value)) {
                closest = currentNode.value;
            }

            if (target > currentNode.value) {
                currentNode = currentNode.right;
            } else if (target < currentNode.value) {
                currentNode = currentNode.left;
            } else {
                break;
            }
        }
        return closest;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}

