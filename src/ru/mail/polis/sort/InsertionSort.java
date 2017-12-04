package ru.mail.polis.sort;

public class InsertionSort {

    static public <T extends Comparable<T>> T[] sort(T[] a) {
        sort(a, 0, a.length-1);
        return a;
    }
    static public <T extends Comparable<T>> T[] sort(T[] a, int left, int right) {
        for (int i = left+1; i <= right; i++) {
            T temp = a[i];
            int j;
            for (j = i - 1; (j >= 0) && (temp.compareTo(a[j]) < 0); j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = temp;
        }
        return a;
    }
}
