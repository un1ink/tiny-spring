package cn.un1ink.springframework.test;

import cn.un1ink.springframework.aop.AdvisedSupport;
import cn.un1ink.springframework.aop.ClassFilter;
import cn.un1ink.springframework.aop.MethodMatcher;
import cn.un1ink.springframework.aop.TargetSource;
import cn.un1ink.springframework.aop.aspectj.AspectJExpressionPointcut;
import cn.un1ink.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import cn.un1ink.springframework.aop.framework.Cglib2AopProxy;
import cn.un1ink.springframework.aop.framework.JdkDynamicAopProxy;
import cn.un1ink.springframework.aop.framework.ProxyFactory;
import cn.un1ink.springframework.aop.framework.ReflectiveMethodInvocation;
import cn.un1ink.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;
import cn.un1ink.springframework.beans.BeansException;
import cn.un1ink.springframework.beans.factory.config.BeanPostProcessor;
import cn.un1ink.springframework.context.support.ClassPathXmlApplicationContext;
import cn.un1ink.springframework.test.bean.IUserService;
import cn.un1ink.springframework.test.bean.UserService;
import cn.un1ink.springframework.test.bean.UserServiceBeforeAdvice;
import cn.un1ink.springframework.test.bean.UserServiceInterceptor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/4/30
 */

public class ApiTest {

    @Test
    public void test_scan() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-scan.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

    @Test
    public void test_property() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService);
    }

    @Test
    public void test_beanPost(){

        BeanPostProcessor beanPostProcessor = new BeanPostProcessor() {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                return null;
            }

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                return null;
            }
        };

        List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();
        beanPostProcessors.add(beanPostProcessor);
        beanPostProcessors.add(beanPostProcessor);
        beanPostProcessors.remove(beanPostProcessor);

        System.out.println(beanPostProcessors.size());
    }

}
