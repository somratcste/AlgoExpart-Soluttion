package binaryTrees;

public class NodeDepth {
    // O(n) time | O(h) space - h is the height of the binary tree
    public static int nodeDepths(BinaryTree root) {
        return nodeDepthHelper(root, 0);
    }

    public static int nodeDepthHelper(BinaryTree root, int depth) {
        if (root == null) return 0;
        return depth + nodeDepthHelper(root.left, depth+1) + nodeDepthHelper(root.right, depth+1);
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
