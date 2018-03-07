package com.facebook.growth.contactimporter;

import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.growth.prefs.CIPrefKeys;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: paymentString */
public final class GrowthUtils {
    private static volatile GrowthUtils f7103d;
    private final FbSharedPreferences f7104a;
    private final Provider<String> f7105b;
    private final GatekeeperStoreImpl f7106c;

    public static com.facebook.growth.contactimporter.GrowthUtils m7382a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7103d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.growth.contactimporter.GrowthUtils.class;
        monitor-enter(r1);
        r0 = f7103d;	 Catch:{ all -> 0x003a }
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
        r0 = m7384b(r0);	 Catch:{ all -> 0x0035 }
        f7103d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7103d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.growth.contactimporter.GrowthUtils.a(com.facebook.inject.InjectorLike):com.facebook.growth.contactimporter.GrowthUtils");
    }

    private static GrowthUtils m7384b(InjectorLike injectorLike) {
        return new GrowthUtils((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 4442), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public GrowthUtils(FbSharedPreferences fbSharedPreferences, Provider<String> provider, GatekeeperStore gatekeeperStore) {
        this.f7104a = fbSharedPreferences;
        this.f7106c = gatekeeperStore;
        this.f7105b = provider;
    }

    private PrefKey m7383a(PrefKey prefKey) {
        String str = (String) this.f7105b.get();
        if (str == null) {
            str = "0";
        }
        return (PrefKey) prefKey.a(str);
    }

    public final void m7385a() {
        this.f7104a.edit().putBoolean(m7383a(CIPrefKeys.b), true).commit();
    }

    public final boolean m7386b() {
        if (TriState.NO.equals(this.f7106c.a(32)) && this.f7104a.a(m7383a(CIPrefKeys.b), false)) {
            return false;
        }
        return true;
    }
}
