package Graphs;

import java.util.*;

public class DetectCycleInGraph {
	
	int V;
	LinkedList<Integer> adj[];
	
	public DetectCycleInGraph(int v) {
		V = v;
		adj = new LinkedList[v];
		for(int i = 0;i<v;i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int u, int v) {
		adj[u].add(v);
	}
	
	public boolean isCyclic() {
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];
		
		for(int i=0;i<V;i++) {
			if(isCyclicUtil(i, visited, recStack)) {
				return true;
			}
		}
		return false;
	}
	
	//			0
	//		  /   \
	//		 1 --- 2
	//			   |	 				
	//			   3---
	//			   |--|
	private boolean isCyclicUtil(int p, boolean[] visited, boolean[] recStack) {
 		if(recStack[p]) { //true, true, true, true
			return true;
		}
		if(visited[p]) { //true, true, true, true
			return false;
		}
		visited[p] = true;
		recStack[p] = true;
		Iterator<Integer> i = adj[p].listIterator();
		while(i.hasNext()) {
			int n = i.next();
			if(isCyclicUtil(n, visited, recStack)) {
				return true;
			}
		}
		recStack[p] = false;
		
		return false;
	}

	public static void main(String[] args) {
		DetectCycleInGraph g = new DetectCycleInGraph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
//		g.addEdge(1, 2);
//		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);		
		System.out.println(g.isCyclic());
	}

}
