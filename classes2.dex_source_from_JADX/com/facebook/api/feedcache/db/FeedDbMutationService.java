package com.facebook.api.feedcache.db;

import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feed.subscriptions.LiveVideoStatusHandler;
import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler.DiskCacheReadException;
import com.facebook.api.feedcache.omnistore.FeedUnitUpdateHandler;
import com.facebook.api.feedcache.omnistore.VpvUpdateHandler;
import com.facebook.api.feedcache.omnistore.analytics.OmnistoreUpdateAnalyticLogger;
import com.facebook.api.feedcache.omnistore.annotations.IsOmnistorePrivacyUpdateEnable;
import com.facebook.api.feedcache.omnistore.annotations.IsOmnistoreVpvUpdateEnable;
import com.facebook.api.feedcache.omnistore.util.FeedUnitUpdateUtil;
import com.facebook.api.feedtype.FeedType;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.init.INeedInit;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.common.userinteraction.UserInteractionController;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.debug.log.BLog;
import com.facebook.feed.data.freshfeed.FreshFeedDataLoader.C05672;
import com.facebook.feed.data.freshfeed.ranking.ClientRankingSignalStore;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionHandle;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: set_notify_me_ */
public class FeedDbMutationService implements INeedInit {
    private static final String f5225a = "1";
    private static volatile FeedDbMutationService f5226s;
    private final ExecutorService f5227b;
    public final DefaultUserInteractionController f5228c;
    private final DbFeedHomeStoriesHandler f5229d;
    private final DBFeedRerankHandler f5230e;
    private final Provider<FeedUnitUpdateHandler> f5231f;
    private final Provider<VpvUpdateHandler> f5232g;
    @IsOmnistorePrivacyUpdateEnable
    private final Provider<Boolean> f5233h;
    @IsOmnistoreVpvUpdateEnable
    private final Provider<Boolean> f5234i;
    private final FbAppType f5235j;
    private final OmnistoreUpdateAnalyticLogger f5236k;
    private final ClientRankingSignalStore f5237l;
    private final LiveVideoStatusHandler f5238m;
    private final GatekeeperStoreImpl f5239n;
    @GuardedBy("mRequests")
    private boolean f5240o = false;
    private boolean f5241p = false;
    private final ArrayDeque<FeedDbRequest> f5242q = new ArrayDeque();
    public C05672 f5243r;

    /* compiled from: set_notify_me_ */
    public class FeedDbInsertionRequest implements FeedDbRequest {
        public final FetchFeedResult f16266a;

        public FeedDbInsertionRequest(FetchFeedResult fetchFeedResult) {
            this.f16266a = fetchFeedResult;
        }
    }

    /* compiled from: set_notify_me_ */
    public interface FeedDbRequest {
    }

    /* compiled from: set_notify_me_ */
    public class FeedDbStoryImageUrlAddRequest implements FeedDbRequest {
        public final String f21885a;
        public final String f21886b;

        public FeedDbStoryImageUrlAddRequest(String str, String str2) {
            this.f21885a = str;
            this.f21886b = str2;
        }
    }

    public static com.facebook.api.feedcache.db.FeedDbMutationService m9091a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5226s;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.api.feedcache.db.FeedDbMutationService.class;
        monitor-enter(r1);
        r0 = f5226s;	 Catch:{ all -> 0x003a }
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
        r0 = m9104b(r0);	 Catch:{ all -> 0x0035 }
        f5226s = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5226s;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.db.FeedDbMutationService.a(com.facebook.inject.InjectorLike):com.facebook.api.feedcache.db.FeedDbMutationService");
    }

    private static FeedDbMutationService m9104b(InjectorLike injectorLike) {
        return new FeedDbMutationService(C0055x2995691a.m1881a(injectorLike), DefaultUserInteractionController.m1747a(injectorLike), DbFeedHomeStoriesHandler.m9120a(injectorLike), DBFeedRerankHandler.m9321a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4805), IdBasedProvider.m1811a(injectorLike, 4806), IdBasedProvider.m1811a(injectorLike, 3894), IdBasedProvider.m1811a(injectorLike, 3895), (FbAppType) injectorLike.getInstance(FbAppType.class), OmnistoreUpdateAnalyticLogger.m9361b(injectorLike), ClientRankingSignalStore.m9365a(injectorLike), LiveVideoStatusHandler.m9378a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public FeedDbMutationService(ExecutorService executorService, UserInteractionController userInteractionController, DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler, DBFeedRerankHandler dBFeedRerankHandler, Provider<FeedUnitUpdateHandler> provider, Provider<VpvUpdateHandler> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, FbAppType fbAppType, OmnistoreUpdateAnalyticLogger omnistoreUpdateAnalyticLogger, ClientRankingSignalStore clientRankingSignalStore, LiveVideoStatusHandler liveVideoStatusHandler, GatekeeperStore gatekeeperStore) {
        this.f5227b = executorService;
        this.f5228c = userInteractionController;
        this.f5229d = dbFeedHomeStoriesHandler;
        this.f5230e = dBFeedRerankHandler;
        this.f5231f = provider;
        this.f5232g = provider2;
        this.f5233h = provider3;
        this.f5234i = provider4;
        this.f5235j = fbAppType;
        this.f5236k = omnistoreUpdateAnalyticLogger;
        this.f5237l = clientRankingSignalStore;
        this.f5238m = liveVideoStatusHandler;
        this.f5239n = gatekeeperStore;
    }

    public void init() {
        synchronized (this.f5242q) {
            this.f5241p = true;
            if (!this.f5240o && this.f5242q.size() > 0) {
                m9092a();
            }
        }
    }

    public final void m9112a(FeedDbRequest feedDbRequest) {
        synchronized (this.f5242q) {
            this.f5242q.addLast(feedDbRequest);
            if (!this.f5240o && this.f5241p) {
                m9092a();
            }
        }
    }

    public final boolean m9113b(FeedDbRequest feedDbRequest) {
        boolean z;
        synchronized (this.f5242q) {
            if (this.f5241p) {
                this.f5242q.addLast(feedDbRequest);
                if (!this.f5240o) {
                    m9092a();
                }
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    @GuardedBy("mRequests")
    private void m9092a() {
        this.f5240o = true;
        ExecutorDetour.a(this.f5227b, new 1(this), -827469852);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m9105b(com.facebook.api.feedcache.db.FeedDbMutationService r5) {
        /*
    L_0x0000:
        r1 = r5.f5242q;
        monitor-enter(r1);
        r0 = r5.f5242q;	 Catch:{ all -> 0x004d }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x004d }
        if (r0 == 0) goto L_0x0010;
    L_0x000b:
        r0 = 0;
        r5.f5240o = r0;	 Catch:{ all -> 0x004d }
        monitor-exit(r1);	 Catch:{ all -> 0x004d }
        return;
    L_0x0010:
        r0 = r5.f5242q;	 Catch:{ all -> 0x004d }
        r0 = r0.removeFirst();	 Catch:{ all -> 0x004d }
        r0 = (com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbRequest) r0;	 Catch:{ all -> 0x004d }
        monitor-exit(r1);	 Catch:{ all -> 0x004d }
        r1 = "FeedDbMutationService(%s)";
        r2 = r0.getClass();
        r2 = r2.getSimpleName();
        r3 = -341619410; // 0xffffffffeba34d2e float:-3.9483876E26 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1, r2, r3);
        r1 = -243934633; // 0xfffffffff175da57 float:-1.21740455E30 double:NaN;
        r1 = com.facebook.tools.dextr.runtime.detour.LoomLoggerDetour.a(r1);
        r2 = "FeedDbMutationService";
        r3 = r0.getClass();
        r3 = r3.getSimpleName();
        com.facebook.loom.logger.api.LoomLogger.a(r1, r2, r3);
        r1 = r0 instanceof com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbInsertionRequest;	 Catch:{ all -> 0x0134 }
        if (r1 == 0) goto L_0x0050;
    L_0x0041:
        r0 = (com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbInsertionRequest) r0;	 Catch:{ all -> 0x0134 }
        r5.m9111a(r0);	 Catch:{ all -> 0x0134 }
        r0 = 1514815075; // 0x5a4a3e63 float:1.42316351E16 double:7.484180884E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        goto L_0x0000;
    L_0x004d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;
    L_0x0050:
        r1 = r0 instanceof com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbMutationRequest;	 Catch:{  }
        if (r1 == 0) goto L_0x0060;
    L_0x0054:
        r0 = (com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbMutationRequest) r0;	 Catch:{  }
        r5.m9100a(r0);	 Catch:{  }
        r0 = 32841027; // 0x1f51d43 float:9.0040775E-38 double:1.6225623E-316;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        goto L_0x0000;
    L_0x0060:
        r1 = r0 instanceof com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbStorySeenRequest;	 Catch:{  }
        if (r1 == 0) goto L_0x0070;
    L_0x0064:
        r0 = (com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbStorySeenRequest) r0;	 Catch:{  }
        r5.m9103a(r0);	 Catch:{  }
        r0 = -150761083; // 0xfffffffff7039185 float:-2.668525E33 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        goto L_0x0000;
    L_0x0070:
        r1 = r0 instanceof com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbImageCacheStateUpdateRequest;	 Catch:{  }
        if (r1 == 0) goto L_0x0080;
    L_0x0074:
        r0 = (com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbImageCacheStateUpdateRequest) r0;	 Catch:{  }
        r5.m9097a(r0);	 Catch:{  }
        r0 = -1582673432; // 0xffffffffa1aa51e8 float:-1.1541328E-18 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        goto L_0x0000;
    L_0x0080:
        r1 = r0 instanceof com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbSeeFirstClearRequest;	 Catch:{  }
        if (r1 == 0) goto L_0x0091;
    L_0x0084:
        r0 = (com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbSeeFirstClearRequest) r0;	 Catch:{  }
        r5.m9101a(r0);	 Catch:{  }
        r0 = -1051379810; // 0xffffffffc155379e float:-13.326078 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        goto L_0x0000;
    L_0x0091:
        r1 = r0 instanceof com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbCacheResultRerankRequest;	 Catch:{  }
        if (r1 == 0) goto L_0x00a2;
    L_0x0095:
        r0 = (com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbCacheResultRerankRequest) r0;	 Catch:{  }
        r5.m9094a(r0);	 Catch:{  }
        r0 = -521547659; // 0xffffffffe0e9d075 float:-1.3478476E20 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        goto L_0x0000;
    L_0x00a2:
        r1 = r0 instanceof com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbCacheRerankRequest;	 Catch:{  }
        if (r1 == 0) goto L_0x00b3;
    L_0x00a6:
        r0 = (com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbCacheRerankRequest) r0;	 Catch:{  }
        r5.m9093a(r0);	 Catch:{  }
        r0 = -495910365; // 0xffffffffe2710223 float:-1.1114548E21 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        goto L_0x0000;
    L_0x00b3:
        r1 = r0 instanceof com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbStoryImageUrlAddRequest;	 Catch:{  }
        if (r1 == 0) goto L_0x00c4;
    L_0x00b7:
        r0 = (com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbStoryImageUrlAddRequest) r0;	 Catch:{  }
        r5.m9102a(r0);	 Catch:{  }
        r0 = 1956524893; // 0x749e335d float:1.0027157E32 double:9.66651735E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        goto L_0x0000;
    L_0x00c4:
        r1 = r0 instanceof com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbDeleteStoriesRequest;	 Catch:{  }
        if (r1 == 0) goto L_0x00d5;
    L_0x00c8:
        r0 = (com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbDeleteStoriesRequest) r0;	 Catch:{  }
        r5.m9095a(r0);	 Catch:{  }
        r0 = 1671584920; // 0x63a25c98 float:5.990089E21 double:8.25872683E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        goto L_0x0000;
    L_0x00d5:
        r1 = r0 instanceof com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbDeleteStoryRequest;	 Catch:{  }
        if (r1 == 0) goto L_0x00e6;
    L_0x00d9:
        r0 = (com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbDeleteStoryRequest) r0;	 Catch:{  }
        r5.m9096a(r0);	 Catch:{  }
        r0 = -696100424; // 0xffffffffd68259b8 float:-7.1660925E13 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        goto L_0x0000;
    L_0x00e6:
        r1 = r0 instanceof com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbVpvOmnistoreSyncRequest;	 Catch:{  }
        if (r1 == 0) goto L_0x00f5;
    L_0x00ea:
        r5.m9106c();	 Catch:{  }
        r0 = -1045059660; // 0xffffffffc1b5a7b4 float:-22.706886 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        goto L_0x0000;
    L_0x00f5:
        r1 = r0 instanceof com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbLikeAndCommentCountUpdateRequest;	 Catch:{  }
        if (r1 == 0) goto L_0x0106;
    L_0x00f9:
        r0 = (com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbLikeAndCommentCountUpdateRequest) r0;	 Catch:{  }
        r5.m9098a(r0);	 Catch:{  }
        r0 = 759596755; // 0x2d4686d3 float:1.1284934E-11 double:3.752906613E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        goto L_0x0000;
    L_0x0106:
        r1 = r0 instanceof com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbLiveVideoStatusUpdateRequest;	 Catch:{  }
        if (r1 == 0) goto L_0x0117;
    L_0x010a:
        r0 = (com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbLiveVideoStatusUpdateRequest) r0;	 Catch:{  }
        r5.m9099a(r0);	 Catch:{  }
        r0 = -1270711073; // 0xffffffffb4427cdf float:-1.8113086E-7 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        goto L_0x0000;
    L_0x0117:
        r1 = "FeedDbMutationService";
        r2 = "Mutation request is not supported: %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{  }
        r4 = 0;
        r0 = r0.getClass();	 Catch:{  }
        r0 = r0.getSimpleName();	 Catch:{  }
        r3[r4] = r0;	 Catch:{  }
        com.facebook.debug.log.BLog.c(r1, r2, r3);	 Catch:{  }
        r0 = 492192568; // 0x1d564338 float:2.8357415E-21 double:2.43175439E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        goto L_0x0000;
    L_0x0134:
        r0 = move-exception;
        r1 = -693974918; // 0xffffffffd6a2c87a float:-8.9490962E13 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.db.FeedDbMutationService.b(com.facebook.api.feedcache.db.FeedDbMutationService):void");
    }

    private void m9099a(FeedDbLiveVideoStatusUpdateRequest feedDbLiveVideoStatusUpdateRequest) {
        if (m9110g()) {
            LiveVideoStatusHandler liveVideoStatusHandler = this.f5238m;
            String str = feedDbLiveVideoStatusUpdateRequest.b;
            if (liveVideoStatusHandler.f5495c.containsKey(str)) {
                GraphQLSubscriptionHandle graphQLSubscriptionHandle = (GraphQLSubscriptionHandle) liveVideoStatusHandler.f5495c.get(str);
                Set hashSet = new HashSet();
                hashSet.add(graphQLSubscriptionHandle);
                liveVideoStatusHandler.f5493a.m9388a(hashSet);
                liveVideoStatusHandler.f5495c.remove(str);
            }
            this.f5237l.m9373c(feedDbLiveVideoStatusUpdateRequest.a, 2);
        }
    }

    private void m9098a(FeedDbLikeAndCommentCountUpdateRequest feedDbLikeAndCommentCountUpdateRequest) {
        if (m9108e()) {
            GraphQLFeedUnitEdge a = this.f5229d.m9160a(FeedType.f5039b, feedDbLikeAndCommentCountUpdateRequest.a);
            if (a == null) {
                ((FeedUnitUpdateHandler) this.f5231f.get()).a(feedDbLikeAndCommentCountUpdateRequest.a);
            } else if (a.mo2540c() instanceof GraphQLStory) {
                GraphQLStory graphQLStory = (GraphQLStory) a.mo2540c();
                if (graphQLStory != null) {
                    int aa_ = graphQLStory.aa_();
                    int n = graphQLStory.mo2891n();
                    if (feedDbLikeAndCommentCountUpdateRequest.b > graphQLStory.aa_()) {
                        graphQLStory = FeedUnitUpdateUtil.a(graphQLStory, feedDbLikeAndCommentCountUpdateRequest.b);
                    }
                    if (feedDbLikeAndCommentCountUpdateRequest.c > graphQLStory.mo2891n()) {
                        graphQLStory = FeedUnitUpdateUtil.b(graphQLStory, feedDbLikeAndCommentCountUpdateRequest.c);
                    }
                    OmnistoreUpdateAnalyticLogger omnistoreUpdateAnalyticLogger = this.f5236k;
                    int i = feedDbLikeAndCommentCountUpdateRequest.b;
                    int i2 = feedDbLikeAndCommentCountUpdateRequest.c;
                    HoneyClientEventFast a2 = omnistoreUpdateAnalyticLogger.f5471a.mo535a("feed_omnistore_likes_comments_count", false);
                    if (a2.m17388a()) {
                        a2.m17381a("old_like_count", aa_);
                        a2.m17381a("new_like_count", i);
                        a2.m17381a("old_comment_count", n);
                        a2.m17381a("new_comment_count", i2);
                        a2.m17390b();
                    }
                    byte[] a3 = FeedUnitUpdateUtil.a(graphQLStory);
                    byte[] b = FeedUnitUpdateUtil.b(graphQLStory);
                    if (a3 != null && b != null) {
                        this.f5229d.m9168a(FeedType.f5039b.m8961a(), feedDbLikeAndCommentCountUpdateRequest.a, a.m19084d(), String.valueOf(a.m21238w()), a3, b);
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m9111a(com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbInsertionRequest r4) {
        /*
        r3 = this;
        r0 = "FeedDbMutationService.processInsert";
        r1 = 1073032506; // 0x3ff52d3a float:1.9154427 double:5.30148498E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0, r1);
        r0 = r3.f5229d;	 Catch:{ Exception -> 0x0039 }
        r1 = r4.f16266a;	 Catch:{ Exception -> 0x0039 }
        r0.m9176c(r1);	 Catch:{ Exception -> 0x0039 }
        r0 = r3.m9108e();	 Catch:{ Exception -> 0x0039 }
        if (r0 == 0) goto L_0x0025;
    L_0x0015:
        r0 = r3.f5231f;	 Catch:{ Exception -> 0x0039 }
        r0 = r0.get();	 Catch:{ Exception -> 0x0039 }
        r0 = (com.facebook.api.feedcache.omnistore.FeedUnitUpdateHandler) r0;	 Catch:{ Exception -> 0x0039 }
        r1 = r4.f16266a;	 Catch:{ Exception -> 0x0039 }
        r0.a(r1);	 Catch:{ Exception -> 0x0039 }
        r3.m9107d();	 Catch:{ Exception -> 0x0039 }
    L_0x0025:
        r0 = r3.m9110g();	 Catch:{ Exception -> 0x0039 }
        if (r0 == 0) goto L_0x0032;
    L_0x002b:
        r0 = r3.f5238m;	 Catch:{ Exception -> 0x0039 }
        r1 = r4.f16266a;	 Catch:{ Exception -> 0x0039 }
        r0.m9382a(r1, r3);	 Catch:{ Exception -> 0x0039 }
    L_0x0032:
        r0 = -1434301058; // 0xffffffffaa824d7e float:-2.314641E-13 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
    L_0x0038:
        return;
    L_0x0039:
        r0 = move-exception;
        r1 = "FeedDbMutationService";
        r2 = "Error performing insertion on feed";
        com.facebook.debug.log.BLog.b(r1, r2, r0);	 Catch:{ all -> 0x0048 }
        r0 = -816361482; // 0xffffffffcf574ff6 float:-3.61234176E9 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        goto L_0x0038;
    L_0x0048:
        r0 = move-exception;
        r1 = -601875320; // 0xffffffffdc201c88 float:-1.80269467E17 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.db.FeedDbMutationService.a(com.facebook.api.feedcache.db.FeedDbMutationService$FeedDbInsertionRequest):void");
    }

    private void m9095a(FeedDbDeleteStoriesRequest feedDbDeleteStoriesRequest) {
        this.f5229d.m9155a(feedDbDeleteStoriesRequest.a);
        if (m9108e()) {
            ((FeedUnitUpdateHandler) this.f5231f.get()).a(feedDbDeleteStoriesRequest.a);
            m9107d();
        }
        if (m9109f()) {
            ((VpvUpdateHandler) this.f5232g.get()).a(feedDbDeleteStoriesRequest.a);
        }
    }

    private void m9096a(FeedDbDeleteStoryRequest feedDbDeleteStoryRequest) {
        this.f5229d.m9165a(feedDbDeleteStoryRequest.a);
        if (m9108e()) {
            ((FeedUnitUpdateHandler) this.f5231f.get()).a(feedDbDeleteStoryRequest.a);
            m9107d();
        }
        if (m9109f()) {
            ((VpvUpdateHandler) this.f5232g.get()).a(feedDbDeleteStoryRequest.a);
        }
    }

    private void m9100a(FeedDbMutationRequest feedDbMutationRequest) {
        this.f5229d.m9168a(feedDbMutationRequest.b, feedDbMutationRequest.c, feedDbMutationRequest.d, feedDbMutationRequest.e, feedDbMutationRequest.f, feedDbMutationRequest.g);
        if (m9108e()) {
            ((FeedUnitUpdateHandler) this.f5231f.get()).a(feedDbMutationRequest.c, feedDbMutationRequest.d, feedDbMutationRequest.a);
        }
    }

    private void m9103a(FeedDbStorySeenRequest feedDbStorySeenRequest) {
        int i = 0;
        String c = PropertyHelper.m21293c(feedDbStorySeenRequest.a);
        if (!StringUtil.m3589a((CharSequence) c) && this.f5229d.m9169b(c, feedDbStorySeenRequest.b) > 0) {
            i = 1;
        }
        if (i == 0) {
            this.f5229d.m9157a(feedDbStorySeenRequest.a.mo2507g(), feedDbStorySeenRequest.b);
        }
        if (m9109f()) {
            ((VpvUpdateHandler) this.f5232g.get()).a(feedDbStorySeenRequest.a);
        }
        PropertyHelper.m21291b(feedDbStorySeenRequest.a, f5225a);
        this.f5237l.m9370a(feedDbStorySeenRequest.a.mo2507g(), 1);
    }

    private void m9097a(FeedDbImageCacheStateUpdateRequest feedDbImageCacheStateUpdateRequest) {
        if (this.f5243r != null) {
            this.f5243r.m20229a(feedDbImageCacheStateUpdateRequest.a, feedDbImageCacheStateUpdateRequest.b, feedDbImageCacheStateUpdateRequest.c);
        }
        this.f5229d.m9167a(feedDbImageCacheStateUpdateRequest.a, feedDbImageCacheStateUpdateRequest.b, feedDbImageCacheStateUpdateRequest.c);
    }

    private void m9102a(FeedDbStoryImageUrlAddRequest feedDbStoryImageUrlAddRequest) {
        if (this.f5243r != null) {
            this.f5243r.m20229a(feedDbStoryImageUrlAddRequest.f21885a, feedDbStoryImageUrlAddRequest.f21886b, 0);
        }
        this.f5229d.m9166a(feedDbStoryImageUrlAddRequest.f21885a, feedDbStoryImageUrlAddRequest.f21886b);
    }

    private void m9101a(FeedDbSeeFirstClearRequest feedDbSeeFirstClearRequest) {
        this.f5229d.m9177c(feedDbSeeFirstClearRequest.a);
    }

    private void m9093a(FeedDbCacheRerankRequest feedDbCacheRerankRequest) {
        try {
            this.f5230e.m9330a(feedDbCacheRerankRequest.a());
        } catch (Throwable e) {
            BLog.b("FeedDbMutationService", "Error performing reranking on cache feed", e);
        }
    }

    private void m9094a(FeedDbCacheResultRerankRequest feedDbCacheResultRerankRequest) {
        try {
            this.f5230e.m9330a(feedDbCacheResultRerankRequest.a());
            feedDbCacheResultRerankRequest.a.a(this.f5229d.m9159a(feedDbCacheResultRerankRequest.b));
        } catch (DiskCacheReadException e) {
            BLog.b("FeedDbMutationService", "fetchHomeStoriesFromDb failed", e);
        } catch (Throwable e2) {
            BLog.b("FeedDbMutationService", "Error performing reranking on cache feed", e2);
        }
    }

    private void m9106c() {
        ((VpvUpdateHandler) this.f5232g.get()).b(this.f5229d.m9174c());
    }

    private void m9107d() {
        if (((FeedUnitUpdateHandler) this.f5231f.get()).a() >= 200) {
            ((FeedUnitUpdateHandler) this.f5231f.get()).b(this.f5229d.m9179d());
        }
    }

    private boolean m9108e() {
        return Product.FB4A == this.f5235j.j && ((Boolean) this.f5233h.get()).booleanValue();
    }

    private boolean m9109f() {
        return Product.FB4A == this.f5235j.j && ((Boolean) this.f5234i.get()).booleanValue();
    }

    private boolean m9110g() {
        return this.f5239n.m2189a(653, false);
    }
}
