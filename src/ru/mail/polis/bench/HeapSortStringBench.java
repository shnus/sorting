package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.HeapSort;
import ru.mail.polis.sort.MergeSort;
import ru.mail.polis.sort.RandomString;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class HeapSortStringBench {

    private Integer[] a;
    String [][] data;
    String[] curr;
    static int index = 0;

    @Setup(value = Level.Trial)
    public void setUpTrial() {
        int n = 10;
        data = new String[10][n];
        RandomString rs = new RandomString(20);
        for (int i = 0; i<10; i++) {
            for(int j =0; j < n; j++) {
                data[i][j] = rs.nextString();
            }
        }

    }
    static int status = 1;
    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        curr = Arrays.copyOf(data[index], data[index].length);
        index = (index + 1) % 10;
    }

    @Benchmark
    public void measureQuickSort(Blackhole bh) {
        bh.consume(new HeapSort().sort(curr));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(HeapSortStringBench.class.getSimpleName())
                .warmupIterations(3)
                .measurementIterations(3)
                .forks(1)
                .build();

        new Runner(opt).run();

    }
}
