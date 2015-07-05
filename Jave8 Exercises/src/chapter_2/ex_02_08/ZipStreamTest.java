package chapter_2.ex_02_08;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Test;

public class ZipStreamTest {
    @Test
    public void test1() {
        Stream<String> first = Stream.of("a", "b", "c");
        Stream<String> second = Stream.of("d", "e", "f", "g");
        Stream<String> res = ZipStream.zip(first, second);
        Stream<String> expectation = Stream.of("a", "d", "b", "e", "c", "f");

        assertTrue("結果が異なります", Arrays.equals(res.toArray(), expectation.toArray()));
    }
    @Test
    public void test2() {
        Stream<String> first = Stream.of("a", "b", "c");
        Stream<String> second = Stream.of("d", "e");
        Stream<String> res = ZipStream.zip(first, second);
        Stream<String> expectation = Stream.of("a", "d", "b", "e");

        assertTrue("結果が異なります", Arrays.equals(res.toArray(), expectation.toArray()));
    }
    @Test
    public void test3() {
        Stream<String> first = Stream.of("a", "b", "c");
        Stream<String> second = Stream.of("d", "e", "f");
        Stream<String> res = ZipStream.zip(first, second);
        Stream<String> expectation = Stream.of("a", "d", "b", "e", "c", "f");

        assertTrue("結果が異なります", Arrays.equals(res.toArray(), expectation.toArray()));
    }

}
