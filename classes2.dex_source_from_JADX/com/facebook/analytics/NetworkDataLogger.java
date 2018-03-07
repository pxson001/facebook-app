package com.facebook.analytics;

import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.device.datausage.DataUsageSyncer;
import com.facebook.http.common.NetworkDataLogUtils;
import com.facebook.http.observer.HttpFlowStatistics;
import com.facebook.http.observer.RequestContext;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import java.net.URI;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

@Singleton
@ThreadSafe
/* compiled from: null reference */
public class NetworkDataLogger {
    private static final Class<?> f12030a = NetworkDataLogger.class;
    private static final ImmutableList<Product> f12031b = ImmutableList.of(Product.MESSENGER);
    private static volatile NetworkDataLogger f12032i;
    private final DataUsageCounters f12033c;
    private final FeatureDataUsageCounters f12034d;
    public final AppStateManager f12035e;
    public final NetworkDataCategorizer f12036f;
    private final DataUsageSyncer f12037g;
    private final FbAppType f12038h;

    public static com.facebook.analytics.NetworkDataLogger m17732a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12032i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.NetworkDataLogger.class;
        monitor-enter(r1);
        r0 = f12032i;	 Catch:{ all -> 0x003a }
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
        r0 = m17737b(r0);	 Catch:{ all -> 0x0035 }
        f12032i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12032i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.NetworkDataLogger.a(com.facebook.inject.InjectorLike):com.facebook.analytics.NetworkDataLogger");
    }

    private static NetworkDataLogger m17737b(InjectorLike injectorLike) {
        return new NetworkDataLogger(DataUsageCounters.m2584a(injectorLike), FeatureDataUsageCounters.m17740a(injectorLike), AppStateManager.m2245a(injectorLike), NetworkDataCategorizer.m17747b(injectorLike), DataUsageSyncer.m17752a(injectorLike), (FbAppType) injectorLike.getInstance(FbAppType.class));
    }

    @Inject
    public NetworkDataLogger(DataUsageCounters dataUsageCounters, FeatureDataUsageCounters featureDataUsageCounters, AppStateManager appStateManager, NetworkDataCategorizer networkDataCategorizer, DataUsageSyncer dataUsageSyncer, FbAppType fbAppType) {
        this.f12033c = dataUsageCounters;
        this.f12034d = featureDataUsageCounters;
        this.f12035e = appStateManager;
        this.f12036f = networkDataCategorizer;
        this.f12037g = dataUsageSyncer;
        this.f12038h = fbAppType;
    }

    private String m17735a(URI uri, String str) {
        String str2 = this.f12036f.m17750a(uri) + m17734a(str) + "_received";
        if (this.f12035e.m2262j()) {
            return str2 + "_bg";
        }
        return str2;
    }

    private String m17736a(HttpContext httpContext, URI uri, String str) {
        CallerContext callerContext = RequestContext.m17674a(httpContext).f11982f;
        String str2 = this.f12036f.m17750a(uri) + m17734a(str);
        String str3 = "ACTIVE";
        if (this.f12035e.m2262j()) {
            str3 = "BACKGROUND";
        }
        Joiner useForNull = Joiner.on(":").useForNull("unknown");
        String a = m17733a(callerContext);
        String str4 = "RECEIVED";
        Object[] objArr = new Object[3];
        objArr[0] = str2;
        objArr[1] = str3;
        objArr[2] = callerContext == null ? null : callerContext.m9067b();
        return useForNull.join(a, str4, objArr);
    }

    private static String m17734a(String str) {
        String str2 = "";
        if (str == null) {
            return str2;
        }
        int indexOf = str.indexOf("/");
        if (indexOf > 0) {
            return "_" + str.substring(0, indexOf);
        }
        return str2;
    }

    public final void m17739a(URI uri, HttpFlowStatistics httpFlowStatistics, HttpContext httpContext, @Nullable HttpResponse httpResponse) {
        String str;
        CallerContext callerContext = RequestContext.m17674a(httpContext).f11982f;
        if (callerContext == null || callerContext.m9067b() == null || !callerContext.m9067b().equals("audio_upload")) {
            str = this.f12036f.m17750a(uri) + "_sent";
        } else {
            str = "audio_upload_sent";
        }
        if (this.f12035e.m2262j()) {
            str = str + "_bg";
        }
        String str2 = str;
        String b = m17738b(httpContext, uri);
        long i = httpFlowStatistics.m17700i();
        this.f12033c.m2591a(str2, i);
        this.f12034d.m2591a(b, i);
        if (httpResponse != null) {
            str2 = NetworkDataLogUtils.m15996a(httpResponse);
            String a = m17735a(uri, str2);
            String a2 = m17736a(httpContext, uri, str2);
            long count = httpFlowStatistics.responseHeaderBytes.getCount();
            long count2 = httpFlowStatistics.responseBodyBytes.getCount();
            if (count2 >= 0) {
                count += count2;
            }
            this.f12033c.m2591a(a, count);
            this.f12034d.m2591a(a2, count);
            this.f12037g.m17754a();
        }
    }

    private String m17738b(HttpContext httpContext, URI uri) {
        CallerContext callerContext = RequestContext.m17674a(httpContext).f11982f;
        String a = this.f12036f.m17750a(uri);
        String str = "ACTIVE";
        if (this.f12035e.m2262j()) {
            str = "BACKGROUND";
        }
        Joiner useForNull = Joiner.on(":").useForNull("unknown");
        String a2 = m17733a(callerContext);
        String str2 = "SENT";
        Object[] objArr = new Object[3];
        objArr[0] = a;
        objArr[1] = str;
        objArr[2] = callerContext == null ? null : callerContext.m9067b();
        return useForNull.join(a2, str2, objArr);
    }

    @Nullable
    private String m17733a(@Nullable CallerContext callerContext) {
        if (callerContext == null) {
            return null;
        }
        if (callerContext.m9067b() == null || !f12031b.contains(this.f12038h.j)) {
            return callerContext.f5181b;
        }
        return null;
    }
}
