package com.eventframe.demo.framework.defalut;


import com.eventframe.demo.framework.EventFramework;

public class FrameFactory {
    public EventFramework getEventFrame(String Type){
        if(Type == null){
            return new EventFramework();
        }
        return null;
    }
}