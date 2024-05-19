package com.eventframe.demo.framework.api;

import com.eventframe.demo.framework.*;
import com.eventframe.demo.framework.asyn.EventProcessor;
import com.eventframe.demo.framework.defalut.FrameFactory;
import com.eventframe.demo.framework.excecption.ExceptionHandler;
import com.eventframe.demo.framework.filter.EventFilter;
import com.eventframe.demo.framework.filter.MyEventFilter;

public class Api {


    public static void main(String[] args) {

        //定义框架
//        EventFramework framework  = new EventFramework();
        FrameFactory factory=new FrameFactory();
        EventFramework framework = factory.getEventFrame(null);

        // 添加事件监听器
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



        framework.addEventListener("click", listener1);

        //添加事件
        Event clickEvent = new Event("click");
        Event hoverEvent = new Event("hover");


        //2.增加特定类型的事件过滤
        EventFilter filter = new MyEventFilter();
        if (filter.accept(clickEvent)) {
            System.out.println("Event accepted by filter");
        } else {
            System.out.println("Event rejected by filter");
        }


        framework.fireEvent(clickEvent);
        framework.fireEvent(hoverEvent);


        EventListener eventListener = new EventListener();


        eventListener.addEventHandler(new EventHandler() {
            @Override
            public void handleEvent(Event event) {
                System.out.println(" 复写处理事件名称event Name:" + event.getName());
            }
        });


        // 模拟异常处理
        ExceptionHandler exceptionHandler = new ExceptionHandler();
        try {

            // 添加事件处理器
        Event event = new Event("ClickEvent");
        eventListener.notifyEvent(event);
         EventProcessor processor = new EventProcessor();

            // 异步处理事件
            processor.processEvent(event);

        } catch (ArithmeticException e) {
            exceptionHandler.handleException(e);
        }



    }







}
