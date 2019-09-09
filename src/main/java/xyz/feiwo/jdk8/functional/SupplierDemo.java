package xyz.feiwo.jdk8.functional;

import java.util.function.Supplier;

/**
 * Created feiwo by 2019/9/10
 */
public class SupplierDemo {
    public static void main(String[] args) {
        // 普通写法，不推荐
        Supplier<Student> supplier = () -> new Student();
        System.out.println(supplier.get());

        System.out.println("-----------");

        // 函数引用 ， 推荐
        Supplier<Student> supplier2 = Student::new;
        System.out.println(supplier2.get());
    }
}

class Student {
    private String name = "非我";
    private Integer age = 20;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}