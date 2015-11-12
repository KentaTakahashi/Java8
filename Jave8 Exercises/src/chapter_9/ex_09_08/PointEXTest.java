package chapter_9.ex_09_08;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class PointEXTest {

    @Test
    public void test1() {
        PointEX p1 = new PointEX(200, 200);
        Point p2 = new Point(200, 0);
        assertEquals("", 200, p1.compareTo(p2));
    }
    @Test
    public void test2() {
        PointEX p1 = new PointEX(Integer.MAX_VALUE, Integer.MIN_VALUE);
        Point p2 = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);
        assertEquals("", Integer.MAX_VALUE, p1.compareTo(p2));
    }
    @Test
    public void test3() {
        PointEX p1 = new PointEX(0, Integer.MIN_VALUE);
        Point p2 = new Point(0, Integer.MIN_VALUE);
        assertEquals("", 0, p1.compareTo(p2));
    }
}
