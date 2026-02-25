package project20280.recursion;

public class mcCarthy {
    public static int M(int n) {
        if(n > 100) {
            return n - 10;
        }
        return M(M(n+11));
    }

    public static void main(String[] args) {

        int n = 87;
        int result = M(n);
        System.out.println("M(" + n + ") = " + result);
    }
}
