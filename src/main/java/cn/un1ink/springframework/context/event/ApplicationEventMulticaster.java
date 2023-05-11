package cn.un1ink.springframework.context.event;

import cn.un1ink.springframework.context.ApplicationEvent;
import cn.un1ink.springframework.context.ApplicationListener;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/4
 */
public interface ApplicationEventMulticaster {

    void addApplicationListener(ApplicationListener<?> listener);


    void removeApplicationListener(ApplicationListener<?> listener);

    void multicastEvent(ApplicationEvent event);
}
