package com.facebook.video.videohome.prefetching;

import android.os.Handler;
import android.os.Message;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.InjectorLike;
import com.facebook.video.exoserviceclient.ExoServiceClient.PrefetchOrigin;
import com.facebook.video.prefetch.VideoPrefetchHelper;
import com.facebook.video.videohome.abtest.VideoHomeConfig;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager.SessionStatusListener;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: show_surge_dialog */
public class VideoHomeVideoPrefetchController {
    public static final String f3317a = VideoHomeVideoPrefetchController.class.getSimpleName();
    private static volatile VideoHomeVideoPrefetchController f3318j;
    private final VideoHomeSessionManager f3319b;
    public final VideoPrefetchHelper f3320c;
    public final VideoHomeConfig f3321d;
    public final Clock f3322e;
    private final SessionStatusListener f3323f;
    public Handler f3324g;
    public ConcurrentLinkedQueue<GraphQLStoryAttachment> f3325h = new ConcurrentLinkedQueue();
    public long f3326i;

    /* compiled from: show_surge_dialog */
    class C03061 implements SessionStatusListener {
        final /* synthetic */ VideoHomeVideoPrefetchController f3315a;

        C03061(VideoHomeVideoPrefetchController videoHomeVideoPrefetchController) {
            this.f3315a = videoHomeVideoPrefetchController;
        }

        public final void m3146a() {
            this.f3315a.f3326i = this.f3315a.f3322e.a();
        }

        public final void kM_() {
        }

        public final void kN_() {
        }

        public final void m3147e() {
            this.f3315a.f3326i = 0;
            if (this.f3315a.f3324g != null && this.f3315a.f3324g.hasMessages(2)) {
                String str = VideoHomeVideoPrefetchController.f3317a;
                this.f3315a.f3324g.removeMessages(2);
                this.f3315a.f3325h.clear();
            }
        }
    }

    /* compiled from: show_surge_dialog */
    public class VideoHomeVideoDelayedPrefetchHandler extends Handler {
        WeakReference<VideoHomeVideoPrefetchController> f3316a;

        public VideoHomeVideoDelayedPrefetchHandler(VideoHomeVideoPrefetchController videoHomeVideoPrefetchController) {
            this.f3316a = new WeakReference(videoHomeVideoPrefetchController);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    VideoHomeVideoPrefetchController videoHomeVideoPrefetchController = (VideoHomeVideoPrefetchController) this.f3316a.get();
                    if (videoHomeVideoPrefetchController != null) {
                        Integer.valueOf(videoHomeVideoPrefetchController.f3325h.size());
                        while (true) {
                            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) videoHomeVideoPrefetchController.f3325h.poll();
                            if (graphQLStoryAttachment != null) {
                                graphQLStoryAttachment.C();
                                videoHomeVideoPrefetchController.f3320c.m2640b(graphQLStoryAttachment, PrefetchOrigin.VIDEO_HOME);
                            } else {
                                return;
                            }
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public static com.facebook.video.videohome.prefetching.VideoHomeVideoPrefetchController m3148a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3318j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.videohome.prefetching.VideoHomeVideoPrefetchController.class;
        monitor-enter(r1);
        r0 = f3318j;	 Catch:{ all -> 0x003a }
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
        r0 = m3149b(r0);	 Catch:{ all -> 0x0035 }
        f3318j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3318j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.videohome.prefetching.VideoHomeVideoPrefetchController.a(com.facebook.inject.InjectorLike):com.facebook.video.videohome.prefetching.VideoHomeVideoPrefetchController");
    }

    private static VideoHomeVideoPrefetchController m3149b(InjectorLike injectorLike) {
        return new VideoHomeVideoPrefetchController(VideoHomeSessionManager.a(injectorLike), VideoPrefetchHelper.m2638b(injectorLike), VideoHomeConfig.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public VideoHomeVideoPrefetchController(VideoHomeSessionManager videoHomeSessionManager, VideoPrefetchHelper videoPrefetchHelper, VideoHomeConfig videoHomeConfig, Clock clock) {
        this.f3319b = videoHomeSessionManager;
        this.f3320c = videoPrefetchHelper;
        this.f3321d = videoHomeConfig;
        this.f3322e = clock;
        this.f3326i = this.f3319b.g() ? this.f3322e.a() : 0;
        this.f3323f = new C03061(this);
        this.f3319b.a(this.f3323f);
    }
}
