package com.facebook.analytics.counter;

import com.facebook.common.util.StringUtil;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import javax.inject.Singleton;

@Singleton
/* compiled from: user_left_app */
public class CountersPrefKeyUtil {
    public static PrefKey f1440a = ((PrefKey) SharedPrefKeys.f987a.m2011a("analytics_counters/"));
    @VisibleForTesting
    static String f1441b = "data";
    @VisibleForTesting
    static String f1442c = "last_update_time";
    public static String f1443d = "/";
    private static volatile CountersPrefKeyUtil f1444e;

    public static com.facebook.analytics.counter.CountersPrefKeyUtil m2780a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f1444e;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.analytics.counter.CountersPrefKeyUtil.class;
        monitor-enter(r1);
        r0 = f1444e;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m2779a();	 Catch:{ all -> 0x0034 }
        f1444e = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f1444e;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.counter.CountersPrefKeyUtil.a(com.facebook.inject.InjectorLike):com.facebook.analytics.counter.CountersPrefKeyUtil");
    }

    private static CountersPrefKeyUtil m2779a() {
        return new CountersPrefKeyUtil();
    }

    @VisibleForTesting
    private PrefKey m2783c(String str, String str2) {
        Preconditions.checkArgument(!StringUtil.m3589a((CharSequence) str2), "Should specify counters name");
        Preconditions.checkArgument(!StringUtil.m3589a((CharSequence) str), "Cannot handle null process name");
        return (PrefKey) ((PrefKey) f1440a.m2011a(str + f1443d)).m2011a(str2 + f1443d);
    }

    final PrefKey m2784a(String str, String str2) {
        return (PrefKey) m2783c(str, str2).m2011a(f1442c);
    }

    final PrefKey m2785b(String str, String str2) {
        return (PrefKey) m2783c(str, str2).m2011a(f1441b);
    }

    @VisibleForTesting
    static String[] m2781a(PrefKey prefKey) {
        Preconditions.checkArgument(prefKey.m2013a(f1440a), "Invalid counters prefkey");
        return prefKey.m2014b(f1440a).split(f1443d, 3);
    }

    static boolean m2782b(PrefKey prefKey) {
        return prefKey.m2013a(f1440a) && prefKey.m2012a().endsWith(f1441b);
    }
}
