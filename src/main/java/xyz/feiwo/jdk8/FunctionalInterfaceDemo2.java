package xyz.feiwo.jdk8;

import java.util.Arrays;
import java.util.List;

/**
 * Created feiwo by 2019/8/31
 */
public class FunctionalInterfaceDemo2 {

    public static void main(String[] args) {
        // lambda 表达式类型，是根据接收类型来进行推断，推断匿名对象是实现了哪个一个接口
        // 如下：lambda 表达式虽然一样，但接收的类型不一样，所以lambda 表达式创建的匿名对象所实现的接口也不一样，lambda表达式不关心接口方法名，
        // 只关心抽象方法的函数参数列表与返回值
        MyInterface1 myInterface1 = ()-> {};
        MyInterface2 myInterface2 = ()-> {};
        Runnable myRunnable = ()-> {};
        System.out.println("myInterface1 implements interface type ==> "+myInterface1.getClass().getInterfaces()[0]);
        System.out.println("myInterface2 implements interface type ==> "+myInterface2.getClass().getInterfaces()[0]);
        System.out.println("myRunnable implements interface type ==> "+myRunnable.getClass().getInterfaces()[0]);

        // Stream初步
        List<String> strings = Arrays.asList("ok", "love", "the", "dead");
        // normal for uppercase
        for (String s : strings) {
            System.out.print(s.toUpperCase()+" ");
        }
        System.out.println();
        // stream op
        // toUpperCase 输入是当前对象，返回一个String对象，符合Function
        strings.stream().map(String::toUpperCase).map(item -> item+" ").forEach(System.out::print);
    }
}

@FunctionalInterface
interface MyInterface1 {
    void test1();
}

@FunctionalInterface
interface MyInterface2 {
    void test2();
}
