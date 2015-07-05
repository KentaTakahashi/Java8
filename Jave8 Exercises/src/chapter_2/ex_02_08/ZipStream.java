package chapter_2.ex_02_08;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ZipStream {

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        T[] array1 = (T[]) first.toArray();
        T[] array2 = (T[]) second.toArray();

        int end = Math.min(array1.length, array2.length);

        List<T> marge = new ArrayList<>();
        for(int i = 0; i < end; i++) {
            marge.add(array1[i]);
            marge.add(array2[i]);
        }

        return Stream.of(marge.toArray(array1));
    }

}
