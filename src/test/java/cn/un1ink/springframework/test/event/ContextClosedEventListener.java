package cn.un1ink.springframework.test.event;

import cn.un1ink.springframework.context.ApplicationListener;
import cn.un1ink.springframework.context.event.ContextClosedEvent;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/5
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }

}
