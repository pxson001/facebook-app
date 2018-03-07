package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.references.CloseableReference;

/* compiled from: page/%s/info */
public abstract class PlatformBitmapFactory {
    public abstract CloseableReference<Bitmap> mo2020a(int i, int i2, Config config);

    public final CloseableReference<Bitmap> m15772a(int i, int i2) {
        return mo2020a(i, i2, Config.ARGB_8888);
    }
}
