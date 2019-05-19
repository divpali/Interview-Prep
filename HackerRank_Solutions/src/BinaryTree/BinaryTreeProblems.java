package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
	}
}

public class BinaryTreeProblems {
	
	//Check if two binary trees are identical
	public boolean identicalTree(Node root1, Node root2) {
		if(root1 == null || root2 == null) {
			return false;
		}
		if(root1 == null && root2 == null) {
			return true;
		}
		return root1.data == root2.data 
				&& identicalTree(root1.left, root2.left)
				&& identicalTree(root1.right, root2.right);
	}

	// Find lowest common ancestor
	public Node lowestCommonAncestors(Node root, int A, int B) {
		Node current = root;
		if (current == null) {
			return null;
		}
		if (current.data == A || current.data == B) {
			return current;
		}
		Node left = lowestCommonAncestors(current.left, A, B);
		Node right = lowestCommonAncestors(current.right, A, B);

		if (left != null && right != null) {
			return current;
		}
		if (left == null) {
			return right;
		} else {
			return left;
		}

	}

	//Create BalancedBinarySearch Tree From Sorted Array
	public Node createBalancedBinarySearchTreeFromSortedArray(int[] arr) {
		int start = 0;
		int end = arr.length;
		return createBalancedBinarySearchTreeFromSortedArray(arr, start, end);
	}

	private Node createBalancedBinarySearchTreeFromSortedArray(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		if (start < end) {
			int mid = (start + end) / 2;
			Node node = new Node(arr[mid]);
			node.left = createBalancedBinarySearchTreeFromSortedArray(arr, start, mid - 1);
			node.right = createBalancedBinarySearchTreeFromSortedArray(arr, mid + 1, end);
			return node;
		}
		return first;

	}

	public int minDepthOfBT(Node root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null || root.right == null) {
			return 1;
		}
		int left = (root.left != null) ? minDepthOfBT(root.left) : Integer.MAX_VALUE;
		int right = (root.right != null) ? minDepthOfBT(root.right) : Integer.MAX_VALUE;
		return Math.min(left, right) + 1;
	}

	//Level Order Traversal of Binary Tree
	public void levelOrderTraversal(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			Node node = q.poll();
			System.out.print(node.data + " ");
			if (node.left != null) {
				q.add(node.left);
			}
			if (node.right != null) {
				q.add(node.right);
			}
		}
	}

	//Spiral Order Traversal of Binary Tree
	public void spiralOrderTraversal(Node root) {
		Stack<Node> stk1 = new Stack<Node>();
		Stack<Node> stk2 = new Stack<Node>();
		stk1.push(root);
		while (!stk1.isEmpty() || !stk2.isEmpty()) {
			while (!stk1.isEmpty()) {
				Node node1 = stk1.pop();
				System.out.print(node1.data + " ");
				if (node1.right != null) {
					stk2.push(node1.right);
				}
				if (node1.left != null) {
					stk2.push(node1.left);
				}
			}
			while (!stk2.isEmpty()) {
				Node n = stk2.peek();
				Node node2 = stk2.pop();
				System.out.print(node2.data + " ");
				if (node2.left != null) {
					stk1.push(node2.left);
				}
				if (node2.right != null) {
					stk1.push(node2.right);
				}
			}
		}
	}

	//Level by level printing of Binary tree
	public void levelByLevelPrinting(Node root) {
		if(root == null) return;
		Queue<Node> q1 = new LinkedList<>();
		Queue<Node> q2 = new LinkedList<>();
		q1.add(root);
		while(!q1.isEmpty() || !q2.isEmpty()) {
			while(!q1.isEmpty()) {
				root = q1.poll();
				System.out.println(root.data);
				if(root.left != null) {
					q2.add(root.left);
				}
				if(root.right != null) {
					q2.add(root.right);
				}
			}
			System.out.println();
			while(!q2.isEmpty()) {
				root = q2.poll();
				System.out.println(root.data);
				if(root.left != null) {
					q1.add(root.left);
				}
				if(root.right != null) {
					q1.add(root.right);
				}
			}
			System.out.println();
		}
	}
	
	
	Node first, middle, last, prev;

	void recoverTree(Node root) {
		first = middle = last = prev = null;
		recoverTreeUtil(root);

		// swap first and the last
		if (first != null && last != null) {
			int temp = first.data;
			first.data = last.data;
			last.data = temp;
		}

		// adjacent swap
		if (first != null && middle != null) {
			int temp1 = first.data;
			first.data = middle.data;
			middle.data = temp1;
		}

	}

	private void recoverTreeUtil(Node root) {
		if (root != null) {
			recoverTreeUtil(root.left);
			if (prev != null && root.data < prev.data) {
				if (first == null) {
					first = prev;
					middle = root;
				} else {
					last = root;
				}
			}
			prev = root;
			recoverTreeUtil(root.right);
		}

	}

	static void printInOrder(Node root) {
		if (root != null) {
			printInOrder(root.left);
			System.out.print(root.data + " ");
			printInOrder(root.right);
		}
	}

	//Root to leaf sum path of Binary tree
	private boolean sumPath(Node root) {
		// TODO Auto-generated method stub
		int sum = 26;
		List<Integer> result = new ArrayList<Integer>();
		return sumPath(root, sum, result);
	}

	private boolean sumPath(Node root, int sum, List<Integer> result) {
		// TODO Auto-generated method stub
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			if (root.data == sum) {
				result.add(root.data);
				return true;
			} else {
				return false;
			}
		}
		if (sumPath(root.left, sum - root.data, result)) {
			result.add(root.data);
			return true;
		}
		if (sumPath(root.right, sum - root.data, result)) {
			result.add(root.data);
			return true;
		}
		return false;

	}

	// total number of unique bST with val 1 to n
	ArrayList<Node> constructTrees(int start, int end) {
		ArrayList<Node> list = new ArrayList<Node>();
		if (start > end) {
			list.add(null);
			return list;
		}
		for (int i = start; i <= end; i++) {
			ArrayList<Node> leftSubtree = constructTrees(start, i - 1);

			ArrayList<Node> rightSubtree = constructTrees(i + 1, end);

			for (int j = 0; j < leftSubtree.size(); j++) {
				Node left = leftSubtree.get(j);
				for (int k = 0; k < rightSubtree.size(); k++) {
					Node right = rightSubtree.get(k);
					Node node = new Node(i);
					node.left = left;
					node.right = right;
					list.add(node);
				}
			}
		}
		return list;
	}

	// 1
	// 2 3
	// 4 5
	// 7 8
	public static void main(String[] args) {
		BinaryTreeProblems b = new BinaryTreeProblems();
		Node n = new Node(1);
		n.left = new Node(2);
		n.left.left = new Node(4);
		n.left.right = new Node(5);
		n.left.right.left = new Node(7);
		n.left.right.right = new Node(8);
		n.right = new Node(3);

		Node res = b.lowestCommonAncestors(n, 4, 8);
		System.out.println("lowest common ancestors : " + res.data);

		System.out.println("minimum depth of tree : " + b.minDepthOfBT(n));

		System.out.println("level order traversal");
		b.levelOrderTraversal(n);
		System.out.println();

		System.out.println("spiral order traversal");
		b.spiralOrderTraversal(n);

		System.out.println();
		System.out.println("Recover Tree:");
		Node root = new Node(6);
		root.left = new Node(10);
		root.right = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.right = new Node(12);
		root.right.left = new Node(7);

		b.recoverTree(root);
//        b.correctBST(root);
		printInOrder(root);

		b.sumPath(root);

		System.out.println();
		System.out.println("Construct trees");
		ArrayList<Node> res1 = b.constructTrees(1, 3);
		for (int i = 0; i < res1.size(); i++) {
			printPreOrder(res1.get(i));
			System.out.println();
		}
	}

	static void printPreOrder(Node root) {
		if (root != null) {
			System.out.print(root.data);
			printPreOrder(root.left);
			printPreOrder(root.right);
		}
	}

}
