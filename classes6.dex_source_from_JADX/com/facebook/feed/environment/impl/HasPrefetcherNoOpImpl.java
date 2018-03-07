package com.facebook.feed.environment.impl;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.InjectorLike;

/* compiled from: multi_photo_reorder */
public class HasPrefetcherNoOpImpl implements HasPrefetcher {
    public static HasPrefetcherNoOpImpl m15834a(InjectorLike injectorLike) {
        return new HasPrefetcherNoOpImpl();
    }

    public final void m15835a(ImageRequest imageRequest, CallerContext callerContext) {
    }
}
