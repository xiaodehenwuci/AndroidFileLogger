package com.fantong.logger;

public interface Logger {

    String getName();

    boolean isVerboseEnable();

    void verbose(String message);

    void verbose(String tag, String message);

    void verbose(String message, Throwable throwable);

    void verbose(String tag, String message, Throwable throwable);

    boolean isDebugEnable();

    void debug(String message);

    void debug(String tag, String message);

    void debug(String message, Throwable throwable);

    void debug(String tag, String message, Throwable throwable);

    boolean isInfoEnable();

    void info(String message);

    void info(String tag, String message);

    void info(String message, Throwable throwable);

    void info(String tag, String message, Throwable throwable);



    void warn(String message);

    void warn(String tag, String message);

    void warn(String message, Throwable throwable);

    void warn(String tag, String message, Throwable throwable);


    void error(String message);

    void error(String tag, String message);

    void error(String message, Throwable throwable);

    void error(String tag, String message, Throwable throwable);
}