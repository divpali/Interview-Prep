package Arrays;

public class MaxSingleSellProfit {
	
	public static int maxProfit(int[] prices) {
		int minP = Integer.MAX_VALUE;
		int profit = 0;
		
		for (int i = 0; i < prices.length; i++) {
			profit = Math.max(profit, prices[i]-minP);
			minP = Math.min(prices[i], minP);
		}
		return profit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {7,1,5,3,6,4};
		int max_profit = maxProfit(arr);
		System.out.println(max_profit);
	}

}
