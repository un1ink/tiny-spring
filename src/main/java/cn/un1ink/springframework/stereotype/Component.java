package cn.un1ink.springframework.stereotype;

import java.lang.annotation.*;

/**
 * @author un1ink
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

    String value() default "";

}
