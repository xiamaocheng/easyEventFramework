package com.eventframe.demo.framework;

public class EventSubscriber implements IEventListener {
    private String name;

    public EventSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void onEvent(Event event) {
        System.out.println(name + " received event: " + event.getMessage());
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
