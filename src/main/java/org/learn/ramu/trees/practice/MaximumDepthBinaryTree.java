package org.learn.ramu.trees.practice;

import org.learn.ramu.trees.TreeNode;

public class MaximumDepthBinaryTree {

    public static int maxDepth(TreeNode root) {

        if(root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth,rightDepth);
    }

    public static void main(String[] args) {

        /*
                3
               / \
              9  20
                / \
               15  7
        */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int depth = maxDepth(root);

        System.out.println("Maximum Depth: " + depth);
    }
}