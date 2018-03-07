package com.facebook.messaging.media.upload;

import android.net.Uri;
import com.facebook.ui.media.attachments.MediaResource;
import java.util.concurrent.Callable;

/* compiled from: loadingIndicatorLock */
public class MediaUploadManagerImpl$8 implements Callable<Uri> {
    final /* synthetic */ MediaResource f11920a;
    final /* synthetic */ MediaUploadManagerImpl f11921b;

    public MediaUploadManagerImpl$8(MediaUploadManagerImpl mediaUploadManagerImpl, MediaResource mediaResource) {
        this.f11921b = mediaUploadManagerImpl;
        this.f11920a = mediaResource;
    }

    public Object call() {
        return this.f11921b.B.a(this.f11920a.c, this.f11920a.D);
    }
}
