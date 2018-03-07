package com.facebook.media.upload;

import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.media.common.MediaLogger;
import com.facebook.media.common.MediaLoggerProvider;
import com.facebook.media.upload.common.UploadSession;
import com.facebook.media.upload.video.VideoUploadSession;
import com.facebook.media.upload.video.VideoUploadSessionProvider;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: keywordType */
public class MediaUploader {
    private static volatile MediaUploader f11909e;
    @VisibleForTesting
    public Map<String, UploadSession> f11910a = new HashMap();
    public final ListeningExecutorService f11911b;
    private final VideoUploadSessionProvider f11912c;
    private final MediaLoggerProvider f11913d;

    public static com.facebook.media.upload.MediaUploader m18852a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f11909e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.media.upload.MediaUploader.class;
        monitor-enter(r1);
        r0 = f11909e;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m18855b(r0);	 Catch:{ all -> 0x0035 }
        f11909e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11909e;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.media.upload.MediaUploader.a(com.facebook.inject.InjectorLike):com.facebook.media.upload.MediaUploader");
    }

    private static MediaUploader m18855b(InjectorLike injectorLike) {
        return new MediaUploader(ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (VideoUploadSessionProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoUploadSessionProvider.class), (MediaLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MediaLoggerProvider.class));
    }

    @Inject
    public MediaUploader(ListeningExecutorService listeningExecutorService, VideoUploadSessionProvider videoUploadSessionProvider, MediaLoggerProvider mediaLoggerProvider) {
        this.f11911b = listeningExecutorService;
        this.f11912c = videoUploadSessionProvider;
        this.f11913d = mediaLoggerProvider;
    }

    public final ListenableFuture<MediaUploadResult> m18856a(MediaItem mediaItem, final MediaUploadParameters mediaUploadParameters, String str) {
        final MediaLogger a = this.f11913d.m18809a(mediaItem.m(), mediaUploadParameters.f11891a, str);
        final MediaItem mediaItem2 = mediaItem;
        final MediaUploadParameters mediaUploadParameters2 = mediaUploadParameters;
        final MediaLogger mediaLogger = a;
        final boolean z = true;
        ListenableFuture<MediaUploadResult> a2 = this.f11911b.a(new Callable<MediaUploadResult>(this) {
            final /* synthetic */ MediaUploader f11905e;

            public Object call() {
                return MediaUploader.m18854b(this.f11905e, mediaItem2, mediaUploadParameters2, mediaLogger, z);
            }
        });
        Futures.a(a2, new FutureCallback<MediaUploadResult>(this) {
            final /* synthetic */ MediaUploader f11908c;

            public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
            }

            public void onFailure(Throwable th) {
                MediaUploader.m18853a(this.f11908c, th, mediaUploadParameters.f11891a, a);
            }
        }, this.f11911b);
        return a2;
    }

    public static MediaUploadResult m18854b(MediaUploader mediaUploader, MediaItem mediaItem, MediaUploadParameters mediaUploadParameters, MediaLogger mediaLogger, boolean z) {
        mediaLogger.m18783a();
        MediaType m = mediaItem.m();
        if (m == MediaType.VIDEO) {
            VideoUploadSession videoUploadSession;
            MediaUploadResult a;
            String str = mediaUploadParameters.f11891a;
            VideoUploadSession videoUploadSession2 = (VideoUploadSession) mediaUploader.f11910a.get(str);
            if (videoUploadSession2 != null) {
                MediaItem mediaItem2 = videoUploadSession2.f11928g;
                if (mediaItem2 != null && mediaItem2.e() == mediaItem.e()) {
                    Preconditions.checkState(videoUploadSession2 instanceof VideoUploadSession, "Sessions do not match types");
                    videoUploadSession2 = videoUploadSession2;
                    videoUploadSession = videoUploadSession2;
                    if (videoUploadSession == null) {
                        videoUploadSession = mediaUploader.f11912c.m18874a(mediaLogger);
                        mediaUploader.f11910a.put(str, videoUploadSession);
                    }
                    a = videoUploadSession.m18873a(mediaItem, mediaUploadParameters, z);
                    mediaUploader.f11910a.remove(str);
                    mediaLogger.m18792a(a.f11900b);
                    return a;
                }
            }
            videoUploadSession2 = null;
            videoUploadSession = videoUploadSession2;
            if (videoUploadSession == null) {
                videoUploadSession = mediaUploader.f11912c.m18874a(mediaLogger);
                mediaUploader.f11910a.put(str, videoUploadSession);
            }
            a = videoUploadSession.m18873a(mediaItem, mediaUploadParameters, z);
            mediaUploader.f11910a.remove(str);
            mediaLogger.m18792a(a.f11900b);
            return a;
        } else if (m == MediaType.PHOTO) {
            throw new UnsupportedOperationException("Photo uploads are currently unsupported");
        } else {
            throw new UnsupportedOperationException("Unsupported media type passed into uploader");
        }
    }

    public static void m18853a(MediaUploader mediaUploader, Throwable th, String str, MediaLogger mediaLogger) {
        VideoUploadSession videoUploadSession = (VideoUploadSession) mediaUploader.f11910a.get(str);
        if (videoUploadSession != null) {
            videoUploadSession.f11930i.m18859b();
            if (videoUploadSession.f11932k) {
                mediaUploader.f11910a.remove(str);
            }
        }
        if (th instanceof CancellationException) {
            mediaLogger.m18799b();
        } else {
            mediaLogger.m18791a(th instanceof Exception ? (Exception) th : null);
        }
    }
}
