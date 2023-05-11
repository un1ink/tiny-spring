package cn.un1ink.springframework.context;

import cn.un1ink.springframework.beans.factory.HierarchicalBeanFactory;
import cn.un1ink.springframework.beans.factory.ListableBeanFactory;
import cn.un1ink.springframework.core.io.Resource;
import cn.un1ink.springframework.core.io.ResourceLoader;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/2
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {

}
