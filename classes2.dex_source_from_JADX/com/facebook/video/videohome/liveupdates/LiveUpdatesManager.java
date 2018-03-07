package com.facebook.video.videohome.liveupdates;

import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.video.videohome.abtest.VideoHomeConfig;
import com.facebook.video.videohome.liveupdates.BroadcastStatusUpdateManager.VideoTracker;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: goodfriends_first_post_prompt */
public class LiveUpdatesManager {
    private static volatile LiveUpdatesManager f22167c;
    public final Lazy<BroadcastStatusUpdateManager> f22168a;
    public final VideoHomeConfig f22169b;

    public static com.facebook.video.videohome.liveupdates.LiveUpdatesManager m30052a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f22167c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.videohome.liveupdates.LiveUpdatesManager.class;
        monitor-enter(r1);
        r0 = f22167c;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m30053b(r0);	 Catch:{ all -> 0x0035 }
        f22167c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f22167c;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.videohome.liveupdates.LiveUpdatesManager.a(com.facebook.inject.InjectorLike):com.facebook.video.videohome.liveupdates.LiveUpdatesManager");
    }

    private static LiveUpdatesManager m30053b(InjectorLike injectorLike) {
        return new LiveUpdatesManager(IdBasedLazy.m1808a(injectorLike, 3707), VideoHomeConfig.m14005a(injectorLike));
    }

    @Inject
    public LiveUpdatesManager(Lazy<BroadcastStatusUpdateManager> lazy, VideoHomeConfig videoHomeConfig) {
        this.f22168a = lazy;
        this.f22169b = videoHomeConfig;
    }

    public final void m30054a(GraphQLMedia graphQLMedia, BroadcastStatusUpdateListener broadcastStatusUpdateListener) {
        if (this.f22169b.f9151b) {
            Preconditions.checkNotNull(broadcastStatusUpdateListener);
            BroadcastStatusUpdateManager broadcastStatusUpdateManager = (BroadcastStatusUpdateManager) this.f22168a.get();
            Preconditions.checkNotNull(broadcastStatusUpdateListener);
            if (BroadcastStatusUpdateManager.m30059a(graphQLMedia.br())) {
                String b = graphQLMedia.m24452b();
                VideoTracker videoTracker = (VideoTracker) broadcastStatusUpdateManager.f22173d.get(b);
                if (videoTracker == null) {
                    videoTracker = new VideoTracker(broadcastStatusUpdateManager, b);
                    videoTracker.e = graphQLMedia.br();
                    videoTracker.b();
                    broadcastStatusUpdateManager.f22173d.put(b, videoTracker);
                    broadcastStatusUpdateManager.f22174e.m30073a(b);
                }
                videoTracker.a(broadcastStatusUpdateListener);
            }
        }
    }

    public final void m30055a(String str, BroadcastStatusUpdateListener broadcastStatusUpdateListener) {
        if (this.f22169b.f9151b) {
            Preconditions.checkNotNull(broadcastStatusUpdateListener);
            BroadcastStatusUpdateManager broadcastStatusUpdateManager = (BroadcastStatusUpdateManager) this.f22168a.get();
            Preconditions.checkNotNull(broadcastStatusUpdateListener);
            VideoTracker videoTracker = (VideoTracker) broadcastStatusUpdateManager.f22173d.get(str);
            if (videoTracker != null) {
                videoTracker.b(broadcastStatusUpdateListener);
                if (videoTracker.c.isEmpty()) {
                    videoTracker.a();
                    broadcastStatusUpdateManager.f22173d.remove(str);
                    broadcastStatusUpdateManager.f22174e.m30075b(str);
                }
            }
        }
    }

    public final boolean m30056a(GraphQLMedia graphQLMedia) {
        if (!this.f22169b.f9151b) {
            return graphQLMedia.br() == GraphQLVideoBroadcastStatus.LIVE;
        } else {
            if (((BroadcastStatusUpdateManager) this.f22168a.get()).m30062a(graphQLMedia.m24452b()) == GraphQLVideoBroadcastStatus.LIVE) {
                return true;
            }
            return false;
        }
    }
}
