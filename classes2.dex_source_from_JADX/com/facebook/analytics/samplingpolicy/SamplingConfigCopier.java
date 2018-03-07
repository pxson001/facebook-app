package com.facebook.analytics.samplingpolicy;

import android.text.TextUtils;
import com.facebook.analytics.prefs.AnalyticsPrefKeys;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: userAgent */
public class SamplingConfigCopier {
    private static volatile SamplingConfigCopier f1482b;
    FbSharedPreferences f1483a;

    public static com.facebook.analytics.samplingpolicy.SamplingConfigCopier m2876a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1482b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.samplingpolicy.SamplingConfigCopier.class;
        monitor-enter(r1);
        r0 = f1482b;	 Catch:{ all -> 0x003a }
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
        r0 = m2877b(r0);	 Catch:{ all -> 0x0035 }
        f1482b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1482b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.samplingpolicy.SamplingConfigCopier.a(com.facebook.inject.InjectorLike):com.facebook.analytics.samplingpolicy.SamplingConfigCopier");
    }

    private static SamplingConfigCopier m2877b(InjectorLike injectorLike) {
        return new SamplingConfigCopier(FbSharedPreferencesImpl.m1826a(injectorLike));
    }

    @Inject
    public SamplingConfigCopier(FbSharedPreferences fbSharedPreferences) {
        this.f1483a = fbSharedPreferences;
    }

    public final void m2878a(AnalyticsLoggingPolicy analyticsLoggingPolicy) {
        if (this.f1483a.mo284a()) {
            String a = this.f1483a.mo278a(AnalyticsPrefKeys.f4987i, "");
            String a2 = this.f1483a.mo278a(AnalyticsPrefKeys.f4986h, "");
            if (!TextUtils.isEmpty(a) && !TextUtils.isEmpty(a2)) {
                analyticsLoggingPolicy.m2873a(a, a2);
                this.f1483a.edit().mo1271a(AnalyticsPrefKeys.f4987i).mo1271a(AnalyticsPrefKeys.f4986h).commit();
            }
        }
    }
}
