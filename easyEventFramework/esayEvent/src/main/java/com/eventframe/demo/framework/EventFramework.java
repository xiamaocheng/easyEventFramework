package com.eventframe.demo.framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventFramework {
    private Map<String, List<IEventListener>> eventListener=new HashMap<>();

    //注册事件监听器

    public void addEventListener(String eventType, IEventListener listener){

        if(!eventListener.containsKey(eventType)){
            eventListener.put(eventType,new ArrayList<>());
        }
        eventListener.get(eventType).add(listener);
    }


    //触发事件
    public  void fireEvent(Event event){

        String eventType=event.getType();
        if(eventListener.containsKey(eventType)){
            List<IEventListener> listeners = eventListener.get(eventType);
            for (IEventListener listener: listeners
                 ) {
                 listener.onEvent(event);
            }
        }
    }





}
