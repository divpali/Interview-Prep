package knapsack;

public class Knapsack_Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] val = {1,4,5,7};
	    int[] wt = {1,3,4,5};
	    int W = 7;
	    
	    System.out.println(knapsack(val, wt, W));
	    System.out.println();

	}
	
	private static int knapsack(int[] val, int[] wt, int W) {
		int[][] T = new int[val.length+1][W+1];
		
		for (int i = 0; i <= val.length; i++) {
			for (int j = 0; j <= W; j++) {
				if(i==0 || j==0) {
					T[i][j] = 0;
					continue;
				}
				
				if(j >= wt[i-1]) {
					T[i][j] = Math.max(T[i-1][j], T[i-1][j-wt[i-1]] +val[i-1]);
				} else {
					T[i][j] = T[i-1][j];
				}
			}
		}
		
		return T[val.length][W];
	}

}
