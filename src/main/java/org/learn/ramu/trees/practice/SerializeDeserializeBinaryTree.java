package org.learn.ramu.trees.practice;

import java.util.*;
import org.learn.ramu.trees.TreeNode;

public class SerializeDeserializeBinaryTree {

    // ===================== SERIALIZE =====================
    public static String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);

        return sb.toString();
    }

    private static void serializeHelper(TreeNode node, StringBuilder sb) {

        if (node == null) {
            sb.append("null,");
            return;
        }

        sb.append(node.val).append(",");

        serializeHelper(node.left,sb);
        serializeHelper(node.right,sb);
    }

    // ===================== DESERIALIZE =====================
    public static TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(List.of(data.split(",")));
        return deserializeHelper(queue);
    }

    private static TreeNode deserializeHelper(Queue<String> queue) {
        String value = queue.poll();
        if(value == null || value.isBlank() || value.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);

        return node;
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
                 / \
                4   5
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialized = serialize(root);
        System.out.println("Serialized: " + serialized);

        TreeNode deserialized = deserialize(serialized);
        System.out.println("Deserialized root: " + deserialized.val);
    }
}