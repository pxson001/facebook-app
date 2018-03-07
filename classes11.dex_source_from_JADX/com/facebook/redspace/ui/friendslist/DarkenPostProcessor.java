package com.facebook.redspace.ui.friendslist;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.support.annotation.ColorInt;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.BasePostprocessor;

/* compiled from: PRIVACY_CHECKUP_WRITE_REQUEST_FLUSH_SUCCESS */
public class DarkenPostProcessor extends BasePostprocessor {
    private final Paint f12437a = new Paint(1);
    private final CacheKey f12438b;

    public DarkenPostProcessor(@ColorInt int i) {
        this.f12438b = new SimpleCacheKey("darken:color=" + i);
        this.f12437a.setColorFilter(new PorterDuffColorFilter(i, Mode.SRC_ATOP));
    }

    public final String m12841a() {
        return "DarkenPostprocessor";
    }

    public final CacheKey m12842b() {
        return this.f12438b;
    }

    public final CloseableReference<Bitmap> m12840a(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
        CloseableReference a = platformBitmapFactory.a(bitmap.getWidth(), bitmap.getHeight());
        try {
            Bitmap bitmap2 = (Bitmap) a.a();
            new Canvas(bitmap2).drawBitmap(bitmap, null, new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight()), this.f12437a);
            CloseableReference<Bitmap> b = CloseableReference.b(a);
            return b;
        } finally {
            CloseableReference.c(a);
        }
    }
}
