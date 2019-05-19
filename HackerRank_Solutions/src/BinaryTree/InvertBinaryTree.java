package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    //create node
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data = data;
        }
    }


    public static void main(String[] args) {
        //create tree
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        // printLevelOrderTree(node);
        Node newNode = flipBinaryTree(node);

        printLevelOrderTree(node);
    }


    public static Node flipBinaryTree(Node root){

        if(root == null){
            return null;
        }

        if(root.left==null && root.right==null){
            return root;
        }

        Node flippedRoot = flipBinaryTree(root.left);

        Node node = root;
        node.left.left = node.right;
        node.left.right = node;
        node.left = null;
        node.right = null;

        return flippedRoot;

    }

    public static void printLevelOrderTree(Node root){
        //take root -> if null return
        //else add root to queue
        //while is not empty -> poll queue and print
        //if root has left child add to queue
        //if root has right child add to queue
        if(root == null) return;

        Queue<Node> q=new LinkedList<>();
        if(root!=null){
            q.add(root);
            while(!q.isEmpty()){
                root=q.poll();
                System.out.println(root.data +" ");
                if(root.left !=null){
                    q.add(root.left);
                }
                if(root.right!=null){
                    q.add(root.right);
                }
            }
        }
    }
}
