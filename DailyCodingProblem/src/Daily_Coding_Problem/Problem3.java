package Daily_Coding_Problem;

/*
Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

For example, given the following Node class

class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
The following test should pass:

node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'
 */


class Node {
	Node left;
	Node right;
	int data;
	
	Node(int data) {
		this.data = data;
	}
}


public class Problem3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,2,1,3,4,7,6,8};
		Node root = deserialize(arr, 0, arr.length-1);
		
		preOrderTraversal(root);

	}
	
	//serialize
	private static void preOrderTraversal(Node nodeToTraverse) {
        System.out.println(nodeToTraverse.data);
        if (nodeToTraverse.left != null){
            preOrderTraversal(nodeToTraverse.left);
        }
        if (nodeToTraverse.right != null){
            preOrderTraversal(nodeToTraverse.right);
        }
    }

	private static int findDiv(int[] arr, int val, int low, int high) {
		int i;
		for(i = low; i<=high; i++) {
			if(val < arr[i]) {
				break;
			}
		}
		return i;
	}

	//deserialize
	public static Node deserialize(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		if (low>high) {
			return null;
		}
		Node root = new Node(arr[low]);
		
		int div = findDiv(arr, root.data, low+1, high);
		
		root.left = deserialize(arr, low+1, div-1);
		root.right = deserialize(arr, div, high);
		
		return root;
	}

}
