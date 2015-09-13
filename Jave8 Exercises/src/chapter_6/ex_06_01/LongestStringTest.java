package chapter_6.ex_06_01;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LongestStringTest {

    List<String> countrys = Arrays.asList(
            "Iceland",
            "Afghanistan",
            "Kazakhstan",
            "Sweden",
            "Tunisia",
            "Turkmenistan",
            "Lebanon"
            );

    @Test
    public void test() {
        countrys.stream().parallel().forEach(country -> {
            String result = LongestString.update(country);
            System.out.println("update(" + country + ") -> result:" + result);
            });
        assertTrue("Turkmenistan" == LongestString.update(""));
    }
    /* 実行結果
     * update(Sweden) -> result:Sweden
     * update(Kazakhstan) -> result:Kazakhstan
     * update(Afghanistan) -> result:Afghanistan
     * update(Iceland) -> result:Iceland
     * update(Tunisia) -> result:Iceland
     * update(Lebanon) -> result:Iceland
     * update(Turkmenistan) -> result:Turkmenistan
     */

}
