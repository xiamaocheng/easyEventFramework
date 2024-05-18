package com.eventframe.demo.framework.asyn;


import com.eventframe.demo.framework.Event;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventProcessor {

    private final ExecutorService executor = Executors.newFixedThreadPool(10);

    public void processEvent(final Event event) {
        executor.submit(new Runnable() {
            @Override
            public void run() {
                // 事件处理逻辑
                handleEvent(event);
            }
        });
    }

    private void handleEvent(Event event) {
        // 事件处理
        System.out.println("异步事件处理中。。。");
    }


}