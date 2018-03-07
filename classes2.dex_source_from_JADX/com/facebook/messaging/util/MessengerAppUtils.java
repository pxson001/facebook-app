package com.facebook.messaging.util;

import android.content.pm.PackageInfo;
import com.facebook.config.versioninfo.VersionStringComparator;
import com.facebook.config.versioninfo.module.VersionStringComparatorMethodAutoProvider;
import com.facebook.content.AppInfo;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messages.ipc.MessengerUserUtils;
import com.facebook.messaging.appspecific.PackageNameResolver;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: sig */
public class MessengerAppUtils {
    private static volatile MessengerAppUtils f4829e;
    private final VersionStringComparator f4830a;
    private final AppInfo f4831b;
    private final Provider<String> f4832c;
    private final MessengerUserUtils f4833d;

    public static com.facebook.messaging.util.MessengerAppUtils m8662a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4829e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.util.MessengerAppUtils.class;
        monitor-enter(r1);
        r0 = f4829e;	 Catch:{ all -> 0x003a }
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
        r0 = m8663b(r0);	 Catch:{ all -> 0x0035 }
        f4829e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4829e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.util.MessengerAppUtils.a(com.facebook.inject.InjectorLike):com.facebook.messaging.util.MessengerAppUtils");
    }

    private static MessengerAppUtils m8663b(InjectorLike injectorLike) {
        return new MessengerAppUtils(VersionStringComparatorMethodAutoProvider.m8670a(injectorLike), AppInfo.m8674a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4442), MessengerUserUtils.m8677a(injectorLike));
    }

    @Inject
    public MessengerAppUtils(VersionStringComparator versionStringComparator, AppInfo appInfo, Provider<String> provider, MessengerUserUtils messengerUserUtils) {
        this.f4830a = versionStringComparator;
        this.f4831b = appInfo;
        this.f4832c = provider;
        this.f4833d = messengerUserUtils;
    }

    public final boolean m8664a() {
        return m8669e() != null;
    }

    public final boolean m8666b() {
        PackageInfo e = m8669e();
        return e != null && e.applicationInfo.enabled;
    }

    public final boolean m8665a(String str) {
        String c = m8667c();
        if (c == null || this.f4830a.m8673a(c, str) < 0) {
            return false;
        }
        return true;
    }

    public final String m8667c() {
        PackageInfo e = m8669e();
        if (e != null) {
            return e.versionName;
        }
        return null;
    }

    public final boolean m8668d() {
        return this.f4833d.m8681a((String) this.f4832c.get()).f4844a;
    }

    public final PackageInfo m8669e() {
        return this.f4831b.c(PackageNameResolver.a(), 0);
    }
}
