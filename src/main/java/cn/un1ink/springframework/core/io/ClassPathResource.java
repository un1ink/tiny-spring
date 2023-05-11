package cn.un1ink.springframework.core.io;

import cn.un1ink.springframework.util.ClassUtils;
import jdk.internal.util.xml.impl.Input;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/1
 */
public class ClassPathResource implements Resource{

    private final String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path){
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());

    }


    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if(is == null){
            throw new FileNotFoundException(this.path + "cannot be opend because it does not exist.");
        }
        return is;
    }
}
