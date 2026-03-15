package org.learn.ramu.trees.practice;

import org.learn.ramu.trees.TreeNode;

public class ValidateBST {

    public static boolean isValidBST(TreeNode root) {

        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode node, long min, long max) {

        if(node == null) return true;

        if(node.val <= min || node.val >= max) {
            return false;
        }

        return validate(node.left,min, node.val) && validate(node.right, node.val,max);
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

        boolean result = isValidBST(root);

        System.out.println(result);
    }
}