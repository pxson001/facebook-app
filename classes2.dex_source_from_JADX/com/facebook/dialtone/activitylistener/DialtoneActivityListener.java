package com.facebook.dialtone.activitylistener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.content.SecureContextHelper;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.dialtone.activity.DialtoneModeSelectionActivity;
import com.facebook.dialtone.activity.DialtoneUnsupportedCarrierInterstitialActivity;
import com.facebook.dialtone.activity.DialtoneWifiInterstitialActivity;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: query_name */
public class DialtoneActivityListener {
    private static volatile DialtoneActivityListener f8420k;
    private final Provider<Boolean> f8421a;
    private final Provider<Boolean> f8422b;
    private final Lazy<SecureContextHelper> f8423c;
    private final Lazy<FbBroadcastManager> f8424d;
    public DialtoneController f8425e;
    public Activity f8426f;
    public boolean f8427g = true;
    public boolean f8428h = false;
    public boolean f8429i = false;
    @GuardedBy("this")
    private int f8430j = 0;

    public static com.facebook.dialtone.activitylistener.DialtoneActivityListener m12969a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8420k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.dialtone.activitylistener.DialtoneActivityListener.class;
        monitor-enter(r1);
        r0 = f8420k;	 Catch:{ all -> 0x003a }
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
        r0 = m12970b(r0);	 Catch:{ all -> 0x0035 }
        f8420k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8420k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.dialtone.activitylistener.DialtoneActivityListener.a(com.facebook.inject.InjectorLike):com.facebook.dialtone.activitylistener.DialtoneActivityListener");
    }

    private static DialtoneActivityListener m12970b(InjectorLike injectorLike) {
        return new DialtoneActivityListener(DialtoneControllerImpl.m8272a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 968), IdBasedLazy.m1808a(injectorLike, 401), IdBasedProvider.m1811a(injectorLike, 3962), IdBasedProvider.m1811a(injectorLike, 3957));
    }

    @Inject
    public DialtoneActivityListener(DialtoneController dialtoneController, Lazy<SecureContextHelper> lazy, Lazy<FbBroadcastManager> lazy2, Provider<Boolean> provider, Provider<Boolean> provider2) {
        this.f8428h = dialtoneController.mo1221b();
        this.f8423c = lazy;
        this.f8424d = lazy2;
        this.f8421a = provider;
        this.f8422b = provider2;
        this.f8425e = dialtoneController;
        this.f8425e.mo1209a(this);
    }

    private boolean m12971g() {
        return (!this.f8425e.mo1221b() || this.f8427g || ((this.f8428h && this.f8429i) || m12974j())) ? false : true;
    }

    private boolean m12972h() {
        return ((Boolean) this.f8421a.get()).booleanValue() && m12971g();
    }

    private boolean m12973i() {
        return (((Boolean) this.f8421a.get()).booleanValue() || !m12971g() || this.f8428h) ? false : true;
    }

    public final boolean m12976a() {
        return !this.f8425e.mo1221b() || !m12974j() || this.f8426f == null || (this.f8426f instanceof DialtoneWifiInterstitialActivity) || (this.f8426f instanceof DialtoneUnsupportedCarrierInterstitialActivity);
    }

    private synchronized boolean m12974j() {
        return this.f8430j > 0;
    }

    public final synchronized void m12975a(Activity activity) {
        if (m12972h()) {
            Intent intent = new Intent(activity, DialtoneModeSelectionActivity.class);
            intent.addFlags(67108864);
            ((SecureContextHelper) this.f8423c.get()).mo662a(intent, activity);
        } else if (m12973i()) {
            this.f8425e.mo1208a((Context) activity);
        }
        this.f8429i = false;
        this.f8430j++;
    }

    public final void m12977b(Activity activity) {
        this.f8426f = activity;
    }

    public final synchronized void m12978f() {
        this.f8427g = false;
        this.f8430j--;
        if (this.f8430j <= 0) {
            this.f8428h = this.f8425e.mo1221b();
        }
    }
}
