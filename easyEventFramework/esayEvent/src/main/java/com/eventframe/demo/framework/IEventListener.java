package com.eventframe.demo.framework;

public interface IEventListener {

    void onEvent(Event event);

    void entryAdded(Event event);

    void entryDeleted(Event event);

    void entryModified(Event event);
}
