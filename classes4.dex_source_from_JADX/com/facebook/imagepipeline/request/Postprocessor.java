package com.facebook.imagepipeline.request;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import javax.annotation.Nullable;

/* compiled from: network_is_connected */
public interface Postprocessor {
    CloseableReference<Bitmap> mo602a(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory);

    String mo603a();

    @Nullable
    CacheKey mo604b();
}
