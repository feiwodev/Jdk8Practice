package xyz.feiwo.jdk8.functional;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * Created feiwo by 2019/9/10
 */
public class BinaryOperatorDemo {
    public static void main(String[] args) {

        System.out.println(compute(1, 2, (a, b) -> a - b));
        System.out.println(compute(1, 2, (a, b) -> a + b));

        System.out.println("-------------");

        System.out.println(getShort("hello", "hello world", (a, b) -> a.length() - b.length()));
    }

    private static int compute(int a, int b , BinaryOperator<Integer> binaryOperator) {
        return binaryOperator.apply(a,b);
    }

    private static String getShort(String a, String b, Comparator<String> comparator) {
        return BinaryOperator.maxBy(comparator).apply(a,b);
    }
}
