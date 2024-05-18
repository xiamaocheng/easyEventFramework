package com.eventframe.demo.framework.distribution;

import com.eventframe.demo.framework.Event;
import com.eventframe.demo.framework.EventListener;
import com.eventframe.demo.framework.IEventListener;
import com.eventframe.demo.framework.utils.PropertyMgr;

import java.util.ArrayList;

public class EventDispatcher {
    private static EventDispatcher instance = new EventDispatcher();

    private ArrayList listeners=new ArrayList();

    public static EventDispatcher getInstance() {
        return instance;

    }

    private EventDispatcher() {
        String[] observers = PropertyMgr.getProperty("observers").split(",");

        for(String s : observers) {
            System.out.println(s);

            try {
                this.addListener((IEventListener)Class.forName(s).newInstance());

            } catch (InstantiationException e) {
                e.printStackTrace();

            } catch (IllegalAccessException e) {
                e.printStackTrace();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();

            }

        }

    }

    public synchronized void addListener(IEventListener listener) {
        System.out.println(":"+listener);

        if (listener == null) {
            System.out.println(":"+listener);

            throw new NullPointerException();

        } else {
            listeners.add(listener);

            return;

        }

    }

    public synchronized void removeListener(IEventListener listener) {
        listeners.remove(listener);

    }

    public void dispatchEvent(Event event) {
// System.out.println("msgDispatchEvent");

        int eventType = Integer.parseInt(event.getType());

        long t1=System.currentTimeMillis();

        System.out.println("kaishi="+t1);

        for (int i = 0; i < listeners.size(); i++) {
            try {
                    EventListener listener = (EventListener) listeners.get(i);

                String name = listener.getClass().getName();

                name = name.substring(name.lastIndexOf('.') + 1);

                switch (eventType) {
                    case Event.ENTRY_ADDED: // 创建博客文章

                        listener.entryAdded(event);

                        break;

                    case Event.ENTRY_DELETED: // 删除博客文章

                        listener.entryDeleted(event);

                        break;

                    case  Event.ENTRY_MODIFIED: //改动 博客文章

                        listener.entryModified(event);

                        break;

                }

            } catch (Exception e) {
// logger.error(e);

            }

        }

        System.out.println("cost time="+(System.currentTimeMillis()-t1));

// Profiler.end("msgDispatchEvent");

    }

}
