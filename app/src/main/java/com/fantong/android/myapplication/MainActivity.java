package com.fantong.android.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fantong.android.myapplication.R;
import com.fantong.logger.LoggerConfiguration;
import com.fantong.logger.LoggerService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoggerConfiguration.getInstance().setLoggerDir(getExternalCacheDir().getPath());
        test(1, new Exception());
    }

    @LoggerService()
    private void test(int i, Exception e) {
    }


}
