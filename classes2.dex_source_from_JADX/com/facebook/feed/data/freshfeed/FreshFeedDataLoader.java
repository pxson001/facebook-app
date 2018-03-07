package com.facebook.feed.data.freshfeed;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.api.feed.FetchFeedParams.FetchFeedCause;
import com.facebook.api.feed.data.FetchRequestState;
import com.facebook.api.feed.xconfig.FreshFeedConfig;
import com.facebook.api.feed.xconfig.FreshFeedConfigReader;
import com.facebook.api.feedcache.db.FeedDbMutationService;
import com.facebook.common.appstartup.AppStartupTracker;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.C0115xfdf5bd2;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.data.BaseFeedDataLoader;
import com.facebook.feed.data.freshfeed.FreshFeedBackgroundUIWorkHandler.UpdateImageCacheStateMessage;
import com.facebook.feed.data.freshfeed.FreshFeedFetcher.FetchParams;
import com.facebook.feed.loader.AutoRefreshScheduler;
import com.facebook.feed.loader.AutoRefreshScheduler.RefreshSchedulerCallback;
import com.facebook.feed.loader.AutoRefreshSchedulerProvider;
import com.facebook.feed.loader.FeedDataLoaderInitializationParams;
import com.facebook.feed.loader.FeedDataLoaderListener;
import com.facebook.feed.loader.HeadLoaderStatus;
import com.facebook.feed.loader.IFeedDataLoader;
import com.facebook.feed.loader.StoryRankingTimeTracker;
import com.facebook.feed.loader.StoryRankingTimeTracker.HitPreviouslyRankedStoriesListener;
import com.facebook.feed.loader.TailLoaderStatus;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger.FreshFeedEvent;
import com.facebook.feed.model.ClientFeedUnitEdge;
import com.facebook.feed.prefs.keys.FeedPrefKeys;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableScheduledFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

/* compiled from: sgny_cover_photo_width_param */
public class FreshFeedDataLoader extends BaseFeedDataLoader implements IFeedDataLoader, HitPreviouslyRankedStoriesListener {
    public static final String f5126A = FreshFeedDataLoader.class.getSimpleName();
    private static final CallerContext f5127B = CallerContext.m9061a(FreshFeedDataLoader.class, "native_newsfeed");
    public final Clock f5128C;
    public final NewsFeedEventLogger f5129D;
    private final AppStartupTracker f5130E;
    private final FreshFeedBackgroundUIWorkHandlerProvider f5131F;
    private final FreshFeedFetcherProvider f5132G;
    private final FreshFeedDataLoaderUIHandlerProvider f5133H;
    private FreshFeedDataLoaderUIHandler f5134I;
    private final FreshFeedConfigReader f5135J;
    private FreshFeedFetcher f5136K;
    private FeedDbMutationService f5137L;
    public final FreshFeedConfigReader f5138M;
    private final ListeningScheduledExecutorService f5139N;
    public final AtomicReference<ListenableScheduledFuture<?>> f5140O;
    public final AutoRefreshScheduler f5141P;
    public final QeAccessor f5142Q;
    private final FbSharedPreferences f5143R;
    private boolean f5144S = false;
    private long f5145T = 0;
    public StoryRankingTimeTracker f5146U;
    @VisibleForTesting
    protected final int f5147p = 1;
    @VisibleForTesting
    protected final int f5148q = 3;
    @VisibleForTesting
    protected FetchParams f5149r;
    protected HandlerThread f5150s;
    protected FreshFeedBackgroundUIWorkHandler f5151t;
    @VisibleForTesting
    protected HeadLoaderStatus f5152u;
    @VisibleForTesting
    protected TailLoaderStatus f5153v;
    @VisibleForTesting
    protected TailLoaderStatus f5154w;
    @VisibleForTesting
    protected boolean f5155x = false;
    @VisibleForTesting
    protected boolean f5156y = false;
    @VisibleForTesting
    protected boolean f5157z = false;

    /* compiled from: sgny_cover_photo_width_param */
    class AutoRefreshRefreshCallback implements RefreshSchedulerCallback {
        final /* synthetic */ FreshFeedDataLoader f5730a;

        public AutoRefreshRefreshCallback(FreshFeedDataLoader freshFeedDataLoader) {
            this.f5730a = freshFeedDataLoader;
        }

        public final void mo1396a() {
            FreshFeedDataLoader.m8982c(this.f5730a, FetchFeedCause.AUTO_REFRESH);
        }

        public final long mo1397b() {
            PerfTestConfig z = this.f5730a.m9028z();
            if (PerfTestConfigBase.m2938a()) {
                z = this.f5730a.m9028z();
                if (PerfTestConfigBase.f1510e != 0) {
                    z = this.f5730a.m9028z();
                    return PerfTestConfigBase.f1510e;
                }
            }
            return this.f5730a.f5142Q.mo575a(ExperimentsForNewsFeedAbTestModule.f5109j, 540000);
        }

        public final long mo1398c() {
            return TimeUnit.SECONDS.toMillis((long) this.f5730a.f5138M.m9087a(FreshFeedConfig.f5214p, 11, 0));
        }

        public final long mo1399d() {
            return TimeUnit.SECONDS.toMillis((long) this.f5730a.f5138M.m9087a(FreshFeedConfig.f5213o, 10, BaseFeedDataLoader.f5158k));
        }
    }

    /* compiled from: sgny_cover_photo_width_param */
    public class FreshFeedCollectionListener {
        public final /* synthetic */ FreshFeedDataLoader f5768a;

        public FreshFeedCollectionListener(FreshFeedDataLoader freshFeedDataLoader) {
            this.f5768a = freshFeedDataLoader;
        }
    }

    /* compiled from: sgny_cover_photo_width_param */
    public class C02711 {
        final /* synthetic */ FreshFeedDataLoader f5826a;

        C02711(FreshFeedDataLoader freshFeedDataLoader) {
            this.f5826a = freshFeedDataLoader;
        }

        public final void m9970a(ImmutableList<ClientFeedUnitEdge> immutableList) {
            FreshFeedDataLoader freshFeedDataLoader = this.f5826a;
            if (freshFeedDataLoader.f5146U != null) {
                int size = immutableList.size();
                int i = 0;
                long j = 0;
                while (i < size) {
                    long max;
                    ClientFeedUnitEdge clientFeedUnitEdge = (ClientFeedUnitEdge) immutableList.get(i);
                    if (clientFeedUnitEdge.mo2540c() instanceof GraphQLStory) {
                        max = Math.max(((GraphQLStory) clientFeedUnitEdge.mo2540c()).aZ(), j);
                    } else {
                        max = j;
                    }
                    i++;
                    j = max;
                }
                if (j > 0) {
                    freshFeedDataLoader.f5146U.m15519a(j);
                }
            }
        }

        public final void m9969a(int i) {
            m9968c(i);
        }

        public final void m9971b(int i) {
            m9968c(i);
        }

        private void m9968c(int i) {
            if (i == 7) {
                this.f5826a.f5141P.f5733c = this.f5826a.f5128C.mo211a();
                FreshFeedDataLoader.m8970J(this.f5826a);
            }
        }
    }

    /* compiled from: sgny_cover_photo_width_param */
    public class C05672 {
        final /* synthetic */ FreshFeedDataLoader f13825a;

        C05672(FreshFeedDataLoader freshFeedDataLoader) {
            this.f13825a = freshFeedDataLoader;
        }

        public final void m20229a(String str, String str2, int i) {
            FreshFeedBackgroundUIWorkHandler freshFeedBackgroundUIWorkHandler = this.f13825a.f5151t;
            freshFeedBackgroundUIWorkHandler.sendMessage(freshFeedBackgroundUIWorkHandler.obtainMessage(6, new UpdateImageCacheStateMessage(freshFeedBackgroundUIWorkHandler, str, str2, i)));
        }
    }

    public static FreshFeedDataLoader m8977b(InjectorLike injectorLike) {
        return new FreshFeedDataLoader((Context) injectorLike.getInstance(Context.class), (FreshFeedFetcherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FreshFeedFetcherProvider.class), NewsFeedEventLogger.m4405a(injectorLike), (FreshFeedDataLoaderUIHandlerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FreshFeedDataLoaderUIHandlerProvider.class), (FreshFeedBackgroundUIWorkHandlerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FreshFeedBackgroundUIWorkHandlerProvider.class), SystemClockMethodAutoProvider.m1498a(injectorLike), AppStartupTracker.m9073a(injectorLike), FreshFeedConfigReader.m9080a(injectorLike), FeedDbMutationService.m9091a(injectorLike), FreshFeedConfigReader.m9080a(injectorLike), C0115xfdf5bd2.m3569a(injectorLike), (AutoRefreshSchedulerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AutoRefreshSchedulerProvider.class), QeInternalImplMethodAutoProvider.m3744a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike));
    }

    @Inject
    public FreshFeedDataLoader(Context context, FreshFeedFetcherProvider freshFeedFetcherProvider, NewsFeedEventLogger newsFeedEventLogger, FreshFeedDataLoaderUIHandlerProvider freshFeedDataLoaderUIHandlerProvider, FreshFeedBackgroundUIWorkHandlerProvider freshFeedBackgroundUIWorkHandlerProvider, Clock clock, AppStartupTracker appStartupTracker, FreshFeedConfigReader freshFeedConfigReader, FeedDbMutationService feedDbMutationService, FreshFeedConfigReader freshFeedConfigReader2, ListeningScheduledExecutorService listeningScheduledExecutorService, AutoRefreshSchedulerProvider autoRefreshSchedulerProvider, QeAccessor qeAccessor, FbSharedPreferences fbSharedPreferences) {
        super(context);
        this.f5128C = clock;
        this.f5131F = freshFeedBackgroundUIWorkHandlerProvider;
        this.f5129D = newsFeedEventLogger;
        this.f5130E = appStartupTracker;
        this.f5132G = freshFeedFetcherProvider;
        this.f5133H = freshFeedDataLoaderUIHandlerProvider;
        this.f5135J = freshFeedConfigReader;
        this.f5152u = new HeadLoaderStatus(newsFeedEventLogger);
        this.f5153v = new TailLoaderStatus(newsFeedEventLogger);
        this.f5154w = new TailLoaderStatus(newsFeedEventLogger);
        this.f5137L = feedDbMutationService;
        this.f5138M = freshFeedConfigReader2;
        this.f5139N = listeningScheduledExecutorService;
        this.f5140O = new AtomicReference(null);
        this.f5141P = autoRefreshSchedulerProvider.m9625a(m8972L());
        this.f5143R = fbSharedPreferences;
        this.f5145T = this.f5143R.mo277a(FeedPrefKeys.f5741e, 0);
        this.f5141P.m9882c(this.f5145T);
        this.f5142Q = qeAccessor;
    }

    @VisibleForTesting
    private void m8965D() {
        if (this.f5136K == null) {
            this.f5134I = this.f5133H.m9071a(Looper.getMainLooper(), this.f5161b, this.f5152u, this.f5153v, this.f5171m, this.f5154w, new FreshFeedCollectionListener(this));
            this.f5134I.f5781m = new C02711(this);
            this.f5150s = new HandlerThread("freshfeed_background_ui_work", -2);
            this.f5150s.start();
            this.f5151t = this.f5131F.m9072a(this.f5150s.getLooper(), this.f5134I, this.f5153v, this.f5172n, this.f5173o);
            this.f5136K = this.f5132G.m9070a(this.f5134I, this.f5151t);
            this.f5151t.f5839m = this.f5136K;
        }
    }

    protected final CallerContext mo1310v() {
        return f5127B;
    }

    protected final void mo1311w() {
        this.f5141P.m9879a();
        m8980b(true);
    }

    private boolean m8966E() {
        TracerDetour.a("FreshFeedDataLoader.doInitialize", -1024569039);
        try {
            if (this.f5166g.m9852a() || this.f5166g.m9855g()) {
                TracerDetour.a(-663674803);
                return false;
            }
            this.f5166g.m9853b();
            m8965D();
            m8967F();
            if (!this.f5157z) {
                m8982c(this, FetchFeedCause.INITIALIZATION);
                this.f5157z = true;
            }
            m8968G();
            TracerDetour.a(-1644553627);
            return true;
        } catch (Throwable th) {
            TracerDetour.a(-1963280892);
        }
    }

    private void m8967F() {
        this.f5137L.f5243r = new C05672(this);
    }

    public final boolean mo1294a(FeedDataLoaderInitializationParams feedDataLoaderInitializationParams) {
        return m8966E();
    }

    public final boolean mo1302h() {
        if (this.f5153v.m9869c()) {
            return false;
        }
        m8965D();
        this.f5129D.m4414a(f5126A, "WarmStart");
        this.f5161b.m9696m();
        this.f5151t.m9987c();
        m8973a(3);
        this.f5136K.m10069b();
        return true;
    }

    public final void mo1304k() {
        TracerDetour.a("FreshFeedDataLoader.onUserLeftApp", -1088694147);
        try {
            m8980b(false);
        } finally {
            TracerDetour.a(188138499);
        }
    }

    private void m8980b(boolean z) {
        if (this.f5134I != null) {
            this.f5134I.mo1402a();
        }
        if (this.f5136K != null) {
            FreshFeedFetcher freshFeedFetcher = this.f5136K;
            if (freshFeedFetcher.f5947f != null) {
                freshFeedFetcher.f5947f.mo1402a();
            }
            if (freshFeedFetcher.f5948g != null) {
                freshFeedFetcher.f5948g.mo1402a();
            }
            Object obj = null;
            if (VERSION.SDK_INT >= 18) {
                obj = 1;
            }
            if (freshFeedFetcher.f5945d != null) {
                if (obj != null) {
                    freshFeedFetcher.f5945d.quitSafely();
                } else {
                    freshFeedFetcher.f5945d.quit();
                }
                freshFeedFetcher.f5945d = null;
            }
            if (freshFeedFetcher.f5946e != null) {
                if (obj != null) {
                    freshFeedFetcher.f5946e.quitSafely();
                } else {
                    freshFeedFetcher.f5946e.quit();
                }
                freshFeedFetcher.f5946e = null;
            }
        }
        if (this.f5151t != null) {
            this.f5151t.mo1402a();
        }
        if (z) {
            this.f5134I = null;
            this.f5136K = null;
            this.f5151t = null;
            if (this.f5150s != null) {
                this.f5150s.quit();
                this.f5150s = null;
            }
        }
    }

    private void m8978b(FetchFeedCause fetchFeedCause) {
        TracerDetour.a("FreshFeedDataLoader.loadNewDataFromNetwork", -1233465559);
        try {
            if (!this.f5153v.m9869c()) {
                this.f5149r = new FetchParams(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, mo1318l(), this.f5173o.m9888b(), "fresh_feed_new_data_fetch", this.f5128C.mo211a(), null, fetchFeedCause);
                this.f5153v.m9868b();
                this.f5129D.m4412a(f5126A, FreshFeedEvent.LOAD_NEW_DATA_FROM_NETWORK);
                this.f5136K.m10068a(this.f5149r);
                TracerDetour.a(-1880297963);
            }
        } finally {
            TracerDetour.a(309543900);
        }
    }

    private void m8968G() {
        TracerDetour.a("FreshFeedDataLoader.loadDataFromCache", -827385010);
        try {
            this.f5152u.m9860c();
            this.f5129D.m4412a(f5126A, FreshFeedEvent.LOAD_DATA_FROM_CACHE);
            this.f5136K.m10067a();
        } finally {
            TracerDetour.a(258399863);
        }
    }

    public final FetchRequestState mo1290a(DataFreshnessParam dataFreshnessParam, FetchFeedCause fetchFeedCause, boolean z) {
        FetchRequestState fetchRequestState;
        TracerDetour.a("FreshFeedDataLoader.loadAfterData", -1596722952);
        try {
            if (this.f5162c.m9789c()) {
                this.f5129D.m4412a(f5126A, FreshFeedEvent.END_OF_FEED);
                fetchRequestState = FetchRequestState.END_OF_FEED;
                TracerDetour.a(-1430402309);
            } else if (!this.f5166g.m9852a() || this.f5154w.m9869c()) {
                fetchRequestState = FetchRequestState.ALREADY_SCHEDULED;
                TracerDetour.a(1328186003);
            } else {
                m8974a(this.f5138M.m9086f(1), 1);
                m8969I();
                try {
                    fetchRequestState = FetchRequestState.SUCCESS;
                } finally {
                    TracerDetour.a(-2091085554);
                }
            }
        } catch (Throwable e) {
            BLog.c("FreshFeed", "Error in loadAfterData.", e);
        }
        return fetchRequestState;
    }

    public final void mo1296b(DataFreshnessParam dataFreshnessParam, FetchFeedCause fetchFeedCause, boolean z) {
    }

    public final boolean mo1305o() {
        return this.f5152u.m9862e();
    }

    public final boolean mo1306p() {
        return this.f5152u.m9862e() || this.f5153v.m9869c();
    }

    public final void mo1307r() {
        this.f5162c.m9790d();
    }

    public final void mo1309t() {
        TracerDetour.a("FreshFeedDataLoader.unStageStories", -410735134);
        try {
            if (!this.f5166g.m9852a() || this.f5166g.m9855g()) {
                TracerDetour.a(1151498338);
                return;
            }
            m8965D();
            this.f5129D.m4414a(f5126A, "unStageStories");
            this.f5155x = true;
            this.f5151t.m9988d();
            TracerDetour.a(-917152178);
        } catch (Throwable th) {
            TracerDetour.a(725343942);
        }
    }

    private void m8974a(int i, int i2) {
        TracerDetour.a("FreshFeedDataLoader.getStoriesForFeed", 1100170355);
        try {
            if (!this.f5154w.m9869c()) {
                this.f5129D.m4413a(f5126A, FreshFeedEvent.STORIES_FOR_FEED, String.valueOf(i));
                this.f5151t.m9982a(i, i2);
                this.f5154w.m9868b();
                TracerDetour.a(-355192291);
            }
        } finally {
            TracerDetour.a(-825290065);
        }
    }

    public final boolean mo1293a(FetchFeedCause fetchFeedCause) {
        if (fetchFeedCause.isFreshFeedNewStoriesEligible()) {
            m8982c(this, fetchFeedCause);
        } else {
            m8969I();
        }
        return this.f5153v.m9869c();
    }

    public static void m8982c(FreshFeedDataLoader freshFeedDataLoader, FetchFeedCause fetchFeedCause) {
        TracerDetour.a("FreshFeedDataLoader.startNewSession", -23512988);
        try {
            freshFeedDataLoader.f5156y = true;
            freshFeedDataLoader.f5155x = fetchFeedCause.isFreshFeedNewStoriesEligible();
            freshFeedDataLoader.f5129D.m4413a(f5126A, FreshFeedEvent.START_NEW_SESSION, fetchFeedCause.name());
            if (fetchFeedCause != FetchFeedCause.RERANK) {
                freshFeedDataLoader.m8978b(fetchFeedCause);
            }
            if (freshFeedDataLoader.f5155x) {
                freshFeedDataLoader.m8983d(fetchFeedCause);
            }
            TracerDetour.a(-1797637433);
        } catch (Throwable th) {
            TracerDetour.a(-1398746450);
        }
    }

    private void m8983d(FetchFeedCause fetchFeedCause) {
        long j;
        if (fetchFeedCause == FetchFeedCause.RERANK) {
            j = 0;
        } else {
            j = (long) this.f5138M.m9087a(FreshFeedConfig.f5207i, 4, 5);
        }
        this.f5129D.m4414a(f5126A, "Scheduling reranking");
        this.f5140O.set(this.f5139N.mo310a(new 3(this), j, TimeUnit.SECONDS));
    }

    private void m8969I() {
        TracerDetour.a("FreshFeedDataLoader.fetchFreshStoriesIfNeeded", -1741711280);
        try {
            this.f5151t.m9985b();
        } finally {
            TracerDetour.a(-661836195);
        }
    }

    public final void mo1295b() {
        TracerDetour.a("FreshFeedDataLoader.onFragmentDetached", 1765445540);
        try {
            super.mo1295b();
        } finally {
            TracerDetour.a(1732188018);
        }
    }

    public final boolean mo1298d() {
        TracerDetour.a("FreshFeedDataLoader.mayStartFeedAutoRefreshNow", -644320377);
        try {
            m8965D();
            if (!m8970J(this)) {
                m8969I();
            }
            boolean c = this.f5153v.m9869c();
            return c;
        } finally {
            TracerDetour.a(296974383);
        }
    }

    public static boolean m8970J(FreshFeedDataLoader freshFeedDataLoader) {
        boolean z = false;
        if (freshFeedDataLoader.f5138M.m9083b(false) && freshFeedDataLoader.m9027y()) {
            z = true;
        }
        if (!z) {
            return false;
        }
        if (freshFeedDataLoader.f5146U == null || freshFeedDataLoader.f5146U.m15524d() || !freshFeedDataLoader.f5146U.m15523c()) {
            return freshFeedDataLoader.f5141P.m9881b(freshFeedDataLoader.f5128C.mo211a());
        }
        return freshFeedDataLoader.f5141P.m9880a(freshFeedDataLoader.f5128C.mo211a(), freshFeedDataLoader.f5146U.m15522b());
    }

    public final boolean mo1299e() {
        return mo1298d();
    }

    public final void mo1300f() {
        TracerDetour.a("FreshFeedDataLoader.forceRefresh", 1519757466);
        try {
            m8982c(this, FetchFeedCause.AUTO_REFRESH);
        } finally {
            TracerDetour.a(1060357126);
        }
    }

    public final boolean mo1301g() {
        TracerDetour.a("FreshFeedDataLoader.doEagerInit", 213756550);
        try {
            if (this.f5157z) {
                return false;
            }
            m8965D();
            m8982c(this, FetchFeedCause.INITIALIZATION);
            this.f5157z = true;
            TracerDetour.a(289711532);
            return true;
        } finally {
            TracerDetour.a(414394272);
        }
    }

    public final void mo1291a(FeedDataLoaderListener feedDataLoaderListener) {
        TracerDetour.a("FreshFeedDataLoader.setFragmentLoaderListener", 432957416);
        try {
            super.mo1291a(feedDataLoaderListener);
            m8965D();
            if (this.f5134I != null) {
                this.f5134I.m9904a(feedDataLoaderListener);
            }
            if (mo1320n()) {
                m8973a(1);
            }
            TracerDetour.a(-2029547272);
        } catch (Throwable th) {
            TracerDetour.a(-699381436);
        }
    }

    public final void mo1297b(FeedDataLoaderListener feedDataLoaderListener) {
        super.mo1297b(feedDataLoaderListener);
        if (this.f5134I != null) {
            this.f5134I.f5777h = this.f5171m;
        }
    }

    public final int mo1308s() {
        return m8971K();
    }

    public final void mo1292a(StoryRankingTimeTracker storyRankingTimeTracker) {
        if (this.f5138M.m9084c(false)) {
            this.f5146U = storyRankingTimeTracker;
        }
    }

    private void m8973a(int i) {
        TracerDetour.a("FreshFeedDataLoader.addInitialStoriesToFeedUnitCollection", 1017564984);
        try {
            this.f5129D.m4413a(f5126A, FreshFeedEvent.INITIALIZED, "resultType: " + i);
            m8974a(m8971K(), i);
        } finally {
            TracerDetour.a(1951292149);
        }
    }

    private int m8971K() {
        return this.f5138M.m9087a(FreshFeedConfig.f5211m, 8, 3);
    }

    public final void iv_() {
        mo1298d();
    }

    public static void m8979b(FreshFeedDataLoader freshFeedDataLoader, int i) {
        boolean z = false;
        TracerDetour.a("FreshFeedCollectionListener.onStoriesAdded", -1167273532);
        try {
            boolean z2;
            freshFeedDataLoader.m8981c(i);
            if (freshFeedDataLoader.f5155x && (i == 0 || i == 5)) {
                freshFeedDataLoader.f5134I.m9908c();
                freshFeedDataLoader.f5155x = false;
                freshFeedDataLoader.f5156y = false;
                freshFeedDataLoader.f5151t.m9987c();
                freshFeedDataLoader.f5136K.m10069b();
                z2 = true;
            } else {
                if (freshFeedDataLoader.f5156y && i == 0) {
                    freshFeedDataLoader.f5156y = false;
                    freshFeedDataLoader.f5151t.m9987c();
                }
                z2 = false;
            }
            if (z2 || freshFeedDataLoader.f5161b.mo1374a() < freshFeedDataLoader.m8971K() || (!freshFeedDataLoader.mo1320n() && i == 0)) {
                freshFeedDataLoader.m8973a(i);
                z = true;
            }
            if (!freshFeedDataLoader.f5166g.m9852a()) {
                freshFeedDataLoader.f5166g.m9854f();
                freshFeedDataLoader.f5129D.m4414a(f5126A, "Initialization Status Finished");
            }
            freshFeedDataLoader.m8975a(i, z);
            freshFeedDataLoader.m9026x();
            if (i == 0) {
                freshFeedDataLoader.f5141P.m9882c(freshFeedDataLoader.f5128C.mo211a());
                freshFeedDataLoader.m8976a(freshFeedDataLoader.f5128C.mo211a());
                m8970J(freshFeedDataLoader);
            }
            TracerDetour.a(1647428316);
        } catch (Throwable th) {
            TracerDetour.a(1292247446);
        }
    }

    private void m8976a(long j) {
        this.f5143R.edit().mo1275a(FeedPrefKeys.f5741e, j).commit();
    }

    private void m8975a(int i, boolean z) {
        if (z) {
            boolean z2;
            AppStartupTracker appStartupTracker = this.f5130E;
            if (i == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            appStartupTracker.f5186a.m3353a(z2);
        }
        if (!this.f5144S) {
            this.f5144S = true;
            switch (i) {
                case 0:
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                case 6:
                    this.f5130E.f5186a.m3371k();
                    break;
                default:
                    this.f5130E.f5186a.m3372l();
                    break;
            }
        }
        if (i == 5) {
            this.f5130E.m9077a(true);
        }
    }

    private void m8981c(int i) {
        if (i == 0 || i == 6 || i == 5) {
            ListenableScheduledFuture listenableScheduledFuture = (ListenableScheduledFuture) this.f5140O.getAndSet(null);
            if (listenableScheduledFuture != null) {
                listenableScheduledFuture.cancel(true);
                this.f5129D.m4414a(f5126A, "cancelScheduledRerank");
            }
        }
    }

    @VisibleForTesting
    private AutoRefreshRefreshCallback m8972L() {
        return new AutoRefreshRefreshCallback(this);
    }
}
