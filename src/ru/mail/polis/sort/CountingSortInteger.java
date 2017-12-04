package ru.mail.polis.sort;

public class CountingSortInteger {

    public Integer[] sort(Integer[] a) {
        int max = findMax(a);
        int[] count = new int[max + 1];
        for (Integer x : a) {
            count[x]++;
        }
        int pos = 0;
        for (int k = 0; k <= max; k++) {
            for (int i = 0; i < count[k]; i++) {
                a[pos++] = k;
            }
        }
        return a;
    }


    public int findMax(Integer[] a){
        int max = 0;
        for (Integer x: a){
            max = Math.max(max,x);
        }
        return max;
    }
}
