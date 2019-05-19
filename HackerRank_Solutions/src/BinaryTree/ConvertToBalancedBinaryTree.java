package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/*
 * Convert a normal BST to Balanced BST
 */
public class ConvertToBalancedBinaryTree {
	
	class Node {
		Node left, right;
		int data;
		Node(int data) {
			this.data = data;
		}
	}
	
	Node root;
	List<Node> nodesList = new ArrayList<Node>();
	
	//store node in a list in inorder fashion
	void storeNode(Node root) {
		if (root==null) {
			return;
		}
		storeNode(root.left);
		nodesList.add(root);
		storeNode(root.right);
	}
	
	void buildTree(Node root) {
		storeNode(root);
		
		int n = nodesList.size();
		buildTreeUtil(nodesList,0,n-1);
	}
	
	//Recursive function to construct binary tree
	Node buildTreeUtil(List<Node> nodes, int start, int end) {
		if(start>end) {
			return null;
		}
		int mid = (start+end)/2;
		Node n = nodes.get(mid);  //this is the root
		
		n.left = buildTreeUtil(nodes, start, mid-1);
		n.right = buildTreeUtil(nodes, mid+1, end);
		
		return n;
	}
	
	void preOrder(Node node) {
		if (node==null) {
			return;
		}
		System.out.print(node.data+" ");
		preOrder(node.left);
		preOrder(node.right);
	}

}
