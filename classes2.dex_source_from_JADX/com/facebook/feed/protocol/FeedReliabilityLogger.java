package com.facebook.feed.protocol;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperimentController;
import com.facebook.abtest.qe.framework.QuickExperimentControllerImpl;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.hardware.BatteryStateManager;
import com.facebook.common.hardware.SystemBatteryStateManager;
import com.facebook.common.udppriming.client.UDPPrimingStatus;
import com.facebook.common.udppriming.client.UDPPrimingStatusHelper.1;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: school_group */
public class FeedReliabilityLogger {
    private static volatile FeedReliabilityLogger f6012i;
    public final Lazy<BatteryStateManager> f6013a;
    public final Lazy<ConnectivityManager> f6014b;
    private final AnalyticsLogger f6015c;
    private final QuickExperimentController f6016d;
    private final ExecutorService f6017e;
    public boolean f6018f = false;
    private boolean f6019g = false;
    private int f6020h = Integer.MAX_VALUE;

    public static com.facebook.feed.protocol.FeedReliabilityLogger m10151a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6012i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.protocol.FeedReliabilityLogger.class;
        monitor-enter(r1);
        r0 = f6012i;	 Catch:{ all -> 0x003a }
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
        r0 = m10155b(r0);	 Catch:{ all -> 0x0035 }
        f6012i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6012i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.protocol.FeedReliabilityLogger.a(com.facebook.inject.InjectorLike):com.facebook.feed.protocol.FeedReliabilityLogger");
    }

    private static FeedReliabilityLogger m10155b(InjectorLike injectorLike) {
        return new FeedReliabilityLogger(C0055x2995691a.m1881a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 547), IdBasedLazy.m1808a(injectorLike, 38), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), QuickExperimentControllerImpl.m10166a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public FeedReliabilityLogger(ExecutorService executorService, Lazy<BatteryStateManager> lazy, Lazy<ConnectivityManager> lazy2, AnalyticsLogger analyticsLogger, QuickExperimentController quickExperimentController, QeAccessor qeAccessor) {
        this.f6017e = executorService;
        this.f6013a = lazy;
        this.f6014b = lazy2;
        this.f6015c = analyticsLogger;
        this.f6016d = quickExperimentController;
        this.f6018f = qeAccessor.mo593a(Liveness.Live, ExposureLogging.Off, ExperimentsForFeedProtocolModule.f6030c, false);
        this.f6019g = qeAccessor.mo593a(Liveness.Live, ExposureLogging.Off, ExperimentsForFeedProtocolModule.f6028a, false);
        this.f6020h = qeAccessor.mo574a(Liveness.Live, ExposureLogging.Off, ExperimentsForFeedProtocolModule.f6029b, Integer.MAX_VALUE);
    }

    public static boolean m10152a(FeedReliabilityLogger feedReliabilityLogger, HoneyClientEvent honeyClientEvent) {
        if (!feedReliabilityLogger.f6018f) {
            return false;
        }
        float a = ((SystemBatteryStateManager) feedReliabilityLogger.f6013a.get()).m11465a();
        if (a != -1.0f) {
            honeyClientEvent.m5086a("battery_level", Integer.valueOf((int) (a * 100.0f)));
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) feedReliabilityLogger.f6014b.get()).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            honeyClientEvent.m5090b("network", activeNetworkInfo.getTypeName());
            honeyClientEvent.m5090b("network_state", activeNetworkInfo.getDetailedState().toString());
        } else {
            honeyClientEvent.m5090b("network", "unknown");
        }
        feedReliabilityLogger.f6015c.mo526a((HoneyAnalyticsEvent) honeyClientEvent);
        return true;
    }

    public final void m10156a(FetchFeedParams fetchFeedParams, boolean z) {
        ExecutorDetour.a(this.f6017e, new 1(this, fetchFeedParams, z), 932928967);
    }

    public final boolean m10157a(FetchFeedParams fetchFeedParams) {
        HoneyClientEvent b = new HoneyClientEvent("feed_e2e_chunk_skipped").m5090b("client_query_id", fetchFeedParams.f5789g);
        b.f3099c = "native_newsfeed";
        return m10152a(this, b);
    }

    private boolean m10154a(String str, FetchFeedParams fetchFeedParams, Exception exception, Map<String, ?> map) {
        HoneyClientEvent b = new HoneyClientEvent(str).m5090b("client_query_id", fetchFeedParams.f5789g);
        b.f3099c = "native_newsfeed";
        b = b;
        if (exception != null) {
            b.m5090b("exception_class", exception.getClass().toString());
            b.m5090b("exception_message", exception.getMessage());
            if (this.f6019g) {
                String str2 = "exception stack";
                int i = this.f6020h;
                int i2 = 0;
                StackTraceElement[] stackTrace = exception.getStackTrace();
                StringBuilder stringBuilder = new StringBuilder();
                int length = stackTrace.length;
                int i3 = 0;
                while (i2 < length) {
                    StackTraceElement stackTraceElement = stackTrace[i2];
                    if (i3 >= i) {
                        break;
                    }
                    stringBuilder.append(stackTraceElement.toString());
                    stringBuilder.append("\n");
                    i3++;
                    i2++;
                }
                b.m5090b(str2, stringBuilder.toString());
            }
        }
        b.m5088a((Map) map);
        return m10152a(this, b);
    }

    private boolean m10153a(String str, FetchFeedParams fetchFeedParams, Exception exception) {
        return m10154a(str, fetchFeedParams, exception, null);
    }

    public final boolean m10158a(FetchFeedParams fetchFeedParams, UDPPrimingStatus uDPPrimingStatus) {
        long parseLong;
        String str;
        String str2 = fetchFeedParams.f5789g;
        long j = 0;
        String[] split = str2.split("_");
        if (split.length == 3) {
            parseLong = Long.parseLong(split[1]);
        } else {
            parseLong = -1;
        }
        long j2 = parseLong;
        if (j2 != -1) {
            j = (System.currentTimeMillis() / 1000) - j2;
        }
        HoneyClientEvent b = new HoneyClientEvent("feed_e2e_udp_prime_request").m5090b("client_query_id", str2);
        String str3 = "exception_message";
        switch (1.a[uDPPrimingStatus.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                str = "frozen";
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                str = "error_template";
                break;
            case 3:
                str = "error_encrypt_channel";
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                str = "error_encrypting";
                break;
            case 5:
                str = "error_ip_address";
                break;
            case 6:
                str = "error_network_io";
                break;
            case 7:
                str = "error_size_limit";
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                str = "error_mismatch";
                break;
            case 9:
                str = "sent";
                break;
            default:
                str = "none";
                break;
        }
        HoneyClientEvent a = b.m5090b(str3, str).m5084a("delta", j);
        a.f3099c = "native_newsfeed";
        return m10152a(this, a);
    }

    public final boolean m10159a(FetchFeedParams fetchFeedParams, Exception exception) {
        return m10153a("feed_e2e_connection_error", fetchFeedParams, exception);
    }

    public final boolean m10160a(FetchFeedParams fetchFeedParams, String str) {
        String str2;
        if (fetchFeedParams.f5788f.isManual()) {
            str2 = "manual";
        } else {
            str2 = "automatic";
        }
        HoneyClientEvent b = new HoneyClientEvent("feed_e2e_load_request").m5090b("fetch_type", fetchFeedParams.f5798p.toString() + ":" + str).m5086a("order_by", (Object) fetchFeedParams.f5784b).m5083a("first_n", fetchFeedParams.f5785c).m5090b("after", fetchFeedParams.f5787e).m5090b("before", fetchFeedParams.f5786d).m5090b("refresh_mode", str2).m5090b("client_query_id", fetchFeedParams.f5789g);
        b.f3099c = "native_newsfeed";
        return m10152a(this, b);
    }

    public final boolean m10163b(FetchFeedParams fetchFeedParams, Exception exception) {
        return m10153a("feed_e2e_receive_error", fetchFeedParams, exception);
    }

    public final boolean m10161a(FetchFeedParams fetchFeedParams, boolean z, Exception exception) {
        Map hashMap = new HashMap();
        hashMap.put("from_primed_result", Boolean.valueOf(z));
        return m10154a("feed_e2e_parsing_error", fetchFeedParams, exception, hashMap);
    }

    public final boolean m10162a(FetchFeedResult fetchFeedResult) {
        HoneyClientEvent b = new HoneyClientEvent("feed_e2e_parsing_error").m5090b("client_query_id", fetchFeedResult.f15756a.f5789g);
        b.f3099c = "native_newsfeed";
        b = b;
        b.m5087a("from_primed_result", fetchFeedResult.f15758c);
        if (fetchFeedResult.m22439d() == null) {
            b.m5087a("null_edges", true);
        }
        if (fetchFeedResult.m22440e() == null) {
            b.m5087a("null_page_info", true);
        }
        return m10152a(this, b);
    }

    public final boolean m10165c(FetchFeedParams fetchFeedParams, Exception exception) {
        return m10153a("feed_e2e_other_error", fetchFeedParams, exception);
    }

    public final boolean m10164b(FetchFeedResult fetchFeedResult) {
        HoneyClientEvent b = new HoneyClientEvent("feed_e2e_end_of_feed_error").m5090b("client_query_id", fetchFeedResult.f15756a.f5789g);
        b.f3099c = "native_newsfeed";
        b = b;
        b.m5086a("page_info", fetchFeedResult.m22440e());
        b.m5087a("from_primed_result", fetchFeedResult.f15758c);
        return m10152a(this, b);
    }
}
