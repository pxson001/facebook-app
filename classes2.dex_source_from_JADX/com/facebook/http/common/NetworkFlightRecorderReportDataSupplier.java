package com.facebook.http.common;

import com.facebook.common.errorreporting.FbCustomReportDataSupplier;
import com.facebook.common.flightrecorder.FbHttpNetworkCustomDataSupplier;
import com.facebook.common.flightrecorder.FlightRecorderEvent;
import com.facebook.common.flightrecorder.STATICDI_MULTIBIND_PROVIDER$FbHttpNetworkCustomDataSupplier;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: trending */
public class NetworkFlightRecorderReportDataSupplier implements FbCustomReportDataSupplier {
    private static final Comparator<FlightRecorderEvent> f2250c = new C01491();
    private static volatile NetworkFlightRecorderReportDataSupplier f2251d;
    private final Lazy<Set<FbHttpNetworkCustomDataSupplier>> f2252a;
    private final Provider<FbHttpRequestProcessor> f2253b;

    /* compiled from: trending */
    final class C01491 implements Comparator<FlightRecorderEvent> {
        C01491() {
        }

        public final int compare(Object obj, Object obj2) {
            return Long.valueOf(((FlightRecorderEvent) obj).getStartTime()).compareTo(Long.valueOf(((FlightRecorderEvent) obj2).getStartTime()));
        }
    }

    public static com.facebook.http.common.NetworkFlightRecorderReportDataSupplier m4422a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2251d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.common.NetworkFlightRecorderReportDataSupplier.class;
        monitor-enter(r1);
        r0 = f2251d;	 Catch:{ all -> 0x003a }
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
        r0 = m4424b(r0);	 Catch:{ all -> 0x0035 }
        f2251d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2251d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.common.NetworkFlightRecorderReportDataSupplier.a(com.facebook.inject.InjectorLike):com.facebook.http.common.NetworkFlightRecorderReportDataSupplier");
    }

    private static NetworkFlightRecorderReportDataSupplier m4424b(InjectorLike injectorLike) {
        return new NetworkFlightRecorderReportDataSupplier(ProviderLazy.m1699a(new STATICDI_MULTIBIND_PROVIDER$FbHttpNetworkCustomDataSupplier(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()), IdBasedSingletonScopeProvider.m1809a(injectorLike, 2217));
    }

    @Inject
    public NetworkFlightRecorderReportDataSupplier(Lazy<Set<FbHttpNetworkCustomDataSupplier>> lazy, Provider<FbHttpRequestProcessor> provider) {
        this.f2252a = lazy;
        this.f2253b = provider;
    }

    public final String mo633a(Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList a = Lists.m1296a();
        for (FbHttpNetworkCustomDataSupplier a2 : (Set) this.f2252a.get()) {
            a.addAll(a2.mo559a());
        }
        Collections.sort(a, f2250c);
        int size = a.size();
        for (int i = 0; i < size; i++) {
            FlightRecorderEvent flightRecorderEvent = (FlightRecorderEvent) a.get(i);
            stringBuilder.append(StringFormatUtil.formatStrLocaleSafe("[%s] %s%n", Long.valueOf(flightRecorderEvent.getStartTime()), flightRecorderEvent.mo2286a()));
        }
        stringBuilder.append(FbHttpRequestProcessor.m12265i((FbHttpRequestProcessor) this.f2253b.get()).mo1699c());
        RequestProcessorSnapshot a3 = ((FbHttpRequestProcessor) this.f2253b.get()).m12266a();
        stringBuilder.append("In flight requests: \n");
        m4423a(stringBuilder, FbHttpUtils.a(a3.a));
        stringBuilder.append("In queue requests: \n");
        m4423a(stringBuilder, FbHttpUtils.a(a3.b));
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    private static void m4423a(StringBuilder stringBuilder, List<String> list) {
        for (String append : list) {
            stringBuilder.append(append).append("\n");
        }
    }

    public final String mo632a() {
        return "network_log";
    }
}
