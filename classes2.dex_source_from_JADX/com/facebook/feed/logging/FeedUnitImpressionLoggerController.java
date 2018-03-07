package com.facebook.feed.logging;

import android.os.Handler;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.executors.ForNonUiThread;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder.ViewportWaterfallStage;
import com.facebook.feed.analytics.vpvlogging.VpvEventHelper;
import com.facebook.feed.logging.FeedUnitFullViewEventsTracker.PartialFullViewType;
import com.facebook.feed.logging.impression.FeedUnitImpression;
import com.facebook.feed.logging.impression.FeedUnitImpressionLogger;
import com.facebook.feed.logging.impression.FeedUnitImpressionType;
import com.facebook.feed.logging.impression.FeedUnitSponsoredImpressionLogger;
import com.facebook.feed.photos.FeedUnitImagesStateMapper;
import com.facebook.feed.prefs.keys.FeedPrefKeys;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.sponsored.SponsoredUtils;
import com.facebook.feed.xconfig.VpvWaterFallXConfig;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.BaseImpression;
import com.facebook.graphql.model.FeedTrackableUtil;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.Impression.ImpressionType;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.Sponsorable;
import com.facebook.graphql.model.SponsoredImpression;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.localstats.LocalStatsLogger;
import com.facebook.localstats.LocalStatsLoggerImpl;
import com.facebook.localstats.LocalStatsLoggerMethodAutoProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.user.model.User;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: prefetch_bytes */
public class FeedUnitImpressionLoggerController {
    private static volatile FeedUnitImpressionLoggerController f9247z;
    private final Lazy<FeedUnitImpressionLogger> f9248a;
    private final Lazy<FeedUnitSponsoredImpressionLogger> f9249b;
    public final FeedUnitImagesStateMapper f9250c;
    public final AnalyticsLogger f9251d;
    private final LocalStatsLoggerImpl f9252e;
    private final NewsFeedAnalyticsEventBuilder f9253f;
    private final FbObjectMapper f9254g;
    private final AbstractFbErrorReporter f9255h;
    private final FbSharedPreferences f9256i;
    @ForNonUiThread
    private final Handler f9257j;
    private final Provider<User> f9258k;
    private final Provider<Boolean> f9259l;
    private final Provider<Boolean> f9260m;
    private final Toaster f9261n;
    public final Clock f9262o;
    private final Lazy<VpvEventHelper> f9263p;
    private final ViewportLoggingHelper f9264q;
    public final XConfigReader f9265r;
    private boolean f9266s;
    private boolean f9267t;
    public long f9268u = this.f9262o.mo211a();
    public List<VpvWaterfallImpression> f9269v = Lists.m1296a();
    public int f9270w;
    public long f9271x;
    private GatekeeperStoreImpl f9272y;

    /* compiled from: prefetch_bytes */
    /* synthetic */ class C07732 {
        static final /* synthetic */ int[] f19531a = new int[FeedUnitImpressionType.values().length];

        static {
            try {
                f19531a[FeedUnitImpressionType.NON_SPONSORED_IMPRESSION.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19531a[FeedUnitImpressionType.VIEWPORT_IMPRESSION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f19531a[FeedUnitImpressionType.VIEWPORT_DURATION_IMPRESSION.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f19531a[FeedUnitImpressionType.SPONSORED_DURATION_IMPRESSION.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f19531a[FeedUnitImpressionType.SPONSORED_IMPRESSION.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f19531a[FeedUnitImpressionType.ORGANIC_IMPRESSION.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f19531a[FeedUnitImpressionType.NON_VIEWABILITY_IMPRESSION.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f19531a[FeedUnitImpressionType.FEED_UNIT_HEIGHT.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f19531a[FeedUnitImpressionType.FEED_UNIT_SEEN.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f19531a[FeedUnitImpressionType.SPONSORED_PERCENT_UNIT_SEEN.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f19531a[FeedUnitImpressionType.SPONSORED_FULL_VIEW_IMPRESSION.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    public static com.facebook.feed.logging.FeedUnitImpressionLoggerController m14182a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9247z;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.logging.FeedUnitImpressionLoggerController.class;
        monitor-enter(r1);
        r0 = f9247z;	 Catch:{ all -> 0x003a }
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
        r0 = m14188b(r0);	 Catch:{ all -> 0x0035 }
        f9247z = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9247z;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.logging.FeedUnitImpressionLoggerController.a(com.facebook.inject.InjectorLike):com.facebook.feed.logging.FeedUnitImpressionLoggerController");
    }

    private static FeedUnitImpressionLoggerController m14188b(InjectorLike injectorLike) {
        return new FeedUnitImpressionLoggerController(IdBasedSingletonScopeProvider.m1810b(injectorLike, 1437), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1438), FbObjectMapperMethodAutoProvider.m6609a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), LocalStatsLoggerMethodAutoProvider.m13608a(injectorLike), NewsFeedAnalyticsEventBuilder.m14112a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3595), Toaster.m6449a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4007), IdBasedProvider.m1811a(injectorLike, 4006), FbSharedPreferencesImpl.m1826a(injectorLike), Handler_ForNonUiThreadMethodAutoProvider.m5522a(injectorLike), IdBasedLazy.m1808a(injectorLike, 1291), ViewportLoggingHelper.m14168a(injectorLike), XConfigReader.m2681a(injectorLike), FeedUnitImagesStateMapper.m14210a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    private void m14186a(FeedUnitImpression feedUnitImpression, ViewportWaterfallStage viewportWaterfallStage) {
        if (feedUnitImpression.f19513a == FeedUnitImpressionType.VIEWPORT_IMPRESSION && feedUnitImpression.f19523k == "native_newsfeed") {
            m14203a(feedUnitImpression.f19517e, viewportWaterfallStage);
        }
    }

    private void m14193e(FeedUnitImpression feedUnitImpression) {
        Object obj = feedUnitImpression.f19514b;
        if ((obj instanceof FeedUnit) && m14192d((FeedUnit) obj)) {
            FeedUnit feedUnit = (FeedUnit) obj;
            int i = 0;
            if (feedUnit != null) {
                String g = feedUnit.mo2507g();
                if (!StringUtil.m3589a((CharSequence) g)) {
                    i = this.f9250c.m14214a(g);
                }
            }
            feedUnitImpression.f19529q = i;
        }
    }

    private FeedUnitImpression m14183a(FeedUnitImpression feedUnitImpression, FeedUnit feedUnit, long j, String str, ImmutableMap<String, String> immutableMap) {
        feedUnitImpression.f19518f = j;
        FeedUnitImpression feedUnitImpression2 = feedUnitImpression;
        feedUnitImpression2.f19523k = str;
        feedUnitImpression2 = feedUnitImpression2;
        feedUnitImpression2.f19530r = immutableMap;
        feedUnitImpression2 = feedUnitImpression2;
        feedUnitImpression2.f19526n = PropertyHelper.m21303f(feedUnit);
        feedUnitImpression2.f19527o = PropertyHelper.m21264a(feedUnit);
        if (!StringUtil.m3589a(feedUnit.mo2507g())) {
            feedUnitImpression.f19529q = this.f9250c.m14214a(feedUnit.mo2507g());
        }
        return feedUnitImpression;
    }

    @Inject
    public FeedUnitImpressionLoggerController(Lazy<FeedUnitImpressionLogger> lazy, Lazy<FeedUnitSponsoredImpressionLogger> lazy2, FbObjectMapper fbObjectMapper, FbErrorReporter fbErrorReporter, AnalyticsLogger analyticsLogger, LocalStatsLogger localStatsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, Provider<User> provider, Toaster toaster, Clock clock, Provider<Boolean> provider2, Provider<Boolean> provider3, FbSharedPreferences fbSharedPreferences, Handler handler, Lazy<VpvEventHelper> lazy3, ViewportLoggingHelper viewportLoggingHelper, XConfigReader xConfigReader, FeedUnitImagesStateMapper feedUnitImagesStateMapper, GatekeeperStore gatekeeperStore) {
        this.f9248a = lazy;
        this.f9249b = lazy2;
        this.f9251d = analyticsLogger;
        this.f9252e = localStatsLogger;
        this.f9253f = newsFeedAnalyticsEventBuilder;
        this.f9258k = provider;
        this.f9261n = toaster;
        this.f9262o = clock;
        this.f9259l = provider2;
        this.f9260m = provider3;
        this.f9254g = fbObjectMapper;
        this.f9255h = fbErrorReporter;
        this.f9256i = fbSharedPreferences;
        this.f9263p = lazy3;
        this.f9264q = viewportLoggingHelper;
        this.f9257j = handler;
        this.f9265r = xConfigReader;
        this.f9270w = -1;
        this.f9271x = -1;
        this.f9250c = feedUnitImagesStateMapper;
        this.f9272y = gatekeeperStore;
        m14194a();
    }

    private void m14189b(FeedUnitImpression feedUnitImpression) {
        JsonNode jsonNode = feedUnitImpression.f19517e;
        int i;
        HoneyAnalyticsEvent honeyAnalyticsEvent;
        switch (C07732.f19531a[feedUnitImpression.f19513a.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                ((FeedUnitImpressionLogger) this.f9248a.get()).m27220a((FeedUnit) feedUnitImpression.f19514b, feedUnitImpression.f19519g);
                return;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                m14191d(feedUnitImpression);
                if (feedUnitImpression.f19523k == "native_newsfeed") {
                    m14203a((ArrayNode) jsonNode, ViewportWaterfallStage.BEFORE_SENT_TO_MARAUDER);
                }
                ((VpvEventHelper) this.f9263p.get()).a(jsonNode, feedUnitImpression.f19523k, feedUnitImpression.f19521i, feedUnitImpression.f19526n, feedUnitImpression.f19527o, (FeedUnit) feedUnitImpression.f19514b, feedUnitImpression.f19530r);
                return;
            case 3:
                ((VpvEventHelper) this.f9263p.get()).a(jsonNode, feedUnitImpression.f19518f, feedUnitImpression.f19523k, (FeedUnit) feedUnitImpression.f19514b, feedUnitImpression.f19526n, feedUnitImpression.f19527o, feedUnitImpression.f19529q, feedUnitImpression.f19530r);
                return;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                this.f9251d.mo533c(NewsFeedAnalyticsEventBuilder.m14096a(jsonNode, feedUnitImpression.f19518f, feedUnitImpression.f19519g));
                return;
            case 5:
                if (this.f9272y.m2189a(888, false)) {
                    m14193e(feedUnitImpression);
                }
                m14191d(feedUnitImpression);
                ((FeedUnitSponsoredImpressionLogger) this.f9249b.get()).a(feedUnitImpression);
                m14190c(feedUnitImpression);
                return;
            case 6:
                BaseImpression baseImpression = feedUnitImpression.f19515c;
                baseImpression.m27481b(feedUnitImpression.f19516d);
                this.f9251d.mo533c(NewsFeedAnalyticsEventBuilder.m14101a(jsonNode, feedUnitImpression.f19516d, feedUnitImpression.f19519g));
                baseImpression.m27476a(feedUnitImpression.f19516d, true, this.f9262o.mo211a());
                return;
            case 7:
                i = feedUnitImpression.f19519g;
                if (NewsFeedAnalyticsEventBuilder.m14092B(jsonNode)) {
                    honeyAnalyticsEvent = null;
                } else {
                    honeyAnalyticsEvent = new HoneyClientEvent("non_viewability").m5085a("tracking", jsonNode).m5083a("scroll_index", i);
                    honeyAnalyticsEvent.f3099c = "native_newsfeed";
                    honeyAnalyticsEvent = honeyAnalyticsEvent;
                }
                this.f9251d.mo533c(honeyAnalyticsEvent);
                return;
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                i = feedUnitImpression.f19522j;
                if (NewsFeedAnalyticsEventBuilder.m14092B(jsonNode)) {
                    honeyAnalyticsEvent = null;
                } else {
                    honeyAnalyticsEvent = new HoneyClientEvent("feed_story_height").m5085a("tracking", jsonNode).m5083a("height", i);
                    honeyAnalyticsEvent.f3099c = "native_newsfeed";
                    honeyAnalyticsEvent = honeyAnalyticsEvent;
                }
                this.f9251d.mo533c(honeyAnalyticsEvent);
                return;
            case 9:
                i = feedUnitImpression.f19524l;
                boolean z = feedUnitImpression.f19525m;
                if (NewsFeedAnalyticsEventBuilder.m14092B(jsonNode)) {
                    honeyAnalyticsEvent = null;
                } else {
                    honeyAnalyticsEvent = new HoneyClientEvent("feed_story_seen").m5085a("tracking", jsonNode).m5083a("seen_height", i).m5087a("fully_seen", z);
                    honeyAnalyticsEvent.f3099c = "native_newsfeed";
                    honeyAnalyticsEvent = honeyAnalyticsEvent;
                }
                this.f9251d.mo533c(honeyAnalyticsEvent);
                return;
            case 10:
                this.f9251d.mo533c(NewsFeedAnalyticsEventBuilder.m14099a(jsonNode, feedUnitImpression.f19515c.f19785h, feedUnitImpression.f19515c.f19786i));
                return;
            case 11:
                if (feedUnitImpression.f19528p >= 0) {
                    i = feedUnitImpression.f19528p;
                    if (NewsFeedAnalyticsEventBuilder.m14092B(jsonNode)) {
                        honeyAnalyticsEvent = null;
                    } else {
                        honeyAnalyticsEvent = new HoneyClientEvent("feed_unit_full_view_debug").m5085a("tracking", jsonNode).m5083a("partial_full_view_type", i);
                        honeyAnalyticsEvent.f3099c = "native_newsfeed";
                        honeyAnalyticsEvent = honeyAnalyticsEvent;
                    }
                    this.f9251d.mo534d(honeyAnalyticsEvent);
                    return;
                }
                if (NewsFeedAnalyticsEventBuilder.m14092B(jsonNode)) {
                    honeyAnalyticsEvent = null;
                } else {
                    honeyAnalyticsEvent = new HoneyClientEvent("feed_unit_full_view").m5085a("tracking", jsonNode);
                    honeyAnalyticsEvent.f3099c = "native_newsfeed";
                    honeyAnalyticsEvent = honeyAnalyticsEvent;
                }
                this.f9251d.mo534d(honeyAnalyticsEvent);
                return;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final void m14194a() {
        this.f9266s = ((Boolean) this.f9259l.get()).booleanValue();
        this.f9267t = ((Boolean) this.f9260m.get()).booleanValue();
    }

    public final void m14197a(FeedUnit feedUnit) {
        m14185a(new FeedUnitImpression(FeedUnitImpressionType.NON_SPONSORED_IMPRESSION, feedUnit, FeedTrackableUtil.m27148a(feedUnit)));
    }

    public final void m14196a(FeedProps<? extends FeedUnit> feedProps, String str, ImmutableMap<String, String> immutableMap) {
        FeedUnit feedUnit;
        if (feedProps != null) {
            feedUnit = (FeedUnit) feedProps.f13444a;
        } else {
            feedUnit = null;
        }
        FeedUnitImpression feedUnitImpression = new FeedUnitImpression(FeedUnitImpressionType.VIEWPORT_IMPRESSION, feedUnit, this.f9264q.m14170a((FeedProps) feedProps));
        feedUnitImpression.f19520h = this.f9262o.mo211a();
        feedUnitImpression = feedUnitImpression;
        feedUnitImpression.f19523k = str;
        feedUnitImpression = feedUnitImpression;
        feedUnitImpression.f19530r = immutableMap;
        feedUnitImpression = feedUnitImpression;
        if (feedProps != null) {
            feedUnitImpression.f19526n = PropertyHelper.m21303f(feedUnit);
            feedUnitImpression.f19527o = PropertyHelper.m21264a(feedUnit);
        }
        this.f9252e.m13616a(7405569);
        m14185a(feedUnitImpression);
    }

    public final void m14195a(FeedProps<? extends FeedUnit> feedProps, FeedUnit feedUnit, long j, String str, ImmutableMap<String, String> immutableMap) {
        m14185a(m14183a(new FeedUnitImpression(FeedUnitImpressionType.VIEWPORT_DURATION_IMPRESSION, feedProps != null ? (FeedUnit) feedProps.m19804a() : null, this.f9264q.m14170a((FeedProps) feedProps)), feedUnit, j, str, (ImmutableMap) immutableMap));
    }

    public final void m14200a(GraphQLStorySet graphQLStorySet, long j, String str, ImmutableMap<String, String> immutableMap) {
        m14185a(m14183a(new FeedUnitImpression(FeedUnitImpressionType.VIEWPORT_DURATION_IMPRESSION, graphQLStorySet, this.f9264q.m14171a(graphQLStorySet)), (FeedUnit) graphQLStorySet, j, str, (ImmutableMap) immutableMap));
    }

    public final void m14201a(Sponsorable sponsorable) {
        m14187a(sponsorable, ImpressionType.ORIGINAL);
    }

    public final void m14205b(Sponsorable sponsorable) {
        m14187a(sponsorable, ImpressionType.SUBSEQUENT);
    }

    public final void m14206c(Sponsorable sponsorable) {
        m14187a(sponsorable, ImpressionType.VIEWABILITY);
    }

    public final void m14207d(Sponsorable sponsorable) {
        m14185a(new FeedUnitImpression(FeedUnitImpressionType.NON_VIEWABILITY_IMPRESSION, sponsorable, FeedTrackableUtil.m27148a((FeedUnit) sponsorable)));
    }

    public final void m14202a(Sponsorable sponsorable, long j) {
        FeedUnitImpression feedUnitImpression = new FeedUnitImpression(FeedUnitImpressionType.SPONSORED_DURATION_IMPRESSION, sponsorable, FeedTrackableUtil.m27148a((FeedUnit) sponsorable));
        feedUnitImpression.f19518f = j;
        m14185a(feedUnitImpression);
    }

    public final void m14208e(Sponsorable sponsorable) {
        FeedUnitImpression feedUnitImpression = new FeedUnitImpression(FeedUnitImpressionType.SPONSORED_PERCENT_UNIT_SEEN, sponsorable, FeedTrackableUtil.m27148a((FeedUnit) sponsorable));
        feedUnitImpression.f19515c = sponsorable.ab_();
        m14185a(feedUnitImpression);
    }

    public final void m14198a(FeedUnit feedUnit, int i) {
        FeedUnitImpression feedUnitImpression = new FeedUnitImpression(FeedUnitImpressionType.FEED_UNIT_HEIGHT, feedUnit, FeedTrackableUtil.m27148a(feedUnit));
        feedUnitImpression.f19522j = i;
        m14185a(feedUnitImpression);
    }

    public final void m14204b(FeedUnit feedUnit) {
        FeedUnitImpression feedUnitImpression = new FeedUnitImpression(FeedUnitImpressionType.SPONSORED_FULL_VIEW_IMPRESSION, feedUnit, FeedTrackableUtil.m27148a(feedUnit));
        feedUnitImpression.f19515c = SponsoredUtils.m21144a((Object) feedUnit).ab_();
        m14185a(feedUnitImpression);
    }

    public final void m14199a(FeedUnit feedUnit, PartialFullViewType partialFullViewType) {
        FeedUnitImpression feedUnitImpression = new FeedUnitImpression(FeedUnitImpressionType.SPONSORED_FULL_VIEW_IMPRESSION, feedUnit, FeedTrackableUtil.m27148a(feedUnit));
        feedUnitImpression.f19515c = SponsoredUtils.m21144a((Object) feedUnit).ab_();
        FeedUnitImpression feedUnitImpression2 = feedUnitImpression;
        feedUnitImpression2.f19528p = partialFullViewType.ordinal();
        m14185a(feedUnitImpression2);
    }

    public final void m14203a(@Nullable ArrayNode arrayNode, ViewportWaterfallStage viewportWaterfallStage) {
        if (this.f9266s) {
            Object obj;
            List list;
            int size = this.f9269v.size();
            if (this.f9270w == -1) {
                this.f9270w = this.f9265r.m2683a(VpvWaterFallXConfig.f19490c, 50);
            }
            if (size < this.f9270w) {
                long a = this.f9262o.mo211a() - this.f9268u;
                if (this.f9271x == -1) {
                    this.f9271x = this.f9265r.m2684a(VpvWaterFallXConfig.f19491d, 180000);
                }
                if (a <= this.f9271x) {
                    obj = null;
                    if (obj != null) {
                        HandlerDetour.a(this.f9257j, new 1(this, ImmutableList.copyOf(this.f9269v)), 648487647);
                        this.f9269v.clear();
                    }
                    list = this.f9269v;
                    if (!this.f9267t) {
                        arrayNode = null;
                    }
                    list.add(new VpvWaterfallImpression(arrayNode, viewportWaterfallStage.getCode()));
                    this.f9268u = this.f9262o.mo211a();
                }
            }
            obj = 1;
            if (obj != null) {
                HandlerDetour.a(this.f9257j, new 1(this, ImmutableList.copyOf(this.f9269v)), 648487647);
                this.f9269v.clear();
            }
            list = this.f9269v;
            if (this.f9267t) {
                arrayNode = null;
            }
            list.add(new VpvWaterfallImpression(arrayNode, viewportWaterfallStage.getCode()));
            this.f9268u = this.f9262o.mo211a();
        }
    }

    public static String m14184a(FeedUnitImpressionLoggerController feedUnitImpressionLoggerController, ImmutableList immutableList) {
        try {
            return feedUnitImpressionLoggerController.f9254g.m6659a((Object) immutableList);
        } catch (JsonProcessingException e) {
            feedUnitImpressionLoggerController.f9255h.mo336a(SoftError.a("JSON exception in VpvWaterfall aggregation", "").a(e).g());
            return null;
        }
    }

    private void m14187a(Sponsorable sponsorable, ImpressionType impressionType) {
        TracerDetour.a("FeedUnitImpressionLoggerController.logSponsoredImpressed", 843552503);
        try {
            BaseImpression a = SponsoredUtils.m21143a(sponsorable);
            if (a != null && a.mo3121k()) {
                a.m27475a(impressionType);
                m14185a(new FeedUnitImpression(a instanceof SponsoredImpression ? FeedUnitImpressionType.SPONSORED_IMPRESSION : FeedUnitImpressionType.ORGANIC_IMPRESSION, sponsorable, FeedTrackableUtil.m27148a((FeedUnit) sponsorable)).m27206a(a).m27207a(impressionType));
            }
            TracerDetour.a(1383543013);
        } catch (Throwable th) {
            TracerDetour.a(1560585421);
        }
    }

    private void m14185a(FeedUnitImpression feedUnitImpression) {
        TracerDetour.a("FeedUnitImpressionLoggerController.logImpression", 862494689);
        try {
            m14186a(feedUnitImpression, ViewportWaterfallStage.BEFORE_VALIDATION);
            if (feedUnitImpression.m27208a()) {
                m14186a(feedUnitImpression, ViewportWaterfallStage.BEFORE_SENT_TO_QUEUE);
                m14189b(feedUnitImpression);
                TracerDetour.a(-1099384393);
            }
        } finally {
            TracerDetour.a(-294180821);
        }
    }

    private void m14190c(FeedUnitImpression feedUnitImpression) {
        if (this.f9256i.mo286a(FeedPrefKeys.f5756t, false) && BuildConstants.i && this.f9258k.get() != null && ((User) this.f9258k.get()).f3612o) {
            this.f9261n.m6456b(new ToastBuilder(feedUnitImpression.toString()));
        }
    }

    private synchronized void m14191d(FeedUnitImpression feedUnitImpression) {
        PrefKey prefKey;
        switch (C07732.f19531a[feedUnitImpression.m27211c().ordinal()]) {
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                prefKey = FeedUnitImpressionPrefKeys.a;
                break;
            case 5:
                prefKey = FeedUnitImpressionPrefKeys.b;
                break;
            default:
                throw new UnsupportedOperationException();
        }
        int a = this.f9256i.mo276a(prefKey, 0);
        if (a == 0) {
            a = ((int) (Math.random() * 36863.0d)) << 16;
        }
        this.f9256i.edit().mo1274a(prefKey, a + 1).commit();
        feedUnitImpression.m27209b(a);
    }

    private static boolean m14192d(FeedUnit feedUnit) {
        if ((feedUnit instanceof GraphQLStorySet) || (feedUnit instanceof GraphQLPYMLWithLargeImageFeedUnit)) {
            return true;
        }
        if (feedUnit instanceof GraphQLStory) {
            ImmutableList M = ((GraphQLStory) feedUnit).m22327M();
            if (M == null) {
                return false;
            }
            int size = M.size();
            for (int i = 0; i < size; i++) {
                GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) M.get(i);
                if (graphQLStoryAttachment != null) {
                    if (GraphQLStoryAttachmentUtil.m28050a(graphQLStoryAttachment, GraphQLStoryAttachmentStyle.MULTI_SHARE, GraphQLStoryAttachmentStyle.MULTI_SHARE_NO_END_CARD)) {
                        return true;
                    }
                    if (GraphQLStoryAttachmentUtil.m28061l(graphQLStoryAttachment) != null) {
                        return true;
                    }
                    if (GraphQLStoryAttachmentUtil.m28049a(graphQLStoryAttachment, GraphQLStoryAttachmentStyle.ALBUM)) {
                        ImmutableList x = graphQLStoryAttachment.m23985x();
                        if (x != null) {
                            int size2 = x.size();
                            for (int i2 = 0; i2 < size2; i2++) {
                                if (GraphQLStoryAttachmentUtil.m28061l((GraphQLStoryAttachment) x.get(i2)) != null) {
                                    return true;
                                }
                            }
                            continue;
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return false;
    }
}
