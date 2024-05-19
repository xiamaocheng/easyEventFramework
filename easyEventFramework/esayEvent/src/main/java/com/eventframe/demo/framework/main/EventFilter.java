package com.eventframe.demo.framework.main;

import com.eventframe.demo.framework.Event;
import com.eventframe.demo.framework.filter.MyEventFilter;

public class EventFilter {
    public static void main(String[] args) {
        Event event = new Event(1, "data");
        com.eventframe.demo.framework.filter.EventFilter filter = new MyEventFilter();

        if (filter.accept(event)) {
            System.out.println("Event accepted by filter");
        } else {
            System.out.println("Event rejected by filter");
        }
    }
}