package com.facebook.feedplugins.attachments.video;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.imagepipeline.request.ImageRequest;

/* compiled from: TE;Z)V */
class VideoAttachmentDelegate$EnvironmentCoverPrefetcher extends VideoAttachmentDelegate$VideoCoverPrefetcher {
    private final HasPrefetcher f22847a;

    public VideoAttachmentDelegate$EnvironmentCoverPrefetcher(HasPrefetcher hasPrefetcher) {
        this.f22847a = hasPrefetcher;
    }

    public final void mo1572a(ImageRequest imageRequest, CallerContext callerContext) {
        this.f22847a.a(imageRequest, callerContext);
    }
}
