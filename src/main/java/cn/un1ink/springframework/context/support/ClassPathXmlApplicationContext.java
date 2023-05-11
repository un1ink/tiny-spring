package cn.un1ink.springframework.context.support;

import cn.un1ink.springframework.beans.BeansException;

/**
 * @description: 应用上下文实现类, 获取xml配置文件入口
 * @author：un1ink
 * @date: 2023/5/2
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext{

    private String [] configLocations;

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }

    public ClassPathXmlApplicationContext() {

    }

    public ClassPathXmlApplicationContext(String configLocation) throws BeansException{
        this(new String[]{configLocation});
    }

    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     * @param configLocations
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException{
        this.configLocations = configLocations;
        refresh();
    }
}
