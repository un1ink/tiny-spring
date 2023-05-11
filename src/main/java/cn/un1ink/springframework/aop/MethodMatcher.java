package cn.un1ink.springframework.aop;

import java.lang.reflect.Method;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/5
 */
public interface MethodMatcher {

    /**
     * Perform static checking whether the given method matches. If this
     * @return whether or not this method matches statically
     */
    boolean matches(Method method, Class<?> targetClass);

}
