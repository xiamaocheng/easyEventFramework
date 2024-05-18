package com.eventframe.demo.framework.filter;

import com.eventframe.demo.framework.Event;


//AI 事件框架中的 事件过滤如何实现 Java
public class MyEventFilter implements EventFilter {
    @Override
    public boolean accept(Event event) {
        // 实现过滤逻辑，例如只接受特定类型的事件
        return event.getSource() instanceof String;
    }
}
