package cn.un1ink.springframework.aop;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/5
 */
public interface ClassFilter {

    /**
     * Should the pointcut apply to the given interface or target class?
     * @param clazz the candidate target class
     * @return whether the advice should apply to the given target class
     */
    boolean matches(Class<?> clazz);

}
