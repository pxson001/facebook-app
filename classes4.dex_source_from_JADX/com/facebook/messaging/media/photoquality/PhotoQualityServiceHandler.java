package com.facebook.messaging.media.photoquality;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.intents.MessagesBroadcastIntents;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.google.common.base.Strings;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mCache */
public class PhotoQualityServiceHandler {
    public static final Class<?> f8759a = PhotoQualityServiceHandler.class;
    private static volatile PhotoQualityServiceHandler f8760j;
    public final ApiMethodRunnerImpl f8761b;
    private final ListeningExecutorService f8762c;
    private final Executor f8763d;
    private final BaseFbBroadcastManager f8764e;
    private final SelfRegistrableReceiverImpl f8765f;
    public final PhotoQualityMethod f8766g;
    public final Cache<ThreadKey, PhotoQualityCacheItem> f8767h = CacheBuilder.newBuilder().a(7, TimeUnit.DAYS).a(50).q();
    public final FbSharedPreferences f8768i;

    /* compiled from: mCache */
    class C04181 implements ActionReceiver {
        final /* synthetic */ PhotoQualityServiceHandler f8773a;

        C04181(PhotoQualityServiceHandler photoQualityServiceHandler) {
            this.f8773a = photoQualityServiceHandler;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -574131526);
            PhotoQualityServiceHandler.m9081c(this.f8773a, (ThreadKey) intent.getParcelableExtra("thread_key"));
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -81197320, a);
        }
    }

    public static com.facebook.messaging.media.photoquality.PhotoQualityServiceHandler m9079a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f8760j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.media.photoquality.PhotoQualityServiceHandler.class;
        monitor-enter(r1);
        r0 = f8760j;	 Catch:{ all -> 0x003a }
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
        r0 = m9080b(r0);	 Catch:{ all -> 0x0035 }
        f8760j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8760j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.photoquality.PhotoQualityServiceHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.photoquality.PhotoQualityServiceHandler");
    }

    private static PhotoQualityServiceHandler m9080b(InjectorLike injectorLike) {
        return new PhotoQualityServiceHandler(ApiMethodRunnerImpl.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), PhotoQualityMethod.m9083a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public PhotoQualityServiceHandler(ApiMethodRunnerImpl apiMethodRunnerImpl, ListeningExecutorService listeningExecutorService, Executor executor, BaseFbBroadcastManager baseFbBroadcastManager, PhotoQualityMethod photoQualityMethod, FbSharedPreferences fbSharedPreferences) {
        this.f8761b = apiMethodRunnerImpl;
        this.f8762c = listeningExecutorService;
        this.f8763d = executor;
        this.f8764e = baseFbBroadcastManager;
        this.f8766g = photoQualityMethod;
        this.f8768i = fbSharedPreferences;
        String a = this.f8768i.a(PhotoQualityUploadPrefs.f8772c, null);
        if (!Strings.isNullOrEmpty(a)) {
            for (PhotoQualityCacheItem photoQualityCacheItem : PhotoQualityCacheItem.a(a)) {
                if (photoQualityCacheItem.a()) {
                    ThreadKey a2 = ThreadKey.a(photoQualityCacheItem.threadKey);
                    if (a2 != null) {
                        photoQualityCacheItem.b();
                        this.f8767h.a(a2, photoQualityCacheItem);
                    }
                }
            }
        }
        this.f8765f = this.f8764e.a().a(MessagesBroadcastIntents.u, new C04181(this)).a();
        this.f8765f.b();
    }

    public void finalize() {
        this.f8765f.c();
        super.finalize();
    }

    public static void m9081c(PhotoQualityServiceHandler photoQualityServiceHandler, ThreadKey threadKey) {
        if (!ThreadKey.d(threadKey)) {
            PhotoQualityCacheItem photoQualityCacheItem = (PhotoQualityCacheItem) photoQualityServiceHandler.f8767h.a(threadKey);
            if (photoQualityCacheItem == null || !photoQualityCacheItem.a()) {
                Futures.a(photoQualityServiceHandler.f8762c.a(new 2(photoQualityServiceHandler, threadKey)), new 3(photoQualityServiceHandler, threadKey), photoQualityServiceHandler.f8763d);
            }
        }
    }
}
