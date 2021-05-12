package com.emindor.snowflakes;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class SnowflakesSurface extends View {
    Snowflake[] snowflakes;
    static Paint p = new Paint();
    Resources res = getResources();
    static public int view_Height = 2000;
    static public int view_Width = 2000;

    public SnowflakesSurface(Context context) {
        super(context);
    }

    public SnowflakesSurface(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        snowflakes = new Snowflake[50];
        for (int i = 0; i < snowflakes.length; i++) {
            snowflakes[i] = new Snowflake();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);
        for (int i = 0; i < snowflakes.length; i++) {
            canvas.drawText("*", snowflakes[i].x, snowflakes[i].y, snowflakes[i].paint);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        view_Height = h;
        view_Width = w;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        for (int i = 0; i < snowflakes.length; i++) {
            snowflakes[i].fall();
        }
        invalidate();
        return true;
    }
}


