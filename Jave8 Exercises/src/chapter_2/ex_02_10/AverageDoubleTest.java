package chapter_2.ex_02_10;

import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.junit.Test;

public class AverageDoubleTest {

    @Test
    public void test1() {
        Stream<Double> doubles = Stream.of(0.0, 1.5, 3.0);
        double expectation = 1.5;

        double res = AverageDouble.averageDouble(doubles);
        System.out.println(res);
        assertTrue("結果が異なります", expectation == res);
    }
    @Test
    public void test2() {
        Stream<Double> doubles = Stream.of(1.0, 1.5, 2.7, 1.2, 3.5);
        double expectation = 1.98;

        double res = AverageDouble.averageDouble(doubles);
        System.out.println(res);
        assertTrue("結果が異なります", expectation == res);
    }
    @Test
    public void test3() {
        Stream<Double> doubles = Stream.of(0.0, -1.5, 3.0, -4.5, 23.0);
        double expectation = 4.0;

        double res = AverageDouble.averageDouble(doubles);
        System.out.println(res);
        assertTrue("結果が異なります", expectation == res);
    }

}
