package xyz.feiwo.jdk8;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created feiwo by 2019/9/2
 *
 * FunctionalInterface 作为函数参数，内置默认方法
 */
public class FunctionalInterfaceDemo3 {


    public static void main(String[] args) {
        // 将lambda expression作为参数传入方法
        // 使用Function函数接口作为方法参数，可以将执行逻辑外化
        System.out.println(compute(2,v -> v * 2));
        System.out.println(compute(2, v -> v + 8));
        System.out.println(compute(2, v -> v * v));

        // compose and andThen
        System.out.println(compute2(2, String::valueOf, v -> v * v));
        System.out.println(compute3(2,String::valueOf, Integer::valueOf));

        // two function params
        System.out.println(compute4(1,2,(v1,v2) -> String.valueOf(v1 + v2)));
        System.out.println(compute5(2,2,(v1,v2) -> v1 * v2, String::valueOf));
    }

    // 将FunctionalInterface作为方法参数
    private static Integer compute(Integer a , Function<Integer, Integer> func) {
        return func.apply(a);
    }

    private static String compute2(Integer a, Function<Integer,String> fun1,Function<Integer,Integer> func2) {
        return fun1.compose(func2).apply(a);
    }

    private static Integer compute3(Integer a,Function<Integer,String> fun1,Function<String,Integer> fun2) {
        return fun1.andThen(fun2).apply(a);
    }

    private static String compute4(Integer a, Integer b, BiFunction<Integer,Integer,String> biFunction) {
        return biFunction.apply(a,b);
    }

    private static String compute5(Integer a, Integer b,BiFunction<Integer,Integer,Integer> biFunction,Function<Integer,String> function) {
        return biFunction.andThen(function).apply(a,b);
    }
}
