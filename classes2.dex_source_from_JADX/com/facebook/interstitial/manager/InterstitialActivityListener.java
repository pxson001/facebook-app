package com.facebook.interstitial.manager;

import android.app.Activity;
import com.facebook.apptab.ui.nux.AppTabInterstitialController;
import com.facebook.apptab.ui.nux.FbMainTabActivityNuxController;
import com.facebook.apptab.ui.nux.FbMainTabActivityNuxController.State;
import com.facebook.common.init.AppInitLock;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: quick_experiment */
public class InterstitialActivityListener {
    private static volatile InterstitialActivityListener f8362c;
    public final AppInitLock f8363a;
    public final InterstitialManager f8364b;

    public static com.facebook.interstitial.manager.InterstitialActivityListener m12874a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8362c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.interstitial.manager.InterstitialActivityListener.class;
        monitor-enter(r1);
        r0 = f8362c;	 Catch:{ all -> 0x003a }
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
        r0 = m12875b(r0);	 Catch:{ all -> 0x0035 }
        f8362c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8362c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.interstitial.manager.InterstitialActivityListener.a(com.facebook.inject.InjectorLike):com.facebook.interstitial.manager.InterstitialActivityListener");
    }

    private static InterstitialActivityListener m12875b(InjectorLike injectorLike) {
        return new InterstitialActivityListener(AppInitLock.m2271a(injectorLike), InterstitialManager.m8082a(injectorLike));
    }

    @Inject
    public InterstitialActivityListener(AppInitLock appInitLock, InterstitialManager interstitialManager) {
        this.f8363a = appInitLock;
        this.f8364b = interstitialManager;
    }

    public final void m12876a(Activity activity) {
        if (this.f8363a.m2278c()) {
            InterstitialController a = this.f8364b.m8117a(new InterstitialTrigger(Action.ACTIVITY_CREATED, activity.getClass()));
            if (a != null && (a instanceof AppTabInterstitialController)) {
                this.f8364b.m8121a().a(a.mo1173b());
                FbMainTabActivityNuxController.m7882a(((AppTabInterstitialController) a).f4255b, State.SHOWN_TABS);
            }
        }
    }
}
