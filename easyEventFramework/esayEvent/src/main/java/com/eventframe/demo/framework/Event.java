package com.eventframe.demo.framework;

import com.eventframe.demo.framework.main.Entry;

public class Event {

    public static final int ENTRY_ADDED = 0;
    public static final int ENTRY_DELETED =1 ;
    public static final int ENTRY_MODIFIED = 2;
    private String type; //事件类型

    private String name; //事件名称

    private String  message; //事件消息

    private Object    source;
    private Object data;



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public void setData(Object data) {
        this.data = data;
    }

    //    public Event(String name) {
//        this.name = name;
//    }




    public Event(Object source, Object data) {
        this.source = source;
        this.data = data;
    }

    public Object getSource() {
        return source;
    }

    public Object getData() {
        return data;
    }


    public Event(String type) {
        this.type = type;
    }

    public Event(String type, String name) {
        this.type = type;
        this.name = name;
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
