package com.kiyashinura.snowflakes;

import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class Snowflake {
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
        paint.setColor(Color.BLUE);
    }

    public void fall() {
        y += vel;
        if (y > SnowflakesSurface.view_Height + this.paint.getTextSize())
            this.y = -this.paint.getTextSize();
    }
}
