package com.eventframe.demo.framework;

import java.util.ArrayList;
import java.util.List;

public class EventSource {
    private IEventListener listener;

    public void setEventListener(IEventListener listener) {
        this.listener = listener;
    }

    public void fireEvent2(Event event) {
        if (listener != null) {
            listener.onEvent(event);
        }
    }

    private List<IEventListener> listeners = new ArrayList<>();

    public void addListener(IEventListener listener) {
        listeners.add(listener);
    }

    public void removeListener(IEventListener listener) {
        listeners.remove(listener);
    }

    public void fireEvent(Event event) {
        for (IEventListener listener : listeners) {
            listener.onEvent(event);
        }
    }

}
