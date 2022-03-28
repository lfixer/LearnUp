package ru.learnUp.events;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {

    private final String message;

    public MyEvent(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
