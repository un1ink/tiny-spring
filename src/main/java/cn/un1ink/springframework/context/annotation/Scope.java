package cn.un1ink.springframework.context.annotation;


import java.lang.annotation.*;

/**
 * @author un1ink
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Scope {

    String value() default "singleton";

}
