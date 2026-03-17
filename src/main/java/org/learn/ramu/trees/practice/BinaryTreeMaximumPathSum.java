package org.learn.ramu.trees.practice;

import org.learn.ramu.trees.TreeNode;

public class BinaryTreeMaximumPathSum {

    static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {

        dfs(root);

        return maxSum;
    }

    private static int dfs(TreeNode node) {

        if(node == null) return 0;

        int leftGain = Math.max(0,dfs(node.left));
        int rightGain = Math.max(0,dfs(node.right));
        int sum = leftGain + node.val + rightGain;
        if(sum > maxSum) {
            maxSum = sum;
        }

        return node.val + Math.max(leftGain,rightGain);
    }

    public static void main(String[] args) {

        /*
                -10
                /  \
               9   20
                  /  \
                 15   7
        */

        TreeNode root = new TreeNode(-10);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int result = maxPathSum(root);

        System.out.println("Maximum Path Sum: " + result);
    }
}