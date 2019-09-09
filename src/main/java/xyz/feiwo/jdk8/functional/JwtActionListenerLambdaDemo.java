package xyz.feiwo.jdk8.functional;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created feiwo by 2019/8/30
 *
 * lambda 表达式 ， 需要函数接口的支持
 * 函数接口： 有且只有一个抽象方法的接口，就可以看做是一个函数接口，一个接口用@FunctionalInterface注解接口的就是一个函数式接口
 * 函数式接口，可以是lambda表达式 ， 方法引用 ， 构造方法的引用构造。
 *
 */
public class JwtActionListenerLambdaDemo {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("My Frame");
        JButton jButton = new JButton("My Button");

        // 常规模式下使用，你们匿名类来实现ActionListener接口
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("normal action listener");
            }
        });
        // 使用lambda 表示是来实现Action Listener
        jButton.addActionListener(event -> {
            System.out.println("lambda express action listener");
        });

        jFrame.add(jButton);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
