package cn.un1ink.springframework.beans.factory;

/**
 * @description: Bean销毁方法接口
 * @author：un1ink
 * @date: 2023/5/3
 */
public interface DisposableBean {

    void destroy() throws Exception;
}
