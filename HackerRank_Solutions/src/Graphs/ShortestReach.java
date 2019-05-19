package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ShortestReach {
	
	private int V;
    private LinkedList<Integer> [] G;
    private static int edge_distance;
    
    public ShortestReach(int size, int edge_weight) {
        this.V = size;
        this.G = new LinkedList[V];
        this.edge_distance = edge_weight;
        
        for(int v = 0; v < V; v++)
            G[v] = new LinkedList<>();
    }

    public void addEdge(int first, int second) {
        G[first].add(second);
        G[second].add(first);
    }
    
    public int[] shortestReach(int startId) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startId);

        int[] distance = new int[V];
        Arrays.fill(distance,-1);
        distance[startId] = 0;

        while(!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            for(int neighour : G[node]) {
                if(distance[neighour] == -1) {
                    distance[neighour] = distance[node] + edge_distance;
                    q.add(neighour);
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
		/*
		 * Scanner scanner = new Scanner(System.in); int queries = scanner.nextInt();
		 * 
		 * for (int t = 0; t < queries; t++) {
		 * 
		 * // Create a graph of size n where each edge weight is 6: ShortestReach graph
		 * = new ShortestReach(scanner.nextInt(),6); int m = scanner.nextInt();
		 * 
		 * // read and set edges for (int i = 0; i < m; i++) { int u = scanner.nextInt()
		 * - 1; int v = scanner.nextInt() - 1;
		 * 
		 * // add each edge to the graph graph.addEdge(u, v); }
		 * 
		 * // Find shortest reach from node s int startId = scanner.nextInt() - 1; int[]
		 * distances = graph.shortestReach(startId);
		 * 
		 * for (int i = 0; i < distances.length; i++) { if (i != startId) {
		 * System.out.print(distances[i]); System.out.print(" "); } }
		 * System.out.println(); }
		 * 
		 * scanner.close();
		 */
    	
    	ShortestReach s = new ShortestReach(4, 6);
    	s.addEdge(0, 1);
    	s.addEdge(0, 2);
    	s.addEdge(1, 2);
    	s.addEdge(2, 3);
    	s.addEdge(3, 3);
    	
    	int[] test = s.shortestReach(3);
    	for (int i = 0; i < test.length; i++) {
    		System.out.println("");
			System.out.println(test[i]);
		}
    	
    }

}
