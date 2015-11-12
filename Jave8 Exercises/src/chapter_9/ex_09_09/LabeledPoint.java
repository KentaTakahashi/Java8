package chapter_9.ex_09_09;

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

}
