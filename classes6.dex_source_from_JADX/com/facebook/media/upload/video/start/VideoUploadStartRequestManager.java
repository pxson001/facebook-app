package com.facebook.media.upload.video.start;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.inject.Assisted;
import com.facebook.media.common.MediaLogger;
import com.facebook.media.upload.video.VideoUploadErrorHandlerProvider;
import com.facebook.photos.base.media.VideoItem;
import java.io.File;
import javax.inject.Inject;

/* compiled from: iso */
public class VideoUploadStartRequestManager {
    private static final CallerContext f11981a = CallerContext.a(VideoUploadStartRequestManager.class);
    private AbstractSingleMethodRunner f11982b;
    private VideoUploadStartMethod f11983c = new VideoUploadStartMethod();
    private ApiMethodRunnerParams f11984d = new ApiMethodRunnerParams();
    private VideoUploadErrorHandlerProvider f11985e;
    private MediaLogger f11986f;

    @Inject
    public VideoUploadStartRequestManager(AbstractSingleMethodRunner abstractSingleMethodRunner, VideoUploadErrorHandlerProvider videoUploadErrorHandlerProvider, @Assisted MediaLogger mediaLogger) {
        this.f11982b = abstractSingleMethodRunner;
        this.f11985e = videoUploadErrorHandlerProvider;
        this.f11986f = mediaLogger;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.facebook.media.upload.video.start.VideoUploadStartResponse m18899a(com.facebook.photos.base.media.VideoItem r7, com.facebook.media.upload.MediaUploadParameters r8, com.facebook.media.upload.common.CancelHandler r9) {
        /*
        r6 = this;
        r0 = m18898a(r7);
        r2 = new com.facebook.media.upload.video.start.VideoUploadStartParams;
        r2.<init>(r0, r8);
        r0 = r6.f11985e;
        r1 = r0.m18867a(r9);
        r0 = r6.f11984d;
        r3 = r9.m18857a();
        r0.a(r3);
        r0 = r6.f11986f;
        r0.m18803c();
    L_0x001d:
        r0 = "Before sending start request";
        r9.m18858a(r0);	 Catch:{ Exception -> 0x003d, CancellationException -> 0x0042 }
        r0 = r6.f11982b;	 Catch:{ Exception -> 0x003d, CancellationException -> 0x0042 }
        r3 = r6.f11983c;	 Catch:{ Exception -> 0x003d, CancellationException -> 0x0042 }
        r4 = r6.f11984d;	 Catch:{ Exception -> 0x003d, CancellationException -> 0x0042 }
        r5 = f11981a;	 Catch:{ Exception -> 0x003d, CancellationException -> 0x0042 }
        r0 = r0.a(r3, r2, r4, r5);	 Catch:{ Exception -> 0x003d, CancellationException -> 0x0042 }
        r0 = (com.facebook.media.upload.video.start.VideoUploadStartResponse) r0;	 Catch:{ Exception -> 0x003d, CancellationException -> 0x0042 }
        r1.m18866c();	 Catch:{ Exception -> 0x003d, CancellationException -> 0x0042 }
        r3 = r6.f11986f;	 Catch:{ Exception -> 0x003d, CancellationException -> 0x0042 }
        r4 = r0.m18900a();	 Catch:{ Exception -> 0x003d, CancellationException -> 0x0042 }
        r3.m18801b(r4);	 Catch:{ Exception -> 0x003d, CancellationException -> 0x0042 }
        return r0;
    L_0x003d:
        r0 = move-exception;
        r1.m18864a(r0);	 Catch:{ CancellationException -> 0x0042, Exception -> 0x0049 }
        goto L_0x001d;
    L_0x0042:
        r0 = move-exception;
        r1 = r6.f11986f;
        r1.m18806d();
        throw r0;
    L_0x0049:
        r0 = move-exception;
        r1 = r6.f11986f;
        r1.m18800b(r0);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.media.upload.video.start.VideoUploadStartRequestManager.a(com.facebook.photos.base.media.VideoItem, com.facebook.media.upload.MediaUploadParameters, com.facebook.media.upload.common.CancelHandler):com.facebook.media.upload.video.start.VideoUploadStartResponse");
    }

    private static long m18898a(VideoItem videoItem) {
        return new File(videoItem.e()).length();
    }
}
