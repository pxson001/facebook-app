package com.facebook.messaging.sms.defaultapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.StringUtil;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.BasePostprocessor;

/* compiled from: com.google.android.gms.auth.LOGIN_PICKER */
public class MmsImagePostprocessor extends BasePostprocessor {
    private static final Matrix f17538a = new Matrix();
    private static final Rect f17539b = new Rect();
    private static final RectF f17540c = new RectF();
    private static final RectF f17541d = new RectF();
    private final long f17542e;
    private final String f17543f;
    private final int f17544g;
    private final int f17545h;
    private final int f17546i;

    public MmsImagePostprocessor(long j, String str, int i, int i2, int i3) {
        this.f17542e = j;
        this.f17543f = str;
        if (i == 0) {
            i = 307200;
        }
        this.f17544g = i;
        if (i2 == 0) {
            i2 = 640;
        }
        this.f17545h = i2;
        if (i3 == 0) {
            i3 = 480;
        }
        this.f17546i = i3;
    }

    public final CloseableReference<Bitmap> m17533a(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
        float width = (float) bitmap.getWidth();
        float height = (float) bitmap.getHeight();
        float min = Math.min(((float) this.f17545h) / width, ((float) this.f17546i) / height);
        if (StringUtil.a(this.f17543f, "image/png")) {
            min = Math.min(min, ((float) Math.sqrt((double) (((float) this.f17544g) / ((float) this.f17542e)))) * 0.9f);
        }
        min = Math.min(min, 1.0f);
        f17538a.setScale(min, min);
        f17539b.set(0, 0, (int) width, (int) height);
        f17540c.set(0.0f, 0.0f, width, height);
        f17538a.mapRect(f17541d, f17540c);
        CloseableReference<Bitmap> a = platformBitmapFactory.a((int) f17541d.width(), (int) f17541d.height(), bitmap.getConfig());
        Bitmap bitmap2 = (Bitmap) a.a();
        if (bitmap.hasAlpha()) {
            bitmap2.eraseColor(0);
        }
        Canvas canvas = new Canvas();
        canvas.concat(f17538a);
        bitmap2.setDensity(bitmap.getDensity());
        bitmap2.setHasAlpha(bitmap.hasAlpha());
        canvas.setBitmap(bitmap2);
        canvas.drawBitmap(bitmap, f17539b, f17540c, null);
        return a;
    }
}
