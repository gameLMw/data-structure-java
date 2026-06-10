package io.github.gamelmw.recursive;

public class Factorial {
    public static int f(int n) {
        if (n == 1) {
            return 1;
        }
        int sum = n * f(n - 1);
        return sum;
    }
}
