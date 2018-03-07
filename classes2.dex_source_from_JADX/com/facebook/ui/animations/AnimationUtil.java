package com.facebook.ui.animations;

import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.view.View;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: response_code */
public class AnimationUtil {
    private static volatile AnimationUtil f6972a;

    public static com.facebook.ui.animations.AnimationUtil m11568a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f6972a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.ui.animations.AnimationUtil.class;
        monitor-enter(r1);
        r0 = f6972a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m11571b();	 Catch:{ all -> 0x0034 }
        f6972a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f6972a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.animations.AnimationUtil.a(com.facebook.inject.InjectorLike):com.facebook.ui.animations.AnimationUtil");
    }

    private static AnimationUtil m11571b() {
        return new AnimationUtil();
    }

    public static boolean m11570a() {
        return VERSION.SDK_INT >= 11;
    }

    public final void m11572a(@Nullable View view) {
        m11569a(view, 2);
    }

    public final void m11573b(@Nullable View view) {
        m11569a(view, 0);
    }

    private static void m11569a(@Nullable View view, int i) {
        if (view != null && ViewCompat.m10964g(view) != i) {
            if (VERSION.SDK_INT == 19) {
                try {
                    ViewCompat.m10937a(view, i, null);
                    return;
                } catch (NullPointerException e) {
                    return;
                }
            }
            ViewCompat.m10937a(view, i, null);
        }
    }
}
