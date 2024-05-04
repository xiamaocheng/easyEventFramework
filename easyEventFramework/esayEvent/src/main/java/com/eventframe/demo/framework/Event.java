package com.eventframe.demo.framework;

public class Event {

    private String type;

    private String name;

//    public Event(String name) {
//        this.name = name;
//    }

    public Event(String type) {
        this.type = type;
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
