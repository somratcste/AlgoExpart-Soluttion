package binaryTrees;

import java.util.*;

public class FindSuccessor {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // O(n) time | O(n) space
    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        List<BinaryTree> inOrderTraversalOrder = new ArrayList<>();
        getInOrderTraversalOrder(tree, inOrderTraversalOrder);

        for (int i=0; i<inOrderTraversalOrder.size(); i++) {
            BinaryTree currentNode = inOrderTraversalOrder.get(i);
            if(currentNode != node) {
                continue;
            }
            if (i == inOrderTraversalOrder.size() -1) {
                return null;
            }
            return inOrderTraversalOrder.get(i+1);
        }
        return null;
    }

    public void getInOrderTraversalOrder(BinaryTree node, List<BinaryTree> inOrder) {
        if (node == null) return;
        getInOrderTraversalOrder(node.left, inOrder);
        inOrder.add(node);
        getInOrderTraversalOrder(node.right, inOrder);
    }
}
