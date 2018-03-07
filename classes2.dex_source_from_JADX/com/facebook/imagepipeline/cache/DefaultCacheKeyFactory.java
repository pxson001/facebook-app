package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;

/* compiled from: p */
public class DefaultCacheKeyFactory {
    private static DefaultCacheKeyFactory f10636a = null;

    protected DefaultCacheKeyFactory() {
    }

    public static synchronized DefaultCacheKeyFactory m15873a() {
        DefaultCacheKeyFactory defaultCacheKeyFactory;
        synchronized (DefaultCacheKeyFactory.class) {
            if (f10636a == null) {
                f10636a = new DefaultCacheKeyFactory();
            }
            defaultCacheKeyFactory = f10636a;
        }
        return defaultCacheKeyFactory;
    }

    public final CacheKey m15876a(ImageRequest imageRequest, Object obj) {
        return new BitmapMemoryCacheKey(mo2039a(imageRequest.f12746c).toString(), imageRequest.f12744a, imageRequest.f12751h, imageRequest.f12750g, null, null, obj);
    }

    public final CacheKey m15877b(ImageRequest imageRequest, Object obj) {
        CacheKey b;
        String str = null;
        Postprocessor postprocessor = imageRequest.f12755l;
        if (postprocessor != null) {
            b = postprocessor.b();
            str = postprocessor.getClass().getName();
        } else {
            b = null;
        }
        return new BitmapMemoryCacheKey(mo2039a(imageRequest.f12746c).toString(), imageRequest.f12744a, imageRequest.f12751h, imageRequest.f12750g, b, str, obj);
    }

    public CacheKey mo2040a(ImageRequest imageRequest) {
        return new SimpleCacheKey(mo2039a(imageRequest.f12746c).toString());
    }

    protected Uri mo2039a(Uri uri) {
        return uri;
    }
}
