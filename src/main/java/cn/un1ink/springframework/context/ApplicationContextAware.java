package cn.un1ink.springframework.context;

import cn.un1ink.springframework.beans.BeansException;
import cn.un1ink.springframework.beans.factory.Aware;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/3
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
