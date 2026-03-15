package org.learn.ramu.trees.practice;

import org.learn.ramu.trees.TreeNode;

public class LowestCommonAncestorBST {

    public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {

        while (root != null) {

            if (p < root.val && q < root.val) {
                root = root.left;
            } else if (p > root.val && q > root.val) {
                root = root.right;
            } else {
                return root;
            }

        }

        return null;
    }

    public static void main(String[] args) {

        /*
                25
               /  \
              15   50
             / \   / \
            10 22 35 70
               /
              18
        */

        TreeNode root = new TreeNode(25);

        root.left = new TreeNode(15);
        root.right = new TreeNode(50);

        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(22);

        root.right.left = new TreeNode(35);
        root.right.right = new TreeNode(70);

        root.left.right.left = new TreeNode(18);

        TreeNode lca = lowestCommonAncestor(root, 18, 22);

        if (lca != null) {
            System.out.println("LCA: " + lca.val);
        }
    }
}