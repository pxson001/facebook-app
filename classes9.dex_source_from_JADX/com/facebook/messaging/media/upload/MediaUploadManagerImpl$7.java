package com.facebook.messaging.media.upload;

import android.net.Uri;
import com.facebook.messaging.media.upload.MediaItemUploadStatus.Stage;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

/* compiled from: loadingIndicatorLock */
class MediaUploadManagerImpl$7 implements AsyncFunction<Void, Uri> {
    final /* synthetic */ MediaResource f11918a;
    final /* synthetic */ MediaUploadManagerImpl f11919b;

    MediaUploadManagerImpl$7(MediaUploadManagerImpl mediaUploadManagerImpl, MediaResource mediaResource) {
        this.f11919b = mediaUploadManagerImpl;
        this.f11918a = mediaResource;
    }

    public final ListenableFuture m12497a(@Nullable Object obj) {
        if (this.f11918a.d != Type.ENCRYPTED_PHOTO) {
            return Futures.a(null);
        }
        MediaUploadManagerImpl.a(this.f11919b, this.f11918a, Stage.ENCRYPTING);
        MediaUploadManagerImpl mediaUploadManagerImpl = this.f11919b;
        MediaResource k = MediaUploadManagerImpl.k(mediaUploadManagerImpl, this.f11918a);
        Preconditions.checkNotNull(k.D);
        return mediaUploadManagerImpl.t.a(new MediaUploadManagerImpl$8(mediaUploadManagerImpl, k));
    }
}
