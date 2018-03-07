package com.facebook.messaging.media.upload;

import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.Uninterruptibles;

/* compiled from: loadingIndicatorLock */
class MediaUploadManagerImpl$4 implements AsyncFunction<String, String> {
    final /* synthetic */ ListenableFuture f11911a;
    final /* synthetic */ MediaResource f11912b;
    final /* synthetic */ MediaUploadManagerImpl f11913c;

    MediaUploadManagerImpl$4(MediaUploadManagerImpl mediaUploadManagerImpl, ListenableFuture listenableFuture, MediaResource mediaResource) {
        this.f11913c = mediaUploadManagerImpl;
        this.f11911a = listenableFuture;
        this.f11912b = mediaResource;
    }

    public final ListenableFuture m12495a(Object obj) {
        String str = (String) obj;
        if (str == null) {
            return Futures.a(null);
        }
        Uninterruptibles.a(this.f11911a);
        return MediaUploadManagerImpl.b(this.f11913c, this.f11912b, str);
    }
}
