package com.facebook.messaging.media.upload;

import android.content.Intent;
import android.net.Uri;
import com.facebook.debug.log.BLog;
import com.facebook.messaging.media.upload.EncryptedPhotoUploadResult.Status;
import com.facebook.messaging.media.upload.MediaItemUploadStatus.State;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;

/* compiled from: loadingIndicatorLock */
class MediaUploadManagerImpl$3 implements FutureCallback<String> {
    final /* synthetic */ MediaResource f11908a;
    final /* synthetic */ SettableFuture f11909b;
    final /* synthetic */ MediaUploadManagerImpl f11910c;

    MediaUploadManagerImpl$3(MediaUploadManagerImpl mediaUploadManagerImpl, MediaResource mediaResource, SettableFuture settableFuture) {
        this.f11910c = mediaUploadManagerImpl;
        this.f11908a = mediaResource;
        this.f11909b = settableFuture;
    }

    public void onSuccess(@Nullable Object obj) {
        String str = (String) obj;
        Class cls = MediaUploadManagerImpl.a;
        Uri uri = this.f11908a.c;
        this.f11910c.g.a(this.f11908a);
        MediaUploadManagerImpl.a(this.f11910c, this.f11909b, this.f11908a, str, MediaUploadManagerImpl$UploadResultPath.UPLOAD);
    }

    public void onFailure(Throwable th) {
        if (this.f11908a.d == Type.ENCRYPTED_PHOTO) {
            MediaUploadManagerImpl mediaUploadManagerImpl = this.f11910c;
            MediaResource mediaResource = this.f11908a;
            Intent intent = new Intent("EncryptedPhotoUploadStatusAction");
            intent.putExtra("EncryptedPhotoUploadStatusKey", new EncryptedPhotoUploadResult(mediaResource.m, mediaResource.c, Status.Failure, null));
            mediaUploadManagerImpl.o.a(intent);
        }
        MediaItemUploadStatus c = this.f11910c.c(this.f11908a);
        if (c.f11847b.equals(State.SUCCEEDED)) {
            Class cls = MediaUploadManagerImpl.a;
            return;
        }
        BLog.a(MediaUploadManagerImpl.a, th, "MediaResource upload failed: %s", new Object[]{this.f11908a.c});
        if (th instanceof CancellationException) {
            this.f11910c.r.a(this.f11908a, MediaUploadManagerImpl$UploadResultPath.UPLOAD.toString(), c.f11850e.toString());
        } else {
            this.f11910c.r.b(this.f11908a, MediaUploadManagerImpl$UploadResultPath.UPLOAD.toString(), c.f11850e.toString());
        }
        c = MediaUploadManagerImpl.a(this.f11910c, this.f11908a, th);
        this.f11910c.o.a(MediaUploadEvents.m12484a());
        FutureDetour.a(this.f11909b, c, 1107004545);
    }
}
