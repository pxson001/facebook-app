package com.facebook.messaging.media.upload;

import com.facebook.fbservice.service.OperationResult;
import com.google.common.base.Function;

/* compiled from: loadingIndicatorLock */
class MediaUploadManagerImpl$14 implements Function<OperationResult, String> {
    final /* synthetic */ MediaUploadManagerImpl f11903a;

    MediaUploadManagerImpl$14(MediaUploadManagerImpl mediaUploadManagerImpl) {
        this.f11903a = mediaUploadManagerImpl;
    }

    public Object apply(Object obj) {
        return ((OperationResult) obj).c;
    }
}
