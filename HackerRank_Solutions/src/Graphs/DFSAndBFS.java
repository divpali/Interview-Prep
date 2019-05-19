package Graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DFSAndBFS {
	
	// Graph has a hash map with key-value (id, node) for node look up
		private Map<Integer, Node> nodeLookup = new HashMap<>();
	 
		static class Node {
			private int id;
	 
			// Each node has a LinkedList that keeps track of all adjacent nodes
			List<Node> adjacent = new LinkedList<>();
	 
			private Node(int id) {
				this.id = id;
			}
		}
	 
		private Node getNode(int id) {
			return nodeLookup.get(id);
		}
	 
		public void addEdge(int src, int dest) {
			Node source = getNode(src);
			Node destination = getNode(dest);
			source.adjacent.add(destination);
		}
	 
		public boolean hasPathBFS(int src, int dest) {
			return hasPathBFS(getNode(src), getNode(dest));
		}
	 
		// declare visited hash set inside hasPathDFS() method
		public boolean hasPathDFS(int src, int dest) {
			HashSet<Integer> visited = new HashSet<>();
			Node source = getNode(src);
			Node destination = getNode(dest);
			return hasPathDFS(source, destination, visited);
		}
	 
		private boolean hasPathDFS(Node src, Node dest, Set<Integer> visited) {
	 
			if(visited.contains(src.id)) {
				return false;
			}		
	 
			visited.add(src.id);
	 
			if(src == dest) {
				return true;
			}
	 
			for(Node child : src.adjacent) {
				if(hasPathDFS(child, dest, visited)) {
					return true;
				}
			}
	 
			return false;
		}
	 
		public boolean hasPathBFS(Node src, Node dest) {
			LinkedList<Node> nextToVisit = new LinkedList<>();
			HashSet<Integer> visited = new HashSet<>();
	 
			nextToVisit.add(src);
			while(!nextToVisit.isEmpty()) {
				Node node = nextToVisit.poll();
				if(node == dest) {
						return true;
				}
	 
				if(visited.contains(node)) {
					continue;
				}
				visited.add(node.id);
	 
				for(Node child : node.adjacent) {
					nextToVisit.add(child);				
				}
			}
			return false;
		}
	 
		public static void main (String[] args) throws java.lang.Exception
		{
			DFSAndBFS graph = new DFSAndBFS();
			graph.nodeLookup.put(1, new Node(1));
			graph.nodeLookup.put(2, new Node(2));
			graph.nodeLookup.put(3, new Node(3));
			graph.nodeLookup.put(4, new Node(4));
			graph.nodeLookup.put(5, new Node(5));
	 
			graph.addEdge(1,2);
			graph.addEdge(2,3);
			graph.addEdge(3,4);
	 
			System.out.println(graph.hasPathBFS(1,4));
	 
		}

}
