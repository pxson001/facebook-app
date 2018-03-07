package com.facebook.ui.images.cache;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.facebook.ui.images.cache.ImageCacheKey.ImageType;
import com.facebook.ui.images.webp.AnimatedImage;

/* compiled from: end_au_manager */
public abstract class CachedImage {
    public abstract Bitmap mo941a();

    public abstract Drawable mo942a(Resources resources);

    public abstract ImageType mo943b();

    public abstract int mo944c();

    public abstract int mo945d();

    public abstract int mo946e();

    public static CachedBitmapImage m13888a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new CachedBitmapImage(bitmap);
    }

    public static CachedAnimatedImage m13887a(AnimatedImage animatedImage) {
        if (animatedImage == null) {
            return null;
        }
        return new CachedAnimatedImage(animatedImage);
    }
}
