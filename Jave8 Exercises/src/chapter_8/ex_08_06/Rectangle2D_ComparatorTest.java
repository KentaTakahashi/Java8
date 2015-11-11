package chapter_8.ex_08_06;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.geometry.Rectangle2D;

public class Rectangle2D_ComparatorTest {

    Rectangle2D_Comparator rectangle2D_Comparator = new Rectangle2D_Comparator();

    @Test
    public void test1() {
        Rectangle2D p1 = new Rectangle2D(0,0,1,1);
        Rectangle2D p2 = new Rectangle2D(0,0,1,2);
        int ret = rectangle2D_Comparator.compare(p1, p2);
        assertEquals(-1, ret);
    }
    @Test
    public void test2() {
        Rectangle2D p1 = new Rectangle2D(0,0,1,1);
        Rectangle2D p2 = new Rectangle2D(0,0,1,1);
        int ret = rectangle2D_Comparator.compare(p1, p2);
        assertEquals(0, ret);
    }
    @Test
    public void test3() {
        Rectangle2D p1 = new Rectangle2D(0,0,2,1);
        Rectangle2D p2 = new Rectangle2D(0,0,1,1);
        int ret = rectangle2D_Comparator.compare(p1, p2);
        assertEquals(1, ret);
    }

}
