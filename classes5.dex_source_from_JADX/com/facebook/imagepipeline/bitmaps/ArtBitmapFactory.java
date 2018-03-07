package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(21)
@ThreadSafe
/* compiled from: TRAVELING */
public class ArtBitmapFactory extends PlatformBitmapFactory {
    private final BitmapPool f13677a;

    public ArtBitmapFactory(BitmapPool bitmapPool) {
        this.f13677a = bitmapPool;
    }

    public final CloseableReference<Bitmap> m22996a(int i, int i2, Config config) {
        Bitmap bitmap = (Bitmap) this.f13677a.a(BitmapUtil.a(i, i2, config));
        Bitmaps.a(bitmap, i, i2, config);
        return CloseableReference.a(bitmap, this.f13677a);
    }
}
