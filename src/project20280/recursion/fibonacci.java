package project20280.recursion;

public class fibonacci {
    static int callCount = 0;
    static int callCount2 = 0;

    public static int fibonacci(int n) {
        callCount++;
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static long memFibonacci(int n, long[] memo) {
        callCount2++;
        if (n == 0 || n == 1) {
            return n;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        return memo[n] = memFibonacci(n - 1, memo) + memFibonacci(n - 2, memo);
    }

    public static void main(String[] args) {
        int n = 5;
        long start = System.nanoTime();
        int result = fibonacci(n);
        long end = System.nanoTime();

        System.out.println("Fibonacci(" + n + ") = " + result);
        System.out.println("Total recursive calls = " + callCount );
        System.out.println("Elapsed time: " + (end - start) + "ns"+"\n");

        int n2 = 5;
        long[] memo = new long[n2 + 1];

        long start2 = System.nanoTime();
        long result2 = memFibonacci(n2, memo);
        long end2 = System.nanoTime();

        System.out.println("Memoised Fibonacci(" + n2 + ") = " + result2);
        System.out.println("Total recursive calls = " + callCount2 );
        System.out.println("Elapsed time: " + (end2 - start2) + " ns");
    }
}
