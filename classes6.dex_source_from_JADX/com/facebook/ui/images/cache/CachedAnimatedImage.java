package com.facebook.ui.images.cache;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.ui.images.cache.ImageCacheKey.ImageType;
import com.facebook.ui.images.webp.AnimatedImage;
import com.facebook.ui.images.webp.BitmapAnimationDrawable;

/* compiled from: section_id */
public class CachedAnimatedImage extends CachedImage {
    private final AnimatedImage f5099a;

    protected CachedAnimatedImage(AnimatedImage animatedImage) {
        this.f5099a = animatedImage;
    }

    public final Bitmap m7857a() {
        throw new IllegalStateException("CachedBitmapImage does not have animated underlying type.");
    }

    public final ImageType m7859b() {
        return ImageType.ANIMATED;
    }

    public final int m7860c() {
        return this.f5099a.f5147a;
    }

    public final int m7861d() {
        return this.f5099a.f5148b;
    }

    public final int m7862e() {
        return ((this.f5099a.f5151e.size() * c()) * d()) * 4;
    }

    public final Drawable m7858a(Resources resources) {
        Drawable bitmapAnimationDrawable;
        AnimatedImage animatedImage = this.f5099a;
        if (animatedImage.f5149c) {
            bitmapAnimationDrawable = new BitmapAnimationDrawable(resources, animatedImage.f5151e, animatedImage.f5152f);
        } else {
            bitmapAnimationDrawable = new BitmapDrawable(resources, (Bitmap) animatedImage.f5151e.get(0));
        }
        return bitmapAnimationDrawable;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof CachedAnimatedImage)) {
            return false;
        }
        return this.f5099a.equals(((CachedAnimatedImage) obj).f5099a);
    }

    public int hashCode() {
        return this.f5099a.hashCode();
    }
}
