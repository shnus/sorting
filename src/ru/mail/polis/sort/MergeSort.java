package ru.mail.polis.sort;

public class MergeSort {

    public <T extends Comparable<T>> T[] sort(T[] a) {
        int n = a.length;
        T[] t = (T[]) new Comparable[n];
        for (int len = 1; len < n; len *= 2) {
            for (int left = 0; left < n - len; left += len + len) {
                int mid = left + len - 1;
                int right = Math.min(left + len + len - 1, n - 1);
                merge(a, t, left, mid, right);
            }
        }

        return a;
    }


    private <T extends Comparable<T>> void merge(T[] a, T[] t, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            t[i] = a[i];
        }
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) a[k] = t[j++];
            else if (j > right) a[k] = t[i++];
            else if (t[j].compareTo(t[i]) < 0) a[k] = t[j++];
            else a[k] = t[i++];
        }

    }


    private <T> void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;

    }
}
