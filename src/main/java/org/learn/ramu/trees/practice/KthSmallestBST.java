package org.learn.ramu.trees.practice;

import java.util.Stack;
import org.learn.ramu.trees.TreeNode;

public class KthSmallestBST {

    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int count = 0;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode node = stack.pop();
            count++;
            if (count == k) {
                return node.val;
            }
            curr = node.right;
        }
        return -1;
    }

    public static void main(String[] args) {

        /*
                5
               / \
              3   7
             / \
            2   4
        */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        int k = 3;

        int result = kthSmallest(root, k);

        System.out.println("Kth Smallest: " + result);
    }
}