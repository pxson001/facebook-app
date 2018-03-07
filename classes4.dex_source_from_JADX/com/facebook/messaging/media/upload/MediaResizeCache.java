package com.facebook.messaging.media.upload;

import com.facebook.messaging.media.upload.util.MediaUploadKey;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Singleton;

@Singleton
/* compiled from: mInsetR */
public class MediaResizeCache {
    private static volatile MediaResizeCache f8674c;
    @GuardedBy("mResizedMediaResources")
    private final Cache<MediaUploadKey, MediaResourceStatus> f8675a = CacheBuilder.newBuilder().a(2073600000, TimeUnit.MILLISECONDS).q();
    @GuardedBy("mResizedMediaResourcesHiRes")
    private final Cache<MediaUploadKey, MediaResourceStatus> f8676b = CacheBuilder.newBuilder().a(2073600000, TimeUnit.MILLISECONDS).q();

    public static com.facebook.messaging.media.upload.MediaResizeCache m8925a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f8674c;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.messaging.media.upload.MediaResizeCache.class;
        monitor-enter(r1);
        r0 = f8674c;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m8924a();	 Catch:{ all -> 0x0034 }
        f8674c = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f8674c;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.MediaResizeCache.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.MediaResizeCache");
    }

    private static MediaResizeCache m8924a() {
        return new MediaResizeCache();
    }

    @Nullable
    public final MediaResource m8926a(MediaResource mediaResource) {
        MediaResource mediaResource2;
        synchronized (this.f8675a) {
            MediaUploadKey a = MediaUploadKey.a(mediaResource);
            MediaResourceStatus mediaResourceStatus = (MediaResourceStatus) this.f8675a.a(a);
            mediaResource2 = mediaResourceStatus == null ? null : mediaResourceStatus.a;
            if (mediaResource2 != null && (mediaResource2.m == null || !mediaResource2.m.equals(mediaResource.m))) {
                mediaResource2 = MediaResource.a().a(mediaResource2).b(mediaResource2.h).a(mediaResource.m).C();
                this.f8675a.a(a, new MediaResourceStatus(mediaResource2, true));
            }
        }
        return mediaResource2;
    }

    public final void m8928a(MediaResource mediaResource, boolean z) {
        if (z) {
            synchronized (this.f8676b) {
                this.f8676b.b(MediaUploadKey.a(mediaResource));
            }
            return;
        }
        synchronized (this.f8675a) {
            this.f8675a.b(MediaUploadKey.a(mediaResource));
        }
    }

    public final boolean m8929a(MediaUploadKey mediaUploadKey) {
        boolean z;
        synchronized (this.f8675a) {
            MediaResourceStatus mediaResourceStatus = (MediaResourceStatus) this.f8675a.a(mediaUploadKey);
            if (mediaResourceStatus == null) {
                z = true;
            } else {
                z = mediaResourceStatus.b;
            }
        }
        return z;
    }

    public final void m8927a(MediaResource mediaResource, @Nullable MediaResource mediaResource2) {
        synchronized (this.f8675a) {
            this.f8675a.a(MediaUploadKey.a(mediaResource), new MediaResourceStatus(mediaResource2, mediaResource2 != null));
        }
    }

    public final MediaResource m8930b(MediaResource mediaResource) {
        MediaResource mediaResource2;
        synchronized (this.f8676b) {
            MediaUploadKey a = MediaUploadKey.a(mediaResource);
            MediaResourceStatus mediaResourceStatus = (MediaResourceStatus) this.f8676b.a(a);
            mediaResource2 = mediaResourceStatus == null ? null : mediaResourceStatus.a;
            if (mediaResource2 != null && (mediaResource2.m == null || !mediaResource2.m.equals(mediaResource.m))) {
                mediaResource2 = MediaResource.a().a(mediaResource2).b(mediaResource2.h).a(mediaResource.m).C();
                this.f8676b.a(a, new MediaResourceStatus(mediaResource2, true));
            }
        }
        return mediaResource2;
    }

    public final void m8931b(MediaResource mediaResource, @Nullable MediaResource mediaResource2) {
        synchronized (this.f8676b) {
            this.f8676b.a(MediaUploadKey.a(mediaResource), new MediaResourceStatus(mediaResource2, mediaResource2 != null));
        }
    }
}
