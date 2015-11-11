package chapter_8.ex_08_06;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.geometry.Point2D;

public class Point2D_ComparatorTest {

    Point2D_Comparator point2D_Comparator = new Point2D_Comparator();

    @Test
    public void test1() {
        Point2D p1 = new Point2D(1,-1);
        Point2D p2 = new Point2D(1,1);
        int ret = point2D_Comparator.compare(p1, p2);
        assertEquals(-1, ret);
    }
    @Test
    public void test2() {
        Point2D p1 = new Point2D(1,1);
        Point2D p2 = new Point2D(1,1);
        int ret = point2D_Comparator.compare(p1, p2);
        assertEquals(0, ret);
    }
    @Test
    public void test3() {
        Point2D p1 = new Point2D(1,1);
        Point2D p2 = new Point2D(-1,1);
        int ret = point2D_Comparator.compare(p1, p2);
        assertEquals(1, ret);
    }

}
