package com.facebook.http.onion.prefs;

import android.content.pm.PackageInfo;
import com.facebook.common.util.SecureHashUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.AppInfo;
import com.facebook.debug.log.BLog;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.xconfig.core.XConfigReader;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: serialized_mutation_param */
public class OnionUtils {
    private static volatile OnionUtils f5562e;
    private final AppInfo f5563a;
    private final Lazy<FbSharedPreferences> f5564b;
    private final Lazy<GatekeeperStore> f5565c;
    public final Lazy<XConfigReader> f5566d;

    /* compiled from: serialized_mutation_param */
    /* synthetic */ class C02611 {
        static final /* synthetic */ int[] f5573a = new int[TriState.values().length];

        static {
            try {
                f5573a[TriState.YES.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5573a[TriState.NO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5573a[TriState.UNSET.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static com.facebook.http.onion.prefs.OnionUtils m9473a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5562e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.onion.prefs.OnionUtils.class;
        monitor-enter(r1);
        r0 = f5562e;	 Catch:{ all -> 0x003a }
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
        r0 = m9475b(r0);	 Catch:{ all -> 0x0035 }
        f5562e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5562e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.onion.prefs.OnionUtils.a(com.facebook.inject.InjectorLike):com.facebook.http.onion.prefs.OnionUtils");
    }

    private static OnionUtils m9475b(InjectorLike injectorLike) {
        return new OnionUtils(AppInfo.m8674a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3078), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2128), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3749));
    }

    @Inject
    public OnionUtils(AppInfo appInfo, Lazy<FbSharedPreferences> lazy, Lazy<GatekeeperStore> lazy2, Lazy<XConfigReader> lazy3) {
        this.f5563a = appInfo;
        this.f5564b = lazy;
        this.f5565c = lazy2;
        this.f5566d = lazy3;
    }

    public final boolean m9476a() {
        return m9474a(((GatekeeperStoreImpl) this.f5565c.get()).m2185a(650));
    }

    public final boolean m9477b() {
        return m9474a(((GatekeeperStoreImpl) this.f5565c.get()).m2185a(651));
    }

    private static boolean m9474a(TriState triState) {
        switch (C02611.f5573a[triState.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return true;
            default:
                return false;
        }
    }

    public final boolean m9478c() {
        return m9476a() && ((FbSharedPreferences) this.f5564b.get()).mo286a(OnionPrefKeys.f5576c, false);
    }

    public final boolean m9479d() {
        return m9477b() && ((FbSharedPreferences) this.f5564b.get()).mo286a(OnionPrefKeys.f5575b, false);
    }

    public final boolean m9480g() {
        PackageInfo d = this.f5563a.d("org.torproject.android", 64);
        if (d == null) {
            return false;
        }
        String str;
        if (d.signatures == null || d.signatures.length != 1) {
            str = null;
        } else {
            str = SecureHashUtil.a(d.signatures[0].toByteArray());
        }
        String str2 = str;
        for (String str3 : OrbotSignaturesXConfig.a(((XConfigReader) this.f5566d.get()).m2685a(OrbotSignaturesXConfig.c, "[]"))) {
            if (str3 != null && str3.equals(str2)) {
                return true;
            }
        }
        BLog.a(OnionUtils.class, "rejecting unknown signature %s", new Object[]{str2});
        return false;
    }
}
