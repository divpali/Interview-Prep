package knapsack;

//Time complexity = O(2^n)

public class MinimumSumDifference {

	public static void main(String[] args) {
		int arr[] = { 3, 1, 4, 2, 2, 1 };
		int n = arr.length;
		System.out.println(findMinimumSumDifference(arr, n));
	}

	private static int findMinimumSumDifference(int[] arr, int n) {
		int sumTotal = 0;
		for (int i = 0; i < n; i++) {
			sumTotal += arr[i];
		}

		return findMinimumSumDifference(arr, n, 0, sumTotal);
	}

	private static int findMinimumSumDifference(int[] arr, int n, int sumCal, int sumTotal) {

		if(n==0) {
			return Math.abs((sumTotal-sumCal)-sumCal);
		}
		return Math.min(findMinimumSumDifference(arr, n - 1, sumCal, sumTotal),
				findMinimumSumDifference(arr, n - 1, sumCal + arr[n - 1], sumTotal));
	}

}
