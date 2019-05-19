package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree2 {

    static class Node {
        int data;
        Node leftChild;
        Node rightChild;
        Node parent;

        public Node(int data) {
            this.data = data;
        }
    }

    Node root;
    //create a binary tree from scratch
    public void add(int data){
        Node nodeToAdd = new Node(data);
        if (root == null){
            root = nodeToAdd;
        }
        else{
            traverseAndAdd(root,nodeToAdd);
        }
    }

    private void traverseAndAdd(Node nodeToTraverse, Node nodeToAdd) {
        if(nodeToTraverse.data > nodeToAdd.data){
            if(nodeToTraverse.leftChild == null){
                nodeToAdd.parent = nodeToTraverse; // made nodeToTraverse as parent
                nodeToTraverse.leftChild = nodeToAdd;
            }else {
                traverseAndAdd(nodeToTraverse.leftChild, nodeToAdd);
            }
        }else{
            if(nodeToTraverse.rightChild == null){
                nodeToAdd.parent = nodeToTraverse;
                nodeToTraverse.rightChild = nodeToAdd;
            }else {
                traverseAndAdd(nodeToTraverse.rightChild, nodeToAdd);
            }
        }
    }

    /*
        Traversing binary tree

                        1
                    2       3
                4       5

        Inorder - (left, root, right) - 4 2 5 1 3
        PreOrder - (root, left, right) - 1 2 4 5 3
        PostOrder - (left, right, root) - 4 5 2 3 1
     */

    public void traverse(){
        if (root != null){
            Node nodeToTraverse = root;
            if (nodeToTraverse.leftChild == null && nodeToTraverse.rightChild == null){
                System.out.println(nodeToTraverse);
            }else{
                /*System.out.println("InOrder Traversal");
                inOrderTraversal(nodeToTraverse);
                System.out.println("");
                System.out.println("PreOrder Traversal");
                preOrderTraversal(nodeToTraverse);
                System.out.println("");*/
                System.out.println("PostOrder Traversal");
                postOrderTraversal(nodeToTraverse);
            }

        }
    }

    private void inOrderTraversal(Node nodeToTraverse) {
        if (nodeToTraverse.leftChild != null){
            inOrderTraversal(nodeToTraverse.leftChild);
        }
        System.out.println(nodeToTraverse.data);
        if (nodeToTraverse.rightChild != null){
            inOrderTraversal(nodeToTraverse.rightChild);
        }
    }

    private void preOrderTraversal(Node nodeToTraverse) {
        System.out.println(nodeToTraverse.data);
        if (nodeToTraverse.leftChild != null){
            preOrderTraversal(nodeToTraverse.leftChild);
        }
        if (nodeToTraverse.rightChild != null){
            preOrderTraversal(nodeToTraverse.rightChild);
        }
    }

    private void postOrderTraversal(Node nodeToTraverse) {
        if (nodeToTraverse.leftChild != null){
            postOrderTraversal(nodeToTraverse.leftChild);
        }
        if (nodeToTraverse.rightChild != null){
            postOrderTraversal(nodeToTraverse.rightChild);
        }
        System.out.println(nodeToTraverse.data);
    }

    /*
        Deleting nodes from binary tree
        Case 1. delete node with no children
        Case 2. delete node with one child
        Case 3. delete node with both children
     */
    public void delete(int val){
        Node nodeToBeDeleted = find(val);

        if(nodeToBeDeleted !=null){
            if (nodeToBeDeleted.leftChild == null && nodeToBeDeleted.rightChild==null){
                deleteCase1(nodeToBeDeleted);
            }
            else if (nodeToBeDeleted.leftChild != null && nodeToBeDeleted.rightChild != null){
                deleteCase3(nodeToBeDeleted);
            }
            else if(nodeToBeDeleted.leftChild!=null){
                //here the left child needs to be deleted
                deleteCase2(nodeToBeDeleted);
            }else if (nodeToBeDeleted.rightChild!=null){
                //here the right child needs to be deleted
                deleteCase2(nodeToBeDeleted);
            }else {
                deleteCase3(nodeToBeDeleted);
            }
        }

    }

    //          50
    //      10      75 <-- delete
    //  30      60      80
    //              77      95
    //          76
    private void deleteCase3(Node nodeToBeDeleted) {
        Node minNode = minLeftTraversal(nodeToBeDeleted.rightChild);
        deleteCase2(minNode);

        //for case : deleting root
        minNode.parent = nodeToBeDeleted.parent;
        minNode.leftChild = nodeToBeDeleted.leftChild;
        minNode.rightChild = nodeToBeDeleted.rightChild;
        if (nodeToBeDeleted.parent == null){
            root = minNode;
        }
        else if (nodeToBeDeleted.parent.rightChild == nodeToBeDeleted) {
            //copy the property of the nodeToBeDeleted [75] to minNode [76]
            minNode.parent = nodeToBeDeleted.parent;
            minNode.leftChild = nodeToBeDeleted.leftChild;
            minNode.rightChild = nodeToBeDeleted.rightChild;

            nodeToBeDeleted.parent.rightChild = minNode;
        }
        else if (nodeToBeDeleted.parent.leftChild == nodeToBeDeleted) {
            minNode.parent = nodeToBeDeleted.parent;
            minNode.leftChild = nodeToBeDeleted.leftChild;
            minNode.rightChild = nodeToBeDeleted.rightChild;

            nodeToBeDeleted.parent.leftChild = minNode;
        }
    }

    private Node minLeftTraversal(Node node){
        if (node.leftChild == null){
            return node;
        }
            return minLeftTraversal(node.leftChild);
    }

    //              50
    //    del-->10      70
    //      30      65

    private void deleteCase2(Node nodeToBeDeleted) {
        if (nodeToBeDeleted.parent.leftChild == nodeToBeDeleted){
            if (nodeToBeDeleted.leftChild != null){
                nodeToBeDeleted.parent.leftChild = nodeToBeDeleted.leftChild;
            }else if (nodeToBeDeleted.rightChild != null){
                nodeToBeDeleted.parent.leftChild = nodeToBeDeleted.rightChild;
            }
        }else if (nodeToBeDeleted.parent.rightChild == nodeToBeDeleted){
            if (nodeToBeDeleted.rightChild != null){
                nodeToBeDeleted.parent.rightChild = nodeToBeDeleted.rightChild;
            }else if (nodeToBeDeleted.leftChild != null){
                nodeToBeDeleted.parent.rightChild = nodeToBeDeleted.leftChild;
            }
        }
    }

    private void deleteCase1(Node nodeToBeDeleted) {
        //when we are deleting we need a reference to the nodeToBeDeleted's parent
        if (nodeToBeDeleted.parent.leftChild == nodeToBeDeleted){
            nodeToBeDeleted.parent.leftChild = null;

        }
        if (nodeToBeDeleted.parent.rightChild == nodeToBeDeleted){
            nodeToBeDeleted.parent.rightChild = null;
        }
    }

    /*
        Find node to delete
     */
    public Node find(int val){
        Node nodeToFind = new Node(val);
        if (root != null){
            return findNode(root,nodeToFind);
        }
        return null;
    }

    private Node findNode(Node searchNode, Node node) {
        if (searchNode == null){
            return null;
        }
        if(searchNode.data == node.data){
            return searchNode;
        }else {
            Node returnNode = findNode(searchNode.leftChild,node);
            if (returnNode == null){
                returnNode = findNode(searchNode.rightChild,node);
            }
            return returnNode;
        }
    }

  //Binary Tree problems
    /*
        level order traversal
     */

    public static void levelOrder(Node root) {
        Queue<Node> queue=new LinkedList<Node>(); 
        queue.add(root); 
        while(!queue.isEmpty()) { 
            Node tempNode=queue.poll(); 
            System.out.print(tempNode.data+" "); 
            if(tempNode.leftChild!=null) {
                queue.add(tempNode.leftChild);
            } 
            if(tempNode.rightChild!=null) {
                queue.add(tempNode.rightChild);
            } 
        }
    }
    
    /*
     * 
     */
    public static Node insert(Node root,int data) {
        Node newNode = new Node(data);
        if(root==null) {
            root = newNode;
        }
        else if(root.data>data) {
            root.leftChild = insert(root.leftChild,data);
        } else {
            root.rightChild = insert(root.rightChild,data);
        }
        return root;
    }
    
    public boolean checkBST(Node root) {
        return checkBSTUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public boolean checkBSTUtil(Node node, int min, int max) {
        if(node==null) {
            return true;
        }
        if(node.data > max || node.data < min) {
            return false;
        }
        return checkBSTUtil(node.leftChild, min, node.data) &&
            checkBSTUtil(node.rightChild, node.data, max);
    }
    
    public Node createBSTFromSortedArray(int[] arr, int start, int end) {
    	int mid = (start+end)/2;
    	Node node = new Node(mid);
    	node.leftChild = createBSTFromSortedArray(arr, start, mid-1);
    	node.rightChild = createBSTFromSortedArray(arr, mid+1, end);
    	return node;
    }

    /*
        same tree
     */
    public boolean sameTree(Node r1, Node r2) {
        if (r1 == null && r2 == null) return true;
        return r1.data == r2.data
                && sameTree(r1.leftChild, r2.leftChild)
                && sameTree(r1.rightChild, r2.rightChild);
    }
    
    				
    
    


}
