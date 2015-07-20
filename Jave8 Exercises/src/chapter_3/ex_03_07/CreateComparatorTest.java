package chapter_3.ex_03_07;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class CreateComparatorTest {

    String[] words = {"a", "Ab", " A", "b"};


    @Test
    public void test1() {
        Comparator<String> comp = CreateComparator.create(true, true, true);
        Arrays.sort(words, comp);

        for (String str : words)
            System.out.println(str);

        String[] expected  = {"b", "Ab", "a", " A"};
        assertArrayEquals(expected , words);
    }
    @Test
    public void test2() {
        Comparator<String> comp = CreateComparator.create(true, false, false);
        Arrays.sort(words, comp);

        for (String str : words)
            System.out.println(str);

        String[] expected  = {"b", "a", "Ab", " A"};
        assertArrayEquals(expected , words);
    }
    @Test
    public void test3() {
        Comparator<String> comp = CreateComparator.create(false, true, false);
        Arrays.sort(words, comp);

        for (String str : words)
            System.out.println(str);

        String[] expected  = {" A", "a", "Ab", "b"};
        assertArrayEquals(expected , words);
    }
    @Test
    public void test4() {
        Comparator<String> comp = CreateComparator.create(false, false, true);
        Arrays.sort(words, comp);

        for (String str : words)
            System.out.println(str);

        String[] expected  = {" A", "Ab", "a", "b"};
        assertArrayEquals(expected , words);
    }

}
