package com.main.trees;

public class TreeTraversals {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> left = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> right = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(2, left, right);

//        inOrderTraversal(root);
//        System.out.println("");
//        preOrderTraversal(root);
//        System.out.println("");
//        postOrderTraversal(root);

        System.out.println(isBalanced(new BinaryTreeNode<>(2, right, "right")));
    }

    public static void inOrderTraversal(BinaryTreeNode<Integer> root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    public static void preOrderTraversal(BinaryTreeNode<Integer> root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public static void postOrderTraversal(BinaryTreeNode<Integer> root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static boolean isBalanced(BinaryTreeNode<Integer> root) {
        return checkBalanced(root).balanced;
    }

    private static BalanceStatusWithHeight checkBalanced(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new BalanceStatusWithHeight(true, -1);
        }

        BalanceStatusWithHeight leftResult = checkBalanced(root.left);
        if (!leftResult.balanced) {
            return leftResult;
        }

        BalanceStatusWithHeight rightResult = checkBalanced(root.right);
        if (!rightResult.balanced) {
            return rightResult;
        }

        boolean isBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;
        int height = Math.max(leftResult.height, rightResult.height) + 1;
        return new BalanceStatusWithHeight(isBalanced, height);
    }

    public static class BinaryTreeNode<T> {
        public T data;
        public BinaryTreeNode<T> left, right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }

        public BinaryTreeNode(T data, BinaryTreeNode<T> child, String leftOrRight) {
            switch (leftOrRight) {
                case "left" -> this.left = child;
                case "right" -> this.right = child;
            }
        }

        public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class BalanceStatusWithHeight {
        public boolean balanced;
        public int height;

        public BalanceStatusWithHeight(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }
}
