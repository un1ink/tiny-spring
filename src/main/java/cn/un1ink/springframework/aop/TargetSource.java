package cn.un1ink.springframework.aop;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/5
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }


    public Class<?>[] getTargetClass() {
        return this.target.getClass().getInterfaces();
    }

    public Object getTarget() {
        return target;
    }
}
