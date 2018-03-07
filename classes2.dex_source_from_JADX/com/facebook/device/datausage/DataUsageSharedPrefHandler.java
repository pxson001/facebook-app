package com.facebook.device.datausage;

import com.facebook.device.resourcemonitor.DataUsageBytes;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: notifyLoadingFailed() should be called before updating the state to ERROR */
public class DataUsageSharedPrefHandler {
    private static volatile DataUsageSharedPrefHandler f12074c;
    public final FbSharedPreferences f12075a;
    private final DateProvider f12076b;

    public static com.facebook.device.datausage.DataUsageSharedPrefHandler m17781a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12074c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.device.datausage.DataUsageSharedPrefHandler.class;
        monitor-enter(r1);
        r0 = f12074c;	 Catch:{ all -> 0x003a }
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
        r0 = m17783b(r0);	 Catch:{ all -> 0x0035 }
        f12074c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12074c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.device.datausage.DataUsageSharedPrefHandler.a(com.facebook.inject.InjectorLike):com.facebook.device.datausage.DataUsageSharedPrefHandler");
    }

    private static DataUsageSharedPrefHandler m17783b(InjectorLike injectorLike) {
        return new DataUsageSharedPrefHandler(FbSharedPreferencesImpl.m1826a(injectorLike), DateProvider.m17778a(injectorLike));
    }

    @Inject
    public DataUsageSharedPrefHandler(FbSharedPreferences fbSharedPreferences, DateProvider dateProvider) {
        this.f12075a = fbSharedPreferences;
        this.f12076b = dateProvider;
    }

    public final DataUsageBytes m17785a(int i) {
        return m17786b(i).m9249a(new DataUsageBytes(this.f12075a.mo277a(m17782a(DataUsagePrefConstants.f17616e, i), 0), this.f12075a.mo277a(m17782a(DataUsagePrefConstants.f17617f, i), 0)));
    }

    public final DataUsageBytes m17786b(int i) {
        return new DataUsageBytes(this.f12075a.mo277a(m17782a(DataUsagePrefConstants.f17613b, i), 0), this.f12075a.mo277a(m17782a(DataUsagePrefConstants.f17614c, i), 0));
    }

    final void m17787c(int i) {
        m17784b(new DataUsageBytes(0, 0), i);
    }

    final void m17788d(int i) {
        m17784b(m17786b(i), i);
    }

    private void m17784b(DataUsageBytes dataUsageBytes, int i) {
        this.f12075a.edit().mo1275a(m17782a(DataUsagePrefConstants.f17616e, i), dataUsageBytes.f5370b).mo1275a(m17782a(DataUsagePrefConstants.f17617f, i), dataUsageBytes.f5371c).commit();
    }

    public static PrefKey m17782a(PrefKey prefKey, int i) {
        return (PrefKey) ((PrefKey) prefKey.m2011a("/type/")).m2011a(String.valueOf(i));
    }
}
