package com.facebook.photos.warning;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.ui.images.effects.Blur;

/* compiled from: selected_city */
public class DarkenAndBlurPostprocessor extends BasePostprocessor {
    private final Paint f3495a;
    private final int f3496b;
    private final int f3497c;
    private final CacheKey f3498d;

    public DarkenAndBlurPostprocessor() {
        this(20, 4);
    }

    public DarkenAndBlurPostprocessor(int i, int i2) {
        this.f3496b = i;
        this.f3497c = i2;
        this.f3495a = new Paint(1);
        this.f3498d = new SimpleCacheKey("darkblur:radius=" + this.f3496b + ":downscale=" + this.f3497c);
    }

    public final String m3440a() {
        return "DarkenAndBlurPostprocessor";
    }

    public final CacheKey m3441b() {
        return this.f3498d;
    }

    public final CloseableReference<Bitmap> m3439a(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
        CloseableReference a = platformBitmapFactory.a(bitmap.getWidth() / this.f3497c, bitmap.getHeight() / this.f3497c);
        try {
            Bitmap bitmap2 = (Bitmap) a.a();
            Canvas canvas = new Canvas(bitmap2);
            Rect rect = new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
            this.f3495a.setColorFilter(new PorterDuffColorFilter(1291845632, Mode.SRC_ATOP));
            canvas.drawBitmap(bitmap, null, rect, this.f3495a);
            Blur.m11215b(bitmap2, this.f3496b);
            CloseableReference<Bitmap> b = CloseableReference.b(a);
            return b;
        } finally {
            CloseableReference.c(a);
        }
    }
}
