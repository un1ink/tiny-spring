package cn.un1ink.springframework.aop.framework;

import cn.un1ink.springframework.aop.AdvisedSupport;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/6
 */
public class ProxyFactory {

    private AdvisedSupport advisedSupport;


    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy(){
        return createAopProxy().getProxy();
    }
    private AopProxy createAopProxy(){
        if(advisedSupport.isProxyTargetClass()){
            return new Cglib2AopProxy(advisedSupport);
        }
        return new JdkDynamicAopProxy(advisedSupport);
    }

}
