package cn.un1ink.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.un1ink.springframework.beans.BeansException;
import cn.un1ink.springframework.beans.PropertyValue;
import cn.un1ink.springframework.beans.PropertyValues;
import cn.un1ink.springframework.beans.factory.*;
import cn.un1ink.springframework.beans.factory.config.*;
import cn.un1ink.springframework.context.ApplicationContextAware;
import com.sun.org.apache.bcel.internal.Const;
import org.omg.PortableServer.POAPackage.ObjectAlreadyActive;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/4/30
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();


    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = resolveBeforeInstantiation(beanName, beanDefinition);
            if(null != bean){
                return bean;
            }
            // 1. 根据args(默认为null)选择构造函数创建bean单例对象
            bean = createBeanInstance(beanDefinition, beanName, args);
            // 2. 根据PropertyValues填充bean属性
            applyPropertyValues(beanName, bean, beanDefinition);
            // 3. 执行Bean的初始化(包含上下文)
            bean = initializeBean(beanName, bean, beanDefinition);


        } catch (Exception e) {
            System.out.println("error bean name :" + beanName);
            throw new BeansException("Instantiation of bean failed", e);
        }
        // 4. 注册实现了 DisposableBean 接口的 Bean 对象
        registerDisposableBeanIfNecessary(beanName, bean, beanDefinition);

        // 5. 根据bean对象的scope，决定是否将bean对象放入singletonObjects池中
        if(beanDefinition.isSingleton()){
            System.out.println(beanName+" 被放入singletonObjects池中");
            registerSingleton(beanName, bean);
        }
        return bean;
    }

    private void registerDisposableBeanIfNecessary(String beanName, Object bean, BeanDefinition beanDefinition) {
        // 非 Singleton 类型的 Bean 不执行销毁方法
        if(!beanDefinition.isSingleton()){
            return;
        }

        if(bean instanceof DisposableBean || StrUtil.isNotEmpty(beanDefinition.getDestroyMethodName())) {
            registerDisposableBean(beanName, new DisposableBeanAdapter(bean, beanName, beanDefinition));

        }
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {

        Constructor<?> constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructor = beanClass.getDeclaredConstructors();
        for(Constructor<?> ctor : declaredConstructor) {
            if(null != args && ctor.getParameterTypes().length == args.length){
                Class<?>[] types = ctor.getParameterTypes();
                boolean isComparable = true;
                for(int i = 0; i < types.length; i++){
                    if(types[i] != args[i].getClass()){
                        isComparable = false;
                        break;
                    }
                }
                if(isComparable){
                    constructorToUse = ctor;
                    break;
                }
            }
        }
        Object instantiation = null;
        try {
            instantiation = getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return instantiation;

    }

    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for(PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if(value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }


    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
        // 0. 设置bean对象aware
        if(bean instanceof Aware) {
            if(bean instanceof BeanFactoryAware){
                ((BeanFactoryAware) bean).setBeanFactory(this);
            }
            if(bean instanceof BeanClassLoaderAware){
                ((BeanClassLoaderAware) bean).setBeanClassLoader(getBeanClassLoader());
            }
            if(bean instanceof BeanNameAware) {
                ((BeanNameAware) bean).setBeanName(beanName);
            }
        }


        // 1. 执行 BeanPostProcessor Before 处理
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);

        // 执行 Bean 对象的初始化方法
        try {
            invokeInitMethods(beanName, wrappedBean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Invocation of init method of bean[" + beanName + "] failed", e);
        }

        // 2. 执行 BeanPostProcessor After 处理
        wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);

        return wrappedBean;
    }

    private void invokeInitMethods(String beanName, Object bean, BeanDefinition beanDefinition) throws Exception {
        // 1. 实现接口InitializingBean
        if(bean instanceof InitializingBean){
            ((InitializingBean) bean).afterPropertiesSet();
        }

        String initMethodName = beanDefinition.getInitMethodName();
        if(StrUtil.isNotEmpty(initMethodName)) {
            Method initMethod = beanDefinition.getBeanClass().getMethod(initMethodName);
            if(null == initMethod){
                throw new BeansException("Could not find an init method named '" + initMethodName+"' on bean with name '" + beanName + "'");
            }
            initMethod.invoke(bean);

        }
    }


    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException{
        Object result = existingBean;
        for(BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessBeforeInitialization(result, beanName);
            if(null == current) {
                return result;
            }
            result = current;
        }
        return result;
    }

    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException{
        Object result = existingBean;
        for(BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessBeforeInitialization(result, beanName);
            if(null == current) {
                return result;
            }
            result = current;
        }
        return result;
    }

    protected Object resolveBeforeInstantiation(String beanName, BeanDefinition beanDefinition) {
        Object bean = applyBeanPostProcessorBeforeInstantiation(beanDefinition.getBeanClass(), beanName);
        if (null != bean) {
            bean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
        }
        return bean;
    }

    public Object applyBeanPostProcessorBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        try {
            for (BeanPostProcessor processor : getBeanPostProcessors()) {
                if (processor instanceof InstantiationAwareBeanPostProcessor) {
                    Object result = ((InstantiationAwareBeanPostProcessor)processor).postProcessBeforeInstantiation(beanClass, beanName);
                    if (null != result){
                        return result;
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }





}
