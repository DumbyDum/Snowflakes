package com.emindor.snowflakes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SnowflakesSurface surface = (SnowflakesSurface) findViewById(R.id.snowflakesSurface);
        surface.invalidate();
    }
}