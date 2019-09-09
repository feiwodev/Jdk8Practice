package xyz.feiwo.jdk8.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created feiwo by 2019/9/9
 *
 * 使用BiFunctional改造对象属性比较
 */
public class BiFunctionalDemo {

    public static void main(String[] args) {

        Person person1 = new Person("zeno", 20);
        Person person2 = new Person("feiwo", 25);
        Person person3 = new Person("xiaoqi", 30);

        List<Person> persons = Arrays.asList(person1,person2,person3);

        List<Person> personsByName = getPersonsByName("zeno", persons);
        personsByName.forEach(System.out::println);

        System.out.println("---------------");

        List<Person> personsByAge = getPersonsByAge(20, persons);
        personsByAge.forEach(System.out::println);

        System.out.println("---------------");

        List<Person> personsFilter = getPersonsFilter(persons, p -> p.getAge() <= 20);
        personsFilter.forEach(System.out::println);

        System.out.println("---------------");

        Person comparePerson = new Person("qq",20);
        List<Person> personsBiFunction = getPersonsBiFunction(comparePerson, persons, (person, personList) ->
                personList.stream().filter(p -> p.getAge() > person.getAge()).collect(Collectors.toList())
        );
        personsBiFunction.forEach(System.out::println);
    }

    private static List<Person> getPersonsByName(String username,List<Person> persons) {
        return persons.stream().filter(person -> person.getUsername().equals(username)).collect(Collectors.toList());
    }

    private static List<Person> getPersonsByAge(int age,List<Person> persons) {
        return persons.stream().filter(person -> person.getAge() > age).collect(Collectors.toList());
    }

    private static List<Person> getPersonsFilter(List<Person> persons, Predicate<Person> predicate) {
        return persons.stream().filter(predicate).collect(Collectors.toList());
    }

    private static List<Person> getPersonsBiFunction(Person p , List<Person> persons, BiFunction<Person,List<Person>,List<Person>> biFunction) {
        return biFunction.apply(p,persons);
    }

}

class Person {
    private String username;
    private Integer age;

    public Person(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
