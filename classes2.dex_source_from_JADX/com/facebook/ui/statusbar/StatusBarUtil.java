package com.facebook.ui.statusbar;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.Window;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: retryStrategy */
public class StatusBarUtil {
    private static volatile StatusBarUtil f6736c;
    public final Resources f6737a;
    private int f6738b = -1;

    public static com.facebook.ui.statusbar.StatusBarUtil m11479a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6736c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ui.statusbar.StatusBarUtil.class;
        monitor-enter(r1);
        r0 = f6736c;	 Catch:{ all -> 0x003a }
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
        r0 = m11480b(r0);	 Catch:{ all -> 0x0035 }
        f6736c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6736c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.statusbar.StatusBarUtil.a(com.facebook.inject.InjectorLike):com.facebook.ui.statusbar.StatusBarUtil");
    }

    private static StatusBarUtil m11480b(InjectorLike injectorLike) {
        return new StatusBarUtil(ResourcesMethodAutoProvider.m6510a(injectorLike));
    }

    @Inject
    public StatusBarUtil(Resources resources) {
        this.f6737a = resources;
    }

    public final int m11481a(Window window) {
        if (this.f6738b > 0) {
            return this.f6738b;
        }
        int identifier = this.f6737a.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            identifier = this.f6737a.getDimensionPixelSize(identifier);
            if (identifier > 0) {
                this.f6738b = identifier;
                return this.f6738b;
            }
        }
        if (window != null) {
            Rect rect = new Rect();
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            if (rect.top > 0) {
                this.f6738b = rect.top;
                return this.f6738b;
            }
        }
        this.f6738b = (int) ((this.f6737a.getDisplayMetrics().density * 25.0f) + 0.5f);
        return this.f6738b;
    }
}
