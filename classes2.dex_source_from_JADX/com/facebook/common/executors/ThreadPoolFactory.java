package com.facebook.common.executors;

import android.annotation.SuppressLint;
import com.facebook.common.cpu.ProcessorInfoUtil;
import com.facebook.common.cpu.ProcessorInfoUtilMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@SuppressLint({"BadMethodUse-java.util.concurrent.ThreadPoolExecutor._Constructor"})
/* compiled from: vpvd_time_delta */
public class ThreadPoolFactory {
    private static volatile ThreadPoolFactory f928f;
    final int f929a;
    final int f930b;
    public final int f931c;
    final int f932d;
    public final BackgroundWorkLogger f933e;

    public static com.facebook.common.executors.ThreadPoolFactory m1885a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f928f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.executors.ThreadPoolFactory.class;
        monitor-enter(r1);
        r0 = f928f;	 Catch:{ all -> 0x003a }
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
        r0 = m1888b(r0);	 Catch:{ all -> 0x0035 }
        f928f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f928f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.executors.ThreadPoolFactory.a(com.facebook.inject.InjectorLike):com.facebook.common.executors.ThreadPoolFactory");
    }

    private static ThreadPoolFactory m1888b(InjectorLike injectorLike) {
        return new ThreadPoolFactory(ProcessorInfoUtilMethodAutoProvider.m1898a(injectorLike), BaseBackgroundWorkLogger.m1660a(injectorLike));
    }

    @Inject
    public ThreadPoolFactory(ProcessorInfoUtil processorInfoUtil, BackgroundWorkLogger backgroundWorkLogger) {
        this.f933e = backgroundWorkLogger;
        this.f929a = Math.max(processorInfoUtil.m1905d() + 1, 2);
        this.f930b = Math.max(processorInfoUtil.m1905d() * 2, 2);
        this.f931c = Math.max((processorInfoUtil.m1905d() * 2) + 1, 3);
        this.f932d = Math.max(processorInfoUtil.m1905d() * 2, 2);
    }

    public final ThreadPoolExecutor m1891a(String str) {
        return ExecutorTracker.m1908a(new ThreadPoolExecutor(this.f929a, Integer.MAX_VALUE, 15, TimeUnit.SECONDS, new SynchronousQueue(), new NamedThreadFactory("Bg_" + str, ThreadPriority.BACKGROUND)));
    }

    public final ThreadPoolExecutor m1892b(String str) {
        return ExecutorTracker.m1908a(new ThreadPoolExecutor(this.f930b, Integer.MAX_VALUE, 15, TimeUnit.SECONDS, new SynchronousQueue(), new NamedThreadFactory("Norm_" + str, ThreadPriority.NORMAL)));
    }

    public final ThreadPoolExecutor m1893c(String str) {
        return ExecutorTracker.m1908a(new ThreadPoolExecutor(this.f930b, Integer.MAX_VALUE, 15, TimeUnit.SECONDS, new SynchronousQueue(), new NamedThreadFactory("NormN_" + str, ThreadPriority.NORMAL_NEW)));
    }

    public final ThreadPoolExecutor m1894d(String str) {
        return m1886a(str, this.f931c);
    }

    public static ThreadPoolExecutor m1886a(String str, int i) {
        return ExecutorTracker.m1908a(new ThreadPoolExecutor(i, Integer.MAX_VALUE, 15, TimeUnit.SECONDS, new SynchronousQueue(), new NamedThreadFactory("Fg_" + str, ThreadPriority.FOREGROUND)));
    }

    public final ThreadPoolExecutor m1895e(String str) {
        return ExecutorTracker.m1908a(new ThreadPoolExecutor(this.f932d, Integer.MAX_VALUE, 15, TimeUnit.SECONDS, new SynchronousQueue(), new NamedThreadFactory("Ff_" + str, ThreadPriority.URGENT)));
    }

    static ThreadPoolExecutor m1889f(String str) {
        return ExecutorTracker.m1908a(new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("Ug_" + str, ThreadPriority.URGENT)));
    }

    public static ThreadPoolExecutor m1887a(String str, int i, int i2) {
        return ExecutorTracker.m1908a(new ThreadPoolExecutor(i, Integer.MAX_VALUE, 15, TimeUnit.SECONDS, new SynchronousQueue(), new NamedThreadFactory("P[" + i2 + "]_" + str, i2)));
    }

    public final FbScheduledThreadPoolExecutor m1896g(String str) {
        return (FbScheduledThreadPoolExecutor) ExecutorTracker.m1908a(new FbScheduledThreadPoolExecutor(1, new NamedThreadFactory(str, ThreadPriority.NORMAL), this.f933e));
    }

    public final FbScheduledThreadPoolExecutor m1897h(String str) {
        return (FbScheduledThreadPoolExecutor) ExecutorTracker.m1908a(new FbScheduledThreadPoolExecutor(1, new NamedThreadFactory(str, ThreadPriority.URGENT), this.f933e));
    }

    public final FbThreadPoolExecutor m1890a(int i, String str) {
        return (FbThreadPoolExecutor) ExecutorTracker.m1908a(new FbThreadPoolExecutor(i, i, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new NamedThreadFactory(str, ThreadPriority.NORMAL), this.f933e));
    }
}
