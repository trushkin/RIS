package by.bsuir;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 7)	Реализовать вывод числа Фибоначчи с определенного числа.
 * Демонстрация работы программы -> fibonacci.png
 * */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = ApplicationContextConnector.getContext();
        Fibonacci fibonacci = context.getBean(Fibonacci.class);
        fibonacci.sequence(0, 34);
    }
}
