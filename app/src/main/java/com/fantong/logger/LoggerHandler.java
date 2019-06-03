package com.fantong.logger;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerHandler extends Handler {

    private int totalSize;
    private BufferedWriter bufferedWriter;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public LoggerHandler(Looper looper) {
        super(looper);
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        String loggerDir = LoggerConfiguration.getInstance().getLoggerDir();
        if (TextUtils.isEmpty(loggerDir)) {
            Log.e("LoggerHandler", "logger dir is null");
            return;
        }
        if (bufferedWriter == null) {
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(loggerDir, dateFormat.format(new Date()) + ".log"))));
            } catch (FileNotFoundException e) {

            }
        }
        if (msg.obj != null && bufferedWriter != null) {
            String s = msg.obj.toString();
            try {
                bufferedWriter.write(s);
                totalSize += s.getBytes().length;
                bufferedWriter.flush();
                Log.e("LoggerHandler", "s " + s);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (totalSize > LoggerConfiguration.getInstance().getMaxFileSize()) {
                    try {
                        bufferedWriter.close();
                        totalSize = 0;
                    } catch (IOException e) {
                    }
                }
            }
        }
    }
}
