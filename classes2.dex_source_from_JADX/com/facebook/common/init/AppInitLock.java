package com.facebook.common.init;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.systrace.Systrace;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: video_inline_android_shutoff */
public class AppInitLock {
    private static volatile AppInitLock f1161d;
    private final DefaultAndroidThreadUtil f1162a;
    private Set<Listener> f1163b = Sets.m1313a();
    private boolean f1164c;

    /* compiled from: video_inline_android_shutoff */
    public abstract class Listener {
        public abstract void mo334a();
    }

    /* compiled from: video_inline_android_shutoff */
    class C01931 implements Runnable {
        final /* synthetic */ AppInitLock f3068a;

        C01931(AppInitLock appInitLock) {
            this.f3068a = appInitLock;
        }

        public void run() {
            Systrace.a(8, "Notify AppInitLock Listeners");
            try {
                AppInitLock.m2274e(this.f3068a);
            } finally {
                Systrace.a(8);
            }
        }
    }

    public static com.facebook.common.init.AppInitLock m2271a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1161d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.init.AppInitLock.class;
        monitor-enter(r1);
        r0 = f1161d;	 Catch:{ all -> 0x003a }
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
        r0 = m2272b(r0);	 Catch:{ all -> 0x0035 }
        f1161d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1161d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.init.AppInitLock.a(com.facebook.inject.InjectorLike):com.facebook.common.init.AppInitLock");
    }

    private static AppInitLock m2272b(InjectorLike injectorLike) {
        return new AppInitLock(DefaultAndroidThreadUtil.m1646b(injectorLike));
    }

    @Inject
    public AppInitLock(DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f1162a = defaultAndroidThreadUtil;
        Systrace.b(8, "App Init Lock Held", 0);
    }

    public final void m2275a() {
        synchronized (this) {
            if (!this.f1164c) {
                Systrace.c(8, "App Init Lock Held", 0);
            }
            this.f1164c = true;
            ObjectDetour.c(this, -386440361);
        }
        m2273d();
    }

    public final synchronized void m2277b() {
        while (!this.f1164c) {
            try {
                ObjectDetour.a(this, -190973105);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    public final void m2276a(Listener listener) {
        synchronized (this) {
            this.f1163b.add(listener);
            boolean z = this.f1164c;
        }
        if (z) {
            m2273d();
        }
    }

    private void m2273d() {
        this.f1162a.m1652a(new C01931(this));
    }

    public static void m2274e(AppInitLock appInitLock) {
        synchronized (appInitLock) {
            Set<Listener> set = appInitLock.f1163b;
            appInitLock.f1163b = Sets.m1313a();
        }
        for (Listener a : set) {
            a.mo334a();
        }
    }

    public final synchronized boolean m2278c() {
        return this.f1164c;
    }
}
