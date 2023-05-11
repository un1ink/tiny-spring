package cn.un1ink.springframework.context;

import cn.un1ink.springframework.context.ApplicationEvent;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/4
 */
public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent event);
}
