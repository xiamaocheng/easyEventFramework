package com.eventframe.demo.framework.main;

import com.eventframe.demo.framework.*;
import com.eventframe.demo.framework.excecption.ExceptionHandler;

public class Main {


    public static void main(String[] args) {
        EventFramework framework  = new EventFramework();




        // 添加事件处理器
        IEventListener listener1 = new IEventListener() {
            @Override
            public void onEvent(Event event) {
                System.out.println(" event 1 style:" + event.getType());
            }

            @Override
            public void entryAdded(Event event) {

            }

            @Override
            public void entryDeleted(Event event) {

            }

            @Override
            public void entryModified(Event event) {

            }
        };

        IEventListener listener2 = new IEventListener() {
            @Override
            public void onEvent(Event event) {
                System.out.println(" event 2 style:" + event.getType());
            }

            @Override
            public void entryAdded(Event event) {

            }

            @Override
            public void entryDeleted(Event event) {

            }

            @Override
            public void entryModified(Event event) {

            }
        };


        framework.addEventListener("click", listener1);
        framework.addEventListener("hover", listener2);


        Event clickEvent = new Event("click");
        Event hoverEvent = new Event("hover");

        framework.fireEvent(clickEvent);
        framework.fireEvent(hoverEvent);


        EventListener eventListener = new EventListener();


        eventListener.addEventHandler(new EventHandler() {
            @Override
            public void handleEvent(Event event) {
                System.out.println("event Name:" + event.getName());
            }
        });
        // 添加事件处理器
        Event event = new Event("ClickEvent");
        eventListener.notifyEvent(event);

        // 模拟异常处理
        ExceptionHandler exceptionHandler = new ExceptionHandler();
        try {
            int result = 1 / 0; // 会触发异常
        } catch (ArithmeticException e) {
            exceptionHandler.handleException(e);
        }



    }







}
