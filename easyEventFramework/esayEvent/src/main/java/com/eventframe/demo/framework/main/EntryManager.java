package com.eventframe.demo.framework.main;

import com.eventframe.demo.framework.Event;
import com.eventframe.demo.framework.distribution.EventDispatcher;

public class EntryManager {
    /**

     * @param args

     */

    public static void main(String[] args) {
        EntryManager eventManager=new EntryManager();

        Entry entry=new Entry();

        entry.setId(1);

        entry.setName("test");

        eventManager.addEntry(entry); //创建

        eventManager.modifyEntry(entry); //改动

        eventManager.deleteEntry(entry); //删除

    }

    public void addEntry(Entry entry) {
        System.out.println("add entry ...id="+entry.getId());

// 事件分发

        Event event = new Event(Event.ENTRY_ADDED, entry, null);

        EventDispatcher.getInstance().dispatchEvent(event);

    }

    public void deleteEntry(Entry entry) {
        System.out.println("delete entry ...id="+entry.getId());

// 事件分发

        Event event = new Event(Event.ENTRY_DELETED, entry, null);

        EventDispatcher.getInstance().dispatchEvent(event);

    }

    public void modifyEntry(Entry entry) {
        System.out.println("modify entry ...id="+entry.getId());

// 事件分发

        Event event = new Event(Event.ENTRY_MODIFIED, entry, null);

        EventDispatcher.getInstance().dispatchEvent(event);

    }

}
