package org.learn.ramu.trees.practice;

import java.util.Stack;
import org.learn.ramu.trees.TreeNode;

public class IterativeTraversals {

    // ================= PREORDER =================
    public static void preorder(TreeNode root) {

        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            System.out.print(node.val + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    // ================= INORDER =================
    public static void inorder(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            curr = node.right;
        }
    }

    // ================= POSTORDER =================
    public static void postorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        TreeNode lastVisited = null;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            TreeNode peekNode = stack.peek();
            if (peekNode.right == null || lastVisited == peekNode.right) {
                TreeNode node = stack.pop();
                System.out.print(node.val + " ");
                lastVisited = node;
            } else {
                curr = peekNode.right;
            }
        }
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
             / \   \
            4   5   6
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);

        System.out.print("Preorder: ");
        preorder(root);

        System.out.print("\nInorder: ");
        inorder(root);

        System.out.print("\nPostorder: ");
        postorder(root);
    }
}