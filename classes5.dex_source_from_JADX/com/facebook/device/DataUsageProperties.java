package com.facebook.device;

import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: screenshot-%d.png */
public class DataUsageProperties {
    static final PrefKey f2902a;
    public static final PrefKey f2903b;
    public static final PrefKey f2904c = ((PrefKey) f2902a.a("hourly_limit_kb"));
    public static final PrefKey f2905d = ((PrefKey) f2902a.a("alarm_limit_kb"));
    private static volatile DataUsageProperties f2906g;
    private final Class<?> f2907e = DataUsageProperties.class;
    private final FbSharedPreferences f2908f;

    public static com.facebook.device.DataUsageProperties m4039a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2906g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.device.DataUsageProperties.class;
        monitor-enter(r1);
        r0 = f2906g;	 Catch:{ all -> 0x003a }
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
        r0 = m4040b(r0);	 Catch:{ all -> 0x0035 }
        f2906g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2906g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.device.DataUsageProperties.a(com.facebook.inject.InjectorLike):com.facebook.device.DataUsageProperties");
    }

    private static DataUsageProperties m4040b(InjectorLike injectorLike) {
        return new DataUsageProperties((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.e.a("data_usage/");
        f2902a = prefKey;
        f2903b = (PrefKey) prefKey.a("limited");
    }

    @Inject
    public DataUsageProperties(FbSharedPreferences fbSharedPreferences) {
        this.f2908f = fbSharedPreferences;
    }
}
