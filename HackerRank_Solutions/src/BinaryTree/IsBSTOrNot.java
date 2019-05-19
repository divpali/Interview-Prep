package BinaryTree;

public class IsBSTOrNot {
    //create node
    private static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {

        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        Node node = new Node(4);
        node.left = new Node(2);
        node.right = new Node(5);
        node.left.left = new Node(1);
        node.left.right = new Node(3);

        if(checkBST(node,min,max)){
            System.out.println("its a BST");
        }else{
            System.out.println("its not a BST");
        }

    }

    public static boolean checkBST(Node root,int min, int max){
        Node node = root;
        if(node == null){
            return true;
        }
        if(node.data <=min || node.data >= max){
            return false;
        }
        return checkBST(node.left,min,node.data) ||
                checkBST(node.right,node.data,max);
    }
}
