package com.facebook.http.common;

import android.os.Process;
import android.os.SystemClock;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.FutureCallback;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: ref */
public class FbHttpRequestProcessorLogger {
    private static volatile FbHttpRequestProcessorLogger f7841f;
    private final AnalyticsLogger f7842a;
    private final FbNetworkManager f7843b;
    private final FbDataConnectionManager f7844c;
    private final NetworkSystemSettings f7845d;
    @GuardedBy("this")
    private final Map<FbHttpRequest<?>, HoneyClientEventFast> f7846e = new HashMap();

    /* compiled from: ref */
    public class C04981 implements FutureCallback<T> {
        final /* synthetic */ FbHttpRequest f11892a;
        final /* synthetic */ FbHttpRequestProcessorLogger f11893b;

        public C04981(FbHttpRequestProcessorLogger fbHttpRequestProcessorLogger, FbHttpRequest fbHttpRequest) {
            this.f11893b = fbHttpRequestProcessorLogger;
            this.f11892a = fbHttpRequest;
        }

        public void onSuccess(@Nullable T t) {
            FbHttpRequestProcessorLogger.m12383a(this.f11893b, this.f11892a, null);
        }

        public void onFailure(Throwable th) {
            FbHttpRequestProcessorLogger.m12383a(this.f11893b, this.f11892a, th);
        }
    }

    public static com.facebook.http.common.FbHttpRequestProcessorLogger m12382a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7841f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.common.FbHttpRequestProcessorLogger.class;
        monitor-enter(r1);
        r0 = f7841f;	 Catch:{ all -> 0x003a }
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
        r0 = m12385b(r0);	 Catch:{ all -> 0x0035 }
        f7841f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7841f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.common.FbHttpRequestProcessorLogger.a(com.facebook.inject.InjectorLike):com.facebook.http.common.FbHttpRequestProcessorLogger");
    }

    private static FbHttpRequestProcessorLogger m12385b(InjectorLike injectorLike) {
        return new FbHttpRequestProcessorLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), FbNetworkManager.m3811a(injectorLike), FbDataConnectionManager.m3787a(injectorLike), NetworkSystemSettings.m12388a(injectorLike));
    }

    @Inject
    public FbHttpRequestProcessorLogger(AnalyticsLogger analyticsLogger, FbNetworkManager fbNetworkManager, FbDataConnectionManager fbDataConnectionManager, NetworkSystemSettings networkSystemSettings) {
        this.f7842a = analyticsLogger;
        this.f7843b = fbNetworkManager;
        this.f7844c = fbDataConnectionManager;
        this.f7845d = networkSystemSettings;
    }

    public final <T> void m12387a(FbHttpRequest<T> fbHttpRequest, String str, String str2) {
        HoneyClientEventFast a = this.f7842a.mo535a("fb4a_http_processor", false);
        if (a.m17388a()) {
            synchronized (this) {
                this.f7846e.put(fbHttpRequest, a);
            }
            a.m17385a("engine_name", str);
            a.m17385a("stack_name", str2);
            a.m17385a("friendly_name", fbHttpRequest.m12231b());
            a.m17385a("initial_priority", fbHttpRequest.m12235h().name());
            a.m17382a("pre_queue_time", m12381a() - fbHttpRequest.m12238l());
            a.m17384a("connection_class", this.f7844c.m3801c());
            a.m17385a("network_type", this.f7843b.m3837m());
            Optional a2 = this.f7845d.m12390a();
            if (a2.isPresent()) {
                a.m17384a("airplane_mode_on", a2.get());
            }
            a2 = this.f7845d.m12391b();
            if (a2.isPresent()) {
                a.m17384a("mobile_data_enabled", a2.get());
            }
            CallerContext c = fbHttpRequest.m12232c();
            if (c != null) {
                a.m17385a("calling_class", c.m9066a());
                a.m17385a("analytics_tag", c.m9068c());
                a.m17385a("feature_tag", c.m9067b());
                a.m17385a("module_tag", c.m9069d());
            }
        }
    }

    public final <T> void m12386a(FbHttpRequest<T> fbHttpRequest) {
        HoneyClientEventFast b = m12384b((FbHttpRequest) fbHttpRequest);
        if (b != null) {
            b.m17382a("queue_time", m12381a() - fbHttpRequest.f7698o);
            b.m17381a("thread_priority", Process.getThreadPriority(Process.myTid()));
        }
    }

    public static synchronized <T> void m12383a(FbHttpRequestProcessorLogger fbHttpRequestProcessorLogger, @Nullable FbHttpRequest fbHttpRequest, Throwable th) {
        synchronized (fbHttpRequestProcessorLogger) {
            HoneyClientEventFast b = fbHttpRequestProcessorLogger.m12384b(fbHttpRequest);
            if (b != null) {
                b.m17382a("total_time", m12381a() - fbHttpRequest.m12238l());
                b.m17386a("success", th == null);
                if (th != null) {
                    b.m17385a("exception", th.getClass().getSimpleName());
                    b.m17385a("exception_msg", th.getMessage());
                }
                Map e = fbHttpRequest.m12236i().m11640e();
                if (e != null) {
                    for (Entry entry : e.entrySet()) {
                        b.m17385a((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                fbHttpRequestProcessorLogger.f7846e.remove(fbHttpRequest);
                b.m17390b();
            }
        }
    }

    private synchronized <T> HoneyClientEventFast m12384b(FbHttpRequest<T> fbHttpRequest) {
        return (HoneyClientEventFast) this.f7846e.get(fbHttpRequest);
    }

    private static long m12381a() {
        return SystemClock.uptimeMillis();
    }
}
