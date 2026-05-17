package io.github.gamelmw.recursive;

import java.util.Arrays;

public class Fibonacci {
    private static int fi(int n) {
        int cache[] = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;
        return f(n, cache);
    }

    private static int f(int n, int[] cache) {
        if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        }
        int x = f(n - 1, cache);
        int y = f(n - 2, cache);
        cache[n] = x + y;//记忆法，存入数组
        return cache[n];
    }
}
