package com.fantong.logger;

import android.util.Log;

public class AndroidLogger implements Logger {

    @Override
    public String getName() {
        return AndroidLogger.class.getName();
    }

    @Override
    public boolean isVerboseEnable() {
        return true;
    }

    @Override
    public void verbose(String message) {
        if (isVerboseEnable()) {
            Log.v(getName(), message);
        }
    }

    @Override
    public void verbose(String tag, String message) {
        if (isVerboseEnable()) {
            Log.v(tag, message);
        }
    }

    @Override
    public void verbose(String message, Throwable throwable) {
        if (isVerboseEnable()) {
            Log.v(getName(), message, throwable);
        }
    }

    @Override
    public void verbose(String tag, String message, Throwable throwable) {
        if (isVerboseEnable()) {
            Log.v(tag, message, throwable);
        }
    }

    @Override
    public boolean isDebugEnable() {
        return true;
    }

    @Override
    public void debug(String message) {
        if (isDebugEnable()) {
            Log.d(getName(), message);
        }
    }

    @Override
    public void debug(String tag, String message) {
        if (isDebugEnable()) {
            Log.d(tag, message);
        }
    }

    @Override
    public void debug(String message, Throwable throwable) {
        if (isDebugEnable()) {
            Log.d(getName(), message);
        }

    }

    @Override
    public void debug(String tag, String message, Throwable throwable) {
        if (isDebugEnable()) {
            Log.d(tag, message, throwable);
        }
    }

    @Override
    public boolean isInfoEnable() {
        return true;
    }

    @Override
    public void info(String message) {
        if (isInfoEnable()) {
            Log.i(getName(), message);
        }
    }

    @Override
    public void info(String tag, String message) {
        if (isInfoEnable()) {
            Log.i(tag, message);
        }
    }

    @Override
    public void info(String message, Throwable throwable) {
        if (isInfoEnable()) {
            Log.i(getName(), message, throwable);
        }
    }

    @Override
    public void info(String tag, String message, Throwable throwable) {
        if (isInfoEnable()) {
            Log.i(tag, message, throwable);
        }
    }

    @Override
    public void warn(String message) {
        Log.w(getName(), message);
    }

    @Override
    public void warn(String tag, String message) {
        Log.w(tag, message);
    }

    @Override
    public void warn(String message, Throwable throwable) {
        Log.w(getName(), message, throwable);
    }

    @Override
    public void warn(String tag, String message, Throwable throwable) {
        Log.w(tag, message, throwable);
    }

    @Override
    public void error(String message) {
        Log.e(getName(), message);
    }

    @Override
    public void error(String tag, String message) {
        Log.w(tag, message);
    }

    @Override
    public void error(String message, Throwable throwable) {
        Log.e(getName(), message, throwable);
    }

    @Override
    public void error(String tag, String message, Throwable throwable) {
        Log.w(tag, message, throwable);
    }
}
