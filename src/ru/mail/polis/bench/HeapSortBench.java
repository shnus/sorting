package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.HeapSort;
import ru.mail.polis.sort.QuickSort;
import ru.mail.polis.sort.SortUtils;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class HeapSortBench {

    private Integer[] a;
    Integer [][] data;
    Integer[] curr;
    int index;

    @Setup(value = Level.Trial)
    public void setUpTrial() {
        int n = 10;
        data = new Integer[10][n];

        for (int i = 0; i<10; i++) {
            data[i] = SortUtils.generateIntegerArrayDESC(n);
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
                .include(HeapSortBench.class.getSimpleName())
                .warmupIterations(3)
                .measurementIterations(3)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
