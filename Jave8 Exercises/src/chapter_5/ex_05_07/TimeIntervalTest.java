package chapter_5.ex_05_07;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

public class TimeIntervalTest {

    TimeInterval interval1 = new TimeInterval(
            LocalDateTime.of(2015, 9, 12, 10, 00),
            LocalDateTime.of(2015, 9, 12, 11, 00));
    TimeInterval interval2 = new TimeInterval(
            LocalDateTime.of(2015, 9, 12, 10, 30),
            LocalDateTime.of(2015, 9, 12, 11, 30));
    TimeInterval interval3 = new TimeInterval(
            LocalDateTime.of(2015, 9, 12, 11, 01),
            LocalDateTime.of(2015, 9, 12, 12, 00));
    @Test
    public void test1() {
        assertTrue(interval1.duplicateChaek(interval2));
    }
    @Test
    public void test2() {
        assertTrue(interval2.duplicateChaek(interval3));
    }
    @Test
    public void test3() {
        assertFalse(interval1.duplicateChaek(interval3));
    }

}
