package binaryTrees;

public class HeightBalanceBinaryTree {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class TreeInfo {
        public boolean isBalanced;
        public int height;

        public TreeInfo(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        TreeInfo treeInfo = getTreeInfo(tree);
        return treeInfo.isBalanced;
    }

    public TreeInfo getTreeInfo(BinaryTree node) {
        if (node == null) return new TreeInfo(true, -1);
        TreeInfo leftSubtreeInfo = getTreeInfo(node.left);
        TreeInfo rightSubtreeInfo = getTreeInfo(node.right);

        boolean isBalanced = leftSubtreeInfo.isBalanced && rightSubtreeInfo.isBalanced &&
                Math.abs(leftSubtreeInfo.height - rightSubtreeInfo.height) <= 1;

        int height = Math.max(leftSubtreeInfo.height, rightSubtreeInfo.height) + 1;
        return new TreeInfo(isBalanced, height);
    }
}
