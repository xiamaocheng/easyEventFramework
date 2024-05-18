package com.eventframe.demo.framework.distribution;

import com.eventframe.demo.framework.Event;
import com.eventframe.demo.framework.EventListener;
import com.eventframe.demo.framework.IEventListener;

/**

 * 积分管理器

 * @author Administrator

 *

 */


//https://blog.csdn.net/weixin_29268637/article/details/114082495

public class ScoreManager implements IEventListener {


    public void entryAdded(Event entryevent) {
        System.out.println("ScoreManager 处理 博客文章被创建事件。");
    }



    public void entryDeleted(Event entryevent) {
// TODO Auto-generated method stub
        System.out.println("ScoreManager 处理 博客文章被删除事件。");

    }

    public void entryModified(Event entryevent) {
// TODO Auto-generated method stub
        System.out.println("ScoreManager 处理 博客文章被改动事件。");

    }

    @Override
    public void onEvent(Event event) {

    }
}
