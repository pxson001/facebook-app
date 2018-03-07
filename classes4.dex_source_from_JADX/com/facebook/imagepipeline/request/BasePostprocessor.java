package com.facebook.imagepipeline.request;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import javax.annotation.Nullable;

/* compiled from: network_offline */
public abstract class BasePostprocessor implements Postprocessor {
    public String mo603a() {
        return "Unknown postprocessor";
    }

    public CloseableReference<Bitmap> mo602a(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
        CloseableReference a = platformBitmapFactory.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        try {
            m7533a((Bitmap) a.a(), bitmap);
            CloseableReference<Bitmap> b = CloseableReference.b(a);
            return b;
        } finally {
            CloseableReference.c(a);
        }
    }

    public void m7533a(Bitmap bitmap, Bitmap bitmap2) {
        Bitmaps.a(bitmap, bitmap2);
        m7532a(bitmap);
    }

    public void m7532a(Bitmap bitmap) {
    }

    @Nullable
    public CacheKey mo604b() {
        return null;
    }
}
