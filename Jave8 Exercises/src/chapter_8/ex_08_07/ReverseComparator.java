package chapter_8.ex_08_07;

import java.util.Comparator;

public class ReverseComparator{

    public static void main(String args[]) {
        Comparator comparator1 = Comparator.nullsFirst(Comparator.naturalOrder()).reversed();
        Comparator comparator2 = Comparator.nullsLast(Comparator.reverseOrder());
    }
}
