package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.references.CloseableReference;

/* compiled from: TRANSVERSE */
public class GingerbreadBitmapFactory extends PlatformBitmapFactory {
    public final CloseableReference<Bitmap> m22997a(int i, int i2, Config config) {
        return CloseableReference.a(Bitmap.createBitmap(i, i2, config), SimpleBitmapReleaser.a());
    }
}
