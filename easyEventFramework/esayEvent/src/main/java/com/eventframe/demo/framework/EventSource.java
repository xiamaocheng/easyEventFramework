package com.eventframe.demo.framework;

public class EventSource {
    private IEventListener listener;

    public void setEventListener(IEventListener listener) {
        this.listener = listener;
    }

    public void fireEvent(Event event) {
        if (listener != null) {
            listener.onEvent(event);
        }
    }

}
