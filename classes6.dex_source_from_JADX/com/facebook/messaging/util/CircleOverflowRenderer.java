package com.facebook.messaging.util;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;

/* compiled from: totalAllItemsEnabled */
public class CircleOverflowRenderer {
    protected Resources f2835a;
    public final Paint f2836b = new Paint();
    public final TextPaint f2837c = new TextPaint();
    public int f2838d;
    protected int f2839e;

    /* compiled from: totalAllItemsEnabled */
    public class Builder {
        public Resources f2829a;
        public int f2830b;
        public int f2831c;
        public int f2832d;
        public int f2833e;
        public Typeface f2834f;

        public Builder(Resources resources) {
            this.f2829a = resources;
        }

        public final CircleOverflowRenderer m3948a() {
            return new CircleOverflowRenderer(this);
        }
    }

    public CircleOverflowRenderer(Builder builder) {
        this.f2835a = builder.f2829a;
        this.f2838d = builder.f2830b;
        this.f2836b.setColor(builder.f2831c);
        this.f2836b.setAntiAlias(true);
        this.f2837c.setColor(builder.f2832d);
        this.f2837c.setTextSize((float) builder.f2833e);
        this.f2837c.setTextAlign(Align.CENTER);
        this.f2837c.setTypeface(builder.f2834f);
        this.f2837c.setAntiAlias(true);
    }

    public final void m3949a(Canvas canvas, int i, int i2, int i3) {
        float f = (float) (this.f2838d / 2);
        float f2 = ((float) i2) + f;
        float f3 = ((float) i3) + f;
        canvas.drawCircle(f2, f3, f, this.f2836b);
        if (this.f2839e <= 0) {
            Rect rect = new Rect();
            String string = this.f2835a.getString(2131231766, new Object[]{Integer.valueOf(123456789)});
            this.f2837c.getTextBounds(string, 0, string.length(), rect);
            this.f2839e = rect.height();
        }
        canvas.drawText(this.f2835a.getString(2131231766, new Object[]{Integer.valueOf(i)}), f2, f3 + ((float) (this.f2839e / 2)), this.f2837c);
    }
}
