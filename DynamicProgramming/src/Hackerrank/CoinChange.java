package Hackerrank;


/*
 *  Can you determine the number of ways of making change for a particular number of units using the given types of coins?
 */
public class CoinChange {
	
	public int numberOfSolutions(int total, int coins[]){
        int[][]  T = new int[coins.length+1][total+1];
        for (int i = 0; i <= coins.length; i++) {
			T[i][0] = 1;
		}
        for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j <= total; j++) {
				if (j<coins[i-1]) {
					T[i][j] = T[i-1][j];
				} else {
					T[i][j] = T[i-1][j] + T[i][j-coins[i-1]];
				}
			}
		}
        return T[coins.length][total];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoinChange cc = new CoinChange();
        int total = 3;
//        int coins[] = {3,4,6,7,9};
        int[] coins = {8,3,1,2};
        System.out.println(cc.numberOfSolutions(total, coins)); 

	}

}
