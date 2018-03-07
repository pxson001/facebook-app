package com.facebook.messaging.media.upload;

import com.facebook.messaging.media.photoquality.PhotoQuality;
import com.facebook.messaging.media.upload.MediaResourceChecker.Result;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

/* compiled from: loadingIndicatorLock */
class MediaUploadManagerImpl$11 implements AsyncFunction<Result, Void> {
    final /* synthetic */ MediaResource f11895a;
    final /* synthetic */ int f11896b;
    final /* synthetic */ PhotoQuality f11897c;
    final /* synthetic */ MediaUploadManagerImpl f11898d;

    MediaUploadManagerImpl$11(MediaUploadManagerImpl mediaUploadManagerImpl, MediaResource mediaResource, int i, PhotoQuality photoQuality) {
        this.f11898d = mediaUploadManagerImpl;
        this.f11895a = mediaResource;
        this.f11896b = i;
        this.f11897c = photoQuality;
    }

    public final ListenableFuture m12493a(@Nullable Object obj) {
        if (((Result) obj) == Result.VALID) {
            return Futures.a(null);
        }
        this.f11898d.h.a(this.f11895a, this.f11896b == 2);
        return MediaUploadManagerImpl.a(this.f11898d, this.f11895a, this.f11897c, this.f11896b);
    }
}
