package cn.un1ink.springframework.beans.factory.config;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/1
 */
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
