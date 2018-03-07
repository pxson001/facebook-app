package com.facebook.orca.notify;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.BasePostprocessor;

/* compiled from: nhs */
public class ScalingPostprocessor extends BasePostprocessor {
    private static final Matrix f6264b = new Matrix();
    private int f6265a;

    public ScalingPostprocessor(int i) {
        this.f6265a = i;
    }

    public final synchronized CloseableReference<Bitmap> m5961a(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
        CloseableReference<Bitmap> a;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        f6264b.setScale(((float) this.f6265a) / ((float) width), ((float) this.f6265a) / ((float) height));
        Rect rect = new Rect(0, 0, width, height);
        RectF rectF = new RectF(0.0f, 0.0f, (float) width, (float) height);
        RectF rectF2 = new RectF();
        f6264b.mapRect(rectF2, rectF);
        a = platformBitmapFactory.a(Math.round(rectF2.width()), Math.round(rectF2.height()), bitmap.getConfig());
        Bitmap bitmap2 = (Bitmap) a.a();
        if (bitmap.hasAlpha()) {
            bitmap2.eraseColor(0);
        }
        Canvas canvas = new Canvas();
        canvas.concat(f6264b);
        Paint paint = new Paint();
        bitmap2.setDensity(bitmap.getDensity());
        bitmap2.setHasAlpha(bitmap.hasAlpha());
        canvas.setBitmap(bitmap2);
        canvas.drawBitmap(bitmap, rect, rectF, paint);
        return a;
    }
}
