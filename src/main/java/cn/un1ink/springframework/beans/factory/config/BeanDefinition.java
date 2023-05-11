package cn.un1ink.springframework.beans.factory.config;

import cn.un1ink.springframework.beans.PropertyValue;
import cn.un1ink.springframework.beans.PropertyValues;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/4/30
 */
public class BeanDefinition {

    String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;

    String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;

    private String scope;
    private boolean singleton = true;

    private boolean prototype = true;

    /**
     * bean对象所属class
     */
    private Class beanClass;

    /**
     * bean对象属性(用于依赖注入)
     */
    private PropertyValues propertyValues;
    /**
     * 用于bean对象初始化
     */
    private String initMethodName;

    /**
     * 用于bean对象销毁
     */
    private String destroyMethodName;


    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues;
    }


    public Class getBeanClass() {
        return beanClass;

    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }


    public boolean isSingleton(){
        return singleton;
    }


    public boolean isPrototype() {
        return prototype;
    }

    public void setScope(String scope) {
        this.scope = scope;
        this.singleton = SCOPE_SINGLETON.equals(scope);
        this.prototype = SCOPE_SINGLETON.equals(scope);
    }
}
