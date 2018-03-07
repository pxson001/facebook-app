package com.facebook.messaging.media.upload;

import android.net.Uri;
import com.facebook.messaging.attachments.EncryptedFileAttachmentUtils;
import com.google.common.io.Files;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import javax.annotation.Nullable;

/* compiled from: loadingIndicatorLock */
public class MediaUploadManagerImpl$6 implements AsyncFunction<String, String> {
    final /* synthetic */ Uri f11916a;
    final /* synthetic */ MediaUploadManagerImpl f11917b;

    public MediaUploadManagerImpl$6(MediaUploadManagerImpl mediaUploadManagerImpl, Uri uri) {
        this.f11917b = mediaUploadManagerImpl;
        this.f11916a = uri;
    }

    public final ListenableFuture m12496a(@Nullable Object obj) {
        String str = (String) obj;
        Files.c(new File(this.f11916a.getPath()), EncryptedFileAttachmentUtils.m8022a(this.f11917b.C, str));
        return Futures.a(str);
    }
}
