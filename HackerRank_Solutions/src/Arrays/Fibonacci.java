package Arrays;

public class Fibonacci {

    public static int fib(int num){
        if(num == 0){
            return 0;
        }
        if(num ==1){
            return 1;
        }
        return fib(num-1)+fib(num-2);
    }

    public static void main(String[] args){
        int n = fib(5);
        System.out.println(n);

        int n1 = fib1(9);
        System.out.println(n1);
    }

    //Dynamic Programming for finding fibonacci for any number
    private static int fib1(int n)
    {
        int f[] = new int[n+1];
        int i;
        f[0] = 0;
        f[1] = 1;

        for (i = 2; i <= n; i++)
        {
            f[i] = f[i-1] + f[i-2];
        }

        return f[n];
    }



}
