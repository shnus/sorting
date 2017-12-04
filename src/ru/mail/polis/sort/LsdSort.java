package ru.mail.polis.sort;

import ru.mail.polis.structures.Numerical;

public class LsdSort {
    public <T extends Numerical> T[] sort(T[] a) {
        final int r = 10;
        int d = 20;
        for (int k = d - 1; k >= 0; k--) {
            int[] count = new int[r];
            for (T x : a) count[digit(x, k)]++;

            for (int i = 1; i < r; i++) {
                count[i] += count[i - 1];
            }
            T[] res = (T[]) new Numerical[a.length];
            for (int i = a.length - 1; i >= 0; i--) {
                res[--count[digit(a[i], k)]] = a[i];
            }
            System.arraycopy(res, 0, a, 0, a.length);
        }
        return a;
    }

    private <T extends Numerical> int digit(T x, int k) {
        return x.getDigit(k);
    }

}
