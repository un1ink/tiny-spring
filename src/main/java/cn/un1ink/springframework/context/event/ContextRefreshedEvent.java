package cn.un1ink.springframework.context.event;

import cn.un1ink.springframework.context.ApplicationEvent;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/4
 */
public class ContextRefreshedEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
