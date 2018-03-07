package com.facebook.photos.base.util;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.io.FbCloseables;
import com.facebook.imagepipeline.internal.ImageRequestBuilderFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.base.photos.Photo;
import com.facebook.photos.base.photos.Photo.PhotoSize;
import com.facebook.widget.images.ImageCacheReader;
import com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;
import javax.annotation.Nullable;
import javax.inject.Inject;

@Deprecated
/* compiled from: inet_cond */
public class CachedDrawableProvider {
    private ImageCacheReader f12799a;
    private Resources f12800b;

    public static CachedDrawableProvider m20203b(InjectorLike injectorLike) {
        return new CachedDrawableProvider(ImageCacheReader.m8365b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public CachedDrawableProvider(ImageCacheReader imageCacheReader, Resources resources) {
        this.f12799a = imageCacheReader;
        this.f12800b = resources;
    }

    @VisibleForTesting
    private Drawable m20202b(Photo photo, PhotoSize photoSize) {
        return m20204a(ImageRequestBuilderFactory.a(photo.mo1095a(photoSize), this.f12800b).m());
    }

    public final boolean m20205a(Photo photo, PhotoSize photoSize) {
        Drawable b = m20202b(photo, photoSize);
        if (b instanceof Closeable) {
            FbCloseables.a((Closeable) b);
        }
        return b != null;
    }

    @Nullable
    public final Drawable m20204a(@Nullable ImageRequest imageRequest) {
        return this.f12799a.m8366a(imageRequest);
    }
}
