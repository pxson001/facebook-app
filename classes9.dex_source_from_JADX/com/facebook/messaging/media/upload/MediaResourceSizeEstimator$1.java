package com.facebook.messaging.media.upload;

import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.videocodec.base.VideoMetadata;
import java.util.concurrent.Callable;

/* compiled from: local_duration */
class MediaResourceSizeEstimator$1 implements Callable<VideoMetadata> {
    final /* synthetic */ MediaResource f11874a;
    final /* synthetic */ MediaResourceSizeEstimator f11875b;

    MediaResourceSizeEstimator$1(MediaResourceSizeEstimator mediaResourceSizeEstimator, MediaResource mediaResource) {
        this.f11875b = mediaResourceSizeEstimator;
        this.f11874a = mediaResource;
    }

    public Object call() {
        return this.f11875b.b.a(this.f11874a.c);
    }
}
