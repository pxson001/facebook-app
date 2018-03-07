package com.facebook.feed.environment.impl;

import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.photos.FeedUnitImagesStateMapper;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: news_feed */
public class HasImageLoadListenerImpl implements HasImageLoadListener {
    private final FeedUnitImagesStateMapper f12296a;

    public static HasImageLoadListenerImpl m18333a(InjectorLike injectorLike) {
        return new HasImageLoadListenerImpl(FeedUnitImagesStateMapper.m14210a(injectorLike));
    }

    @Inject
    public HasImageLoadListenerImpl(FeedUnitImagesStateMapper feedUnitImagesStateMapper) {
        this.f12296a = feedUnitImagesStateMapper;
    }

    public final void mo2426a(DraweeController draweeController, String str, ImageRequest imageRequest) {
        if (str != null) {
            this.f12296a.m14215a(draweeController, str, imageRequest.f12746c);
        }
    }
}
