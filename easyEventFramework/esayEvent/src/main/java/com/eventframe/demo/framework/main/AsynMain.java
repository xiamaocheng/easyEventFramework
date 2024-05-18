package com.eventframe.demo.framework.main;

import com.eventframe.demo.framework.Event;
import com.eventframe.demo.framework.asyn.EventProcessor;

public class AsynMain {

    public static void main(String[] args) {
        EventProcessor processor = new EventProcessor();
        // 生成事件
        Event event = new Event(1, "data");
        // 异步处理事件
        processor.processEvent(event);
    }


}
