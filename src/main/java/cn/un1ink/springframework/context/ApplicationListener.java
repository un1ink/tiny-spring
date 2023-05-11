package cn.un1ink.springframework.context;

import java.util.EventListener;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/4
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    void onApplicationEvent(E event);
}
