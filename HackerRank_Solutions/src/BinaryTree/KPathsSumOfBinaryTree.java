package BinaryTree;

public class KPathsSumOfBinaryTree {

    static class Node1 {
        int data;
        Node1 left; Node1 right;
        Node1(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        KPathsSumOfBinaryTree k = new KPathsSumOfBinaryTree();

        Node1 root = new Node1(1);
        root.left = new Node1(2);
        root.right = new Node1(3);
        root.left.left = new Node1(7);
        root.left.right = new Node1(5);
        root.right.left = new Node1(6);
        root.right.right = new Node1(7);

        int sum = 10;
        k.sumPaths(root, sum, "");
    }

    public void sumPaths(Node1 node, int sum, String path) {
        if (node != null) {
            if (node.data > sum) return;
            else {
                path += " "+node.data;
                if (sum == 0) {
                    System.out.println("path = " + path);
                }
                sumPaths(node.left, sum-node.data, path);
                sumPaths(node.right, sum-node.data, path);
            }
        }
    }
}
