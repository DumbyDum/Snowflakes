package com.satanbakespancakes.snowflakes;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.Random;

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


class Snowflake {
    float x, y, vel, ror;
    Paint paint;

    public Snowflake() {
        Random r = new Random();
        this.x = r.nextInt(SnowflakesSurface.view_Width);
        do {
            this.vel = r.nextFloat() * 4;
        } while (this.vel < 0.4);
        paint = new Paint(SnowflakesSurface.p);
        do {
            paint.setTextSize(r.nextInt(250));
        } while (paint.getTextSize() < 20);
        ror = r.nextInt(359);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(Color.parseColor("#E6E6FA"));
    }

    public void fall() {
        y += vel;
        if(y > SnowflakesSurface.view_Height + this.paint.getTextSize()) this.y = - this.paint.getTextSize();
    }
}