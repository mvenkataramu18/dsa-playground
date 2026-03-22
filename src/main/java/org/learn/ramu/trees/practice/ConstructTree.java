package org.learn.ramu.trees.practice;

import java.util.*;
import org.learn.ramu.trees.TreeNode;

public class ConstructTree {

    static int preIndex = 0;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

       Map<Integer, Integer> map = new HashMap<>();
       for (int i = 0; i < inorder.length; i++) {
           map.put(inorder[i], i);
       }

       return build(preorder,0,inorder.length -1,map);
    }

    private static TreeNode build(int[] preorder,
            int left,
            int right,
            Map<Integer, Integer> inorderMap) {

        if(left > right) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex++]);
        int inorderIndex = inorderMap.get(root.val);
        root.left = build(preorder,left,inorderIndex-1,inorderMap);
        root.right = build(preorder,inorderIndex+1,right,inorderMap);

        return root;
    }

    public static void main(String[] args) {

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder  = {9, 3, 15, 20, 7};

        TreeNode root = buildTree(preorder, inorder);

        System.out.println("Tree constructed!");
    }
}