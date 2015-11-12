package chapter_9.ex_09_08;

import java.awt.Point;

public class PointEX extends Point{

    public PointEX(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Point other) {
        long diffX = (long)x - other.x;
        if(diffX < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else if(diffX > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if(diffX != 0)
            return (int) diffX;

        long diffY = (long)y - other.y;
        if(diffY < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else if(diffY > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else
            return (int) diffY;
    }
}
