package ru.mail.polis.sort;

import java.util.Random;

public class QuickSortOptim {

    public <T extends Comparable<T>> T[] sort(T[] a) {
        shuffleArray(a);
        sort(a, 0, a.length - 1);
        return a;
    }

    private <T extends Comparable<T>> void sort(T[] a, int left, int right) {
        if (left >= right) return;
        int lt = left, gt = right;
        T v = a[left];
        int i = left;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) swap(a, lt++, i++);
            else if (cmp > 0) swap(a, i, gt--);
            else i++;
        }
        sort(a, left, lt - 1);
        sort(a, gt + 1, right);
    }


    private <T> void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private <T> void shuffleArray(T[] a) {
        Random rnd = new Random();
        for (int i = a.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            swap(a, i, index);
        }
    }
}
