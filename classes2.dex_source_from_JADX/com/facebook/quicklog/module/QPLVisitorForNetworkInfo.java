package com.facebook.quicklog.module;

import android.util.SparseArray;
import com.facebook.http.common.CachedNetworkInfoCollector;
import com.facebook.http.observer.NetworkInfo;
import com.facebook.http.observer.NetworkInfoCollector;
import com.facebook.inject.InjectorLike;
import com.facebook.quicklog.PerformanceLoggingEvent;
import com.facebook.quicklog.PerformanceLoggingEventVisitor;
import com.facebook.quicklog.driver.analytics1.DefaultHoneySamplingPolicy;
import com.facebook.quicklog.driver.analytics1.DefaultHoneySamplingPolicy.WrapperHoneySamplingConfig;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: uploaded_date */
public class QPLVisitorForNetworkInfo implements PerformanceLoggingEventVisitor {
    private static volatile QPLVisitorForNetworkInfo f1604d;
    private final SparseArray<Integer> f1605a = new SparseArray();
    private final NetworkInfoCollector f1606b;
    private final DefaultHoneySamplingPolicy f1607c;

    public static com.facebook.quicklog.module.QPLVisitorForNetworkInfo m3222a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1604d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.quicklog.module.QPLVisitorForNetworkInfo.class;
        monitor-enter(r1);
        r0 = f1604d;	 Catch:{ all -> 0x003a }
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
        r0 = m3223b(r0);	 Catch:{ all -> 0x0035 }
        f1604d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1604d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.quicklog.module.QPLVisitorForNetworkInfo.a(com.facebook.inject.InjectorLike):com.facebook.quicklog.module.QPLVisitorForNetworkInfo");
    }

    private static QPLVisitorForNetworkInfo m3223b(InjectorLike injectorLike) {
        return new QPLVisitorForNetworkInfo(CachedNetworkInfoCollector.m3227a(injectorLike), HoneySamplingPolicyMethodAutoProvider.m2861a(injectorLike));
    }

    @Inject
    public QPLVisitorForNetworkInfo(NetworkInfoCollector networkInfoCollector, DefaultHoneySamplingPolicy defaultHoneySamplingPolicy) {
        this.f1606b = networkInfoCollector;
        this.f1607c = defaultHoneySamplingPolicy;
    }

    public final void m3225a(int i) {
        synchronized (this.f1605a) {
            this.f1605a.put(i, Integer.valueOf(0));
        }
    }

    private boolean m3224b(int i) {
        if (this.f1606b == null) {
            return false;
        }
        int intValue;
        synchronized (this.f1605a) {
            Integer num = (Integer) this.f1605a.get(i);
            if (num != null) {
                intValue = num.intValue();
            } else {
                intValue = Integer.MAX_VALUE;
            }
        }
        if (intValue == Integer.MAX_VALUE) {
            return false;
        }
        WrapperHoneySamplingConfig a = this.f1607c.m2927a();
        return a != null ? this.f1607c.m2926a(a.m4464a(6094849)) != Integer.MAX_VALUE : this.f1607c.m2926a(intValue) != Integer.MAX_VALUE;
    }

    public final void mo494a(PerformanceLoggingEvent performanceLoggingEvent) {
        if (m3224b(performanceLoggingEvent.f7937k)) {
            NetworkInfo a = this.f1606b.mo495a();
            if (a != null) {
                performanceLoggingEvent.m12522a(a.m27417b());
            }
        }
    }
}
