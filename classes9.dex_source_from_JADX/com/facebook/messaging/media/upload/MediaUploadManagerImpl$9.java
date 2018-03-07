package com.facebook.messaging.media.upload;

import android.net.Uri;
import com.facebook.debug.log.BLog;
import com.facebook.messaging.media.upload.util.MediaUploadKey;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.SettableFuture;
import javax.annotation.Nullable;

/* compiled from: loadingIndicatorLock */
class MediaUploadManagerImpl$9 implements FutureCallback<String> {
    final /* synthetic */ MediaResource f11922a;
    final /* synthetic */ SettableFuture f11923b;
    final /* synthetic */ MediaUploadManagerImpl f11924c;

    MediaUploadManagerImpl$9(MediaUploadManagerImpl mediaUploadManagerImpl, MediaResource mediaResource, SettableFuture settableFuture) {
        this.f11924c = mediaUploadManagerImpl;
        this.f11922a = mediaResource;
        this.f11923b = settableFuture;
    }

    public void onSuccess(@Nullable Object obj) {
        Object obj2;
        String str = (String) obj;
        if (Strings.isNullOrEmpty(str) || str.equals("0")) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        if (obj2 != null) {
            Class cls = MediaUploadManagerImpl.a;
            Uri uri = this.f11922a.c;
            this.f11924c.g.a(this.f11922a);
            this.f11924c.D.a(MediaUploadKey.m12721b(this.f11922a), Double.valueOf(1.0d));
            if (MediaUploadManagerImpl.a(this.f11924c, this.f11923b, this.f11922a, str, MediaUploadManagerImpl$UploadResultPath.SKIPPED_FROM_SERVER)) {
                this.f11924c.j.b(this.f11922a);
                return;
            }
            return;
        }
        cls = MediaUploadManagerImpl.a;
        uri = this.f11922a.c;
        this.f11924c.g.a(this.f11922a);
    }

    public void onFailure(Throwable th) {
        BLog.a(MediaUploadManagerImpl.a, th, "GetFbid from server failed: %s", new Object[]{this.f11922a.c});
    }
}
