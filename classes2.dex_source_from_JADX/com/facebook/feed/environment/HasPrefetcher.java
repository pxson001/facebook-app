package com.facebook.feed.environment;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.multirow.api.AnyEnvironment;

/* compiled from: newsfeed_story_attachment_photo_feed_prefetch */
public interface HasPrefetcher extends AnyEnvironment {
    void mo2434a(ImageRequest imageRequest, CallerContext callerContext);
}
