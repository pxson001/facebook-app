package com.facebook.messaging.media.upload;

import com.facebook.fbservice.service.OperationResult;
import com.google.common.base.Function;

/* compiled from: loadingIndicatorLock */
class MediaUploadManagerImpl$13 implements Function<OperationResult, String> {
    final /* synthetic */ MediaUploadManagerImpl f11902a;

    MediaUploadManagerImpl$13(MediaUploadManagerImpl mediaUploadManagerImpl) {
        this.f11902a = mediaUploadManagerImpl;
    }

    public Object apply(Object obj) {
        return ((OperationResult) obj).c;
    }
}
