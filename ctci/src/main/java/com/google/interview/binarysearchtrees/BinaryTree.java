package com.google.interview.binarysearchtrees;

import java.util.Stack;

public class BinaryTree<T extends Comparable<T>> {

    private Node<T> root = null;

    public void insert(T data) {
        if (root == null) {
            root = new Node<T>(data, null);
        } else {
            insert(root, data);
        }

    }

    private void insert(Node<T> node, T data) {
        if (data.compareTo(node.getData()) <= 0) {
            if (node.getLeft() == null) {
                node.setLeft(new Node(data, node));
            } else {
                insert(node.getLeft(), data);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new Node(data, node));
            } else {
                insert(node.getRight(), data);
            }
        }
    }

    public int maxDepth() {
        return maxDepth(root);
    }

    public int maxDepth(Node<T> node) {
        if (node == null) {
            return 0;
        }

        int depthLeft = maxDepth(root.getLeft());
        int depthRight = maxDepth(root.getRight());

        return depthLeft >= depthRight ? depthLeft + 1 : depthRight + 1;

    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(Node<T> node) {
        if (node == null) {
            return;
        }

        inorder(node.getLeft());
        print(node);
        inorder(node.getRight());
    }

    public void preorder() {
        preorder(root);
    }

    private void preorder(Node<T> node) {
        if (node == null)
            return;

        print(node);
        preorder(node.getLeft());
        preorder(node.getRight());
    }

    private void print(Node<T> node) {
        System.out.println(node.getData());
    }

    public T getMin() {
        if (root == null) {
            throw new IllegalStateException("Empty Tree");
        }

        return getMin(root);
    }

    private T getMin(Node<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }

        return node.getData();
    }

    public T getMax() {
        if (root == null) {
            throw new IllegalStateException("Empty Tree");
        }

        Node<T> node = root;
        while (node.getRight() != null) {
            node = node.getRight();
        }

        return node.getData();
    }

    public void delete() {

    }

    public Node<T> search(T data) {
        return search(data, root);
    }

    public Node<T> search(T data, Node<T> node) {
        if (node == null) {
            return node;
        }

        Node<T> searchNode = null;

        if (data == node.getData()) {
            searchNode = node;
        } else {
            if (data.compareTo(node.getData()) > 0) {
                searchNode = search(data, node.getRight());
            } else {
                searchNode = search(data, node.getLeft());
            }
        }

        return searchNode;
    }

    public T getSuccessor(T data) {
        Node<T> node = search(data);

        if (node.getRight() != null) {
            return getMin(node.getRight());
        }

        Node<T> parent = node.getParent();
        T value = data;

        while (parent != null && (parent.getLeft() == null || parent.getLeft().getData() != data)) {
            data = parent.getData();
            parent = parent.getParent();
        }

        if (parent == null) {
            value = null;
        } else {
            value = parent.getData();
        }

        return value;

    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node<T> node) {
        if (node == null) {
            return true;
        }

        int heightLeftSubtree = maxDepth(node.getLeft());
        int heightRightSubtree = maxDepth(node.getRight());

        return Math.abs(heightLeftSubtree - heightRightSubtree) <= 1 && isBalanced(node.getLeft())
                && isBalanced(node.getRight());

    }

    public T lca(T a, T b) {
        return lca(root, a, b);
    }

    public Node<T> lca_better(T a, T b) {
        return lca_better(root, a, b);
    }

    public Node<T> lca_better(Node<T> root, T a, T b) {
        if (root == null) {
            return null;
        }

        Node<T> left = lca_better(root.getLeft(), a, b);

        if (left != null && left != a && left != b) {
            return left;
        }

        Node<T> right = lca_better(root.getRight(), a, b);

        if (right != null && right != a && right != b) {
            return right;
        }

        if (right == a && left == b || left == a && right == b) {
            return root;
        }

        if (right == null && left == null) {
            return null;
        }

        return left == null ? right : left;

    }

    private T lca(Node<T> node, T a, T b) {
        if (node == null) {
            return null;
        }

        if (node.getData() == a || node.getData() == b) {
            return node.getData();
        }

        T left = lca(node.getLeft(), a, b);
        T right = lca(node.getRight(), a, b);

        if (left != null && right != null) {
            return node.getData();
        }

        return left != null ? left : right;
    }

    public Node<T> findCommonAncestor_parent_binaryTree() {
        return null;
    }

    public Node<T> findCommonAncestor_binarySearchTree(T a, T b) {
        Node<T> node_a = search(a);
        Node<T> node_b = search(b);

        return findCommonAncestor_binarySearchTree(node_a, node_b, root);

    }

    private Node<T> findCommonAncestor_binarySearchTree(Node<T> node_a, Node<T> node_b, Node<T> root) {
        if (root == null) {
            return null;
        }

        if (node_a.getData() == root.getData() || node_b.getData() == root.getData()) {
            return root;
        }

        if ((node_a.getData().compareTo(root.getData()) < 0 && node_b.getData().compareTo(root.getData()) > 0)
                || (node_b.getData().compareTo(root.getData()) < 0 && node_a.getData().compareTo(root.getData()) > 0)) {
            return root;
        }

        if (node_a.getData().compareTo(root.getData()) <= 0 && node_b.getData().compareTo(root.getData()) <= 0) {
            return findCommonAncestor_binarySearchTree(node_a, node_b, root.getLeft());
        } else {
            return findCommonAncestor_binarySearchTree(node_a, node_b, root.getLeft());
        }

    }
}
