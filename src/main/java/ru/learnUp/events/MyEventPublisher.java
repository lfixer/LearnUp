package ru.learnUp.events;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Locale;

public class MyEventPublisher implements ApplicationContextAware {

    private ApplicationContext context;

    public boolean publishEvent(int difference, int trueNum, Locale locale) {
        if (difference > 0) {
            context.publishEvent(new MyEvent(context.getMessage("greater", null, locale)));
            return true;
        } else if (difference < 0) {
            context.publishEvent(new MyEvent(context.getMessage("less", null, locale)));
            return true;
        } else {
            context.publishEvent(new MyEvent(context.getMessage("win", new Object[]{trueNum}, locale)));
            return false;
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
