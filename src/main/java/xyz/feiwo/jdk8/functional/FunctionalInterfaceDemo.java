package xyz.feiwo.jdk8.functional;

/**
 * Created feiwo by 2019/8/30
 *
 * 自定义函数式接口
 */
public class FunctionalInterfaceDemo {

    private void myMethod(MyInterface myInterface) {
        System.out.println("method 1");
        myInterface.test();
        System.out.println("method 2");
    }

    public static void main(String[] args) {
        FunctionalInterfaceDemo demo = new FunctionalInterfaceDemo();
        // norma implements
        demo.myMethod(new MyInterface() {
            @Override
            public void test() {
                System.out.println("my interface test method");
            }
        });

        System.out.println("-------------------");

        // lambda express
        demo.myMethod(() -> {
            System.out.println("my interface test method lambda express");
        });
        System.out.println("-------------------");
        // get lambda express variable
        MyInterface myInterface = () -> {
            System.out.println("my interface lambda express variable");
        };
        demo.myMethod(myInterface);
        System.out.println("-------------------");
        // lambda 表达式本质上是创建了一个匿名对象
        System.out.println(myInterface.getClass());
        // lambda 表达式的匿名类父类是Object类型
        System.out.println(myInterface.getClass().getSuperclass());
        // 实现了一个接口，是MyInterface接口
        System.out.println(myInterface.getClass().getInterfaces()[0]);

    }
}

// 定义一个函数接口
@FunctionalInterface
interface MyInterface {
    void test();

    // @Override Object方法，并不会增加抽象方法数
    // 因为函数接口最终的实现是一个匿名类对象，在Java中，所有类都默认继承Object类，所以复写Object类中的方法，并不会增加抽象方法数
    @Override
    String toString();
}
