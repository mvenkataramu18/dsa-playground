package org.learn.ramu.trees.practice;

import org.learn.ramu.trees.TreeNode;

public class LCAInBinaryTree {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode leftAncestor = lowestCommonAncestor(root.left, p, q);

        TreeNode rightAncestor = lowestCommonAncestor(root.right, p, q);

        if (rightAncestor != null && leftAncestor != null) {
            return root;
        } else if (rightAncestor != null) {
            return rightAncestor;
        } else {
            return leftAncestor;
        }

    }

    public static void main(String[] args) {

        /*
                3
               / \
              5   1
             / \ / \
            6  2 0  8
              / \
             7   4
        */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left;   // 5
        TreeNode q = root.right;  // 1

        TreeNode lca = lowestCommonAncestor(root, p, q);

        System.out.println("LCA: " + (lca != null ? lca.val : "null"));
    }
}