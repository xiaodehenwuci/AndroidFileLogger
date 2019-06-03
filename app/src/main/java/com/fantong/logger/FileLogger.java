package com.fantong.logger;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;

import java.text.SimpleDateFormat;
import java.util.Date;


public class FileLogger extends AndroidLogger {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private LoggerHandler handler;


    public FileLogger() {
        HandlerThread handlerThread = new HandlerThread("file_logger");
        handlerThread.start();
        this.handler = new LoggerHandler(handlerThread.getLooper());
    }

    private void printLogToStorage(Message message) {
        this.handler.sendMessage(message);
    }

    private Message getMessage(String level, String tag, String message) {
        Message obtain = Message.obtain(this.handler);
        String format = dateFormat.format(new Date());
        int pid = Process.myPid();
        long id = Thread.currentThread().getId();
        obtain.obj = format + " " + pid + "-" + id + " " + level + "/" + tag + ": " + message;
        //2019-06-03 09:22:05.131 4006-853 I/PowerUtils: use feature battery typ capacit
        return obtain;
    }

    @Override
    public void verbose(String message) {
        super.verbose(message);
        printLogToStorage(getMessage("V", getName(), message));
    }


    @Override
    public void verbose(String tag, String message) {
        super.verbose(tag, message);
        printLogToStorage(getMessage("V", tag, message));
    }

    @Override
    public void verbose(String message, Throwable throwable) {
        super.verbose(message, throwable);
        printLogToStorage(getMessage("V", getName(), message));
    }

    @Override
    public void verbose(String tag, String message, Throwable throwable) {
        super.verbose(tag, message, throwable);
        printLogToStorage(getMessage("V", getName(), message));
    }

    @Override
    public void debug(String message) {
        super.debug(message);
        printLogToStorage(getMessage("D", getName(), message));

    }

    @Override
    public void debug(String tag, String message) {
        super.debug(tag, message);
        printLogToStorage(getMessage("D", getName(), message));
    }

    @Override
    public void debug(String message, Throwable throwable) {
        super.debug(message, throwable);
        printLogToStorage(getMessage("D", getName(), message));
    }

    @Override
    public void debug(String tag, String message, Throwable throwable) {
        super.debug(tag, message, throwable);
        printLogToStorage(getMessage("D", getName(), message));
    }

    @Override
    public void info(String message) {
        super.info(message);
        printLogToStorage(getMessage("I", getName(), message));
    }

    @Override
    public void info(String tag, String message) {
        super.info(tag, message);
        printLogToStorage(getMessage("I", getName(), message));
    }

    @Override
    public void info(String message, Throwable throwable) {
        super.info(message, throwable);
        printLogToStorage(getMessage("I", getName(), message));
    }

    @Override
    public void info(String tag, String message, Throwable throwable) {
        super.info(tag, message, throwable);
        printLogToStorage(getMessage("I", getName(), message));
    }

    @Override
    public void warn(String message) {
        super.warn(message);
        printLogToStorage(getMessage("W", getName(), message));
    }

    @Override
    public void warn(String tag, String message) {
        super.warn(tag, message);
        printLogToStorage(getMessage("W", getName(), message));
    }

    @Override
    public void warn(String message, Throwable throwable) {
        super.warn(message, throwable);
        printLogToStorage(getMessage("W", getName(), message));
    }

    @Override
    public void warn(String tag, String message, Throwable throwable) {
        super.warn(tag, message, throwable);
        printLogToStorage(getMessage("W", getName(), message));
    }

    @Override
    public void error(String message) {
        super.error(message);
        printLogToStorage(getMessage("E", getName(), message));
    }

    @Override
    public void error(String tag, String message) {
        super.error(tag, message);
        printLogToStorage(getMessage("E", getName(), message));
    }

    @Override
    public void error(String message, Throwable throwable) {
        super.error(message, throwable);
        printLogToStorage(getMessage("E", getName(), message));
    }

    @Override
    public void error(String tag, String message, Throwable throwable) {
        super.error(tag, message, throwable);
        printLogToStorage(getMessage("E", getName(), message));
    }
}
