package com.eventframe.demo.mainTest;

import com.eventframe.demo.framework.*;
import com.eventframe.demo.framework.excecption.ExceptionHandler;

import org.junit.jupiter.api.Test;

public class UTest {



    @Test
 public void testMain(){
        EventFramework framework  = new EventFramework();

//    创建事件监听器
//
//    注册事件监听器
//
//
//    触发事件


        // 创建事件源
//        EventSource eventSource = new EventSource();
//
//        // 创建事件监听器
//        EventListener eventListener = new CustomEventListener();
//
//        // 设置事件监听器
//
//        eventSource.setEventListener(eventListener);
//
//        // 触发事件
//        Event event = new Event("Custom Event");
//        eventSource.fireEvent(event);



        // 创建事件监听器
        IEventListener listener1 = new IEventListener() {
            @Override
            public void onEvent(Event event) {
                System.out.println("监听器1处理事件：" + event.getType());
            }
        };

        IEventListener listener2 = new IEventListener() {
            @Override
            public void onEvent(Event event) {
                System.out.println("监听器2处理事件：" + event.getType());
            }
        };

        // 注册事件监听器
        framework.addEventListener("click", listener1);
        framework.addEventListener("hover", listener2);

        // 触发事件
        Event clickEvent = new Event("click");
        Event hoverEvent = new Event("hover");

        framework.fireEvent(clickEvent);
        framework.fireEvent(hoverEvent);

        //事件监听器
        EventListener eventListener = new EventListener();

        // 添加事件处理器
        eventListener.addEventHandler(new EventHandler() {
            @Override
            public void handleEvent(Event event) {
                System.out.println("处理事件：" + event.getName());
            }
        });

        // 模拟事件触发
        Event event = new Event("ClickEvent");
        eventListener.notifyEvent(event);

        // 模拟异常处理
        ExceptionHandler exceptionHandler = new ExceptionHandler();
        try {
            int result = 1 / 0; // 会触发异常
        } catch (ArithmeticException e) {
            exceptionHandler.handleException(e);
        }


        System.out.println(System.getProperty("file.encoding"));
    }



}
