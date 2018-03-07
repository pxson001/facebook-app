package com.facebook.offlinemode.intentchecker;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import com.facebook.offlinemode.ui.OfflineSnackbarActionController;
import com.facebook.offlinemode.ui.OfflineSnackbarView;
import com.facebook.ui.toaster.ClickableToast;
import com.facebook.ui.toaster.ClickableToastBuilder;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: currentRegion */
public class OfflineIntentManager {
    private static volatile OfflineIntentManager f16532d;
    public final Lazy<ClickableToastBuilder> f16533a;
    private final NetworkMonitor f16534b;
    private final Lazy<Set<OfflineIntentChecker>> f16535c;

    public static com.facebook.offlinemode.intentchecker.OfflineIntentManager m19484a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16532d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.offlinemode.intentchecker.OfflineIntentManager.class;
        monitor-enter(r1);
        r0 = f16532d;	 Catch:{ all -> 0x003a }
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
        r0 = m19485b(r0);	 Catch:{ all -> 0x0035 }
        f16532d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16532d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offlinemode.intentchecker.OfflineIntentManager.a(com.facebook.inject.InjectorLike):com.facebook.offlinemode.intentchecker.OfflineIntentManager");
    }

    private static OfflineIntentManager m19485b(InjectorLike injectorLike) {
        return new OfflineIntentManager(IdBasedLazy.a(injectorLike, 3585), NetworkMonitor.a(injectorLike), ProviderLazy.a(new STATICDI_MULTIBIND_PROVIDER$OfflineIntentChecker(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()));
    }

    @Inject
    public OfflineIntentManager(Lazy<ClickableToastBuilder> lazy, NetworkMonitor networkMonitor, Lazy<Set<OfflineIntentChecker>> lazy2) {
        this.f16533a = lazy;
        this.f16534b = networkMonitor;
        this.f16535c = lazy2;
    }

    public final boolean m19486a(Context context, Intent intent) {
        return m19487a(context, intent, null);
    }

    public final boolean m19487a(Context context, Intent intent, View view) {
        if (this.f16534b.a()) {
            return false;
        }
        for (OfflineIntentChecker offlineIntentChecker : (Set) this.f16535c.get()) {
            if (offlineIntentChecker.m19482a(intent) && offlineIntentChecker.m19481a()) {
                OfflineSnackbarActionController b = offlineIntentChecker.m19483b(intent);
                OfflineSnackbarView offlineSnackbarView = new OfflineSnackbarView(context);
                offlineSnackbarView.c = b;
                ClickableToast a = ((ClickableToastBuilder) this.f16533a.get()).a(offlineSnackbarView, 3000);
                a.i = view;
                a.a();
                return true;
            }
        }
        return false;
    }
}
