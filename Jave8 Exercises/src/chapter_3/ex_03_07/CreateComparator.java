package chapter_3.ex_03_07;

import java.util.Comparator;

public class CreateComparator {
    public static Comparator<String> create(boolean isReverseOrder, boolean isIgnoreCase, boolean isExcludeBlank) {
        return (s1, s2) -> {
            int res;

            if(isExcludeBlank) {
                s1 = s1.replace(" ", "");
                s2 = s2.replace(" ", "");
            }

            if(isIgnoreCase)
                res = s1.compareToIgnoreCase(s2);
            else
                res = s1.compareTo(s2);

            if(isReverseOrder)
                return -res;
            else
                return res;
        };
    }
}
