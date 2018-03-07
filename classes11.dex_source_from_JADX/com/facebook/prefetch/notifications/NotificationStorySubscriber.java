package com.facebook.prefetch.notifications;

import com.facebook.inject.InjectorLike;
import com.facebook.notifications.abtest.Notifications2gImprovementsExperimentController;
import com.facebook.notifications.util.NotificationStoryHelper;
import com.facebook.video.abtest.VideoExoplayerConfig;
import com.facebook.video.abtest.VideoLivePlaybackConfig;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: Switching Protocols */
public class NotificationStorySubscriber {
    private static volatile NotificationStorySubscriber f10842h;
    public final Notifications2gImprovementsExperimentController f10843a;
    public final NotificationStoryImagesPrefetcher f10844b;
    public final NotificationStoryFeedbackUpdater f10845c;
    public final NotificationStoryHelper f10846d;
    public final NotificationStoryVideosPrefetcher f10847e;
    private final VideoExoplayerConfig f10848f;
    public final VideoLivePlaybackConfig f10849g;

    public static com.facebook.prefetch.notifications.NotificationStorySubscriber m11308a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10842h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.prefetch.notifications.NotificationStorySubscriber.class;
        monitor-enter(r1);
        r0 = f10842h;	 Catch:{ all -> 0x003a }
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
        r0 = m11309b(r0);	 Catch:{ all -> 0x0035 }
        f10842h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10842h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.prefetch.notifications.NotificationStorySubscriber.a(com.facebook.inject.InjectorLike):com.facebook.prefetch.notifications.NotificationStorySubscriber");
    }

    private static NotificationStorySubscriber m11309b(InjectorLike injectorLike) {
        return new NotificationStorySubscriber(Notifications2gImprovementsExperimentController.b(injectorLike), NotificationStoryImagesPrefetcher.m11306a(injectorLike), NotificationStoryFeedbackUpdater.m11303a(injectorLike), NotificationStoryHelper.a(injectorLike), NotificationStoryVideosPrefetcher.m11310a(injectorLike), VideoExoplayerConfig.b(injectorLike), VideoLivePlaybackConfig.a(injectorLike));
    }

    @Inject
    public NotificationStorySubscriber(Notifications2gImprovementsExperimentController notifications2gImprovementsExperimentController, NotificationStoryImagesPrefetcher notificationStoryImagesPrefetcher, NotificationStoryFeedbackUpdater notificationStoryFeedbackUpdater, NotificationStoryHelper notificationStoryHelper, NotificationStoryVideosPrefetcher notificationStoryVideosPrefetcher, VideoExoplayerConfig videoExoplayerConfig, VideoLivePlaybackConfig videoLivePlaybackConfig) {
        this.f10843a = notifications2gImprovementsExperimentController;
        this.f10844b = notificationStoryImagesPrefetcher;
        this.f10845c = notificationStoryFeedbackUpdater;
        this.f10846d = notificationStoryHelper;
        this.f10847e = notificationStoryVideosPrefetcher;
        this.f10848f = videoExoplayerConfig;
        this.f10849g = videoLivePlaybackConfig;
    }
}
