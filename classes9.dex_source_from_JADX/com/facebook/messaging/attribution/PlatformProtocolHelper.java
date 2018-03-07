package com.facebook.messaging.attribution;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.platform.MessengerPlatformConfigManager;
import com.google.common.annotations.VisibleForTesting;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: oui */
public class PlatformProtocolHelper {
    private static volatile PlatformProtocolHelper f7909c;
    private final Context f7910a;
    private final MessengerPlatformConfigManager f7911b;

    public static com.facebook.messaging.attribution.PlatformProtocolHelper m8118a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7909c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.attribution.PlatformProtocolHelper.class;
        monitor-enter(r1);
        r0 = f7909c;	 Catch:{ all -> 0x003a }
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
        r0 = m8119b(r0);	 Catch:{ all -> 0x0035 }
        f7909c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7909c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.attribution.PlatformProtocolHelper.a(com.facebook.inject.InjectorLike):com.facebook.messaging.attribution.PlatformProtocolHelper");
    }

    private static PlatformProtocolHelper m8119b(InjectorLike injectorLike) {
        return new PlatformProtocolHelper((Context) injectorLike.getInstance(Context.class), MessengerPlatformConfigManager.a(injectorLike));
    }

    @Inject
    public PlatformProtocolHelper(Context context, MessengerPlatformConfigManager messengerPlatformConfigManager) {
        this.f7910a = context;
        this.f7911b = messengerPlatformConfigManager;
    }

    @VisibleForTesting
    public final boolean m8121a(String str) {
        PackageManager packageManager = this.f7910a.getPackageManager();
        Intent d = m8120d(str);
        d.addCategory("com.facebook.orca.category.PLATFORM_THREAD_20150314");
        return packageManager.resolveActivity(d, 65536) != null;
    }

    @VisibleForTesting
    public final boolean m8122b(String str) {
        PackageManager packageManager = this.f7910a.getPackageManager();
        Intent d = m8120d(str);
        d.addCategory("com.facebook.orca.category.PLATFORM_THREAD_20150311");
        return packageManager.resolveActivity(d, 65536) != null;
    }

    @VisibleForTesting
    public final boolean m8123c(String str) {
        PackageManager packageManager = this.f7910a.getPackageManager();
        Intent d = m8120d(str);
        d.addCategory("com.facebook.orca.category.PLATFORM_REPLY_20141218");
        return packageManager.resolveActivity(d, 65536) != null;
    }

    private static Intent m8120d(String str) {
        Intent intent = new Intent("android.intent.action.PICK", null);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setPackage(str);
        return intent;
    }
}
