package com.fantong.logger;

import android.text.TextUtils;
import android.view.TextureView;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Log {

    private final static ConcurrentMap<String, Logger> __loggers = new ConcurrentHashMap<>();


    public static Logger getLogger(String name) {
        Logger logger = __loggers.get(name);
        if (logger != null) {
            return logger;
        }
        if (TextUtils.isEmpty(name)){
            return LoggerConfiguration.getInstance().getDefaultLogger();
        }
        try {
            Class<?> clazz = Class.forName(name);
            logger = (Logger) clazz.newInstance();
        } catch (Exception e) {
            logger = LoggerConfiguration.getInstance().getDefaultLogger();
        }
        __loggers.put(name, logger);
        return logger;
    }
}
