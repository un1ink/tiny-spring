package cn.un1ink.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/6
 */
public interface Advisor {

    Advice getAdvice();

}
