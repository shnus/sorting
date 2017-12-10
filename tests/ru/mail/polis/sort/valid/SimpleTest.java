package ru.mail.polis.sort.valid;

import org.junit.Assert;
import org.junit.Test;
import ru.mail.polis.sort.*;
import ru.mail.polis.structures.IntKeyObject;
import ru.mail.polis.structures.IntKeyStringValueObject;
import ru.mail.polis.structures.Numerical;
import ru.mail.polis.structures.SimpleInteger;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Nechaev Mikhail
 * Since 14/11/2017.
 */
public class SimpleTest {

    @Test
    public void test01() throws IOException {
        SimpleSortOnComparisons<String> simpleSort = new SimpleSortOnComparisons<>();
        String[] array = new String[]{"abc", "bcd", "cde", "acd", "zxy", "bba"};
        simpleSort.sort(array);
        Assert.assertArrayEquals(new String[]{"abc", "acd", "bba", "bcd", "cde", "zxy"}, array);
    }

    @Test
    public void testInsertionSort01() throws IOException {
        InsertionSort insertionSort = new InsertionSort();
        String[] array = new String[]{"abc", "bcd", "cde", "acd", "zxy", "bba"};
        insertionSort.sort(array);
        Assert.assertArrayEquals(new String[]{"abc", "acd", "bba", "bcd", "cde", "zxy"}, array);
    }

    @Test
    public void testQuickSort01() {
        QuickSort quickSort = new QuickSort();
        String[] array = new String[]{"abc", "bcd", "cde", "acd", "zxy", "bba"};
        quickSort.sort(array);
        Assert.assertArrayEquals(new String[]{"abc", "acd", "bba", "bcd", "cde", "zxy"}, array);
    }

    @Test
    public void testQuickSortOptim01() {
        QuickSortOptim quickSort = new QuickSortOptim();
        String[] array = new String[]{"abc", "bcd", "cde", "acd", "zxy", "bba"};
        quickSort.sort(array);
        Assert.assertArrayEquals(new String[]{"abc", "acd", "bba", "bcd", "cde", "zxy"}, array);
    }

    @Test
    public void testQuickSortWithInsertions01() {
        QuickSortWithInsertions quickSort = new QuickSortWithInsertions();
        String[] array = new String[]{"abc", "bcd", "cde", "acd", "zxy", "bba"};
        quickSort.sort(array);
        Assert.assertArrayEquals(new String[]{"abc", "acd", "bba", "bcd", "cde", "zxy"}, array);
    }

    @Test
    public void testMergeSort01() {
        MergeSort mergeSort = new MergeSort();
        String[] array = new String[]{"abc", "bcd", "cde", "acd", "zxy", "bba"};
        mergeSort.sort(array);
        Assert.assertArrayEquals(new String[]{"abc", "acd", "bba", "bcd", "cde", "zxy"}, array);
    }

    @Test
    public void testHeapSort01() {
        HeapSort heapSort = new HeapSort();
        String[] array = new String[]{"abc", "bcd", "cde", "acd", "zxy", "bba"};
        heapSort.sort(array);
        Assert.assertArrayEquals(new String[]{"abc", "acd", "bba", "bcd", "cde", "zxy"}, array);
    }

    @Test
    public void testCounterSort01() {
        CountingSort countingSort = new CountingSort();
        IntKeyObject obj1 = new IntKeyStringValueObject(5,"abc");
        IntKeyObject obj2 = new IntKeyStringValueObject(3,"aba");
        IntKeyObject obj3 = new IntKeyStringValueObject(5,"afc");
        IntKeyObject obj4 = new IntKeyStringValueObject(1,"fbc");
        IntKeyObject obj5 = new IntKeyStringValueObject(2,"gbc");
        IntKeyObject obj6 = new IntKeyStringValueObject(1,"rew");
        IntKeyObject[] array = new IntKeyObject[]{obj1, obj2, obj3, obj4, obj5, obj6};
        countingSort.sort(array);
        Assert.assertArrayEquals(new IntKeyObject[]{obj4, obj6, obj5, obj2, obj1, obj3}, array);
    }

    @Test
    public void testLsdSort01() {
        LsdSort lsdSort = new LsdSort();
        SimpleInteger[] array = new SimpleInteger[]{
                new SimpleInteger(54348),
                new SimpleInteger(24645),
                new SimpleInteger(37345),
                new SimpleInteger(15432),
                new SimpleInteger(93464),
                new SimpleInteger(56364),
                new SimpleInteger(34656)
        };
        lsdSort.sort(array);

        Integer[] integers = new Integer[array.length];
        for(int i = 0; i<array.length; i++){
            integers[i] = array[i].getInteger();
        }

        Assert.assertArrayEquals(new Integer[]{
                new Integer(15432),
                new Integer(24645),
                new Integer(34656),
                new Integer(37345),
                new Integer(54348),
                new Integer(56364),
                new Integer(93464)
        }, integers);
    }

    @Test
    public void testLSD() throws IOException {
        LsdSort lsdSort = new LsdSort();
        Numerical[] array = new Numerical[]{new SimpleInteger(10), new SimpleInteger(20), new SimpleInteger(30)};
        lsdSort.sort(array);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testCountingSort() throws IOException {
        CountingSort countingSort = new CountingSort();
        List<IntKeyObject<String>> list = Arrays.asList(new IntKeyStringValueObject(1, "abc"), new IntKeyStringValueObject(2, "bcd"));
        IntKeyObject<String>[] array = (IntKeyObject<String>[]) list.toArray();
        countingSort.sort(array);
    }

    @Test
    public void testCountingSortInteger01() {
        RandomString rs = new RandomString(20);
        for(int i=0; i<100;i++){
            String s = rs.nextSimpleString();
            System.out.println(s);
        }
        LsdSort lsdSort = new LsdSort();
        SimpleInteger[] array = new SimpleInteger[]{
                new SimpleInteger(1),
                new SimpleInteger(3),
                new SimpleInteger(3),
                new SimpleInteger(5),
                new SimpleInteger(2),
                new SimpleInteger(2),
                new SimpleInteger(2)
        };
        lsdSort.sort(array);

        Integer[] integers = new Integer[array.length];
        for(int i = 0; i<array.length; i++){
            integers[i] = array[i].getInteger();
        }

        Assert.assertArrayEquals(new Integer[]{
                new Integer(1),
                new Integer(2),
                new Integer(2),
                new Integer(2),
                new Integer(3),
                new Integer(3),
                new Integer(5)
        }, integers);
    }

}
