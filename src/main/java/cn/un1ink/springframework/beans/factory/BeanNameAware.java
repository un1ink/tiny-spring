package cn.un1ink.springframework.beans.factory;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/3
 */
public interface BeanNameAware extends Aware{

    void setBeanName(String beanName);
}
