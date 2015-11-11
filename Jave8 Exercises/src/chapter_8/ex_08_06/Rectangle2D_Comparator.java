package chapter_8.ex_08_06;

import java.util.Comparator;

import javafx.geometry.Rectangle2D;

public class Rectangle2D_Comparator implements Comparator<Rectangle2D>{
    @Override
    public int compare(Rectangle2D lectangle1, Rectangle2D lectangle2) {
        double x1 = lectangle1.getWidth();
        double x2 = lectangle2.getWidth();
        if(x1 < x2)
            return -1;
        if(x1 > x2)
            return  1;

        double y1 = lectangle1.getHeight();
        double y2 = lectangle2.getHeight();
        if(y1 < y2)
            return -1;
        if(y1 > y2)
            return  1;

        return 0;
    }
}
