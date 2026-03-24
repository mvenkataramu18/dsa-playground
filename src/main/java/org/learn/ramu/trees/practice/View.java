package org.learn.ramu.trees.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import org.learn.ramu.trees.Pair;
import org.learn.ramu.trees.TreeNode;
import org.learn.ramu.trees.ViewType;

public class View {

    public static List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {

            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int hd = pair.hd;

            map.computeIfAbsent(hd , k -> new ArrayList<>()).add(node.val);

            if(node.left != null) queue.offer(new Pair(node.left, hd -1));
            if(node.right != null) queue.offer(new Pair(node.right, hd +1));
        }

        for(Integer hd : map.keySet()) {
           result.add(map.get(hd));
        }

        return result;
    }

    public static List<Integer> view(TreeNode root, ViewType viewType) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {

            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int hd = pair.hd;

            if (viewType == ViewType.BOTTOM || !map.containsKey(hd)) {
                map.put(hd, node.val);
            }

            if (node.left != null) {
                queue.offer(new Pair(node.left, hd - 1));
            }

            if (node.right != null) {
                queue.offer(new Pair(node.right, hd + 1));
            }
        }

        for (int key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
               \
                4
                 \
                  5
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);

        List<Integer> top = view(root, ViewType.TOP);
        System.out.println("Top View: " + top);

        List<Integer> bottom = view(root, ViewType.BOTTOM);
        System.out.println("Bottom View: " + bottom);

        List<List<Integer>> verticalTraversal = verticalTraversal(root);
        System.out.println("Vertical Traversal: " + verticalTraversal);
    }
}