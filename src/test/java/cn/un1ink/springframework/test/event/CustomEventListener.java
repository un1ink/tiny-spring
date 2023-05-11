package cn.un1ink.springframework.test.event;

import cn.un1ink.springframework.context.ApplicationListener;

import java.util.Date;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/5
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到：" + event.getSource() + "消息;时间：" + new Date());
        System.out.println("消息：" + event.getId() + ":" + event.getMessage());
    }



}

