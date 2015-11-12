package chapter_9.ex_09_10;

import java.util.Objects;

public class LabeledPoint{
    private String label;
    private int x;
    private int y;

    public LabeledPoint(String label, int x, int y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(this.getClass() != obj.getClass())
            return false;
        LabeledPoint other = (LabeledPoint) obj;

        return Objects.equals(this.label, other.label) &&
               Objects.equals(this.x, other.x) &&
               Objects.equals(this.y, other.y);
    }
    @Override
    public int hashCode() {
        return Objects.hash(label, x, y);
    }

    public int compareTo(LabeledPoint other) {
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
