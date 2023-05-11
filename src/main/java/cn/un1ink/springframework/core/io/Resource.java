package cn.un1ink.springframework.core.io;


import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/1
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
