package chapter_3.ex_03_20;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionalMap {

    public static <T, U> List<U> map(List<T> list, Function<T, U> func) {
        List<U> res = new ArrayList<U>();
        for(T t : list)
            res.add(func.apply(t));
        return res;
    }

    public static void main(String args[]) {
        List<String> strList = new ArrayList<String>();
        strList.add("apple");
        strList.add("banana");
        strList.add("cherry");

        List<Integer> numList = map(strList, String::length);

        for(int i: numList)
            System.out.println(i);
        /*
         * 実行結果
         * 5
         * 6
         * 6
         *
         * */
    }
}
