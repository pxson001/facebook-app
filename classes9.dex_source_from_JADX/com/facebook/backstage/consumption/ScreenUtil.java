package com.facebook.backstage.consumption;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: rtc_ringtone_level */
public class ScreenUtil {
    private static volatile ScreenUtil f4634f;
    private final Display f4635a;
    private final DisplayMetrics f4636b = new DisplayMetrics();
    private int f4637c;
    private int f4638d;
    private int f4639e;

    public static com.facebook.backstage.consumption.ScreenUtil m4547a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4634f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.backstage.consumption.ScreenUtil.class;
        monitor-enter(r1);
        r0 = f4634f;	 Catch:{ all -> 0x003a }
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
        r0 = m4548b(r0);	 Catch:{ all -> 0x0035 }
        f4634f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4634f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backstage.consumption.ScreenUtil.a(com.facebook.inject.InjectorLike):com.facebook.backstage.consumption.ScreenUtil");
    }

    private static ScreenUtil m4548b(InjectorLike injectorLike) {
        return new ScreenUtil(WindowManagerMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public ScreenUtil(WindowManager windowManager) {
        this.f4635a = windowManager.getDefaultDisplay();
        m4550f();
    }

    public final int m4551a() {
        m4549e();
        return this.f4636b.widthPixels;
    }

    public final int m4552b() {
        m4549e();
        return this.f4636b.heightPixels;
    }

    public final int m4553c() {
        m4549e();
        return this.f4638d;
    }

    public final int m4554d() {
        m4549e();
        return this.f4639e;
    }

    private void m4549e() {
        if (this.f4635a.getRotation() != this.f4637c) {
            m4550f();
        }
    }

    private void m4550f() {
        this.f4635a.getMetrics(this.f4636b);
        this.f4638d = this.f4636b.widthPixels / 2;
        this.f4639e = this.f4636b.heightPixels / 2;
        this.f4637c = this.f4635a.getRotation();
    }
}
