package com.facebook.feed.logging;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.SimpleArrayMap;
import com.facebook.api.feed.data.FeedUnitData;
import com.facebook.api.feed.data.FeedUnitDataController;
import com.facebook.api.feedcache.db.FeedDbMutationService;
import com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbStorySeenRequest;
import com.facebook.browser.prefetch.BrowserPrefetcher;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.common.viewport.qe.ExperimentsForViewportTestModule;
import com.facebook.debug.log.BLog;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder.ViewportWaterfallStage;
import com.facebook.feed.logging.viewport.FeedLoggingHandler;
import com.facebook.feed.logging.viewport.GroupMallVpvs;
import com.facebook.feed.logging.viewport.RecentVpvs;
import com.facebook.feed.photos.FeedUnitImagesStateMapper;
import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.unit.FeedUnitHelper;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.DedupableUtil;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.FeedTrackableUtil;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.graphql.model.StorySetHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.json.JSONObject;

@Singleton
/* compiled from: preferences */
public class ViewportLoggingHandler implements Callback, FeedLoggingHandler {
    private static volatile ViewportLoggingHandler f9279x;
    @VisibleForTesting
    public Handler f9280a = new Handler(Looper.getMainLooper(), this);
    private final Clock f9281b;
    private final FeedDbMutationService f9282c;
    private final RecentVpvs f9283d;
    private final FeedUnitImpressionLoggerController f9284e;
    private final FeedStoryRefresherLogger f9285f;
    private final Lazy<BrowserPrefetchVpvLoggingHandler> f9286g;
    private final Lazy<FeedbackPrefetchVpvLoggingHandler> f9287h;
    private final Provider<Boolean> f9288i;
    private final Provider<Boolean> f9289j;
    private final FeedUnitImagesStateMapper f9290k;
    private final FeedLoggingUtil f9291l;
    public final QeAccessor f9292m;
    private final GatekeeperStoreImpl f9293n;
    private final FeedUnitDataController f9294o;
    private final GroupMallVpvs f9295p;
    private boolean f9296q;
    private boolean f9297r;
    private boolean f9298s;
    private boolean f9299t;
    private String f9300u = "unknown";
    private ImmutableMap<String, String> f9301v;
    private long f9302w = 1000;

    public static com.facebook.feed.logging.ViewportLoggingHandler m14224a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9279x;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.logging.ViewportLoggingHandler.class;
        monitor-enter(r1);
        r0 = f9279x;	 Catch:{ all -> 0x003a }
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
        r0 = m14240b(r0);	 Catch:{ all -> 0x0035 }
        f9279x = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9279x;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.logging.ViewportLoggingHandler.a(com.facebook.inject.InjectorLike):com.facebook.feed.logging.ViewportLoggingHandler");
    }

    private static ViewportLoggingHandler m14240b(InjectorLike injectorLike) {
        return new ViewportLoggingHandler(GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), FeedDbMutationService.m9091a(injectorLike), RecentVpvs.m9803a(injectorLike), FeedUnitImpressionLoggerController.m14182a(injectorLike), FeedStoryRefresherLogger.m14261a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1422), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1431), IdBasedProvider.m1811a(injectorLike, 3974), IdBasedProvider.m1811a(injectorLike, 3978), FeedUnitImagesStateMapper.m14210a(injectorLike), FeedUnitDataController.m14175a(injectorLike), FeedLoggingUtil.m14266a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), GroupMallVpvs.m14274a(injectorLike));
    }

    private static FeedProps<? extends FeedUnit> m14225a(FeedProps<? extends FeedUnit> feedProps) {
        FeedUnit feedUnit = (FeedUnit) feedProps.f13444a;
        if (feedUnit instanceof GraphQLStorySet) {
            return feedProps.m19803a(StorySetHelper.a((GraphQLStorySet) feedUnit));
        }
        if (!(feedUnit instanceof GraphQLStory)) {
            return feedProps;
        }
        GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
        ImmutableList j = StoryHierarchyHelper.m27434a(graphQLStory).m22608j();
        int size = j.size();
        if (size <= 1) {
            return feedProps;
        }
        int ac_ = graphQLStory.ac_();
        return size > ac_ ? feedProps.m19803a((Flattenable) j.get(ac_)) : feedProps;
    }

    @Inject
    public ViewportLoggingHandler(GatekeeperStore gatekeeperStore, Clock clock, FeedDbMutationService feedDbMutationService, RecentVpvs recentVpvs, FeedUnitImpressionLoggerController feedUnitImpressionLoggerController, FeedStoryRefresherLogger feedStoryRefresherLogger, Lazy<BrowserPrefetchVpvLoggingHandler> lazy, Lazy<FeedbackPrefetchVpvLoggingHandler> lazy2, Provider<Boolean> provider, Provider<Boolean> provider2, FeedUnitImagesStateMapper feedUnitImagesStateMapper, FeedUnitDataController feedUnitDataController, FeedLoggingUtil feedLoggingUtil, QeAccessor qeAccessor, GroupMallVpvs groupMallVpvs) {
        this.f9293n = gatekeeperStore;
        this.f9281b = clock;
        this.f9283d = recentVpvs;
        this.f9282c = feedDbMutationService;
        this.f9284e = feedUnitImpressionLoggerController;
        this.f9285f = feedStoryRefresherLogger;
        this.f9286g = lazy;
        this.f9287h = lazy2;
        this.f9288i = provider;
        this.f9289j = provider2;
        this.f9290k = feedUnitImagesStateMapper;
        this.f9291l = feedLoggingUtil;
        this.f9292m = qeAccessor;
        this.f9294o = feedUnitDataController;
        this.f9295p = groupMallVpvs;
        m14249a();
    }

    public final void m14249a() {
        boolean z;
        this.f9296q = ((Boolean) this.f9288i.get()).booleanValue();
        this.f9297r = ((Boolean) this.f9289j.get()).booleanValue();
        BrowserPrefetcher browserPrefetcher = (BrowserPrefetcher) ((BrowserPrefetchVpvLoggingHandler) this.f9286g.get()).f9312a.get();
        if (!browserPrefetcher.m14298a() || browserPrefetcher.m14302c() == 0) {
            z = false;
        } else {
            z = true;
        }
        this.f9298s = z;
        this.f9299t = ((FeedbackPrefetchVpvLoggingHandler) this.f9287h.get()).f9386c.mo596a(ExperimentsForNewsFeedAbTestModule.f5117r, false);
    }

    public final boolean mo1919a(Object obj) {
        return false;
    }

    public final void mo1921b(Object obj) {
        m14247e(obj);
    }

    public final void mo1922c(Object obj) {
        m14232a(FeedUnitHelper.m21142b(obj), FeedUnitHelper.m21141a(obj), false);
        m14248f(obj);
    }

    public final boolean mo1923d(Object obj) {
        return true;
    }

    public final void mo1916a(ScrollingViewProxy scrollingViewProxy, Object obj, int i) {
        HasMultiRow b = FeedLoggingUtil.m14271b(scrollingViewProxy);
        if (b != null && b.mo2512e() != 0 && scrollingViewProxy.mo2343C() && FeedUnitHelper.m21141a(obj) != null) {
            m14234a(obj, this.f9291l.m14273a(b, scrollingViewProxy, scrollingViewProxy.mo2386f(i)));
        }
    }

    public final void mo1913a(SimpleArrayMap<Object, Object> simpleArrayMap) {
        int size = simpleArrayMap.size();
        for (int i = 0; i < size; i++) {
            Object b = simpleArrayMap.b(i);
            FeedUnit a = FeedUnitHelper.m21141a(b);
            GraphQLFeedUnitEdge b2 = FeedUnitHelper.m21142b(b);
            if (a != null) {
                FeedProps a2 = m14225a(FeedProps.m19802c(a));
                FeedUnitData a3 = this.f9294o.m14177a((FeedUnit) a2.m19804a());
                String a4 = m14226a(b2);
                m14227a(a2, a3, a, a4, false);
                m14227a(a2, a3, a, a4, true);
                if (a instanceof GraphQLStorySet) {
                    m14233a((GraphQLStorySet) a, false);
                    m14233a((GraphQLStorySet) a, true);
                }
            }
        }
    }

    public final void mo1915a(ScrollingViewProxy scrollingViewProxy, int i, int i2) {
    }

    public final void mo1918a(String str) {
        this.f9300u = str;
    }

    public final void mo1917a(ImmutableMap<String, String> immutableMap) {
        this.f9301v = immutableMap;
    }

    public final void mo1914a(ScrollableItemListFeedUnit scrollableItemListFeedUnit, int i) {
        GraphQLFeedUnitEdge b = FeedUnitHelper.m21142b(scrollableItemListFeedUnit);
        m14235a((Object) scrollableItemListFeedUnit, false, true);
        m14232a(b, (FeedUnit) scrollableItemListFeedUnit, true);
    }

    public final void mo1920b(ScrollableItemListFeedUnit scrollableItemListFeedUnit, int i) {
        m14248f(scrollableItemListFeedUnit);
        m14247e(scrollableItemListFeedUnit);
        m14235a((Object) scrollableItemListFeedUnit, true, true);
    }

    private void m14247e(Object obj) {
        FeedUnit a = FeedUnitHelper.m21141a(obj);
        if (a != null) {
            m14231a(a, ViewportWaterfallStage.AFTER_ENTER_VIEWPORT);
            FeedUnitData a2 = this.f9294o.m14177a(a);
            a2.f19499f = true;
            a2.f19494a = this.f9281b.mo211a();
            this.f9284e.m14197a(a);
            long j = this.f9302w;
            this.f9280a.sendMessageDelayed(this.f9280a.obtainMessage(1, obj), j);
        }
    }

    private void m14232a(@Nullable GraphQLFeedUnitEdge graphQLFeedUnitEdge, @Nullable FeedUnit feedUnit, boolean z) {
        if (feedUnit != null) {
            FeedUnitData a = this.f9294o.m14177a(feedUnit);
            a.f19499f = false;
            FeedProps c = FeedProps.m19802c(feedUnit);
            FeedProps a2 = m14225a(c);
            m14227a(a2, m14223a((FeedUnit) a2.f13444a, feedUnit, a), feedUnit, m14226a(graphQLFeedUnitEdge), false);
            if (!z && (feedUnit instanceof GraphQLStorySet)) {
                m14233a((GraphQLStorySet) feedUnit, false);
            }
            if (a.f19494a > 0) {
                m14231a(feedUnit, ViewportWaterfallStage.BEFORE_EXIT_VIEWPORT);
                m14230a(c, graphQLFeedUnitEdge, a);
            }
        }
    }

    private void m14236a(String str, boolean z) {
        if (z == this.f9292m.mo596a(ExperimentsForViewportTestModule.e, true)) {
            RecentVpvs recentVpvs = this.f9283d;
            if (!StringUtil.m3589a((CharSequence) str)) {
                recentVpvs.f5684b.m9842a((Object) str, (Object) str);
            }
        }
    }

    private boolean m14238a(FeedUnit feedUnit) {
        return m14239a(feedUnit, this.f9300u) || !this.f9292m.mo596a(ExperimentsForViewportTestModule.d, true);
    }

    private boolean m14246c(String str) {
        return "group_feed".equals(str) && this.f9292m.mo596a(ExperimentsForViewportTestModule.c, false);
    }

    private void m14231a(FeedUnit feedUnit, ViewportWaterfallStage viewportWaterfallStage) {
        if (m14239a(feedUnit, this.f9300u)) {
            this.f9284e.m14203a(FeedTrackableUtil.m27148a(feedUnit), viewportWaterfallStage);
        }
    }

    private void m14228a(FeedProps<? extends FeedUnit> feedProps, FeedUnit feedUnit, long j) {
        if (this.f9300u != "native_timeline" || this.f9293n.m2189a(768, false)) {
            this.f9284e.m14195a((FeedProps) feedProps, feedUnit, j, this.f9300u, this.f9301v);
        }
    }

    private void m14230a(FeedProps<? extends FeedUnit> feedProps, @Nullable FeedEdge feedEdge, FeedUnitData feedUnitData) {
        if (feedProps != null) {
            String str = this.f9300u;
            boolean z = false;
            boolean z2 = true;
            switch (str.hashCode()) {
                case -1618203101:
                    if (str.equals("video_home")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -947791335:
                    if (str.equals("native_newsfeed")) {
                        z2 = false;
                        break;
                    }
                    break;
            }
            switch (z2) {
                case false:
                    z = this.f9292m.mo596a(ExperimentsForViewportTestModule.f, false);
                    break;
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    break;
                default:
                    z = true;
                    break;
            }
            if (z) {
                FeedUnit feedUnit = (FeedUnit) feedProps.m19804a();
                String a = m14226a((GraphQLFeedUnitEdge) feedEdge);
                long a2 = feedUnitData.m27194a();
                long a3 = this.f9281b.mo211a();
                a2 = a3 - a2;
                m14231a(feedUnit, ViewportWaterfallStage.BEFORE_TIME_THRESHOLD);
                if (a2 >= this.f9302w) {
                    this.f9285f.m14263a(feedUnit.T_());
                    if (m14238a(feedUnit)) {
                        m14236a(a, false);
                    }
                    if (m14246c(this.f9300u)) {
                        m14242b(feedUnit);
                    }
                    m14231a(feedUnit, ViewportWaterfallStage.BEFORE_DEDUP);
                    if (this.f9296q || !feedUnitData.m27200d()) {
                        this.f9284e.m14196a(feedProps, this.f9300u, this.f9301v);
                        feedUnitData.f19497d = true;
                        feedUnitData.m27198c(a3);
                    }
                }
            }
        }
    }

    private void m14242b(FeedUnit feedUnit) {
        if (feedUnit instanceof GraphQLStory) {
            String str;
            try {
                str = (String) new JSONObject(((GraphQLStory) feedUnit).mo2877k()).get("mf_story_key");
            } catch (Throwable e) {
                BLog.b(ViewportLoggingHandler.class.getName(), e, "Unable to parse story key for group story from tracking data: %s", new Object[]{r2});
                str = null;
            }
            if (!Strings.isNullOrEmpty(str)) {
                this.f9295p.m14277a(str, str);
            }
        }
    }

    private void m14245c(FeedUnit feedUnit) {
        if (this.f9297r && feedUnit != null && feedUnit.mo2507g() != null) {
            this.f9282c.m9112a(new FeedDbStorySeenRequest(feedUnit, this.f9290k.m14214a(feedUnit.mo2507g())));
        }
    }

    @VisibleForTesting
    private void m14234a(Object obj, boolean z) {
        m14235a(obj, z, false);
    }

    private void m14235a(Object obj, boolean z, boolean z2) {
        Object a = FeedUnitHelper.m21141a(obj);
        if (a != null) {
            FeedProps a2 = m14225a(FeedProps.m19802c(a));
            m14227a(a2, this.f9294o.m14177a((FeedUnit) a2.f13444a), a, m14226a(FeedUnitHelper.m21142b(obj)), z);
            if (!z2 && (a instanceof GraphQLStorySet)) {
                m14233a((GraphQLStorySet) a, z);
            }
        }
    }

    private void m14233a(GraphQLStorySet graphQLStorySet, boolean z) {
        if (this.f9293n.m2189a(778, false)) {
            FeedUnitData a = this.f9294o.m14178a(graphQLStorySet);
            if (!a.f19500g && z) {
                a.f19495b = this.f9281b.mo211a();
            } else if (a.f19500g && !z) {
                long a2 = this.f9281b.mo211a() - a.f19495b;
                if (a2 >= 100) {
                    this.f9284e.m14200a(graphQLStorySet, a2, this.f9300u, this.f9301v);
                }
            }
            a.f19500g = z;
        }
    }

    @VisibleForTesting
    private void m14227a(FeedProps<? extends FeedUnit> feedProps, FeedUnitData feedUnitData, FeedUnit feedUnit, String str, boolean z) {
        TracerDetour.a("ViewportLoggingHandler.setUserViewing", -1247379507);
        if (z) {
            try {
                if (!feedUnitData.m27199c()) {
                    m14229a((FeedProps) feedProps, feedUnit, str);
                    feedUnitData.m27196a(z);
                    TracerDetour.a(1391281407);
                }
            } catch (Throwable th) {
                TracerDetour.a(1342911556);
            }
        }
        if (!z && feedUnitData.m27199c()) {
            m14241b(feedProps, feedUnit, str);
        }
        feedUnitData.m27196a(z);
        TracerDetour.a(1391281407);
    }

    private FeedUnitData m14223a(FeedUnit feedUnit, FeedUnit feedUnit2, @Nullable FeedUnitData feedUnitData) {
        return (feedUnitData == null || feedUnit2 != feedUnit) ? this.f9294o.m14177a(feedUnit) : feedUnitData;
    }

    private void m14229a(FeedProps<? extends FeedUnit> feedProps, FeedUnit feedUnit, String str) {
        FeedUnit feedUnit2 = (FeedUnit) feedProps.f13444a;
        this.f9294o.m14177a(feedUnit2).f19495b = this.f9281b.mo211a();
        if (this.f9299t && (feedUnit2 instanceof GraphQLStory)) {
            ((FeedbackPrefetchVpvLoggingHandler) this.f9287h.get()).m14338a((GraphQLStory) feedUnit2);
        }
        if (this.f9298s && (feedUnit2 instanceof GraphQLStory)) {
            ((BrowserPrefetchVpvLoggingHandler) this.f9286g.get()).m14281a((FeedProps) feedProps);
        }
        if (this.f9292m.mo596a(ExperimentsForNewsFeedAbTestModule.al, false) && m14238a(feedUnit2) && str != null) {
            this.f9280a.sendMessageDelayed(this.f9280a.obtainMessage(2, str), 250);
        }
        if (this.f9292m.mo596a(ExperimentsForNewsFeedAbTestModule.am, false)) {
            this.f9280a.sendMessageDelayed(this.f9280a.obtainMessage(3, feedUnit), 250);
        }
    }

    private void m14241b(FeedProps<? extends FeedUnit> feedProps, FeedUnit feedUnit, String str) {
        FeedUnit feedUnit2;
        if (feedProps != null) {
            feedUnit2 = (FeedUnit) feedProps.f13444a;
        } else {
            feedUnit2 = null;
        }
        m14244c(feedProps, feedUnit, str);
        if (this.f9298s && (feedUnit2 instanceof GraphQLStory)) {
            BrowserPrefetchVpvLoggingHandler browserPrefetchVpvLoggingHandler = (BrowserPrefetchVpvLoggingHandler) this.f9286g.get();
            String g = ((GraphQLStory) feedUnit2).mo2507g();
            Runnable runnable = (Runnable) browserPrefetchVpvLoggingHandler.f9313b.get(g);
            if (runnable != null) {
                browserPrefetchVpvLoggingHandler.f9313b.remove(g);
                HandlerDetour.a(((BrowserPrefetcher) browserPrefetchVpvLoggingHandler.f9312a.get()).f9324j, runnable);
            }
        }
        if (this.f9299t && (feedUnit2 instanceof GraphQLStory)) {
            FeedbackPrefetchVpvLoggingHandler feedbackPrefetchVpvLoggingHandler = (FeedbackPrefetchVpvLoggingHandler) this.f9287h.get();
            HandlerDetour.a(feedbackPrefetchVpvLoggingHandler.f9387d, (Runnable) feedbackPrefetchVpvLoggingHandler.f9389f.remove(((GraphQLStory) feedUnit2).mo2507g()));
        }
        if (this.f9292m.mo596a(ExperimentsForNewsFeedAbTestModule.al, false) && str != null) {
            this.f9280a.removeMessages(2, str);
        }
        if (this.f9292m.mo596a(ExperimentsForNewsFeedAbTestModule.am, false)) {
            this.f9280a.removeMessages(3, feedUnit);
        }
    }

    private void m14244c(FeedProps<? extends FeedUnit> feedProps, FeedUnit feedUnit, String str) {
        FeedUnit feedUnit2;
        TracerDetour.a("ViewportLoggingHandler.logFeedUnitDuration", 1218196897);
        if (feedProps != null) {
            try {
                feedUnit2 = (FeedUnit) feedProps.m19804a();
            } catch (Throwable th) {
                TracerDetour.a(-81993850);
            }
        } else {
            feedUnit2 = null;
        }
        long a = this.f9281b.mo211a() - this.f9294o.m14177a(feedUnit2).m27197b();
        if (a >= 100) {
            m14228a((FeedProps) feedProps, feedUnit, a);
        }
        if (a >= 250 && m14238a(feedUnit2)) {
            m14236a(str, true);
        }
        if (!this.f9292m.mo596a(ExperimentsForNewsFeedAbTestModule.am, false) && a >= 250) {
            m14245c(feedUnit);
        }
        TracerDetour.a(-2058562333);
    }

    @Nullable
    private static String m14226a(@Nullable GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
        return graphQLFeedUnitEdge == null ? null : DedupableUtil.m23084a(graphQLFeedUnitEdge);
    }

    private static boolean m14239a(@Nullable FeedUnit feedUnit, String str) {
        return feedUnit != null && str == "native_newsfeed";
    }

    public boolean handleMessage(Message message) {
        if (message.what == 2) {
            return m14237a(message);
        }
        if (message.what == 3) {
            return m14243b(message);
        }
        Object obj = message.obj;
        FeedUnit a = FeedUnitHelper.m21141a(obj);
        GraphQLFeedUnitEdge b = FeedUnitHelper.m21142b(obj);
        FeedUnitData a2 = this.f9294o.m14177a(a);
        if (a2.f19499f) {
            m14231a(a, ViewportWaterfallStage.IN_VIEWPORT_FOR_MORE_THAN_VPV_DURATION);
            m14230a(FeedProps.m19802c(a), b, a2);
        }
        return true;
    }

    private void m14248f(Object obj) {
        this.f9280a.removeMessages(1, obj);
    }

    private boolean m14237a(Message message) {
        m14236a((String) message.obj, true);
        return true;
    }

    private boolean m14243b(Message message) {
        m14245c((FeedUnit) message.obj);
        return true;
    }
}
