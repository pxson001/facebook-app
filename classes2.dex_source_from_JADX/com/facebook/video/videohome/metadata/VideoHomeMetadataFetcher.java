package com.facebook.video.videohome.metadata;

import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.async.CancellableRunnable;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.idleexecutor.DefaultProcessIdleExecutor;
import com.facebook.common.idleexecutor.IdleExecutor;
import com.facebook.common.idleexecutor.IdleExecutor_DefaultIdleExecutorMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.enums.GraphQLVideoHomeBadgeUpdateReason;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionHandle;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.notifications.common.JewelCounters;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ultralight.Inject;
import com.facebook.video.analytics.VideoAnalytics.BadgeFetchReason;
import com.facebook.video.analytics.VideoAnalytics.PrefetchReason;
import com.facebook.video.videohome.abtest.VideoHomeConfig;
import com.facebook.video.videohome.fragment.VideoHomeHomeFragment;
import com.facebook.video.videohome.fragment.VideoHomeHomeFragment.12;
import com.facebook.video.videohome.liveupdates.BroadcastStatusUpdateManager;
import com.facebook.video.videohome.liveupdates.LiveUpdatesManager;
import com.facebook.video.videohome.logging.VideoHomeLoggingUtils;
import com.facebook.video.videohome.metadata.VideoHomeMetadata.Builder;
import com.facebook.video.videohome.prefetching.VideoHomeReactionSessionHelper;
import com.facebook.video.videohome.protocol.VideoHomeQuery.VideoHomeBadgeQueryString;
import com.facebook.video.videohome.protocol.VideoHomeQueryGraphQLHelper;
import com.facebook.video.videohome.protocol.VideoHomeQueryModels.VideoHomeBadgeQueryModel;
import com.facebook.video.videohome.protocol.VideoHomeQueryModels.VideoHomePrefetchMetadataNoBadgingQueryModel;
import com.facebook.video.videohome.protocol.VideoHomeQueryModels.VideoHomePrefetchMetadataQueryModel;
import com.facebook.video.videohome.protocol.VideoHomeSubscriptionsGraphQLHelper;
import com.facebook.video.videohome.protocol.VideoHomeSubscriptionsModels$VideoHomeBadgeSubModel;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: goodwill_throwback */
public class VideoHomeMetadataFetcher implements IHaveUserData {
    public static final String f22130d = VideoHomeMetadataFetcher.class.getSimpleName();
    private static volatile VideoHomeMetadataFetcher f22131v;
    @Nullable
    @VisibleForTesting
    public CancellableRunnable f22132a;
    @Nullable
    @VisibleForTesting
    public GraphQLSubscriptionHandle f22133b;
    @VisibleForTesting
    public boolean f22134c;
    private final Lazy<VideoHomeQueryGraphQLHelper> f22135e;
    public final Lazy<VideoHomeSubscriptionsGraphQLHelper> f22136f;
    public final Lazy<VideoHomeReactionSessionHelper> f22137g;
    private final Lazy<VideoHomeSessionManager> f22138h;
    private final Lazy<AndroidThreadUtil> f22139i;
    public final Lazy<VideoHomeBadgeUpdater> f22140j;
    public final Lazy<JewelCounters> f22141k;
    private final Lazy<VideoHomeLoggingUtils> f22142l;
    public final Lazy<LiveUpdatesManager> f22143m;
    private final Lazy<VideoHomeConfig> f22144n;
    private final String f22145o;
    private final Provider<Boolean> f22146p;
    private final Provider<String> f22147q;
    private final DefaultProcessIdleExecutor f22148r;
    @Nullable
    private WeakReference<VideoHomeMetadataListener> f22149s;
    public int f22150t = 100;
    private BadgeFetchReason f22151u;

    /* compiled from: goodwill_throwback */
    class C08931 implements FutureCallback<VideoHomeSubscriptionsModels$VideoHomeBadgeSubModel> {
        final /* synthetic */ VideoHomeMetadataFetcher f22162a;

        C08931(VideoHomeMetadataFetcher videoHomeMetadataFetcher) {
            this.f22162a = videoHomeMetadataFetcher;
        }

        public void onSuccess(Object obj) {
            VideoHomeSubscriptionsModels$VideoHomeBadgeSubModel videoHomeSubscriptionsModels$VideoHomeBadgeSubModel = (VideoHomeSubscriptionsModels$VideoHomeBadgeSubModel) obj;
            if (videoHomeSubscriptionsModels$VideoHomeBadgeSubModel == null) {
                BLog.b(VideoHomeMetadataFetcher.f22130d, "Video Home badge subscription succeeded but result was null.");
                return;
            }
            int l = videoHomeSubscriptionsModels$VideoHomeBadgeSubModel.m30051l();
            int a = videoHomeSubscriptionsModels$VideoHomeBadgeSubModel.m30045a();
            this.f22162a.f22150t = videoHomeSubscriptionsModels$VideoHomeBadgeSubModel.m30050k();
            boolean a2 = this.f22162a.m30028a(l, a, false);
            Builder builder = new Builder();
            builder.a = a;
            Builder builder2 = builder;
            builder2.b = videoHomeSubscriptionsModels$VideoHomeBadgeSubModel.m30050k();
            builder2 = builder2;
            builder2.c = l;
            Builder builder3 = builder2;
            builder3.f = videoHomeSubscriptionsModels$VideoHomeBadgeSubModel.m30049j();
            VideoHomeMetadata a3 = builder3.a();
            String str = VideoHomeMetadataFetcher.f22130d;
            Object[] objArr = new Object[]{Integer.valueOf(a3.c), Boolean.valueOf(a2), a3.f, Integer.valueOf(a3.a), Integer.valueOf(a3.b)};
            VideoHomeReactionSessionHelper videoHomeReactionSessionHelper = (VideoHomeReactionSessionHelper) this.f22162a.f22137g.get();
            VideoHomeBadgeUpdater videoHomeBadgeUpdater = (VideoHomeBadgeUpdater) this.f22162a.f22140j.get();
            videoHomeBadgeUpdater.d = a3;
            videoHomeReactionSessionHelper.a(a3);
            if (this.f22162a.m30029b()) {
                videoHomeReactionSessionHelper.a(true);
            } else if (a2) {
                videoHomeReactionSessionHelper.a(videoHomeBadgeUpdater, PrefetchReason.MQTT);
            } else {
                videoHomeBadgeUpdater.c();
            }
            this.f22162a.m30027a(a3);
        }

        public void onFailure(Throwable th) {
            BLog.b(VideoHomeMetadataFetcher.f22130d, "Video Home badge subscription query failed", th);
        }
    }

    public static com.facebook.video.videohome.metadata.VideoHomeMetadataFetcher m30014a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f22131v;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.videohome.metadata.VideoHomeMetadataFetcher.class;
        monitor-enter(r1);
        r0 = f22131v;	 Catch:{ all -> 0x003a }
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
        r0 = m30017b(r0);	 Catch:{ all -> 0x0035 }
        f22131v = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f22131v;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.videohome.metadata.VideoHomeMetadataFetcher.a(com.facebook.inject.InjectorLike):com.facebook.video.videohome.metadata.VideoHomeMetadataFetcher");
    }

    private static VideoHomeMetadataFetcher m30017b(InjectorLike injectorLike) {
        return new VideoHomeMetadataFetcher(IdBasedLazy.m1808a(injectorLike, 11704), IdBasedLazy.m1808a(injectorLike, 3715), IdBasedSingletonScopeProvider.m1810b(injectorLike, 11702), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3716), IdBasedLazy.m1808a(injectorLike, 517), IdBasedLazy.m1808a(injectorLike, 11659), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2793), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3709), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3708), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3706), String_LoggedInUserIdMethodAutoProvider.m4329b(injectorLike), IdBasedProvider.m1811a(injectorLike, 4369), IdBasedProvider.m1811a(injectorLike, 4472), IdleExecutor_DefaultIdleExecutorMethodAutoProvider.m2724a(injectorLike));
    }

    public static void m30018b(VideoHomeMetadataFetcher videoHomeMetadataFetcher, VideoHomeMetadata videoHomeMetadata) {
        if (videoHomeMetadata.d > 0) {
            videoHomeMetadataFetcher.f22132a = videoHomeMetadataFetcher.m30023n();
            if (videoHomeMetadataFetcher.f22132a != null) {
                videoHomeMetadataFetcher.f22151u = BadgeFetchReason.PERIODIC;
                ((DefaultAndroidThreadUtil) videoHomeMetadataFetcher.f22139i.get()).m1657b(videoHomeMetadataFetcher.f22132a, videoHomeMetadata.d * 1000);
            }
        }
    }

    @Inject
    private VideoHomeMetadataFetcher(Lazy<VideoHomeQueryGraphQLHelper> lazy, Lazy<VideoHomeSubscriptionsGraphQLHelper> lazy2, Lazy<VideoHomeReactionSessionHelper> lazy3, Lazy<VideoHomeSessionManager> lazy4, Lazy<AndroidThreadUtil> lazy5, Lazy<VideoHomeBadgeUpdater> lazy6, Lazy<JewelCounters> lazy7, Lazy<VideoHomeLoggingUtils> lazy8, Lazy<LiveUpdatesManager> lazy9, Lazy<VideoHomeConfig> lazy10, String str, Provider<Boolean> provider, Provider<String> provider2, IdleExecutor idleExecutor) {
        this.f22135e = lazy;
        this.f22136f = lazy2;
        this.f22137g = lazy3;
        this.f22138h = lazy4;
        this.f22139i = lazy5;
        this.f22140j = lazy6;
        this.f22141k = lazy7;
        this.f22142l = lazy8;
        this.f22143m = lazy9;
        this.f22145o = str;
        this.f22146p = provider;
        this.f22147q = provider2;
        this.f22148r = idleExecutor;
        this.f22144n = lazy10;
    }

    public final void m30025a() {
        ((VideoHomeLoggingUtils) this.f22142l.get()).a(this.f22151u);
        if (((VideoHomeConfig) this.f22144n.get()).m14007a()) {
            VideoHomeQueryGraphQLHelper videoHomeQueryGraphQLHelper = (VideoHomeQueryGraphQLHelper) this.f22135e.get();
            FutureCallback k = m30020k();
            FutureCallback l = m30021l();
            GraphQLCachePolicy graphQLCachePolicy = GraphQLCachePolicy.f7111c;
            GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest("VideohomeMetadata");
            Futures.m2458a(graphQLBatchRequest.m11224b(GraphQLRequest.m11587a((TypedGraphQlQueryString) new VideoHomeBadgeQueryString()).m11594a(graphQLCachePolicy).m11590a(10)), k, videoHomeQueryGraphQLHelper.b);
            Futures.m2458a(graphQLBatchRequest.m11224b(VideoHomeQueryGraphQLHelper.c(graphQLCachePolicy)), l, videoHomeQueryGraphQLHelper.b);
            ((VideoHomeQueryGraphQLHelper) this.f22135e.get()).a.m10452a(graphQLBatchRequest);
            return;
        }
        this.f22135e.get();
        GraphQLRequest a = VideoHomeQueryGraphQLHelper.a(GraphQLCachePolicy.f7111c);
        videoHomeQueryGraphQLHelper = (VideoHomeQueryGraphQLHelper) this.f22135e.get();
        Futures.m2458a(videoHomeQueryGraphQLHelper.a.m10446a(a), m30022m(), videoHomeQueryGraphQLHelper.b);
    }

    @VisibleForTesting
    private FutureCallback<VideoHomeSubscriptionsModels$VideoHomeBadgeSubModel> m30019j() {
        return new C08931(this);
    }

    @VisibleForTesting
    private FutureCallback<GraphQLResult<VideoHomeBadgeQueryModel>> m30020k() {
        return new 2(this);
    }

    @VisibleForTesting
    private FutureCallback<GraphQLResult<VideoHomePrefetchMetadataQueryModel>> m30021l() {
        return new 3(this);
    }

    @VisibleForTesting
    private FutureCallback<GraphQLResult<VideoHomePrefetchMetadataNoBadgingQueryModel>> m30022m() {
        return new 4(this);
    }

    @VisibleForTesting
    final long m30024a(long j) {
        return ((String) this.f22147q.get()).equals("0") ? j : Long.parseLong((String) this.f22147q.get());
    }

    @VisibleForTesting
    final boolean m30028a(int i, int i2, boolean z) {
        if (!((Boolean) this.f22146p.get()).booleanValue()) {
            return m30016a(i2, z) && m30015a(i);
        } else {
            if (m30029b()) {
                return false;
            }
            return true;
        }
    }

    @VisibleForTesting
    private static boolean m30015a(int i) {
        return i > 0;
    }

    @VisibleForTesting
    private boolean m30016a(int i, boolean z) {
        boolean z2;
        if (!z || ((VideoHomeBadgeUpdater) this.f22140j.get()).a(i)) {
            z2 = true;
        } else {
            z2 = false;
        }
        return !m30029b() && (z2 || !((VideoHomeReactionSessionHelper) this.f22137g.get()).e());
    }

    final boolean m30029b() {
        return ((VideoHomeSessionManager) this.f22138h.get()).g();
    }

    public void clearUserData() {
        ((VideoHomeBadgeUpdater) this.f22140j.get()).d();
    }

    @Nullable
    private CancellableRunnable m30023n() {
        if (this.f22134c) {
            return new CancellableRunnable(new 5(this));
        }
        return null;
    }

    public final void m30030c() {
        this.f22134c = true;
        this.f22132a = m30023n();
        this.f22151u = BadgeFetchReason.APP_START;
        if (this.f22132a != null) {
            this.f22148r.mo269a(this.f22132a);
        }
    }

    public final void m30031e() {
        if (((VideoHomeConfig) this.f22144n.get()).f9163n) {
            this.f22133b = ((VideoHomeSubscriptionsGraphQLHelper) this.f22136f.get()).m30041a(this.f22145o, m30019j());
        }
        LiveUpdatesManager liveUpdatesManager = (LiveUpdatesManager) this.f22143m.get();
        if (liveUpdatesManager.f22169b.f9151b) {
            ((BroadcastStatusUpdateManager) liveUpdatesManager.f22168a.get()).m30063c();
        }
    }

    public final void m30026a(VideoHomeHomeFragment videoHomeHomeFragment) {
        this.f22149s = new WeakReference(videoHomeHomeFragment);
    }

    @VisibleForTesting
    final void m30027a(VideoHomeMetadata videoHomeMetadata) {
        if (this.f22149s != null) {
            VideoHomeHomeFragment videoHomeHomeFragment = (VideoHomeHomeFragment) this.f22149s.get();
            if (videoHomeHomeFragment != null && videoHomeMetadata.f != null && videoHomeHomeFragment.g.g() && videoHomeMetadata.f == GraphQLVideoHomeBadgeUpdateReason.LIVE_STARTED) {
                HandlerDetour.a(VideoHomeHomeFragment.aX, new 12(videoHomeHomeFragment), -979578984);
            }
        }
    }
}
