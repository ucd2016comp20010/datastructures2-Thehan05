package project20280.recursion;

public class Foo {
    public static void foo(int n) {
        if(n / 2 == 0) {
            System.out.print(n);
            return;
        }
        foo(n / 2);
        System.out.print(n % 2);
    }

    public static void main(String[] args) {
        foo(2468);
    }
}
