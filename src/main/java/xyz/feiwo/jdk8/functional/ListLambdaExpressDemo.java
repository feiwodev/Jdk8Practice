package xyz.feiwo.jdk8.functional;


import java.util.List;

/**
 * Created feiwo by 2019/8/30
 */
public class ListLambdaExpressDemo {

    public static void main(String[] args) {

        List<Integer> integers = List.of(1,2,3,4,5,6,7);

        // normal for list
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }

        System.out.println("-------------------------");

        // foreach list
        for (Integer integer : integers) {
            System.out.println(integer);
        }

        System.out.println("-------------------------");

        // lambda list
        // method reference
        integers.forEach(System.out::println);

    }

}
