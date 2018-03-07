package com.facebook.imagepipeline.internal;

import android.net.Uri;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.ConnectionStatusLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.throttling.TimeWindowThrottlingPolicy;
import com.facebook.analytics.webrequest.WebRequestCounters;
import com.facebook.cdn.handler.CdnHeaderResponse;
import com.facebook.cdn.handler.CdnHttpRequestHandler;
import com.facebook.cdn.handlerimpl.CdnHttpRequestHandlerImpl;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.futures.FutureUtils;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.config.application.FbAppType;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpRequestCancelTrigger;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.http.common.HttpFutureWrapper;
import com.facebook.http.common.NetworkDataLogUtils;
import com.facebook.http.common.RequestIdempotency;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.http.qe.ExperimentsForHttpQeModule;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.producers.BaseConsumer;
import com.facebook.imagepipeline.producers.BaseNetworkFetcher;
import com.facebook.imagepipeline.producers.BaseProducerContext;
import com.facebook.imagepipeline.producers.BaseProducerContextCallbacks;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.NetworkFetchProducer.C06271;
import com.facebook.imagepipeline.producers.NetworkFetcher.Callback;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.images.fetch.ImageReferrer;
import com.facebook.ui.media.fetch.DownloadResultResponseHandler;
import com.facebook.ui.media.fetch.MediaRedirectHandler;
import com.facebook.ui.media.fetch.MediaResponseHandler;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.util.concurrent.FutureCallback;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;

@Singleton
/* compiled from: orientation_end */
public class FbImageNetworkFetcher extends BaseNetworkFetcher<FbFetchState> {
    private static volatile FbImageNetworkFetcher f10733n;
    private final AnalyticsLogger f10734a;
    private final TimeWindowThrottlingPolicy f10735b;
    private final FbAppType f10736c;
    private final FbHttpRequestProcessor f10737d;
    private final NetworkDataLogUtils f10738e;
    private final WebRequestCounters f10739f;
    private final CdnHttpRequestHandler f10740g;
    private final FbDataConnectionManager f10741h;
    private final ConnectionStatusLogger f10742i;
    public final MonotonicClock f10743j;
    private final Set<FbImageFetchListener> f10744k;
    public final FbImageCompressionCountReaderProvider f10745l;
    private final QeAccessor f10746m;

    /* compiled from: orientation_end */
    /* synthetic */ class C06284 {
        static final /* synthetic */ int[] f14718a = new int[Priority.values().length];

        static {
            try {
                f14718a[Priority.HIGH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14718a[Priority.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f14718a[Priority.LOW.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static com.facebook.imagepipeline.internal.FbImageNetworkFetcher m15978a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10733n;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.imagepipeline.internal.FbImageNetworkFetcher.class;
        monitor-enter(r1);
        r0 = f10733n;	 Catch:{ all -> 0x003a }
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
        r0 = m15979b(r0);	 Catch:{ all -> 0x0035 }
        f10733n = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10733n;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.internal.FbImageNetworkFetcher.a(com.facebook.inject.InjectorLike):com.facebook.imagepipeline.internal.FbImageNetworkFetcher");
    }

    private static FbImageNetworkFetcher m15979b(InjectorLike injectorLike) {
        return new FbImageNetworkFetcher(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), TimeWindowThrottlingPolicy.m15990a(injectorLike), (FbAppType) injectorLike.getInstance(FbAppType.class), FbHttpRequestProcessor.m12260a(injectorLike), NetworkDataLogUtils.m15995a(injectorLike), WebRequestCounters.m15998a(injectorLike), CdnHttpRequestHandlerImpl.m12290a(injectorLike), FbDataConnectionManager.m3787a(injectorLike), ConnectionStatusLogger.m12202a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), STATICDI_MULTIBIND_PROVIDER$FbImageFetchListener.m16005a(injectorLike), (FbImageCompressionCountReaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FbImageCompressionCountReaderProvider.class), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public final void mo2060a(FetchState fetchState, int i) {
        FbFetchState fbFetchState = (FbFetchState) fetchState;
        fbFetchState.f14710d = this.f10743j.now();
        for (FbImageFetchListener a : this.f10744k) {
            a.mo2114a(fbFetchState.f14714b.f14480a, (CallerContext) fbFetchState.f14714b.f14483d, i, fbFetchState.f14714b.m20862f(), fbFetchState.m21128l());
        }
    }

    public final void mo2061a(FetchState fetchState, final C06271 c06271) {
        final FbFetchState fbFetchState = (FbFetchState) fetchState;
        final BaseProducerContext b = fbFetchState.m21130b();
        try {
            final HttpFutureWrapper a = m15976a(b.m20853a().m18798b(), (CallerContext) b.m20860d(), m15977a(this, b.m20863g()), fbFetchState, c06271);
            FutureUtils.m21156a(a.m17398a(), new FutureCallback<Void>(this) {
                final /* synthetic */ FbImageNetworkFetcher f14745b;

                public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
                }

                public void onFailure(Throwable th) {
                    if (th instanceof CancellationException) {
                        c06271.m21134a();
                    } else {
                        c06271.m21136a(th);
                    }
                }
            }, CallerThreadExecutor.m21153a());
            b.m20856a(new BaseProducerContextCallbacks(this) {
                final /* synthetic */ FbImageNetworkFetcher f14752d;

                public final void mo2801a() {
                    fbFetchState.f14711e = this.f14752d.f10743j.now();
                    a.m17400b();
                }

                public final void mo2818d() {
                    a.m17399a(FbImageNetworkFetcher.m15977a(this.f14752d, b.m20863g()));
                }
            });
        } catch (Throwable e) {
            c06271.m21136a(e);
        }
    }

    @Nullable
    public final Map mo2063b(FetchState fetchState, int i) {
        FbFetchState fbFetchState = (FbFetchState) fetchState;
        long j = fbFetchState.f14709c - fbFetchState.m21126j();
        long k = fbFetchState.m21127k() - fbFetchState.m21126j();
        double e = this.f10741h.m3803e();
        CdnHeaderResponse cdnHeaderResponse = fbFetchState.f14707a;
        Builder builder = ImmutableMap.builder();
        builder.m609b("responseLatency", String.valueOf(j));
        builder.m609b("result_content_length", String.valueOf(i));
        builder.m609b("rtt_ms", String.valueOf(this.f10741h.m3804f()));
        builder.m609b("average_bandwidth_kbit", String.valueOf(e));
        builder.m609b("dropped_bytes", String.valueOf(fbFetchState.m21125h()));
        if (fbFetchState.m21128l()) {
            builder.m609b("cancellation_time_ms", String.valueOf(k));
        }
        if (cdnHeaderResponse != CdnHeaderResponse.NOT_IN_GK) {
            builder.m609b("cdnHeaderResponse", cdnHeaderResponse.name());
        }
        return builder.m610b();
    }

    @Inject
    public FbImageNetworkFetcher(AnalyticsLogger analyticsLogger, TimeWindowThrottlingPolicy timeWindowThrottlingPolicy, FbAppType fbAppType, FbHttpRequestProcessor fbHttpRequestProcessor, NetworkDataLogUtils networkDataLogUtils, WebRequestCounters webRequestCounters, CdnHttpRequestHandler cdnHttpRequestHandler, FbDataConnectionManager fbDataConnectionManager, ConnectionStatusLogger connectionStatusLogger, MonotonicClock monotonicClock, Set<FbImageFetchListener> set, FbImageCompressionCountReaderProvider fbImageCompressionCountReaderProvider, QeAccessor qeAccessor) {
        this.f10734a = analyticsLogger;
        this.f10735b = timeWindowThrottlingPolicy;
        this.f10736c = fbAppType;
        this.f10737d = fbHttpRequestProcessor;
        this.f10738e = networkDataLogUtils;
        this.f10739f = webRequestCounters;
        this.f10740g = cdnHttpRequestHandler;
        this.f10741h = fbDataConnectionManager;
        this.f10742i = connectionStatusLogger;
        this.f10743j = monotonicClock;
        this.f10744k = set;
        this.f10745l = fbImageCompressionCountReaderProvider;
        this.f10746m = qeAccessor;
    }

    private HttpFutureWrapper<Void> m15976a(Uri uri, CallerContext callerContext, RequestPriority requestPriority, FbFetchState fbFetchState, Callback callback) {
        ImageReferrer imageReferrer = new ImageReferrer(this.f10736c.c(), ImmutableList.of(callerContext.m9068c()));
        HttpUriRequest httpGet = new HttpGet(URI.create(uri.toString()));
        httpGet.addHeader("Referer", imageReferrer.m21137a().toString());
        httpGet.addHeader("X-FB-Connection-Type", this.f10742i.m12209b());
        HttpClientParams.setRedirecting(httpGet.getParams(), true);
        this.f10739f.m16002b(uri.toString());
        RedirectHandler mediaRedirectHandler = new MediaRedirectHandler(uri, this.f10739f);
        final FbFetchState fbFetchState2 = fbFetchState;
        final C06271 c06271 = callback;
        final Uri uri2 = uri;
        final CallerContext callerContext2 = callerContext;
        C06293 c06293 = new DownloadResultResponseHandler<Void>(this) {
            final /* synthetic */ FbImageNetworkFetcher f14728e;

            public final Object mo2824a(InputStream inputStream, long j, CdnHeaderResponse cdnHeaderResponse) {
                fbFetchState2.f14707a = cdnHeaderResponse;
                fbFetchState2.f14709c = this.f14728e.f10743j.now();
                c06271.m21135a(this.f14728e.f10745l.m16006a(uri2, inputStream, callerContext2), (int) j);
                return null;
            }
        };
        return this.f10737d.m12269b(FbHttpRequest.newBuilder().m12250a("image").m12246a(callerContext).m12257b("MediaDownloader").m12254a(httpGet).m12252a(mediaRedirectHandler).m12253a(new MediaResponseHandler(uri, c06293, "image", this.f10739f, this.f10734a, this.f10735b, this.f10738e, this.f10740g)).m12247a(new FbHttpRequestCancelTrigger()).m12249a(requestPriority).m12248a(RequestIdempotency.RETRY_SAFE).m12255a(true).m12256a());
    }

    public final FetchState mo2059a(BaseConsumer baseConsumer, BaseProducerContext baseProducerContext) {
        return new FbFetchState(baseConsumer, baseProducerContext, this.f10743j.now());
    }

    public static RequestPriority m15977a(FbImageNetworkFetcher fbImageNetworkFetcher, Priority priority) {
        switch (C06284.f14718a[priority.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return RequestPriority.INTERACTIVE;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return RequestPriority.NON_INTERACTIVE;
            case 3:
                return fbImageNetworkFetcher.f10746m.mo596a(ExperimentsForHttpQeModule.aS, false) ? RequestPriority.NON_INTERACTIVE : RequestPriority.CAN_WAIT;
            default:
                throw new UnsupportedOperationException("Unrecognized priority: " + priority);
        }
    }

    public final boolean mo2062a(FetchState fetchState) {
        ConnectionQuality c = this.f10741h.m3801c();
        return c == ConnectionQuality.POOR || c == ConnectionQuality.MODERATE;
    }
}
