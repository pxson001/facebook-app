package com.facebook.zero;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.init.INeedInitForSharedPrefsListenerRegistration;
import com.facebook.prefs.shared.init.INeedInitForSharedPrefsListenerRegistration.PrefKeyMatchType;
import com.facebook.zero.common.constants.DialtonePrefKeys;
import com.facebook.zero.common.constants.ZeroPrefKeys;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.facebook.zero.service.FbZeroTokenManager;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: title and description are empty for tooltip. */
public class FbZeroFeatureVisibilityHelper {
    private static volatile FbZeroFeatureVisibilityHelper f4277h;
    private final FbSharedPreferences f4278a;
    private final FbZeroTokenManager f4279b;
    private final Provider<Boolean> f4280c;
    private final Provider<Boolean> f4281d;
    private final FullFbUiFeaturesAccessor f4282e;
    private final Map<PrefKey, Boolean> f4283f = Maps.m838c();
    private volatile boolean f4284g;

    /* compiled from: title and description are empty for tooltip. */
    public class ZeroFeatureVisibilityHelperSharedPrefsListenerRegistration extends INeedInitForSharedPrefsListenerRegistration<FbZeroFeatureVisibilityHelper> {
        protected final void mo667a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey, Object obj) {
            FbZeroFeatureVisibilityHelper.m7917a((FbZeroFeatureVisibilityHelper) obj, prefKey, Boolean.valueOf(fbSharedPreferences.mo286a(prefKey, true)));
        }

        @Inject
        public ZeroFeatureVisibilityHelperSharedPrefsListenerRegistration(Lazy<FbZeroFeatureVisibilityHelper> lazy) {
            super(lazy, ZeroPrefKeys.f2624Y, PrefKeyMatchType.PREFIX);
        }
    }

    public static com.facebook.zero.FbZeroFeatureVisibilityHelper m7916a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4277h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.zero.FbZeroFeatureVisibilityHelper.class;
        monitor-enter(r1);
        r0 = f4277h;	 Catch:{ all -> 0x003a }
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
        r0 = m7918b(r0);	 Catch:{ all -> 0x0035 }
        f4277h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4277h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.FbZeroFeatureVisibilityHelper.a(com.facebook.inject.InjectorLike):com.facebook.zero.FbZeroFeatureVisibilityHelper");
    }

    private static FbZeroFeatureVisibilityHelper m7918b(InjectorLike injectorLike) {
        return new FbZeroFeatureVisibilityHelper(FbSharedPreferencesImpl.m1826a(injectorLike), FbZeroTokenManager.m7926b(injectorLike), IdBasedProvider.m1811a(injectorLike, 4034), IdBasedProvider.m1811a(injectorLike, 3957), FullFbUiFeaturesAccessor.m4716a(injectorLike));
    }

    @Inject
    public FbZeroFeatureVisibilityHelper(FbSharedPreferences fbSharedPreferences, FbZeroTokenManager fbZeroTokenManager, Provider<Boolean> provider, Provider<Boolean> provider2, FullFbUiFeaturesAccessor fullFbUiFeaturesAccessor) {
        this.f4278a = fbSharedPreferences;
        this.f4279b = fbZeroTokenManager;
        this.f4280c = provider;
        this.f4281d = provider2;
        this.f4282e = fullFbUiFeaturesAccessor;
    }

    public static void m7917a(FbZeroFeatureVisibilityHelper fbZeroFeatureVisibilityHelper, PrefKey prefKey, Boolean bool) {
        fbZeroFeatureVisibilityHelper.m7919c();
        fbZeroFeatureVisibilityHelper.f4283f.put(prefKey, bool);
    }

    private void m7919c() {
        if (!this.f4284g) {
            synchronized (this) {
                if (!this.f4284g) {
                    m7920d();
                    this.f4284g = true;
                }
            }
        }
    }

    private void m7920d() {
        for (ZeroFeatureKey a : ZeroFeatureKey.values()) {
            PrefKey a2 = ZeroPrefKeys.m4712a(a);
            this.f4283f.put(a2, Boolean.valueOf(this.f4278a.mo286a(a2, true)));
        }
    }

    public final boolean m7924a(ZeroFeatureKey zeroFeatureKey) {
        if (zeroFeatureKey == ZeroFeatureKey.DIALTONE_PHOTOCAP_SPINNER || zeroFeatureKey == ZeroFeatureKey.DIALTONE_PHOTOCAP_ERROR) {
            return true;
        }
        if (!this.f4278a.mo284a()) {
            return false;
        }
        m7919c();
        if ((!((Boolean) this.f4280c.get()).booleanValue() && !this.f4278a.mo286a(DialtonePrefKeys.f2495r, false)) || !this.f4279b.m7964e().contains(zeroFeatureKey)) {
            return zeroFeatureKey.equals(ZeroFeatureKey.DIALTONE_MANUAL_SWITCHER_MODE) ? m7922f() : false;
        } else {
            if (zeroFeatureKey.equals(ZeroFeatureKey.FB4A_INDICATOR) && m7921e()) {
                return true;
            }
            if (zeroFeatureKey.equals(ZeroFeatureKey.FB4A_INDICATOR) && !m7921e()) {
                return !((Boolean) this.f4281d.get()).booleanValue();
            } else {
                if (zeroFeatureKey.equals(ZeroFeatureKey.DIALTONE_MANUAL_SWITCHER_MODE)) {
                    return m7922f();
                }
                PrefKey a = ZeroPrefKeys.m4712a(zeroFeatureKey);
                return this.f4283f.containsKey(a) ? ((Boolean) this.f4283f.get(a)).booleanValue() : true;
            }
        }
    }

    public final boolean m7923a() {
        return m7924a(ZeroFeatureKey.NATIVE_UPSELL_INTERSTITIAL);
    }

    public final ZeroFeatureKey m7925b() {
        if (m7924a(ZeroFeatureKey.FB4A_INDICATOR)) {
            return ZeroFeatureKey.FB4A_INDICATOR;
        }
        if (m7924a(ZeroFeatureKey.DIALTONE_MANUAL_SWITCHER_MODE)) {
            return ZeroFeatureKey.DIALTONE_MANUAL_SWITCHER_MODE;
        }
        return null;
    }

    private boolean m7921e() {
        return this.f4282e.m4682a(ZeroFeatureKey.FB4A_INDICATOR);
    }

    private boolean m7922f() {
        return m7921e() ? false : ((Boolean) this.f4281d.get()).booleanValue();
    }
}
