package org.learn.ramu.trees.practice;

import java.util.ArrayList;
import java.util.List;
import org.learn.ramu.trees.TreeNode;

public class PathSumII {

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();

        dfs(root,targetSum,new ArrayList<>(),result);

        return result;
    }

    private static void dfs(TreeNode node, int targetSum,
            List<Integer> path,
            List<List<Integer>> result) {

        if(node == null) return;

        path.add(node.val);

        if(node.left == null && node.right == null && node.val == targetSum) {
            result.add(new ArrayList<>(path));
        }

        dfs(node.left,targetSum - node.val , path , result);
        dfs(node.right,targetSum - node.val , path , result);

        path.removeLast();
    }

    public static void main(String[] args) {

        /*
                5
               / \
              4   8
             /   / \
            11  13  4
           /  \     / \
          7    2   5   1
        */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;

        List<List<Integer>> result = pathSum(root, targetSum);

        System.out.println(result);
    }
}