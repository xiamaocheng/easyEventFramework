package com.eventframe.demo.framework;

class CustomEventListener implements IEventListener {
    @Override
    public void onEvent(Event event) {
        System.out.println("receview event:" + event.getName());
    }
}