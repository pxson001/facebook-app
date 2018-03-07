package com.facebook.orca.contacts.divebar;

import com.facebook.analytics.NavigationLogger;
import com.facebook.common.activitylistener.ListenableActivity;
import com.facebook.divebar.DivebarFragmentInitializer;
import com.facebook.divebar.DrawerBasedDivebarControllerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.ui.drawers.DrawerContentFragment;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: onOverflowButtonClicked */
public class FavoritesDivebarInitializer implements DivebarFragmentInitializer {
    private static volatile FavoritesDivebarInitializer f5890d;
    private final NavigationLogger f5891a;
    private final QuickPerformanceLogger f5892b;
    private boolean f5893c = false;

    public static com.facebook.orca.contacts.divebar.FavoritesDivebarInitializer m5548a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5890d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.contacts.divebar.FavoritesDivebarInitializer.class;
        monitor-enter(r1);
        r0 = f5890d;	 Catch:{ all -> 0x003a }
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
        r0 = m5549b(r0);	 Catch:{ all -> 0x0035 }
        f5890d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5890d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.contacts.divebar.FavoritesDivebarInitializer.a(com.facebook.inject.InjectorLike):com.facebook.orca.contacts.divebar.FavoritesDivebarInitializer");
    }

    private static FavoritesDivebarInitializer m5549b(InjectorLike injectorLike) {
        return new FavoritesDivebarInitializer(NavigationLogger.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FavoritesDivebarInitializer(NavigationLogger navigationLogger, QuickPerformanceLogger quickPerformanceLogger) {
        this.f5891a = navigationLogger;
        this.f5892b = quickPerformanceLogger;
    }

    public final DrawerContentFragment m5550a() {
        if (!this.f5893c) {
            this.f5892b.b(6225921);
            this.f5893c = true;
        }
        return new DivebarFragment();
    }

    public final boolean m5553b() {
        return true;
    }

    public final void m5551a(ListenableActivity listenableActivity, DrawerBasedDivebarControllerImpl drawerBasedDivebarControllerImpl) {
    }

    public final void m5552a(boolean z) {
        if (z) {
            this.f5891a.a("tap_dive_bar").a("divebar", false);
            return;
        }
        if (this.f5891a.u == null) {
            this.f5891a.a("tap_outside");
        }
        this.f5891a.c("divebar");
    }

    public final boolean m5554c() {
        return true;
    }

    public final boolean m5555d() {
        return false;
    }
}
