package cn.un1ink.springframework.context.event;

import cn.un1ink.springframework.context.ApplicationContext;
import cn.un1ink.springframework.context.ApplicationEvent;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/4
 */
public abstract class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
