package Easy;

public class GetNthFibonacci {

	public int nthFin(int n) {
		int[] fib = new int[n + 1];

		fib[0] = 0;
		fib[1] = 1;

		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2]; // 0,1,1,2,3,5
		}
		return fib[n];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetNthFibonacci g = new GetNthFibonacci();
		int res = g.nthFin(5);
		System.out.println(res);
	}

}
