package com.facebook.events.sideshow;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: TYPE_FLOAT */
public class SimpleClippingBitmapDrawable extends Drawable {
    private Bitmap f24454a;
    private int f24455b = 255;
    private int f24456c;
    private final Paint f24457d = new Paint(2);

    public SimpleClippingBitmapDrawable(Bitmap bitmap, int i) {
        this.f24454a = bitmap;
        this.f24456c = i;
    }

    public void draw(Canvas canvas) {
        float width;
        float f = 0.0f;
        Rect bounds = getBounds();
        if ((this.f24456c & 5) == 5) {
            width = (float) (bounds.width() - this.f24454a.getWidth());
        } else if ((this.f24456c & 3) == 3) {
            width = 0.0f;
        } else if ((this.f24456c & 1) == 1) {
            width = ((float) (bounds.width() - this.f24454a.getWidth())) / 2.0f;
        } else {
            width = 0.0f;
        }
        if ((this.f24456c & 80) == 80) {
            f = (float) (bounds.height() - this.f24454a.getHeight());
        } else if ((this.f24456c & 48) != 48 && (this.f24456c & 17) == 17) {
            f = ((float) (bounds.height() - this.f24454a.getHeight())) / 2.0f;
        }
        canvas.drawBitmap(this.f24454a, width, f, this.f24457d);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f24457d.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
        this.f24455b = i;
        this.f24457d.setAlpha(i);
    }

    public void setFilterBitmap(boolean z) {
        this.f24457d.setFilterBitmap(z);
    }

    public int getAlpha() {
        return this.f24455b;
    }

    public int getIntrinsicWidth() {
        return -1;
    }

    public int getIntrinsicHeight() {
        return -1;
    }

    public int getMinimumWidth() {
        return 0;
    }

    public int getMinimumHeight() {
        return 0;
    }
}
