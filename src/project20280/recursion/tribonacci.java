package project20280.recursion;

public class tribonacci {
    public static int tribonacci(int n) {

        if (n == 0 || n == 1) return 0;
        if (n == 2) return 1;

        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println("Tribonacci(" + n + ") = " + tribonacci(n));
    }
}
