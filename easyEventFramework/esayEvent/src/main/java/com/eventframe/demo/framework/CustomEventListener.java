package com.eventframe.demo.framework;

class CustomEventListener implements IEventListener {
    @Override
    public void onEvent(Event event) {
        System.out.println("receview event:" + event.getName());
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
}