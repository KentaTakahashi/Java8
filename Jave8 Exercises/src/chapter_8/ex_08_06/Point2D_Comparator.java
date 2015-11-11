package chapter_8.ex_08_06;

import java.util.Comparator;

import javafx.geometry.Point2D;

public class Point2D_Comparator implements Comparator<Point2D>{
    @Override
    public int compare(Point2D point1, Point2D point2) {
        double x1 = point1.getX();
        double x2 = point2.getX();
        if(x1 < x2)
            return -1;
        if(x1 > x2)
            return  1;

        double y1 = point1.getY();
        double y2 = point2.getY();
        if(y1 < y2)
            return -1;
        if(y1 > y2)
            return  1;

        return 0;
    }
}
