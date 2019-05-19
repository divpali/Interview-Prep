package BinaryTree;

public class FindProperSubtree {
	
	static class Node {
		int data;
		Node left;
		Node right;
		Node(int data) {
			this.data = data;
		}
	}
	
	boolean areIdentical(Node root1, Node root2) { 
        /* base cases */
        if (root1 == null && root2 == null) 
            return true; 
   
        if (root1 == null || root2 == null) 
            return false; 
   
        /* Check if the data of both roots is same and data of left and right 
           subtrees are also same */
        return (root1.data == root2.data 
                && areIdentical(root1.left, root2.left) 
                && areIdentical(root1.right, root2.right)); 
    } 
   
    /* This function returns true if S is a subtree of T, otherwise false */
    boolean isSubtree(Node T, Node S)  { 
        /* base cases */
        if (S == null)  
            return true; 
   
        if (T == null) 
            return false; 
   
        /* Check the tree with root as current node */
        if (areIdentical(T, S))  
            return true; 
   
        /* If the tree with root as current node doesn't match then 
           try left and right subtrees one by one */
        return isSubtree(T.left, S) 
                || isSubtree(T.right, S); 
    }

	public static void main(String[] args) {
		FindProperSubtree f = new FindProperSubtree();
		Node n1 = new Node(10);
		n1.left = new Node(8);
		n1.left.left = new Node(7);
		n1.left.right = new Node(9);
		n1.right = new Node(12);
		
		Node n2 = new Node(8);
		n2.left = new Node(7);
		n2.right = new Node(9);
		
		System.out.println(f.isSubtree(n1, n2));
		
	}

}
