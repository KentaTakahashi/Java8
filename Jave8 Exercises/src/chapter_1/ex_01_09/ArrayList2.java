package chapter_1.ex_01_09;

import java.util.ArrayList;


public class ArrayList2<T> extends ArrayList<T> implements Collection2<T>{
    public static void main(String args[]){
        Collection2<String> strings = new ArrayList2<String>();
        strings.add("Alice ");
        strings.add("Bob");
        strings.add("Carol");
        strings.add("Dave");
        strings.add("Charlie");
        strings.add("Ellen");


        //通常のforEach、全要素を標準出力
        System.out.println("-------------forEach--------------");
        strings.forEach(System.out::println);

        //今回作成したforEachIf、頭文字がCの要素のみを標準出力
        System.out.println("-------------forEachIf startsWith(\"C\")--------------");
        strings.forEachIf(
                System.out::println,
                s -> s.startsWith("C")
                );
    }
}