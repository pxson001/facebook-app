package com.facebook.photos.mediagallery.util;

import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Assisted;
import com.facebook.photos.base.util.CachedDrawableProvider;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: is_in_sync */
public class WarmupImageHelper {
    public final String f10800a;
    public final ImageRequest f10801b;
    public final CachedDrawableProvider f10802c;

    @Inject
    public WarmupImageHelper(@Assisted String str, @Assisted ImageRequest imageRequest, CachedDrawableProvider cachedDrawableProvider) {
        this.f10800a = (String) Preconditions.checkNotNull(str);
        this.f10801b = (ImageRequest) Preconditions.checkNotNull(imageRequest);
        this.f10802c = cachedDrawableProvider;
    }
}
