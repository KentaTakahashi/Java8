package chapter_6.ex_06_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class ParallelIncrementer {
    public static void main(String args[]) {

        long result, startTime, endTime;

        startTime = System.nanoTime();
        result = calcAtomicLong();
        endTime = System.nanoTime();
        System.out.println("calcAtomicLong\n    result : "+ result+ "\t time : " + (endTime - startTime) / 1000 + " (nanoseconds)");

        startTime = System.nanoTime();
        result = calcLongAdder();
        endTime = System.nanoTime();
        System.out.println("calcLongAdder\n    result : "+ result+ "\t time : " + (endTime - startTime) / 1000 + " (nanoseconds)");

    }
    /* 計算結果　→　今回の実行環境だと、LongAdderの方が10倍以上早い
     * calcAtomicLong
     *     result : 1000000000  time : 24281992 (nanoseconds)
     * calcLongAdder
     *     result : 1000000000  time : 1943226 (nanoseconds)
    */

    private static long calcAtomicLong() {
        AtomicLong atomicLong = new AtomicLong();
        List<Runnable> runners = new ArrayList<Runnable>();
        for(int i = 0; i < 10000; i++) {
            runners.add(()->{
                for(int j = 0; j < 100000; j++) {
                    atomicLong.incrementAndGet();
                }
            });
        }
        runners.stream().parallel().forEach(x -> x.run());

        return atomicLong.get();
    }

    private static long calcLongAdder() {
        LongAdder longAdder = new LongAdder();
        List<Runnable> runners = new ArrayList<Runnable>();
        for(int i = 0; i < 10000; i++) {
            runners.add(()->{
                for(int j = 0; j < 100000; j++) {
                    longAdder.increment();
                }
            });
        }
        runners.stream().parallel().forEach(x -> x.run());

        return longAdder.longValue();
    }
}
