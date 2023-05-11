package cn.un1ink.springframework.aop;

import java.awt.*;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/6
 */
public interface PointcutAdvisor extends Advisor{

    Pointcut getPointcut();
}
