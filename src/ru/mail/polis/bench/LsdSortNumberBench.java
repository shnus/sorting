package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.LsdSort;
import ru.mail.polis.sort.RandomString;
import ru.mail.polis.structures.SimpleInteger;
import ru.mail.polis.structures.SimpleString;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class LsdSortNumberBench {

    private Integer[] a;
    SimpleInteger[][] data;
    SimpleInteger[] curr;
    static int index = 0;

    @Setup(value = Level.Trial)
    public void setUpTrial() {
        int n = 10000000;
        data = new SimpleInteger[10][n];
        RandomString rs = new RandomString(20);
        String s;
        Random rnd = new Random();
        int nn;
        for (int i = 0; i<10; i++) {
            for(int j =0; j < n; j++) {
                nn = 10000000 + rnd.nextInt(90000000);
                data[i][j] = new SimpleInteger(Integer.valueOf(nn));

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
        bh.consume(new LsdSort().sort(curr));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(LsdSortNumberBench.class.getSimpleName())
                .warmupIterations(3)
                .measurementIterations(3)
                .forks(1)
                .build();

        new Runner(opt).run();

    }
}
