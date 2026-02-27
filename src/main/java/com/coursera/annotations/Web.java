package com.coursera.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Repeatable(Webs.class)
public @interface Web {
    String id() default "";
    String name() default "";
    String xpath() default "";
    String css() default "";
    String locale() default "en_US";
}
