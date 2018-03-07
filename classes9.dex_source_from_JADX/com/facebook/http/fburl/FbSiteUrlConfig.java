package com.facebook.http.fburl;

import com.facebook.common.util.StringUtil;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.http.prefs.InternalHttpPrefKeys;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.ultralight.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: p2p_pin_set_fail */
public class FbSiteUrlConfig {
    private static volatile FbSiteUrlConfig f7538e;
    public final Provider<Boolean> f7539a;
    public final FbSharedPreferences f7540b;
    private final boolean f7541c;
    private final Provider<String> f7542d;

    public static com.facebook.http.fburl.FbSiteUrlConfig m7831a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7538e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.fburl.FbSiteUrlConfig.class;
        monitor-enter(r1);
        r0 = f7538e;	 Catch:{ all -> 0x003a }
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
        r0 = m7832b(r0);	 Catch:{ all -> 0x0035 }
        f7538e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7538e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.fburl.FbSiteUrlConfig.a(com.facebook.inject.InjectorLike):com.facebook.http.fburl.FbSiteUrlConfig");
    }

    private static FbSiteUrlConfig m7832b(InjectorLike injectorLike) {
        return new FbSiteUrlConfig(IdBasedProvider.a(injectorLike, 3937), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4476));
    }

    @Inject
    private FbSiteUrlConfig(Provider<Boolean> provider, FbSharedPreferences fbSharedPreferences, Boolean bool, Provider<String> provider2) {
        this.f7539a = provider;
        this.f7540b = fbSharedPreferences;
        this.f7541c = bool.booleanValue();
        this.f7542d = provider2;
    }

    public final String m7833a() {
        if (!((Boolean) this.f7539a.get()).booleanValue()) {
            return "m.facebook.com";
        }
        String a = this.f7540b.a(InternalHttpPrefKeys.q, "default");
        Object obj = -1;
        switch (a.hashCode()) {
            case -1183762670:
                if (a.equals("intern")) {
                    obj = null;
                    break;
                }
                break;
            case 99349:
                if (a.equals("dev")) {
                    obj = 1;
                    break;
                }
                break;
            case 1544803905:
                if (a.equals("default")) {
                    obj = 3;
                    break;
                }
                break;
            case 1865400007:
                if (a.equals("sandbox")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return "m.intern.facebook.com";
            case 1:
                return "m.dev.facebook.com";
            case 2:
            case 3:
                obj = this.f7540b.a(InternalHttpPrefKeys.r, null);
                if (StringUtil.a(obj)) {
                    return "m.facebook.com";
                }
                return "m." + obj;
            default:
                return "m.facebook.com";
        }
    }

    public final String m7834c() {
        if (this.f7541c) {
            String str = (String) this.f7542d.get();
            if (StringUtil.a(str)) {
                return m7833a();
            }
            return str + "." + m7833a();
        }
        throw new UnsupportedOperationException("You're querying community link on not AtWork build");
    }
}
