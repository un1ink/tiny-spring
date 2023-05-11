package cn.un1ink.springframework.core.io;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/1
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);

}
