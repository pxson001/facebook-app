package com.facebook.appinvites.data;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v4.util.LruCache;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: messaging_push_notif */
public class InstalledAppsCache {
    private static volatile InstalledAppsCache f8084c;
    private final PackageManager f8085a;
    private final LruCache f8086b = new LruCache(100);

    public static com.facebook.appinvites.data.InstalledAppsCache m8367a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8084c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.appinvites.data.InstalledAppsCache.class;
        monitor-enter(r1);
        r0 = f8084c;	 Catch:{ all -> 0x003a }
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
        r0 = m8368b(r0);	 Catch:{ all -> 0x0035 }
        f8084c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8084c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appinvites.data.InstalledAppsCache.a(com.facebook.inject.InjectorLike):com.facebook.appinvites.data.InstalledAppsCache");
    }

    private static InstalledAppsCache m8368b(InjectorLike injectorLike) {
        return new InstalledAppsCache(PackageManagerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public InstalledAppsCache(PackageManager packageManager) {
        this.f8085a = packageManager;
    }

    public final boolean m8369a(String str) {
        Boolean bool = (Boolean) this.f8086b.a(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return m8370b(str);
    }

    public final boolean m8370b(String str) {
        boolean z;
        PackageInfo packageInfo = null;
        Preconditions.checkNotNull(str);
        try {
            packageInfo = this.f8085a.getPackageInfo(str, 0);
        } catch (NameNotFoundException e) {
        }
        LruCache lruCache = this.f8086b;
        if (packageInfo != null) {
            z = true;
        } else {
            z = false;
        }
        lruCache.a(str, Boolean.valueOf(z));
        if (packageInfo != null) {
            return true;
        }
        return false;
    }
}
