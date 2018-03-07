package com.facebook.config.server;

import android.net.Uri;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.http.config.PlatformAppHttpConfig;
import com.facebook.http.config.SimplePlatformAppHttpConfig;
import com.facebook.http.prefs.InternalHttpPrefKeys;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: sequence_number */
public class DefaultServerConfig implements ServerConfig {
    private static volatile DefaultServerConfig f2831m;
    private final FbSharedPreferences f2832a;
    private final BaseFbBroadcastManager f2833b;
    private final Provider<Boolean> f2834c;
    private final Provider<Boolean> f2835d;
    private final AppStateManager f2836e;
    private final UserAgentFactory f2837f;
    private final PlatformAppHttpConfig f2838g;
    private final OnSharedPreferenceChangeListener f2839h;
    private final Provider<String> f2840i;
    @GuardedBy("this")
    private PlatformAppHttpConfig f2841j;
    @GuardedBy("this")
    private PlatformAppHttpConfig f2842k;
    @GuardedBy("this")
    private boolean f2843l = false;

    /* compiled from: sequence_number */
    class C02021 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ DefaultServerConfig f2830a;

        C02021(DefaultServerConfig defaultServerConfig) {
            this.f2830a = defaultServerConfig;
        }

        public final void m3959a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
            DefaultServerConfig.m3964g(this.f2830a);
        }
    }

    public static com.facebook.config.server.DefaultServerConfig m3960a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2831m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.config.server.DefaultServerConfig.class;
        monitor-enter(r1);
        r0 = f2831m;	 Catch:{ all -> 0x003a }
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
        r0 = m3962b(r0);	 Catch:{ all -> 0x0035 }
        f2831m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2831m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.config.server.DefaultServerConfig.a(com.facebook.inject.InjectorLike):com.facebook.config.server.DefaultServerConfig");
    }

    private static DefaultServerConfig m3962b(InjectorLike injectorLike) {
        return new DefaultServerConfig((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), IdBasedProvider.a(injectorLike, 3937), IdBasedProvider.a(injectorLike, 3934), AppStateManager.a(injectorLike), UserAgentFactory.b(injectorLike), IdBasedProvider.a(injectorLike, 4448));
    }

    @Inject
    public DefaultServerConfig(FbSharedPreferences fbSharedPreferences, FbBroadcastManager fbBroadcastManager, Provider<Boolean> provider, Provider<Boolean> provider2, AppStateManager appStateManager, UserAgentFactory userAgentFactory, Provider<String> provider3) {
        this.f2832a = fbSharedPreferences;
        this.f2833b = fbBroadcastManager;
        this.f2834c = provider;
        this.f2835d = provider2;
        this.f2836e = appStateManager;
        this.f2837f = userAgentFactory;
        this.f2840i = provider3;
        this.f2838g = new PresenceAwarePlatformHttpConfig(new SimplePlatformAppHttpConfig("facebook.com", "", this.f2840i), appStateManager, this.f2837f.a());
        this.f2839h = new C02021(this);
    }

    @GuardedBy("this")
    private void m3963f() {
        if (!this.f2843l) {
            this.f2843l = true;
            this.f2832a.c(InternalHttpPrefKeys.p, this.f2839h);
        }
    }

    public static synchronized void m3964g(DefaultServerConfig defaultServerConfig) {
        synchronized (defaultServerConfig) {
            if (defaultServerConfig.f2841j != null) {
                defaultServerConfig.f2841j = null;
                defaultServerConfig.f2833b.a("com.facebook.config.server.ACTION_SERVER_CONFIG_CHANGED");
            }
        }
    }

    public final synchronized PlatformAppHttpConfig m3967a() {
        m3965h();
        this.f2841j.b();
        return this.f2841j;
    }

    public final PlatformAppHttpConfig m3968b() {
        return this.f2838g;
    }

    public final synchronized PlatformAppHttpConfig m3969c() {
        m3966i();
        return this.f2842k;
    }

    public final String m3970d() {
        return this.f2837f.a();
    }

    public final String m3971e() {
        UserAgentFactory userAgentFactory = this.f2837f;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(StringFormatUtil.formatStrLocaleSafe("[%s/%s;%s/%s;]", "FBAN", userAgentFactory.d, "FBAV", UserAgentFactory.a(userAgentFactory.b.a())));
        return stringBuilder.toString();
    }

    private PlatformAppHttpConfig m3961a(String str, String str2) {
        return new PresenceAwarePlatformHttpConfig(new SimplePlatformAppHttpConfig(str, str2, this.f2840i), this.f2836e, m3970d());
    }

    @GuardedBy("this")
    private void m3965h() {
        if (this.f2841j == null) {
            m3963f();
            if (((Boolean) this.f2834c.get()).booleanValue()) {
                Object obj;
                String a = this.f2832a.a(InternalHttpPrefKeys.q, "default");
                Object a2 = this.f2832a.a(InternalHttpPrefKeys.t, "");
                if ("intern".equals(a)) {
                    obj = "intern.facebook.com";
                } else if ("dev".equals(a)) {
                    obj = "dev.facebook.com";
                } else if ("production".equals(a)) {
                    obj = null;
                } else {
                    obj = this.f2832a.a(InternalHttpPrefKeys.r, null);
                    if (StringUtil.a(obj)) {
                        obj = "facebook.com";
                    } else {
                        try {
                            Uri.parse(obj);
                        } catch (Throwable th) {
                            BLog.a("DefaultServerConfig", "Failed to parse web sandbox URL", th);
                            obj = null;
                        }
                    }
                }
                if (!(StringUtil.a(obj) && StringUtil.a(a2))) {
                    this.f2841j = m3961a(obj, a2);
                }
            }
            if (this.f2841j == null) {
                this.f2841j = this.f2838g;
            }
        }
    }

    @GuardedBy("this")
    private void m3966i() {
        if (this.f2842k == null) {
            m3963f();
            if (((Boolean) this.f2835d.get()).booleanValue()) {
                this.f2842k = new PresenceAwarePlatformHttpConfig(new BootstrapPlatformAppHttpConfig(this.f2840i), this.f2836e, m3970d());
            } else {
                this.f2842k = m3967a();
            }
        }
    }
}
