package com.facebook.ui.images.cache;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.ui.images.cache.ImageCacheKey.ImageType;

/* compiled from: endTime */
public class CachedBitmapImage extends CachedImage {
    private final Bitmap f13039a;

    protected CachedBitmapImage(Bitmap bitmap) {
        this.f13039a = bitmap;
    }

    public final Bitmap mo941a() {
        return this.f13039a;
    }

    public final ImageType mo943b() {
        return ImageType.BITMAP;
    }

    public final int mo944c() {
        return this.f13039a.getWidth();
    }

    public final int mo945d() {
        return this.f13039a.getHeight();
    }

    public final int mo946e() {
        return (mo944c() * mo945d()) * 4;
    }

    public final Drawable mo942a(Resources resources) {
        return new BitmapDrawable(resources, this.f13039a);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof CachedBitmapImage)) {
            return false;
        }
        return this.f13039a.equals(((CachedBitmapImage) obj).f13039a);
    }

    public int hashCode() {
        return this.f13039a.hashCode();
    }
}
