package com.facebook.video.videohome.prefetching;

import android.os.Handler;
import android.os.Looper;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.async.CancellableRunnable;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.publish.common.PendingStory;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.RequestType;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.reaction.ReactionQueryParams;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionSessionHelper;
import com.facebook.reaction.ReactionSessionListener;
import com.facebook.reaction.common.ReactionUnitComponentUtil;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoriesModel.EdgesModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentModel;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PrefetchReason;
import com.facebook.video.exoserviceclient.ExoServiceClient.PrefetchOrigin;
import com.facebook.video.prefetch.VideoPrefetchHelper;
import com.facebook.video.videohome.abtest.ExperimentsForVideoHomeAbTestModule;
import com.facebook.video.videohome.abtest.VideoHomeConfig;
import com.facebook.video.videohome.logging.VideoHomeLoggingUtils;
import com.facebook.video.videohome.metadata.VideoHomeBadgeUpdater;
import com.facebook.video.videohome.metadata.VideoHomeMetadata;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager;
import com.facebook.video.videohome.utils.VideoHomeLiveUpdatesHelper;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: showed_optimistic_send */
public class VideoHomeReactionSessionHelper {
    public static final String f3290c = VideoHomeReactionSessionHelper.class.getSimpleName();
    private static final Handler f3291d = new Handler(Looper.getMainLooper());
    public static final Object f3292e = new Object();
    private static volatile VideoHomeReactionSessionHelper f3293y;
    @Nullable
    CancellableRunnable f3294a;
    ReactionQueryParams f3295b;
    private final Lazy<ReactionSessionHelper> f3296f;
    private final Lazy<AndroidThreadUtil> f3297g;
    public final Lazy<VideoHomeSessionManager> f3298h;
    public final VideoHomeLiveUpdatesHelper f3299i;
    public final VideoHomeLoggingUtils f3300j;
    @Nullable
    public ReactionSession f3301k;
    private final String f3302l;
    public final Toaster f3303m;
    private final PrefetchReactionSessionListener f3304n = new PrefetchReactionSessionListener(this);
    public final Provider<Boolean> f3305o;
    public final QeAccessor f3306p;
    private final Clock f3307q;
    public boolean f3308r;
    private long f3309s = 1800;
    @Nullable
    private VideoHomeMetadata f3310t;
    private VideoPrefetchHelper f3311u;
    @Nullable
    private WeakReference<VideoHomePrefetchCallback> f3312v;
    public int f3313w;
    private VideoHomeConfig f3314x;

    /* compiled from: showed_optimistic_send */
    class C03052 implements Runnable {
        final /* synthetic */ VideoHomeReactionSessionHelper f3288a;

        public void run() {
            String str = VideoHomeReactionSessionHelper.f3290c;
            this.f3288a.m3141a(true);
        }

        C03052(VideoHomeReactionSessionHelper videoHomeReactionSessionHelper) {
            this.f3288a = videoHomeReactionSessionHelper;
        }
    }

    /* compiled from: showed_optimistic_send */
    class PrefetchReactionSessionListener implements ReactionSessionListener {
        final /* synthetic */ VideoHomeReactionSessionHelper f3289a;

        public PrefetchReactionSessionListener(VideoHomeReactionSessionHelper videoHomeReactionSessionHelper) {
            this.f3289a = videoHomeReactionSessionHelper;
        }

        public final boolean kq_() {
            return true;
        }

        public final void m3127a(ReactionStories reactionStories) {
        }

        public final void kr_() {
        }

        public final void m3128a(String str, Optional<PendingStory> optional) {
        }

        public final void kQ_() {
            if (this.f3289a.f3301k != null) {
                VideoHomeBadgeUpdater m = VideoHomeReactionSessionHelper.m3136m(this.f3289a);
                if (m != null) {
                    m.m2882c();
                }
                this.f3289a.m3145g();
                this.f3289a.f3299i.m3163a(this.f3289a.f3301k);
                this.f3289a.f3313w = VideoHomeReactionSessionHelper.m3129a(this.f3289a, this.f3289a.f3301k);
                this.f3289a.m3141a(true);
                String str = VideoHomeReactionSessionHelper.f3290c;
                ReactionSession reactionSession = this.f3289a.f3301k;
                if (((Boolean) this.f3289a.f3305o.get()).booleanValue()) {
                    this.f3289a.f3303m.a(new ToastBuilder("prefetchVideoHomeData finished succesfully"));
                }
            }
        }

        public final void kp_() {
            if (this.f3289a.f3301k != null) {
                this.f3289a.f3313w = 0;
                VideoHomeBadgeUpdater m = VideoHomeReactionSessionHelper.m3136m(this.f3289a);
                if (m != null) {
                    m.m2882c();
                }
                BLog.b(VideoHomeReactionSessionHelper.f3290c, "prefetchVideoHomeData prefetch error sessionId = %s", new Object[]{this.f3289a.f3301k.a});
            }
        }
    }

    public static com.facebook.video.videohome.prefetching.VideoHomeReactionSessionHelper m3130a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3293y;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.videohome.prefetching.VideoHomeReactionSessionHelper.class;
        monitor-enter(r1);
        r0 = f3293y;	 Catch:{ all -> 0x003a }
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
        r0 = m3132b(r0);	 Catch:{ all -> 0x0035 }
        f3293y = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3293y;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.videohome.prefetching.VideoHomeReactionSessionHelper.a(com.facebook.inject.InjectorLike):com.facebook.video.videohome.prefetching.VideoHomeReactionSessionHelper");
    }

    private static VideoHomeReactionSessionHelper m3132b(InjectorLike injectorLike) {
        return new VideoHomeReactionSessionHelper(IdBasedLazy.a(injectorLike, 9835), IdBasedSingletonScopeProvider.b(injectorLike, 3716), String_LoggedInUserIdMethodAutoProvider.b(injectorLike), Toaster.b(injectorLike), IdBasedProvider.a(injectorLike, 4370), VideoHomeLoggingUtils.a(injectorLike), IdBasedLazy.a(injectorLike, 517), VideoHomeLiveUpdatesHelper.m3160b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), VideoPrefetchHelper.m2638b(injectorLike), VideoHomeConfig.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    static /* synthetic */ int m3129a(VideoHomeReactionSessionHelper videoHomeReactionSessionHelper, ReactionSession reactionSession) {
        int i;
        int i2 = 0;
        ImmutableList p = reactionSession.p();
        int size = p.size();
        for (int i3 = 0; i3 < size; i3++) {
            ImmutableList a = ((ReactionStories) p.get(i3)).a();
            int size2 = a.size();
            for (int i4 = 0; i4 < size2; i4++) {
                EdgesModel edgesModel = (EdgesModel) a.get(i4);
                if (edgesModel.a() != null) {
                    ImmutableList s = edgesModel.a().s();
                    int size3 = s.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ReactionUnitComponentModel reactionUnitComponentModel = (ReactionUnitComponentModel) s.get(i5);
                        if (VideoHomeLiveUpdatesHelper.m3159a(reactionUnitComponentModel)) {
                            ImmutableList a2 = ReactionUnitComponentUtil.a(reactionUnitComponentModel);
                            if (a2 != null) {
                                i4 = a2.size();
                                i = 0;
                                while (i2 < i4) {
                                    a2.get(i2);
                                    i++;
                                    i2++;
                                }
                            } else {
                                i = 0;
                            }
                            return i;
                        }
                    }
                    continue;
                }
            }
        }
        i = 0;
        return i;
    }

    @Inject
    public VideoHomeReactionSessionHelper(Lazy<ReactionSessionHelper> lazy, Lazy<VideoHomeSessionManager> lazy2, String str, Toaster toaster, Provider<Boolean> provider, VideoHomeLoggingUtils videoHomeLoggingUtils, Lazy<AndroidThreadUtil> lazy3, VideoHomeLiveUpdatesHelper videoHomeLiveUpdatesHelper, QeAccessor qeAccessor, VideoPrefetchHelper videoPrefetchHelper, VideoHomeConfig videoHomeConfig, Clock clock) {
        this.f3296f = lazy;
        this.f3298h = lazy2;
        this.f3302l = str;
        this.f3303m = toaster;
        this.f3305o = provider;
        this.f3300j = videoHomeLoggingUtils;
        this.f3297g = lazy3;
        this.f3299i = videoHomeLiveUpdatesHelper;
        this.f3306p = qeAccessor;
        this.f3295b = m3134j();
        this.f3311u = videoPrefetchHelper;
        this.f3299i.f3333e = new WeakReference(this);
        this.f3314x = videoHomeConfig;
        this.f3307q = clock;
    }

    private ReactionQueryParams m3134j() {
        int a = this.f3306p.a(ExperimentsForVideoHomeAbTestModule.A, 2);
        boolean a2 = this.f3306p.a(ExperimentsForVideoHomeAbTestModule.n, false);
        ReactionQueryParams reactionQueryParams = new ReactionQueryParams();
        reactionQueryParams.t = Long.valueOf(Long.parseLong(this.f3302l));
        reactionQueryParams = reactionQueryParams;
        reactionQueryParams.b = (long) a;
        ReactionQueryParams reactionQueryParams2 = reactionQueryParams;
        reactionQueryParams2.A = a2;
        reactionQueryParams2 = reactionQueryParams2;
        reactionQueryParams2.i = NegativeFeedbackExperienceLocation.VIDEO_CHANNEL.stringValueOf();
        reactionQueryParams2 = reactionQueryParams2;
        reactionQueryParams2.p = RequestType.NORMAL;
        return reactionQueryParams2;
    }

    public final void m3140a(VideoHomeMetadata videoHomeMetadata) {
        this.f3310t = (VideoHomeMetadata) Preconditions.checkNotNull(videoHomeMetadata);
        if (this.f3310t.f2982c > 0) {
            this.f3295b.b = (long) this.f3310t.f2982c;
        }
        this.f3295b.p = RequestType.PREFETCH;
        this.f3309s = this.f3310t.f2984e;
    }

    public final void m3139a(@Nullable final VideoHomeBadgeUpdater videoHomeBadgeUpdater, final PrefetchReason prefetchReason) {
        if (this.f3306p.a(ExperimentsForVideoHomeAbTestModule.l, true)) {
            HandlerDetour.a(f3291d, new Runnable(this) {
                final /* synthetic */ VideoHomeReactionSessionHelper f3287c;

                public void run() {
                    synchronized (VideoHomeReactionSessionHelper.f3292e) {
                        this.f3287c.m3138a(videoHomeBadgeUpdater);
                        this.f3287c.f3300j.a(prefetchReason, PlayerOrigin.VIDEO_HOME);
                        VideoHomeReactionSessionHelper.f3290c;
                        this.f3287c.f3301k;
                        if (((Boolean) this.f3287c.f3305o.get()).booleanValue()) {
                            this.f3287c.f3303m.a(new ToastBuilder("prefetchVideoHomeData started"));
                        }
                    }
                }
            }, 2125172334);
        }
    }

    final void m3138a(@Nullable VideoHomeBadgeUpdater videoHomeBadgeUpdater) {
        this.f3300j.g = this.f3307q.a();
        this.f3312v = videoHomeBadgeUpdater == null ? null : new WeakReference(videoHomeBadgeUpdater);
        if (this.f3301k == null) {
            this.f3301k = m3137a();
            this.f3301k.a(this.f3304n);
            return;
        }
        this.f3301k.a();
        if (this.f3301k.A != null) {
            this.f3301k.A.run();
        }
    }

    public final ReactionSession m3137a() {
        return ((ReactionSessionHelper) this.f3296f.get()).a(Surface.VIDEO_HOME, this.f3295b);
    }

    @Nullable
    public final String m3142b() {
        String f;
        synchronized (f3292e) {
            if (m3144e()) {
                f = this.f3301k.f();
            } else {
                f = null;
            }
        }
        return f;
    }

    public final void m3143c() {
        synchronized (f3292e) {
            this.f3301k = null;
            this.f3295b = m3134j();
            this.f3310t = null;
        }
    }

    public final synchronized void m3141a(boolean z) {
        this.f3308r = z;
        Boolean.valueOf(this.f3308r);
        if (!z) {
            if (this.f3294a != null) {
                this.f3294a.a();
            }
            if (this.f3309s > 0) {
                this.f3294a = m3135l();
                ((DefaultAndroidThreadUtil) this.f3297g.get()).b(this.f3294a, this.f3309s * 1000);
                Long.valueOf(this.f3309s);
            }
        }
    }

    private CancellableRunnable m3135l() {
        return new CancellableRunnable(new C03052(this));
    }

    @Nullable
    public static VideoHomeBadgeUpdater m3136m(VideoHomeReactionSessionHelper videoHomeReactionSessionHelper) {
        return videoHomeReactionSessionHelper.f3312v == null ? null : (VideoHomeBadgeUpdater) videoHomeReactionSessionHelper.f3312v.get();
    }

    public final boolean m3144e() {
        return this.f3301k != null;
    }

    final void m3145g() {
        if (this.f3301k != null && !this.f3314x.f) {
            ImmutableList p = this.f3301k.p();
            int size = p.size();
            for (int i = 0; i < size; i++) {
                ImmutableList a = ((ReactionStories) p.get(i)).a();
                int size2 = a.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    EdgesModel edgesModel = (EdgesModel) a.get(i2);
                    if (edgesModel.a() != null) {
                        ImmutableList s = edgesModel.a().s();
                        int size3 = s.size();
                        for (int i3 = 0; i3 < size3; i3++) {
                            ImmutableList a2 = ReactionUnitComponentUtil.a((ReactionUnitComponentModel) s.get(i3));
                            if (a2 != null) {
                                int size4 = a2.size();
                                for (int i4 = 0; i4 < size4; i4++) {
                                    GraphQLStory ax = ((ReactionUnitComponentFields) a2.get(i4)).ax();
                                    if (!(ax == null || StoryAttachmentHelper.o(ax) == null)) {
                                        GraphQLStoryAttachment o = StoryAttachmentHelper.o(ax);
                                        if (!(o == null || o.r() == null)) {
                                            if (this.f3314x.h) {
                                                this.f3311u.m2639a(o, PrefetchOrigin.VIDEO_HOME);
                                                return;
                                            } else {
                                                this.f3311u.m2640b(o, PrefetchOrigin.VIDEO_HOME);
                                                return;
                                            }
                                        }
                                    }
                                }
                                continue;
                            }
                        }
                        continue;
                    }
                }
            }
        }
    }
}
