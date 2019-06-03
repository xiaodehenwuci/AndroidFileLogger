package com.fantong.logger;

public class LoggerConfiguration {
    private static final LoggerConfiguration ourInstance = new LoggerConfiguration();

    public static LoggerConfiguration getInstance() {
        return ourInstance;
    }

    private Logger defaultLogger = new FileLogger();

    private String loggerDir;
    private int maxFileSize = 200 * 1024 * 1024;

    private LoggerConfiguration() {
    }


    public String getLoggerDir() {
        return loggerDir;
    }

    public void setLoggerDir(String loggerDir) {
        this.loggerDir = loggerDir;
    }

    public int getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(int maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public Logger getDefaultLogger() {
        return defaultLogger;
    }

    public void setDefaultLogger(Logger defaultLogger) {
        this.defaultLogger = defaultLogger;
    }
}
