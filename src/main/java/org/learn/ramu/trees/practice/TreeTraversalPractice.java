package org.learn.ramu.trees.practice;

import java.util.LinkedList;
import java.util.Queue;
import org.learn.ramu.trees.TreeNode;

public class TreeTraversalPractice {

    // TODO: Root → Left → Right
    public static void preorder(TreeNode root) {
        if(root == null) return;

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // TODO: Left → Root → Right
    public static void inorder(TreeNode root) {
        if(root == null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // TODO: Left → Right → Root
    public static void postorder(TreeNode root) {
        if(root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    // TODO: BFS using Queue
    public static void bfs(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);


        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if(node.left != null) {
                queue.add(node.left);
            }

            if(node.right != null) {
                queue.add(node.right);
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

        System.out.print("\nBFS: ");
        bfs(root);
    }
}
