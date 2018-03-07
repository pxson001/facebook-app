package com.facebook.messaging.media.upload;

import android.net.Uri;
import com.facebook.debug.log.BLog;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: loadingIndicatorLock */
class MediaUploadManagerImpl$5 implements FutureCallback<String> {
    final /* synthetic */ MediaResource f11914a;
    final /* synthetic */ MediaUploadManagerImpl f11915b;

    MediaUploadManagerImpl$5(MediaUploadManagerImpl mediaUploadManagerImpl, MediaResource mediaResource) {
        this.f11915b = mediaUploadManagerImpl;
        this.f11914a = mediaResource;
    }

    public void onSuccess(@Nullable Object obj) {
        if (((String) obj) != null) {
            Class cls = MediaUploadManagerImpl.a;
            Uri uri = this.f11914a.c;
            this.f11915b.A.a(this.f11914a, null);
        }
    }

    public void onFailure(Throwable th) {
        BLog.b(MediaUploadManagerImpl.a, "Hi-res upload failed. MediaUri=%s, Exception=%s", new Object[]{this.f11914a.c, th});
        this.f11915b.A.a(this.f11914a, th);
    }
}
