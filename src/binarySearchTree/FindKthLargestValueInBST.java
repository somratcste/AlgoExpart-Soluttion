package binarySearchTree;

public class FindKthLargestValueInBST {
    // solution 1
    /*
    // This is an input class. Do not edit.
  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

	// O(n) time | o(n) space
  public int findKthLargestValueInBst(BST tree, int k) {
    ArrayList<Integer> sortedNodeValues = new ArrayList<Integer>();
		inOrderTraverse(tree, sortedNodeValues);
		return sortedNodeValues.get(sortedNodeValues.size() - k);
  }

	public void inOrderTraverse(BST node, ArrayList<Integer> sortedNodeValues) {
		if (node == null) return;
		inOrderTraverse(node.left, sortedNodeValues);
		sortedNodeValues.add(node.value);
		inOrderTraverse(node.right, sortedNodeValues);
	}
     */

    // solution 2
    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    static class TreeInfo {
        public int numberOfNodesVisited;
        public int latestVisitedNodeValue;

        public TreeInfo(int numberOfNodesVisited, int latestVisitedNodeValue) {
            this.numberOfNodesVisited = numberOfNodesVisited;
            this.latestVisitedNodeValue = latestVisitedNodeValue;
        }
    }

    // O(h+k) time | O(h) space
    // h is the height of the tree, k is the input parameter
    public int findKthLargestValueInBst(BST tree, int k) {
        TreeInfo treeInfo = new TreeInfo(0, -1);
        reverseInOrderTraverse(tree, k, treeInfo);
        return treeInfo.latestVisitedNodeValue;
    }

    public void reverseInOrderTraverse(BST node, int k, TreeInfo treeInfo) {
        if (node == null || treeInfo.numberOfNodesVisited >= k) return;
        reverseInOrderTraverse(node.right, k, treeInfo);
        if (treeInfo.numberOfNodesVisited < k) {
            treeInfo.numberOfNodesVisited += 1;
            treeInfo.latestVisitedNodeValue = node.value;
            reverseInOrderTraverse(node.left, k, treeInfo);
        }
    }
}
