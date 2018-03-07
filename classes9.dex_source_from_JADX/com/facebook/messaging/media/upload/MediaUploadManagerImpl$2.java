package com.facebook.messaging.media.upload;

import android.net.Uri;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

/* compiled from: loadingIndicatorLock */
class MediaUploadManagerImpl$2 implements AsyncFunction<Uri, String> {
    final /* synthetic */ MediaResource f11905a;
    final /* synthetic */ boolean f11906b;
    final /* synthetic */ MediaUploadManagerImpl f11907c;

    MediaUploadManagerImpl$2(MediaUploadManagerImpl mediaUploadManagerImpl, MediaResource mediaResource, boolean z) {
        this.f11907c = mediaUploadManagerImpl;
        this.f11905a = mediaResource;
        this.f11906b = z;
    }

    public final ListenableFuture m12494a(@Nullable Object obj) {
        Uri uri = (Uri) obj;
        MediaResource k = MediaUploadManagerImpl.k(this.f11907c, this.f11905a);
        if (uri != null) {
            MediaResourceBuilder a = MediaResource.a().a(k);
            a.a = uri;
            a = a;
            a.m = "application/octet-stream";
            k = a.C();
        }
        ListenableFuture a2 = MediaUploadManagerImpl.a(this.f11907c, this.f11905a, k, this.f11906b);
        return uri != null ? Futures.b(a2, new MediaUploadManagerImpl$6(this.f11907c, uri), this.f11907c.t) : a2;
    }
}
