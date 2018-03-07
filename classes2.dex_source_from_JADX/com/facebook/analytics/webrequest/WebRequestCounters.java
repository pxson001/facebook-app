package com.facebook.analytics.webrequest;

import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.analytics.counter.AnalyticsCounters;
import com.facebook.analytics.counter.CountersPrefWriter;
import com.facebook.analytics.counter.CountersPrefWriterMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsConfig$Level;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.FbAnalyticsConfig;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: organic_impression */
public class WebRequestCounters extends AnalyticsCounters {
    private static volatile WebRequestCounters f10752l;
    private final String f10753b = "total_request";
    private final String f10754c = "unique_request";
    private final String f10755d = "total_succeed";
    private final String f10756e = "succeed_on_first_try";
    private final String f10757f = "succeed_on_second_try";
    private final String f10758g = "succeed_on_third_try";
    private final String f10759h = "succeed_on_fourth_onward_try";
    private final String f10760i = "ignored_request_due_to_cache_failure";
    private Map<String, Integer> f10761j;
    private final BaseAnalyticsConfig f10762k;

    public static com.facebook.analytics.webrequest.WebRequestCounters m15998a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10752l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.webrequest.WebRequestCounters.class;
        monitor-enter(r1);
        r0 = f10752l;	 Catch:{ all -> 0x003a }
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
        r0 = m15999b(r0);	 Catch:{ all -> 0x0035 }
        f10752l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10752l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.webrequest.WebRequestCounters.a(com.facebook.inject.InjectorLike):com.facebook.analytics.webrequest.WebRequestCounters");
    }

    private static WebRequestCounters m15999b(InjectorLike injectorLike) {
        return new WebRequestCounters(FbAnalyticsConfig.m3559a(injectorLike), CountersPrefWriterMethodAutoProvider.m2777a(injectorLike));
    }

    @Inject
    public WebRequestCounters(BaseAnalyticsConfig baseAnalyticsConfig, @Nullable CountersPrefWriter countersPrefWriter) {
        super(countersPrefWriter);
        this.f10762k = baseAnalyticsConfig;
        this.f10761j = Collections.synchronizedMap(new WeakHashMap());
    }

    protected final String mo360a() {
        return "web_request_counters";
    }

    public final void m16002b(String str) {
        if (m16000f()) {
            m2591a("total_request", 1);
            Integer num = (Integer) this.f10761j.get(str);
            if (num != null) {
                this.f10761j.put(str, Integer.valueOf(num.intValue() + 1));
                return;
            }
            this.f10761j.put(str, Integer.valueOf(1));
            m2591a("unique_request", 1);
        }
    }

    public final void m16003c(String str) {
        if (m16000f()) {
            m2591a("total_succeed", 1);
            Integer num = (Integer) this.f10761j.remove(str);
            if (num != null) {
                switch (num.intValue()) {
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                        m2591a("succeed_on_first_try", 1);
                        return;
                    case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                        m2591a("succeed_on_second_try", 1);
                        return;
                    case 3:
                        m2591a("succeed_on_third_try", 1);
                        return;
                    default:
                        m2591a("succeed_on_fourth_onward_try", 1);
                        return;
                }
            }
        }
    }

    public final void mo2064e() {
        if (m16000f()) {
            m2591a("ignored_request_due_to_cache_failure", 1);
        }
    }

    private boolean m16000f() {
        return this.f10762k.m3562a() == AnalyticsConfig$Level.CORE_AND_SAMPLED;
    }
}
