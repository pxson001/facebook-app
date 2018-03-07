package com.facebook.feed.logging.impression;

import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.api.feed.MarkImpressionsLoggedParams;
import com.facebook.api.feed.MarkImpressionsLoggedParams.Builder;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.FbAsyncTask;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.Operation;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder$SponsoredImpressionPhase;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.BaseImpression;
import com.facebook.graphql.model.Impression$ImpressionType;
import com.facebook.graphql.model.ImpressionUtil;
import com.facebook.graphql.model.Sponsorable;
import com.facebook.graphql.model.SponsoredImpression;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiResponseChecker;
import com.facebook.http.protocol.StringResponseHandler;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.localstats.LocalStatsLogger;
import com.facebook.localstats.LocalStatsLoggerImpl;
import com.facebook.localstats.LocalStatsLoggerMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.params.BasicHttpParams;

@Singleton
/* compiled from: profile_photo */
public class FeedUnitSponsoredImpressionLogger {
    private static final String f4122a = FeedUnitSponsoredImpressionLogger.class.getSimpleName();
    private static volatile FeedUnitSponsoredImpressionLogger f4123r;
    private final FbHttpRequestProcessor f4124b;
    private final ApiResponseChecker f4125c;
    private final DefaultBlueServiceOperationFactory f4126d;
    private final AbstractFbErrorReporter f4127e;
    private final Clock f4128f;
    private final ObjectMapper f4129g;
    public final Provider<Boolean> f4130h;
    private final Provider<Boolean> f4131i;
    private final Provider<Boolean> f4132j;
    private NewsFeedAnalyticsEventBuilder f4133k;
    private AnalyticsLogger f4134l;
    private LocalStatsLoggerImpl f4135m;
    private final DefaultAndroidThreadUtil f4136n;
    public String f4137o;
    private final Lazy<FbNetworkManager> f4138p;
    private GatekeeperStoreImpl f4139q;

    /* compiled from: profile_photo */
    class SponsoredImpressionLoggerAsyncTask extends FbAsyncTask<Void, Void, Boolean> {
        final /* synthetic */ FeedUnitSponsoredImpressionLogger f4140a;
        private final FeedUnitImpression f4141b;

        protected final Object mo340a(Object[] objArr) {
            boolean a;
            String newsFeedAnalyticsEventBuilder$SponsoredImpressionPhase;
            FeedUnitImpression feedUnitImpression;
            Object obj;
            FeedUnitSponsoredImpressionLogger.m4668a(this.f4140a, this.f4141b, NewsFeedAnalyticsEventBuilder$SponsoredImpressionPhase.STARTED, true, null);
            boolean b = this.f4140a.m4676b(this.f4141b);
            if (!b) {
                FeedUnitSponsoredImpressionLogger.m4668a(this.f4140a, this.f4141b, NewsFeedAnalyticsEventBuilder$SponsoredImpressionPhase.FAILED, false, this.f4140a.f4137o);
                if (((Boolean) this.f4140a.f4130h.get()).booleanValue() && this.f4141b.d != Impression$ImpressionType.SUBSEQUENT) {
                    FeedUnitSponsoredImpressionLogger.m4668a(this.f4140a, this.f4141b, NewsFeedAnalyticsEventBuilder$SponsoredImpressionPhase.FALLBACK, b, null);
                    a = FeedUnitSponsoredImpressionLogger.m4671a(this.f4140a, this.f4141b, false);
                    newsFeedAnalyticsEventBuilder$SponsoredImpressionPhase = NewsFeedAnalyticsEventBuilder$SponsoredImpressionPhase.FALLBACK.toString();
                    if (a) {
                        feedUnitImpression = this.f4141b;
                        if ((feedUnitImpression.d != Impression$ImpressionType.ORIGINAL || feedUnitImpression.d == Impression$ImpressionType.VIEWABILITY) && (feedUnitImpression.b instanceof Sponsorable)) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            this.f4140a.m4677c(this.f4141b);
                        }
                    }
                    FeedUnitSponsoredImpressionLogger.m4668a(this.f4140a, this.f4141b, NewsFeedAnalyticsEventBuilder$SponsoredImpressionPhase.COMPLETED, a, newsFeedAnalyticsEventBuilder$SponsoredImpressionPhase);
                    return Boolean.valueOf(a);
                }
            }
            a = b;
            newsFeedAnalyticsEventBuilder$SponsoredImpressionPhase = null;
            if (a) {
                feedUnitImpression = this.f4141b;
                if (feedUnitImpression.d != Impression$ImpressionType.ORIGINAL) {
                }
                obj = 1;
                if (obj != null) {
                    this.f4140a.m4677c(this.f4141b);
                }
            }
            FeedUnitSponsoredImpressionLogger.m4668a(this.f4140a, this.f4141b, NewsFeedAnalyticsEventBuilder$SponsoredImpressionPhase.COMPLETED, a, newsFeedAnalyticsEventBuilder$SponsoredImpressionPhase);
            return Boolean.valueOf(a);
        }

        public SponsoredImpressionLoggerAsyncTask(FeedUnitSponsoredImpressionLogger feedUnitSponsoredImpressionLogger, FeedUnitImpression feedUnitImpression) {
            this.f4140a = feedUnitSponsoredImpressionLogger;
            this.f4141b = feedUnitImpression;
        }
    }

    public static com.facebook.feed.logging.impression.FeedUnitSponsoredImpressionLogger m4665a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4123r;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.logging.impression.FeedUnitSponsoredImpressionLogger.class;
        monitor-enter(r1);
        r0 = f4123r;	 Catch:{ all -> 0x003a }
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
        r0 = m4673b(r0);	 Catch:{ all -> 0x0035 }
        f4123r = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4123r;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.logging.impression.FeedUnitSponsoredImpressionLogger.a(com.facebook.inject.InjectorLike):com.facebook.feed.logging.impression.FeedUnitSponsoredImpressionLogger");
    }

    private static FeedUnitSponsoredImpressionLogger m4673b(InjectorLike injectorLike) {
        return new FeedUnitSponsoredImpressionLogger(FbHttpRequestProcessor.a(injectorLike), ApiResponseChecker.a(injectorLike), DefaultBlueServiceOperationFactory.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), LocalStatsLoggerMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3998), IdBasedProvider.a(injectorLike, 3986), IdBasedProvider.a(injectorLike, 4003), DefaultAndroidThreadUtil.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 585), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FeedUnitSponsoredImpressionLogger(FbHttpRequestProcessor fbHttpRequestProcessor, ApiResponseChecker apiResponseChecker, BlueServiceOperationFactory blueServiceOperationFactory, FbErrorReporter fbErrorReporter, Clock clock, ObjectMapper objectMapper, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AnalyticsLogger analyticsLogger, LocalStatsLogger localStatsLogger, Provider<Boolean> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, AndroidThreadUtil androidThreadUtil, Lazy<FbNetworkManager> lazy, GatekeeperStore gatekeeperStore) {
        this.f4124b = fbHttpRequestProcessor;
        this.f4125c = apiResponseChecker;
        this.f4126d = blueServiceOperationFactory;
        this.f4127e = fbErrorReporter;
        this.f4128f = clock;
        this.f4129g = objectMapper;
        this.f4133k = newsFeedAnalyticsEventBuilder;
        this.f4134l = analyticsLogger;
        this.f4135m = localStatsLogger;
        this.f4136n = androidThreadUtil;
        this.f4130h = provider;
        this.f4132j = provider2;
        this.f4131i = provider3;
        this.f4138p = lazy;
        this.f4139q = gatekeeperStore;
    }

    public final void m4675a(FeedUnitImpression feedUnitImpression) {
        this.f4135m.a(7405572);
        m4668a(this, feedUnitImpression, NewsFeedAnalyticsEventBuilder$SponsoredImpressionPhase.STARTING, true, null);
        this.f4136n.a(new SponsoredImpressionLoggerAsyncTask(this, feedUnitImpression), new Void[0]);
    }

    @VisibleForTesting
    final boolean m4676b(FeedUnitImpression feedUnitImpression) {
        BaseImpression ab_;
        SponsoredImpression sponsoredImpression = (SponsoredImpression) feedUnitImpression.c;
        Impression$ImpressionType impression$ImpressionType = feedUnitImpression.d;
        ArrayNode arrayNode = feedUnitImpression.e;
        if (sponsoredImpression == null) {
            ab_ = ((Sponsorable) feedUnitImpression.b).ab_();
        } else {
            ab_ = sponsoredImpression;
        }
        ab_.b(impression$ImpressionType);
        boolean a = (!ab_.p && feedUnitImpression.b() && ((Boolean) this.f4132j.get()).booleanValue()) ? m4671a(this, feedUnitImpression, false) : m4667a(ab_, arrayNode, impression$ImpressionType, feedUnitImpression) != null;
        ab_.a(impression$ImpressionType, a, this.f4128f.a());
        return a;
    }

    public static boolean m4671a(FeedUnitSponsoredImpressionLogger feedUnitSponsoredImpressionLogger, FeedUnitImpression feedUnitImpression, boolean z) {
        int i;
        boolean z2;
        String str;
        Impression$ImpressionType impression$ImpressionType = feedUnitImpression.d;
        BaseImpression baseImpression = feedUnitImpression.c;
        JsonNode jsonNode = feedUnitImpression.e;
        if (baseImpression != null) {
            i = ((SponsoredImpression) baseImpression).r;
        } else {
            i = 0;
        }
        boolean d = ((FbNetworkManager) feedUnitSponsoredImpressionLogger.f4138p.get()).d();
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("ad_multi_impression");
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        honeyClientEvent = honeyClientEvent.b(z2).a("tracking", jsonNode);
        String str2 = "io";
        if (impression$ImpressionType == Impression$ImpressionType.ORIGINAL) {
            str = "1";
        } else {
            str = "0";
        }
        honeyClientEvent = honeyClientEvent.b(str2, str);
        str2 = "isv";
        if (impression$ImpressionType == Impression$ImpressionType.VIEWABILITY) {
            str = "1";
        } else {
            str = "0";
        }
        honeyClientEvent = honeyClientEvent.b(str2, str).a("csp", i);
        str2 = "is_exp";
        if (z) {
            str = "1";
        } else {
            str = "0";
        }
        honeyClientEvent = honeyClientEvent.b(str2, str);
        str2 = "imp_connection_state";
        if (d) {
            str = "1";
        } else {
            str = "0";
        }
        HoneyClientEvent b = honeyClientEvent.b(str2, str);
        if (feedUnitSponsoredImpressionLogger.f4139q.a(888, false)) {
            b.a("image_load_state", feedUnitImpression.q);
        }
        if (z) {
            feedUnitSponsoredImpressionLogger.f4134l.c(b);
        } else {
            feedUnitSponsoredImpressionLogger.f4134l.d(b);
        }
        return true;
    }

    @VisibleForTesting
    final void m4677c(FeedUnitImpression feedUnitImpression) {
        Sponsorable sponsorable = (Sponsorable) feedUnitImpression.b;
        int i = feedUnitImpression.g;
        ImpressionUtil.a(sponsorable, ImpressionUtil.d(sponsorable) | (1 << i));
        if (sponsorable.g() != null) {
            Builder builder = new Builder();
            builder.f4146a = sponsorable.g();
            builder = builder;
            builder.f4147b = sponsorable.getType();
            Builder builder2 = builder;
            builder2.f4148c = i;
            builder2 = builder2;
            Preconditions.checkNotNull(builder2.f4146a);
            Preconditions.checkNotNull(builder2.f4147b);
            MarkImpressionsLoggedParams markImpressionsLoggedParams = new MarkImpressionsLoggedParams(builder2.f4146a, builder2.f4147b, builder2.f4148c);
            Bundle bundle = new Bundle();
            bundle.putParcelable("markImpressionLoggedParams", markImpressionsLoggedParams);
            Operation a = BlueServiceOperationFactoryDetour.a(this.f4126d, "feed_mark_impression_logged", bundle, -493201663);
            a.a(true);
            a.a();
        }
    }

    @Nullable
    @VisibleForTesting
    private List<String> m4667a(SponsoredImpression sponsoredImpression, ArrayNode arrayNode, Impression$ImpressionType impression$ImpressionType, FeedUnitImpression feedUnitImpression) {
        boolean z = false;
        List<String> a = sponsoredImpression.a(impression$ImpressionType, arrayNode, this.f4128f.a(), feedUnitImpression.m(), this.f4139q.a(888, false) ? Integer.valueOf(feedUnitImpression.s()) : null);
        if (a.isEmpty()) {
            return null;
        }
        List<String> a2 = Lists.a();
        for (String str : a) {
            try {
                new Object[1][0] = str;
                z = m4672a(m4666a(str), (List) a2);
            } catch (Exception e) {
                this.f4137o = e.getMessage();
                if (!sponsoredImpression.c(impression$ImpressionType)) {
                    return null;
                }
                m4669a(e, str);
                return null;
            }
        }
        m4670a((List) a2, feedUnitImpression, z);
        return a2;
    }

    private void m4670a(List<String> list, FeedUnitImpression feedUnitImpression, boolean z) {
        for (int i = 0; i < list.size(); i++) {
            try {
                m4666a((String) list.get(i));
                if (z) {
                    m4668a(this, feedUnitImpression, NewsFeedAnalyticsEventBuilder$SponsoredImpressionPhase.VIEWPING, true, (String) list.get(i));
                }
            } catch (Exception e) {
                m4674b(feedUnitImpression, NewsFeedAnalyticsEventBuilder$SponsoredImpressionPhase.VIEWPING, false, e.getMessage() + " " + ((String) list.get(i)));
            }
        }
    }

    @VisibleForTesting
    private String m4666a(String str) {
        URL url = new URL(str);
        HttpUriRequest httpGet = new HttpGet(new URI(url.getProtocol(), url.getAuthority(), url.getPath(), url.getQuery(), url.getRef()));
        ResponseHandler stringResponseHandler = new StringResponseHandler(this.f4125c);
        httpGet.setParams(new BasicHttpParams().setParameter("http.protocol.handle-redirects", Boolean.valueOf(true)));
        FbHttpRequest.Builder newBuilder = FbHttpRequest.newBuilder();
        newBuilder.c = "SponsoredImpressionLogger";
        newBuilder = newBuilder;
        newBuilder.d = CallerContext.a(getClass());
        newBuilder = newBuilder;
        newBuilder.b = httpGet;
        FbHttpRequest.Builder builder = newBuilder;
        builder.l = RequestPriority.NON_INTERACTIVE;
        builder = builder;
        builder.g = stringResponseHandler;
        return (String) this.f4124b.a(builder.a());
    }

    @VisibleForTesting
    private boolean m4672a(String str, List<String> list) {
        Preconditions.checkNotNull(list);
        try {
            if (!Strings.isNullOrEmpty(str)) {
                JsonNode a = this.f4129g.a(str);
                JsonNode b = a.b("third_party_impression_logging_urls");
                JsonNode b2 = a.b("enable_debug_logging");
                if (b != null && b.h()) {
                    Iterator G = b.G();
                    while (G.hasNext()) {
                        list.add(((JsonNode) G.next()).s());
                    }
                }
                if (b2 != null && b2.n() && b2.C() == 1) {
                    return true;
                }
            }
        } catch (Throwable e) {
            this.f4127e.a(f4122a, "Failed to parse third party impressions :" + str, e);
        }
        return false;
    }

    private void m4669a(Exception exception, String str) {
        String format;
        if ((exception instanceof MalformedURLException) || (exception instanceof URISyntaxException)) {
            format = String.format("Failed to parse original impression url: %s", new Object[]{str});
        } else {
            format = String.format("Failed to request original impression url: %s", new Object[]{str});
        }
        this.f4127e.a(f4122a, format, exception);
    }

    public static void m4668a(FeedUnitSponsoredImpressionLogger feedUnitSponsoredImpressionLogger, FeedUnitImpression feedUnitImpression, NewsFeedAnalyticsEventBuilder$SponsoredImpressionPhase newsFeedAnalyticsEventBuilder$SponsoredImpressionPhase, @Nullable boolean z, String str) {
        if (((Boolean) feedUnitSponsoredImpressionLogger.f4131i.get()).booleanValue()) {
            HoneyClientEvent a = NewsFeedAnalyticsEventBuilder.a(feedUnitImpression.e, feedUnitImpression.d, newsFeedAnalyticsEventBuilder$SponsoredImpressionPhase, z, str, feedUnitImpression.i, ((FbNetworkManager) feedUnitSponsoredImpressionLogger.f4138p.get()).d());
            if (feedUnitSponsoredImpressionLogger.f4139q.a(888, false)) {
                a.a("image_load_state", feedUnitImpression.q);
            }
            feedUnitSponsoredImpressionLogger.f4134l.a(a);
        }
    }

    private void m4674b(FeedUnitImpression feedUnitImpression, NewsFeedAnalyticsEventBuilder$SponsoredImpressionPhase newsFeedAnalyticsEventBuilder$SponsoredImpressionPhase, boolean z, @Nullable String str) {
        if (((Boolean) this.f4131i.get()).booleanValue()) {
            HoneyClientEvent a = NewsFeedAnalyticsEventBuilder.a(feedUnitImpression.e, feedUnitImpression.d, newsFeedAnalyticsEventBuilder$SponsoredImpressionPhase, z, str, feedUnitImpression.i, ((FbNetworkManager) this.f4138p.get()).d());
            if (this.f4139q.a(888, false)) {
                a.a("image_load_state", feedUnitImpression.q);
            }
            this.f4134l.c(a);
        }
    }
}
