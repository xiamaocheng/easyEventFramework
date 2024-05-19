package com.eventframe.demo.Test.main;

import com.eventframe.demo.framework.Event;
import com.eventframe.demo.framework.filter.EventFilter;
import com.eventframe.demo.framework.filter.MyEventFilter;

public class EventFrameworkExample {
    public static void main(String[] args) {
        Event event = new Event(1, "data");
        EventFilter filter = new MyEventFilter();

        if (filter.accept(event)) {
            System.out.println("Event accepted by filter");
        } else {
            System.out.println("Event rejected by filter");
        }
    }
}