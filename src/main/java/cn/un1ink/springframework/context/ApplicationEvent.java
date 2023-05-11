package cn.un1ink.springframework.context;

import java.util.EventObject;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/4
 */
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
