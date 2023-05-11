package cn.un1ink.springframework.beans;

import cn.un1ink.springframework.beans.factory.config.BeanDefinition;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/4/30
 */

@SuppressWarnings("serial")
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
