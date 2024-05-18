package com.eventframe.demo.framework.filter;

import com.eventframe.demo.framework.Event;

public interface EventFilter {
    boolean accept(Event event);

}
