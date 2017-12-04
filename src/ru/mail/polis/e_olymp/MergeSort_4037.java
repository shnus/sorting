package ru.mail.polis.e_olymp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort_4037 {
    public static void main(String[] args) {

        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        String line;

        try {
            while ((line = bi.readLine()) != null) {
                int n = Integer.valueOf(line);
                Robot[] robots = new Robot[n];
                for (int i = 0; i < n; i++){
                    String[] s = bi.readLine().split(" ");
                    robots[i] = new Robot(Integer.valueOf(s[0]),Integer.valueOf(s[1]));
                }

                new MergeSort().sort(robots);

                for(Robot r: robots){
                    StringBuilder ss = new StringBuilder();
                    ss.append(r.firstNum).append(" ").append(r.secondNum);
                    System.out.println(ss.toString());
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Robot implements Comparable<Robot>{

        int firstNum;
        int secondNum;

        public Robot(int firstNum, int secondNum){
            this.firstNum = firstNum;
            this.secondNum = secondNum;
        }

        @Override
        public int compareTo(Robot o) {
            return firstNum-o.firstNum;
        }
    }

}
class MergeSort {

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


