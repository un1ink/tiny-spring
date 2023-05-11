package cn.un1ink.springframework.context.event;

import cn.un1ink.springframework.beans.factory.BeanFactory;
import cn.un1ink.springframework.context.ApplicationEvent;
import cn.un1ink.springframework.context.ApplicationListener;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/4
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory){
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(ApplicationEvent event) {
        for(ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
