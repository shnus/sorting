package ru.mail.polis.e_olymp;

import ru.mail.polis.sort.InsertionSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


public class QuickSort_4848 {

    public static void main(String[] args) {

        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        String line;

        try {
            while ((line = bi.readLine()) != null) {
                String[] s = line.split(" ");
                Integer[] integers = new Integer[s.length];
                int j = 0;
                for(String ss: s){
                    integers[j++] = Integer.valueOf(ss);
                }

                new HeapSort().sort(integers);

                for(Integer i: integers){
                    System.out.print(i+" ");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class HeapSort {
    public <T extends Comparable<T>> T[] sort(T[] heap) {
        int heapSize = heap.length;
        build(heap);
        for(int i = 0; i<heap.length-1; i++){
            swap(heap, 0, heapSize-1);
            heapSize--;
            shiftDown(heap, heapSize, 0);
        }

        return heap;

    }

    private  <T extends Comparable<T>> void build(T[] heap) {
        int n = heap.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            shiftDown(heap, n, i);
        }
    }

    private  <T extends Comparable<T>> void shiftDown(T[] heap, int size,  int i){
        int maxIndex = i;
        int l = 2*i+1;
        int r = 2*i+2;
        if(l<size && (heap[l].compareTo(heap[maxIndex])>0)){
            maxIndex = l;
        }

        if(r<size && (heap[r].compareTo(heap[maxIndex])>0)){
            maxIndex = r;
        }

        if(i!=maxIndex){
            T cur = heap[i];
            heap[i] = heap[maxIndex];
            heap[maxIndex] = cur;
            shiftDown(heap, size, maxIndex);
        }
    }

    private <T> void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}

