package org.learn.ramu.trees.practice;

import org.learn.ramu.trees.TreeNode;

public class BalancedBinaryTree {

    public static boolean isBalanced(TreeNode root) {

        return height(root) != -1;
    }

    private static int height(TreeNode node) {

        if (node == null) return 0;

        int leftHeight = height(node.left);
        if(leftHeight == -1) return -1;
        int rightHeight = height(node.right);
        if(rightHeight == -1) return  -1;

        int difference = Math.abs(leftHeight - rightHeight);
        if(difference > 1) return -1;

        return 1 + Math.max(leftHeight,rightHeight);
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
             / \
            4   5
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        boolean result = isBalanced(root);

        System.out.println("Balanced: " + result);
    }
}