package com.facebook.device;

import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: show_optout_tooltip_period */
public class ScreenUtil {
    private static volatile ScreenUtil f4860e;
    private final Display f4861a;
    private final DisplayMetrics f4862b = new DisplayMetrics();
    private final DisplayMetrics f4863c = new DisplayMetrics();
    private int f4864d;

    public static com.facebook.device.ScreenUtil m8695a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4860e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.device.ScreenUtil.class;
        monitor-enter(r1);
        r0 = f4860e;	 Catch:{ all -> 0x003a }
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
        r0 = m8698b(r0);	 Catch:{ all -> 0x0035 }
        f4860e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4860e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.device.ScreenUtil.a(com.facebook.inject.InjectorLike):com.facebook.device.ScreenUtil");
    }

    private static ScreenUtil m8698b(InjectorLike injectorLike) {
        return new ScreenUtil(WindowManagerMethodAutoProvider.m8708b(injectorLike));
    }

    @Inject
    public ScreenUtil(WindowManager windowManager) {
        this.f4861a = windowManager.getDefaultDisplay();
        m8699h();
    }

    private void m8697a(boolean z) {
        if (z) {
            m8699h();
            return;
        }
        int rotation = this.f4861a.getRotation();
        if (rotation != this.f4864d) {
            m8696a(rotation);
        }
    }

    private void m8699h() {
        m8696a(this.f4861a.getRotation());
    }

    private void m8696a(int i) {
        this.f4864d = i;
        this.f4861a.getMetrics(this.f4862b);
        if (VERSION.SDK_INT >= 17) {
            this.f4861a.getRealMetrics(this.f4863c);
        }
    }

    public final int m8700a() {
        m8697a(false);
        return this.f4862b.densityDpi;
    }

    public final float m8701b() {
        m8697a(false);
        return this.f4862b.density;
    }

    public final int m8702c() {
        m8697a(false);
        return this.f4862b.widthPixels;
    }

    public final int m8703d() {
        m8697a(false);
        return this.f4862b.heightPixels;
    }

    public final int m8704e() {
        m8697a(false);
        return this.f4863c.heightPixels;
    }

    public final int m8705f() {
        return Math.min(m8702c(), m8703d());
    }

    public final int m8706g() {
        return Math.max(m8702c(), m8703d());
    }
}
