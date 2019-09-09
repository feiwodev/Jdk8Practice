package xyz.feiwo.jdk8.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created feiwo by 2019/9/9
 */
public class PredicateDemo {
    public static void main(String[] args) {

        Predicate<String> predicate = p -> p.length() == 5;
        System.out.println(predicate.test("Hello"));
        System.out.println("-------------------");

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // 过滤偶数
        conditionFilter(list,item -> item % 2 == 0);
        System.out.println("-------------------");

        // 奇数
        conditionFilter(list, item -> item % 2 != 0);
        System.out.println("-------------------");

        // 大于5的数
        conditionFilter(list,item -> item > 5);
        System.out.println("-------------------");

        // 小于3的数
        conditionFilter(list, item -> item < 3);
        System.out.println("-------------------");

        // 打印全部的数
        conditionFilter(list, item -> true);
        System.out.println("-------------------");

        // 大于5的偶数
        conditionFilter2(list,item -> item > 5, item -> item % 2 == 0);

    }

    private static void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer integer : list) {
            if (predicate.test(integer)) {
                System.out.println(integer);
            }
        }
    }

    // predicate 默认方法 and , or , (negate,not) ,isEqual
    private static void conditionFilter2(List<Integer> list,Predicate<Integer> predicate, Predicate<Integer> predicate2) {
        for (Integer integer : list) {
            if (predicate.and(predicate2).test(integer)) {
                System.out.println(integer);
            }
        }
    }
}
