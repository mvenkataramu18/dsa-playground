package org.learn.ramu.trees.practice;

import org.learn.ramu.trees.TreeNode;

public class FlattenBinaryTree {

    public static void flatten(TreeNode root) {

        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        if(left != null) {
            root.right = left;
            root.left = null;

            TreeNode curr = root.right;
            while (curr.right != null) {
                curr = curr.right;
            }
            curr.right = right;
        }
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   5
             / \   \
            3   4   6
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(6);

        flatten(root);

        System.out.println("Flatten done");
    }
}