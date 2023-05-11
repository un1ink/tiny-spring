package cn.un1ink.springframework.beans.factory.support;

import cn.un1ink.springframework.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/1
 */
public class CglibSubclassingInstantiationStrategy extends SimpleInstantiationStrategy{

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        try {
            if(null == ctor) {
                return enhancer.create();
            }
            return enhancer.create(ctor.getParameterTypes(), args);
        } catch (Exception e){
            System.out.println("instantiate error with beanName:" + beanName);
            e.printStackTrace();
        }
        return enhancer.create(ctor.getParameterTypes(), args);


    }
}
