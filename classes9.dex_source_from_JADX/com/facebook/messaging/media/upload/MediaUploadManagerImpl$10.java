package com.facebook.messaging.media.upload;

import com.facebook.fbservice.service.OperationResult;
import com.google.common.base.Function;

/* compiled from: loadingIndicatorLock */
public class MediaUploadManagerImpl$10 implements Function<OperationResult, String> {
    final /* synthetic */ MediaUploadManagerImpl f11894a;

    public MediaUploadManagerImpl$10(MediaUploadManagerImpl mediaUploadManagerImpl) {
        this.f11894a = mediaUploadManagerImpl;
    }

    public Object apply(Object obj) {
        return ((OperationResult) obj).c;
    }
}
