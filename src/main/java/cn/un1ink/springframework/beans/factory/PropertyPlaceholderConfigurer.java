package cn.un1ink.springframework.beans.factory;

import cn.un1ink.springframework.beans.BeansException;
import cn.un1ink.springframework.beans.PropertyValue;
import cn.un1ink.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.un1ink.springframework.core.io.DefaultResourceLoader;
import cn.un1ink.springframework.core.io.Resource;
import cn.un1ink.springframework.util.StringValueResolver;

import java.io.IOException;
import java.util.Properties;

public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {

    public static final String DEFAULT_PLACEHOLDER_PREFIX = "${";

    public static final String DEFAULT_PLACEHOLDER_SUFFIX = "}";

    private String location;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        try {
            DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(location);

            Properties properties = new Properties();
            properties.load(resource.getInputStream());

            String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();


        } catch (IOException e) {
            throw new RuntimeException("Could not load properties", e);
        }

    }

    public void setLocation(String location) {
        this.location = location;
    }

    private String resolvePlaceholder(String value, Properties properties) {
        String strVal = value;
        StringBuilder builder = new StringBuilder(strVal);
        int startIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
        int stopIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_SUFFIX);
        if(startIdx != -1 && stopIdx != -1 && startIdx < stopIdx) {
            String propKey = strVal.substring(startIdx + 2, stopIdx);
            String propVal = properties.getProperty(propKey);
            builder.replace(startIdx, stopIdx + 1, propVal);
        }
        return builder.toString();



    }

    private class PlaceholderResolvingStringValues implements StringValueResolver {
        private final Properties properties;

        private PlaceholderResolvingStringValues(Properties properties) {
            this.properties = properties;
        }

        @Override
        public String resolverStringValue(String strVal) {
            return PropertyPlaceholderConfigurer.this.resolvePlaceholder(strVal, properties);
        }
    }
}
