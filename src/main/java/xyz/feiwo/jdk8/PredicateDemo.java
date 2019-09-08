package xyz.feiwo.jdk8;

import java.util.function.Predicate;

/**
 * Created feiwo by 2019/9/9
 */
public class PredicateDemo {
    public static void main(String[] args) {

        Predicate<String> predicate = p -> p.length() == 5;
        System.out.println(predicate.test("Hello"));

    }
}
