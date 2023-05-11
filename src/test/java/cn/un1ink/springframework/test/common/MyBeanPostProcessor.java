package cn.un1ink.springframework.test.common;

import cn.un1ink.springframework.beans.BeansException;
import cn.un1ink.springframework.beans.factory.config.BeanPostProcessor;
import cn.un1ink.springframework.test.bean.UserService;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/2
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        if ("userService".equals(beanName)) {
//            UserService userService = (UserService) bean;
//            userService.setLocation("改为：北京");
//            System.out.println("改为北京");
//        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
