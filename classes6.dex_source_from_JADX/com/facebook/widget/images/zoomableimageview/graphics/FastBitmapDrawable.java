package com.facebook.widget.images.zoomableimageview.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* compiled from: removeFriendListMemberParams */
public class FastBitmapDrawable extends Drawable {
    protected Bitmap f5980a;
    protected Paint f5981b = new Paint();

    public FastBitmapDrawable(Bitmap bitmap) {
        this.f5980a = bitmap;
        this.f5981b.setDither(true);
        this.f5981b.setFilterBitmap(true);
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.f5980a, 0.0f, 0.0f, this.f5981b);
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
        this.f5981b.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f5981b.setColorFilter(colorFilter);
    }

    public int getIntrinsicWidth() {
        return this.f5980a.getWidth();
    }

    public int getIntrinsicHeight() {
        return this.f5980a.getHeight();
    }

    public int getMinimumWidth() {
        return this.f5980a.getWidth();
    }

    public int getMinimumHeight() {
        return this.f5980a.getHeight();
    }
}
