package com.facebook.apptab.state;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.marketplace.tab.abtest.ExperimentsForMarketplaceTabAbtestModule;
import com.facebook.notifications.notificationsfriending.abtest.NotificationsFriendingExperimentController;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.redspace.entry.RedSpaceEntryPointCapability;
import com.facebook.video.videohome.abtest.ExperimentsForVideoHomeAbTestModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: string/common_google_play_services_unknown_issue */
public class TabBarStateManager implements IHaveUserData {
    private static Class<TabBarStateManager> f3986a = TabBarStateManager.class;
    private static volatile TabBarStateManager f3987m;
    private final FbSharedPreferences f3988b;
    private final ObjectMapper f3989c;
    private final RTLUtil f3990d;
    private final RedSpaceEntryPointCapability f3991e;
    private final boolean f3992f;
    private NavigationConfig f3993g;
    private NavigationImmersiveConfig f3994h;
    private NavigationMemoryConfig f3995i;
    private NotificationsFriendingExperimentController f3996j;
    private QeAccessor f3997k;
    private Provider<Boolean> f3998l;

    public static com.facebook.apptab.state.TabBarStateManager m6591a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3987m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.apptab.state.TabBarStateManager.class;
        monitor-enter(r1);
        r0 = f3987m;	 Catch:{ all -> 0x003a }
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
        r0 = m6593b(r0);	 Catch:{ all -> 0x0035 }
        f3987m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3987m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.apptab.state.TabBarStateManager.a(com.facebook.inject.InjectorLike):com.facebook.apptab.state.TabBarStateManager");
    }

    private static TabBarStateManager m6593b(InjectorLike injectorLike) {
        return new TabBarStateManager(FbSharedPreferencesImpl.m1826a(injectorLike), NotificationsFriendingExperimentController.m6599a(injectorLike), FbObjectMapperMethodAutoProvider.m6609a(injectorLike), RTLUtil.m6553a(injectorLike), RedSpaceEntryPointCapability.m7792b(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3967), TabStateModule.m7796b());
    }

    @Inject
    public TabBarStateManager(FbSharedPreferences fbSharedPreferences, NotificationsFriendingExperimentController notificationsFriendingExperimentController, ObjectMapper objectMapper, RTLUtil rTLUtil, RedSpaceEntryPointCapability redSpaceEntryPointCapability, QeAccessor qeAccessor, Provider<Boolean> provider, Boolean bool) {
        this.f3988b = fbSharedPreferences;
        this.f3996j = notificationsFriendingExperimentController;
        this.f3989c = objectMapper;
        this.f3990d = rTLUtil;
        this.f3991e = redSpaceEntryPointCapability;
        this.f3997k = qeAccessor;
        this.f3998l = provider;
        this.f3992f = bool.booleanValue();
    }

    public final synchronized void m6595a(NavigationImmersiveConfig navigationImmersiveConfig) {
        try {
            this.f3988b.edit().mo1276a(AppTabPrefKeys.f8140a, this.f3989c.m6659a((Object) navigationImmersiveConfig)).commit();
        } catch (Throwable e) {
            BLog.a(f3986a, "Can't write immersive navigation config to shared pref", e);
        }
    }

    public final synchronized void m6596a(NavigationMemoryConfig navigationMemoryConfig) {
        try {
            this.f3988b.edit().mo1276a(AppTabPrefKeys.f8141b, this.f3989c.m6659a((Object) navigationMemoryConfig)).commit();
        } catch (Throwable e) {
            BLog.a(f3986a, "Can't write memory navigation config to shared pref", e);
        }
    }

    public final synchronized NavigationConfig m6594a() {
        NavigationConfig navigationConfig;
        boolean z = true;
        synchronized (this) {
            boolean z2;
            boolean a = this.f3997k.mo596a(ExperimentsForVideoHomeAbTestModule.f7002p, false);
            boolean z3 = ((Boolean) this.f3998l.get()).booleanValue() && this.f3997k.mo596a(ExperimentsForMarketplaceTabAbtestModule.f7031a, false);
            boolean b = this.f3996j.m6601b();
            if (!b || this.f3996j.m6606n()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (b) {
                z = false;
            }
            if (this.f3993g == null || this.f3993g.m11583f() != this.f3990d.m6557a()) {
                this.f3993g = new NavigationConfig(this.f3990d.m6557a(), this.f3991e.m7794b(), a, z3, z2, this.f3992f, z);
            }
            navigationConfig = this.f3993g;
        }
        return navigationConfig;
    }

    public final synchronized NavigationImmersiveConfig m6597b() {
        if (this.f3994h == null) {
            this.f3994h = (NavigationImmersiveConfig) m6592a(AppTabPrefKeys.f8140a, NavigationImmersiveConfig.class);
            if (this.f3994h == null) {
                this.f3994h = NavigationImmersiveConfig.a();
            }
        }
        return this.f3994h;
    }

    public final synchronized NavigationMemoryConfig m6598c() {
        if (this.f3995i == null) {
            this.f3995i = (NavigationMemoryConfig) m6592a(AppTabPrefKeys.f8141b, NavigationMemoryConfig.class);
            if (this.f3995i == null) {
                this.f3995i = NavigationMemoryConfig.m13803a();
            }
        }
        return this.f3995i;
    }

    private <T> T m6592a(PrefKey prefKey, Class<T> cls) {
        T t = null;
        try {
            this.f3988b.mo292c();
            String a = this.f3988b.mo278a(prefKey, null);
            if (a != null) {
                t = this.f3989c.m6657a(a, (Class) cls);
            }
        } catch (Throwable e) {
            BLog.a(f3986a, "Parse error reading navigation config from shared pref", e);
        } catch (Throwable e2) {
            BLog.b(f3986a, "Shared prefs initialization wait was interrupted", e2);
        }
        return t;
    }

    public void clearUserData() {
        this.f3993g = null;
        this.f3994h = null;
        this.f3995i = null;
    }
}
