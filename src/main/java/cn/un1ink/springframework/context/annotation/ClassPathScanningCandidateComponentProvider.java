package cn.un1ink.springframework.context.annotation;

import cn.hutool.core.util.ClassUtil;
import cn.un1ink.springframework.beans.factory.config.BeanDefinition;
import cn.un1ink.springframework.stereotype.Component;
import cn.un1ink.springframework.util.ClassUtils;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author un1ink
 */
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponent(String basePackage){
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageBySuper(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;

    }

}
