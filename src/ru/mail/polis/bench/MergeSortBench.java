package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.InsertionSort;
import ru.mail.polis.sort.MergeSort;
import ru.mail.polis.sort.SortUtils;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class MergeSortBench {

    private Integer[] a;
    Integer [][] data;
    Integer[] curr;
    int index;

    @Setup(value = Level.Trial)
    public void setUpTrial() {
        data = new Integer[10][1000];

        for (int i = 0; i<4; i++) {
            data[i] = SortUtils.generateIntegerArray(1000);
        }
        for (int i = 0; i<7; i++) {
            data[i] = SortUtils.generateIntegerArrayASC(1000);
        }
        for (int i = 0; i<10; i++) {
            data[i] = SortUtils.generateIntegerArrayDESC(1000);
        }

    }

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        curr = Arrays.copyOf(data[index], data[index].length);
        index = (index + 1) % 10;
    }

    @Benchmark
    public void measureQuickSort(Blackhole bh) {
        bh.consume(new MergeSort().sort(curr));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MergeSortBench.class.getSimpleName())
                .warmupIterations(6)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
