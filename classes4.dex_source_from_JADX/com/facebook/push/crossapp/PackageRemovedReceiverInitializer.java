package com.facebook.push.crossapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: lockscreen_nux */
public class PackageRemovedReceiverInitializer implements INeedInit {
    private static final Class<?> f9072a = PackageRemovedReceiverInitializer.class;
    private static final String[] f9073b = new String[]{"com.facebook.orca", "com.facebook.katana", "com.facebook.wakizashi", "com.facebook.lite", "com.facebook.pages.app"};
    private static volatile PackageRemovedReceiverInitializer f9074e;
    public final Context f9075c;
    public final PackageManager f9076d;

    public static com.facebook.push.crossapp.PackageRemovedReceiverInitializer m9418a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9074e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.crossapp.PackageRemovedReceiverInitializer.class;
        monitor-enter(r1);
        r0 = f9074e;	 Catch:{ all -> 0x003a }
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
        r0 = m9420b(r0);	 Catch:{ all -> 0x0035 }
        f9074e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9074e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.crossapp.PackageRemovedReceiverInitializer.a(com.facebook.inject.InjectorLike):com.facebook.push.crossapp.PackageRemovedReceiverInitializer");
    }

    private static PackageRemovedReceiverInitializer m9420b(InjectorLike injectorLike) {
        return new PackageRemovedReceiverInitializer((Context) injectorLike.getInstance(Context.class), PackageManagerMethodAutoProvider.a(injectorLike));
    }

    public static boolean m9419a(String str) {
        for (String equals : f9073b) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Inject
    public PackageRemovedReceiverInitializer(Context context, PackageManager packageManager) {
        this.f9075c = context;
        this.f9076d = packageManager;
    }

    public void init() {
        if (!m9419a(this.f9075c.getPackageName())) {
            Class cls = PackageFullyRemovedBroadcastReceiver.class;
            cls.getSimpleName();
            this.f9076d.setComponentEnabledSetting(new ComponentName(this.f9075c, cls), 2, 1);
        }
    }
}
