package com.facebook.quicklog.module;

import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.common.util.TriState;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: use_signal_connected_wifi */
public class StandardDebugAndTestConfig {
    public static final PrefKey f1501a = ((PrefKey) SharedPrefKeys.f989c.m2011a("perfmarker_to_logcat"));
    private static volatile StandardDebugAndTestConfig f1502d;
    private FbSharedPreferences f1503b;
    private PerfTestConfig f1504c;

    public static com.facebook.quicklog.module.StandardDebugAndTestConfig m2930a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1502d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.quicklog.module.StandardDebugAndTestConfig.class;
        monitor-enter(r1);
        r0 = f1502d;	 Catch:{ all -> 0x003a }
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
        r0 = m2931b(r0);	 Catch:{ all -> 0x0035 }
        f1502d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1502d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.quicklog.module.StandardDebugAndTestConfig.a(com.facebook.inject.InjectorLike):com.facebook.quicklog.module.StandardDebugAndTestConfig");
    }

    private static StandardDebugAndTestConfig m2931b(InjectorLike injectorLike) {
        return new StandardDebugAndTestConfig(FbSharedPreferencesImpl.m1826a(injectorLike), PerfTestConfig.m2936a(injectorLike));
    }

    @Inject
    public StandardDebugAndTestConfig(FbSharedPreferences fbSharedPreferences, PerfTestConfig perfTestConfig) {
        this.f1503b = fbSharedPreferences;
        this.f1504c = perfTestConfig;
    }

    public final TriState m2932a() {
        if (this.f1503b.mo284a()) {
            return this.f1503b.mo286a(f1501a, false) ? TriState.YES : TriState.NO;
        } else {
            return TriState.UNSET;
        }
    }

    public final boolean m2933b() {
        return PerfTestConfigBase.m2938a();
    }

    public final boolean m2935e() {
        return PerfTestConfigBase.f1523r;
    }

    public final boolean m2934d() {
        return PerfTestConfigBase.f1522q;
    }
}
