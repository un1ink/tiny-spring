package cn.un1ink.springframework.beans.factory;

/**
 * @description: Bean初始化方法接口
 * @author：un1ink
 * @date: 2023/5/3
 */
public interface InitializingBean {

    /**
     * bean 初始化
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;

}
