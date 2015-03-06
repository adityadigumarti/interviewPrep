package com.google.interview.binarysearchtrees;

public class LCA {

    public static Node LCA(Node root, Node a, Node b) {
        Node left = null, right = null;

        if (root == null) {
            return null;
        }

        // If the root is one of a or b, then it is the LCA
        if (root == a || root == b) {
            return root;
        }

        left = LCA(root.getLeft(), a, b);
        right = LCA(root.getRight(), a, b);

        // If both nodes lie in left or right then their LCA is in left or right,
        // Otherwise root is their LCA
        if (left != null && right != null) {
            return root;
        }

        return (left != null) ? left : right;
    }

    public int maxPathSum(Node<Integer> root) {
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        calculateSum(root, max);
        return max[0];
    }

    public int calculateSum(Node<Integer> root, int[] max) {
        if (root == null)
            return 0;

        int left = calculateSum(root.getLeft(), max);
        int right = calculateSum(root.getRight(), max);

        int current = Math.max(root.getData(), Math.max(root.getData() + left, root.getData() + right));

        max[0] = Math.max(max[0], Math.max(current, left + root.getData() + right));

        return current;
    }

}
