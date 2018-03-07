package com.facebook.push.analytics;

import android.accounts.AccountManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.facebook.content.AppInfo;
import com.facebook.inject.InjectorLike;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: in_app_message */
public class GooglePlayServicesDetector {
    private static final Class<?> f10422a = GooglePlayServicesDetector.class;
    private static volatile GooglePlayServicesDetector f10423d;
    private final Context f10424b;
    private final AppInfo f10425c;

    public static com.facebook.push.analytics.GooglePlayServicesDetector m10963a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10423d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.analytics.GooglePlayServicesDetector.class;
        monitor-enter(r1);
        r0 = f10423d;	 Catch:{ all -> 0x003a }
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
        r0 = m10964b(r0);	 Catch:{ all -> 0x0035 }
        f10423d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10423d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.analytics.GooglePlayServicesDetector.a(com.facebook.inject.InjectorLike):com.facebook.push.analytics.GooglePlayServicesDetector");
    }

    private static GooglePlayServicesDetector m10964b(InjectorLike injectorLike) {
        return new GooglePlayServicesDetector((Context) injectorLike.getInstance(Context.class), AppInfo.a(injectorLike));
    }

    @Inject
    public GooglePlayServicesDetector(Context context, AppInfo appInfo) {
        this.f10424b = context;
        this.f10425c = appInfo;
    }

    public final Map<String, String> m10965a() {
        boolean z = false;
        Map<String, String> c = Maps.c();
        c.put("com.android.vending", String.valueOf(m10962a("com.android.vending")));
        PackageInfo d = this.f10425c.d("com.google.android.gms", 64);
        if (d == null) {
            c.put("com.google.android.gms", "0");
            c.put("com.google.android.gsf", String.valueOf(m10962a("com.google.android.gsf")));
            String str = "has_g_account";
            if (AccountManager.get(this.f10424b).getAccountsByType("com.google").length > 0) {
                z = true;
            }
            c.put(str, String.valueOf(z));
        } else {
            c.put("com.google.android.gms", "1");
            c.put("gms_version", String.valueOf(d.versionCode));
            ApplicationInfo e = this.f10425c.e("com.google.android.gms", 0);
            if (e == null) {
                c.put("com.google.android.gms", "0");
            } else {
                c.put("gms_enabled", String.valueOf(e.enabled));
            }
        }
        c.put("gms_availability", String.valueOf(GooglePlayServicesUtil.a(this.f10424b)));
        return c;
    }

    private int m10962a(String str) {
        return this.f10425c.d(str, 0) == null ? 0 : 1;
    }
}
