package Graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSerachInGraph {
	
	private int V;   // No. of vertices 
    private LinkedList<Integer> adj[]; //Adjacency Lists 
  
    // Constructor 
    BreadthFirstSerachInGraph(int v) { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
  
    // Function to add an edge into the graph 
    void addEdge(int v,int w) { 
        adj[v].add(w); 
    } 
	
	public void bfs(int src) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[V];
		
		q.add(src);
		visited[src] = true;
		
		while(!q.isEmpty()) {
			src = q.poll();
			System.out.print(src+" ");
			Iterator<Integer> n = adj[src].listIterator();
			while (n.hasNext()) {
				int i = n.next();
				if (!visited[i]) {
					visited[i] = true;
					q.add(i);
				}
				
			}
		}
	}
	
	void BFS(int s) {  
        boolean visited[] = new boolean[V]; 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
        visited[s]=true; 
        queue.add(s); 
  
        while (queue.size() != 0) { 
            s = queue.poll(); 
            System.out.print(s+" "); 
  
            Iterator<Integer> i = adj[s].listIterator(); 
            while (i.hasNext()) { 
                int n = i.next(); 
                if (!visited[n]) { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            } 
        } 
    } 
	
	public static void main(String[] args) {
		BreadthFirstSerachInGraph g = new BreadthFirstSerachInGraph(4);
		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Breadth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        g.BFS(2);
	}
	

}
