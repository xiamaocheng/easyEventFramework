package com.eventframe.demo.framework;

import java.util.ArrayList;
import java.util.List;

public class EventListener  implements  IEventListener{
    @Override
    public void onEvent(Event event) {

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

    private List<EventHandler> eventHandlers;

    public EventListener() {
        this.eventHandlers = new ArrayList<>();
    }

    public void addEventHandler(EventHandler eventHandler) {
        eventHandlers.add(eventHandler);
    }

    public void notifyEvent(Event event) {
        for (EventHandler handler : eventHandlers) {
            handler.handleEvent(event);
        }
    }


}
