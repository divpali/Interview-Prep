package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class BTreeNode {
    int data;
    BTreeNode left;
    BTreeNode right;

    public BTreeNode(int data) {
        this.data = data;
    }
}

public class KSumPaths {

    private List<List<Integer>> paths = new ArrayList<>();

    public List<List<Integer>> pathSum(BTreeNode root, int sum) {
        traverse(root, sum, new ArrayList<Integer>());
        return paths;
    }

    private void traverse(BTreeNode root, int sum, ArrayList<Integer> path) {
        if (root != null) {
            path.add(root.data);

            if (root.left == null && root.right == null && sum == root.data) {
                paths.add((ArrayList) path.clone());
            }

            traverse(root.left,  sum - root.data, path);
            traverse(root.right, sum - root.data, path);

            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        KSumPaths k = new KSumPaths();

        BTreeNode root = new BTreeNode(5);
        root.left = new BTreeNode(4);
        root.left.left = new BTreeNode(11);
        root.left.left.left = new BTreeNode(7);
        root.left.left.right = new BTreeNode(2);

        root.right = new BTreeNode(8);
        root.right.left = new BTreeNode(13);
        root.right.right = new BTreeNode(4);
        root.right.right.right = new BTreeNode(1);
        root.right.right.left = new BTreeNode(5);

        int sum = 10;
        List<List<Integer>> res = k.pathSum(root, sum);
        printResult(res);
    }

    private static void printResult(List<List<Integer>> result) {
        for (List<Integer> path : result) {
            for (int n : path) {
                System.out.println(n + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
