package com.eventframe.demo.framework;

import com.eventframe.demo.framework.main.Entry;

public class Event {

    public static final int ENTRY_ADDED = 0;
    public static final int ENTRY_DELETED =1 ;
    public static final int ENTRY_MODIFIED = 2;
    private String type;

    private String name;

//    public Event(String name) {
//        this.name = name;
//    }

    public Event(String type) {
        this.type = type;
    }

    public Event(int entryAdded, Entry entry, Object o) {
        this.name="1";
        this.type="2";
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
