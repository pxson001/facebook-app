package com.facebook.aldrin.transition.activity;

import android.app.Activity;
import com.facebook.aldrin.transition.AldrinTransitionLauncher;
import com.facebook.common.activitylistener.annotations.AuthNotRequiredHelper;
import com.facebook.common.init.AppInitLock;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: quick_share_publish_failure */
public class AldrinStatusCheckActivityListener {
    private static volatile AldrinStatusCheckActivityListener f8316d;
    public final Provider<Boolean> f8317a;
    public final AppInitLock f8318b;
    public final Lazy<AldrinTransitionLauncher> f8319c;

    public static com.facebook.aldrin.transition.activity.AldrinStatusCheckActivityListener m12837a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8316d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.aldrin.transition.activity.AldrinStatusCheckActivityListener.class;
        monitor-enter(r1);
        r0 = f8316d;	 Catch:{ all -> 0x003a }
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
        r0 = m12838b(r0);	 Catch:{ all -> 0x0035 }
        f8316d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8316d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.aldrin.transition.activity.AldrinStatusCheckActivityListener.a(com.facebook.inject.InjectorLike):com.facebook.aldrin.transition.activity.AldrinStatusCheckActivityListener");
    }

    private static AldrinStatusCheckActivityListener m12838b(InjectorLike injectorLike) {
        return new AldrinStatusCheckActivityListener(IdBasedProvider.m1811a(injectorLike, 3873), AppInitLock.m2271a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 4769));
    }

    @Inject
    public AldrinStatusCheckActivityListener(Provider<Boolean> provider, AppInitLock appInitLock, Lazy<AldrinTransitionLauncher> lazy) {
        this.f8317a = provider;
        this.f8318b = appInitLock;
        this.f8319c = lazy;
    }

    public final void m12839a(Activity activity) {
        if (((Boolean) this.f8317a.get()).booleanValue() && !(activity instanceof AldrinTransitionActivity) && this.f8318b.m2278c() && !AuthNotRequiredHelper.m6539a(activity)) {
            ((AldrinTransitionLauncher) this.f8319c.get()).a(activity);
        }
    }
}
