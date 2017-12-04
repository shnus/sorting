package ru.mail.polis.sort;

import java.util.Random;

public class QuickSortWithInsertions {
    public <T extends Comparable<T>> T[] sort(T[] a) {
        shuffleArray(a);
        sort(a, 0, a.length - 1);
        return a;
    }

    private <T extends Comparable<T>> void sort(T[] a, int left, int right) {
        if (left >= right) return;
        int idx = partition(a, left, right);
        if(right-left<20){
            InsertionSort.sort(a, left, idx);
            InsertionSort.sort(a, idx+1, right);
        } else {
            sort(a, left, idx);
            sort(a, idx + 1, right);
        }
    }

    private <T extends Comparable<T>> int partition(T[] a, int left, int right) {
        T p = a[left + (right - left + 1) / 2];
        int i = left, j = right;
        while (i <= j) {
            while (a[i].compareTo(p) < 0) i++;
            while (a[j].compareTo(p) > 0) j--;
            if (i <= j) swap(a, i++, j--);
        }
        return j;
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
