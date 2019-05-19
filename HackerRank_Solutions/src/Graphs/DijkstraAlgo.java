package Graphs;

import java.util.Arrays;
import java.util.LinkedList;

public class DijkstraAlgo {
	int V;
	LinkedList<Integer> adj[];
	
	DijkstraAlgo(int v) {
		V = v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	
	public void dijkstra(LinkedList<Integer> adj[]) {
		boolean[] visited = new boolean[V];
		int[] distance = new int[V];
		Arrays.fill(distance, Integer.MAX_VALUE);
		for(int i=0;i<V-1;i++) {
			//find vertex with min distance
			int minVertex = findMinVertex(distance, visited);
			//explore neighbours
			for(int j=0;j<v;j++) {
				if()
			}
		}
	}
	
	public int findMinVertex(boolean[] dist, int[] visited) {
		int minVertex = -1;
		for(int i=0;i<dist.length;i++) {
			if(!(visited[i] && (minVertex == -1 || dist[i] < dist[minVertex]))) {
				minVertex = i;
			}
		}
		return minVertex;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
