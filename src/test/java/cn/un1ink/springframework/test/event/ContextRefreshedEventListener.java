package cn.un1ink.springframework.test.event;

import cn.un1ink.springframework.context.ApplicationListener;
import cn.un1ink.springframework.context.event.ContextRefreshedEvent;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/5
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件：" + this.getClass().getName());
    }

}
