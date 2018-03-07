package com.facebook.imagepipeline.internal;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.InjectorLike;

/* compiled from: p2p_android_group_commerce_enabled */
public class FbCacheKeyFactory extends DefaultCacheKeyFactory {
    public static FbCacheKeyFactory m15870a(InjectorLike injectorLike) {
        return new FbCacheKeyFactory();
    }

    protected final Uri mo2039a(Uri uri) {
        if (UriUtil.m18788a(uri)) {
            return FacebookUriUtil.m20924i(uri);
        }
        return uri;
    }

    public final CacheKey mo2040a(ImageRequest imageRequest) {
        return new SimpleCacheKey(FacebookUriUtil.m20924i(imageRequest.f12746c).toString());
    }
}
