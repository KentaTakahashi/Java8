package chapter_8.ex_08_13;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Repeatable (MyTestCases.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyTestCase {
    int params();
    int expected();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyTestCases {
    MyTestCase[] value();
}