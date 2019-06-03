package com.fantong.logger;

import android.text.TextUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

@Aspect
public class LoggerAspect {

    @Pointcut("execution(@com.fantong.logger.LoggerService * *(..))")
    public void logger() {

    }

    @Around("logger()")
    public Object logger(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        LoggerService loggerService = method.getAnnotation(LoggerService.class);
        Object[] args = point.getArgs();
        String name = loggerService.name();
        Logger logger = Log.getLogger(name);
        String tag = loggerService.tag();
        if (TextUtils.isEmpty(tag)) {
            tag = logger.getName();
        }
        Level level = loggerService.level();
        LogPoint logPoint = loggerService.point();
        if (logPoint == LogPoint.BEFORE || logPoint == LogPoint.AROUND) {
            switch (level) {
                case VERBOSE:
                    logger.verbose(tag, method.getName() + " before " + Objects.toString(args));
                    break;
                case DEBUG:
                    logger.debug(tag, method.getName() + " before " + Objects.toString(args));
                    break;
                case INFO:
                    logger.info(tag, method.getName() + " before " + Objects.toString(args));
                    break;
                case WARN:
                    logger.warn(tag, method.getName() + " before " + Objects.toString(args));
                    break;
                case ERROR:
                    logger.error(tag, method.getName() + " before " + Objects.toString(args));
                    break;
            }
        }
        Object proceed = point.proceed();
        if (logPoint == LogPoint.AFTER || logPoint == LogPoint.AROUND) {
            switch (level) {
                case VERBOSE:
                    logger.verbose(tag, method.getName() + " after " + Objects.toString(proceed));
                    break;
                case DEBUG:
                    logger.debug(tag, method.getName() + " after " + Objects.toString(proceed));
                    break;
                case INFO:
                    logger.info(tag, method.getName() + " after " + Objects.toString(proceed));
                    break;
                case WARN:
                    logger.warn(tag, method.getName() + " after " + Objects.toString(proceed));
                    break;
                case ERROR:
                    logger.error(tag, method.getName() + " after " + Objects.toString(proceed));
                    break;
            }
        }
        return proceed;
    }
}
