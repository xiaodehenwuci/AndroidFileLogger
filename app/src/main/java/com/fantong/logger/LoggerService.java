package com.fantong.logger;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoggerService {
    /**
     * @return tag Used to identify the source of a log message
     */
    String tag() default "";

    String name() default "";

    Level level() default Level.DEBUG;

    LogPoint point() default  LogPoint.AROUND;
}
