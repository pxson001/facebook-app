package com.facebook.feedplugins.musicpreview;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;

/* compiled from: confirmation_close */
public class GradientOverlay extends Drawable {
    private final int f8035a;
    private final int f8036b;

    public GradientOverlay(Resources resources) {
        this.f8035a = resources.getColor(2131363075);
        this.f8036b = resources.getColor(2131363076);
    }

    public void draw(Canvas canvas) {
        Shader linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, (float) (canvas.getHeight() / 2), this.f8035a, this.f8036b, TileMode.MIRROR);
        Paint paint = new Paint(1);
        paint.setStyle(Style.FILL);
        paint.setShader(linearGradient);
        canvas.drawRect(0.0f, (float) (canvas.getHeight() / 2), (float) canvas.getWidth(), (float) canvas.getHeight(), paint);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
