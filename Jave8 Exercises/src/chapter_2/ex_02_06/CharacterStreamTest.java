package chapter_2.ex_02_06;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Test;

public class CharacterStreamTest {

    @Test
    public void test() {
        Stream<Character> s1 = CharacterStream.characterStream("test");
        Stream<Character> s2 = CharacterStream.characterStreamEX("test");

        assertTrue("結果が異なります", Arrays.equals(s1.toArray(), s2.toArray()));
    }

}
