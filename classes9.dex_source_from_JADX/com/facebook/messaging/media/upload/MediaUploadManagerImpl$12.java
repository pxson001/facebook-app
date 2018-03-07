package com.facebook.messaging.media.upload;

import com.facebook.fbservice.service.OperationResult;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.base.Function;

/* compiled from: loadingIndicatorLock */
class MediaUploadManagerImpl$12 implements Function<OperationResult, Void> {
    final /* synthetic */ int f11899a;
    final /* synthetic */ MediaResource f11900b;
    final /* synthetic */ MediaUploadManagerImpl f11901c;

    MediaUploadManagerImpl$12(MediaUploadManagerImpl mediaUploadManagerImpl, int i, MediaResource mediaResource) {
        this.f11901c = mediaUploadManagerImpl;
        this.f11899a = i;
        this.f11900b = mediaResource;
    }

    public Object apply(Object obj) {
        MediaResource mediaResource = (MediaResource) ((OperationResult) obj).h();
        if (this.f11899a == 1) {
            this.f11901c.h.a(this.f11900b, mediaResource);
        } else {
            this.f11901c.h.b(this.f11900b, mediaResource);
        }
        return null;
    }
}
