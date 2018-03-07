package com.facebook.feedplugins.loadingindicator;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* compiled from: friending_possibilities_imp */
public class LoadingStoryDrawable extends Drawable {
    public static final RectF f12896a = new RectF(0.0f, 0.0f, 40.0f, 40.0f);
    public static final RectF[] f12897b = new RectF[]{new RectF(50.0f, 10.0f, 140.0f, 15.0f), new RectF(50.0f, 26.0f, 117.0f, 31.0f)};
    public static final RectF[] f12898c = new RectF[]{new RectF(0.0f, 60.0f, 274.0f, 65.0f), new RectF(0.0f, 78.0f, 300.0f, 83.0f), new RectF(0.0f, 96.0f, 150.0f, 101.0f)};
    private final float f12899d;
    public Paint f12900e = new Paint(1);

    public LoadingStoryDrawable(Resources resources) {
        this.f12900e.setStyle(Style.FILL);
        this.f12900e.setColor(-3355444);
        this.f12899d = resources.getDisplayMetrics().density;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        float height = (float) bounds.height();
        float width = (((float) bounds.width()) - (10.0f * this.f12899d)) / 300.0f;
        float f = height / (101.0f + (40.0f * this.f12899d));
        if (width >= f) {
            width = f;
        }
        canvas.save();
        canvas.scale(width, width);
        int i = 0;
        canvas.drawRect(f12896a, this.f12900e);
        for (RectF drawRect : f12897b) {
            canvas.drawRect(drawRect, this.f12900e);
        }
        RectF[] rectFArr = f12898c;
        int length = rectFArr.length;
        while (i < length) {
            canvas.drawRect(rectFArr[i], this.f12900e);
            i++;
        }
        canvas.restore();
    }

    public void setAlpha(int i) {
        this.f12900e.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f12900e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getOpacity() {
        return -3;
    }
}
