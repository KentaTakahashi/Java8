package chapter_2.ex_02_06;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CharacterStream {

    public static Stream<Character> characterStreamEX(String s) {
        return IntStream.range(0, s.length()).mapToObj(s::charAt);
    }

    public static Stream<Character> characterStream(String s) {
        List<Character> result = new ArrayList<>();
        for(char c: s.toCharArray())
            result.add(c);
        return result.stream();
    }
}
