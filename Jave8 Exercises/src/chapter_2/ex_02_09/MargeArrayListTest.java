package chapter_2.ex_02_09;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.Test;

public class MargeArrayListTest {

    ArrayList<String> list1 = new ArrayList<>();
    {
        list1.add("a");
        list1.add("b");
        list1.add("c");
    }
    ArrayList<String> list2 = new ArrayList<>();
    {
        list2.add("d");
        list2.add("e");
        list2.add("f");
    }
    ArrayList<String> expectation = new ArrayList<>();
    {
        expectation.add("a");
        expectation.add("b");
        expectation.add("c");
        expectation.add("d");
        expectation.add("e");
        expectation.add("f");
    }

    @Test
    public void test1() {

        ArrayList<String> res = MargeArrayList.margeArrayList1(Stream.of(list1, list2));

        for(String s: res)
            System.out.println(s);

        assertTrue("結果が異なります", res.equals(expectation));
    }
    @Test
    public void test2() {

        ArrayList<String> res = MargeArrayList.margeArrayList2(Stream.of(list1, list2));

        for(String s: res)
            System.out.println(s);

        assertTrue("結果が異なります", res.equals(expectation));
    }
    @Test
    public void test3() {

        ArrayList<String> res = MargeArrayList.margeArrayList3(Stream.of(list1, list2));

        for(String s: res)
            System.out.println(s);

        assertTrue("結果が異なります", res.equals(expectation));
    }

}
