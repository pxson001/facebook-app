package com.facebook.messaging.media.photoquality;

import com.facebook.common.time.SystemClock;
import com.facebook.debug.log.BLog;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: logging_tag */
class PhotoQualityServiceHandler$3 implements FutureCallback<PhotoQualityQueryResult> {
    final /* synthetic */ ThreadKey f11796a;
    final /* synthetic */ PhotoQualityServiceHandler f11797b;

    PhotoQualityServiceHandler$3(PhotoQualityServiceHandler photoQualityServiceHandler, ThreadKey threadKey) {
        this.f11797b = photoQualityServiceHandler;
        this.f11796a = threadKey;
    }

    public void onSuccess(@Nullable Object obj) {
        PhotoQualityQueryResult photoQualityQueryResult = (PhotoQualityQueryResult) obj;
        if (photoQualityQueryResult != null) {
            PhotoQualityServiceHandler photoQualityServiceHandler = this.f11797b;
            ThreadKey threadKey = this.f11796a;
            int intValue = photoQualityQueryResult.resolution.intValue();
            photoQualityServiceHandler.h.a(threadKey, new PhotoQualityCacheItem(intValue, photoQualityQueryResult.thumbnailResolution.intValue(), 604800000 + SystemClock.a.a(), threadKey.g()));
            photoQualityServiceHandler.i.edit().a(PhotoQualityUploadPrefs.c, PhotoQualityCacheItem.m12412a(photoQualityServiceHandler.h.b().values())).commit();
        }
    }

    public void onFailure(Throwable th) {
        BLog.b(PhotoQualityServiceHandler.a, th, "Failed to get response for thread: %s", new Object[]{Long.valueOf(this.f11796a.i())});
    }
}
