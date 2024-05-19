package com.eventframe.demo.framework.main;

import com.eventframe.demo.framework.Event;
import com.eventframe.demo.framework.EventSource;
import com.eventframe.demo.framework.EventSubscriber;

public class Subscriber {

    public static void main(String[] args) {
        EventSource eventSource = new EventSource();

        EventSubscriber subscriber1 = new EventSubscriber("Subscriber 1");
        EventSubscriber subscriber2 = new EventSubscriber("Subscriber 2");

        eventSource.addListener(subscriber1);
        eventSource.addListener(subscriber2);

        eventSource.fireEvent(new Event("Hello World!"));

        eventSource.removeListener(subscriber2);

        eventSource.fireEvent(new Event("Goodbye World!"));
    }
}
