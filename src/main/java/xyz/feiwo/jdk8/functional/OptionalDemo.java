package xyz.feiwo.jdk8.functional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created feiwo by 2019/9/10
 */
public class OptionalDemo {

    public static void main(String[] args) {
        // of() 不能为null值 ， empty() 创建value为null的Optional , ofNullable() 值可null可不为null
        Optional<String> optional = Optional.ofNullable(null);
        optional.ifPresent(System.out::println);
        System.out.println(optional.orElse("world"));

        System.out.println("-------------");

        Box box = new Box();
        box.setName("box1");

        Product product = new Product();
        product.setName("mp3");

        Product product1 = new Product();
        product1.setName("mp4");

        box.setProducts(Arrays.asList(product,product1));

        Optional<Box> optionalBox = Optional.ofNullable(box);
        System.out.println(optionalBox.map(Box::getProducts).orElse(Collections.emptyList()));
    }

}

class Box {
    private String name;
    private List<Product> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

class Product {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}