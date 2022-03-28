package ru.learnUp;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.learnUp.events.MyEventPublisher;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main implements ApplicationContextAware {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
        MyEventPublisher publisher = context.getBean(MyEventPublisher.class);
        int trueNum = new Random().nextInt(1000);
        Locale locale = Locale.getDefault();
        System.out.println(context.getMessage("hello", null, locale));

        Scanner sc = new Scanner(System.in);

        while (publisher.publishEvent(trueNum - sc.nextInt(), trueNum, locale)) {

        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
