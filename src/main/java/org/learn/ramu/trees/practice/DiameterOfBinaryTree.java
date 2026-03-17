package org.learn.ramu.trees.practice;

import org.learn.ramu.trees.TreeNode;

public class DiameterOfBinaryTree {

    static int diameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {

        height(root);

        return diameter;
    }

    private static int height(TreeNode node) {

        if (node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        if (diameter < leftHeight + rightHeight) {
            diameter = leftHeight + rightHeight;
        }

        return 1 + Math.max(leftHeight, rightHeight);
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

        int result = diameterOfBinaryTree(root);

        System.out.println("Diameter: " + result);
    }
}