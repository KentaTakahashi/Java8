package chapter_2.ex_02_07;

import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.junit.Test;

public class IsFiniteTest {

    @Test
    public void test1() {
        Stream<String> stream = Stream.empty();
        boolean expectation = true;

        assertTrue("結果が異なります", expectation == IsFinite.isFinite(stream));
    }
    @Test
    public void test2() {
        Stream<String> stream = Stream.of("a", "bc", "def");
        boolean expectation = true;

        assertTrue("結果が異なります", expectation == IsFinite.isFinite(stream));
    }
    @Test
    public void test3() {
        Stream<String> stream = Stream.generate(() -> "id");//無限順次ストリーム
        boolean expectation = false;

        assertTrue("結果が異なります", expectation == IsFinite.isFinite(stream));
    }
}
