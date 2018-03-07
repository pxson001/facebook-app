package com.facebook.common.errorreporting.memory;

import com.facebook.common.init.INeedInit;
import com.facebook.inject.InjectorLike;
import java.lang.Thread.UncaughtExceptionHandler;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: video_ids */
public class MemoryDumpHandler implements INeedInit, UncaughtExceptionHandler {
    private static volatile MemoryDumpHandler f1180d;
    private final MemoryDumpingGatekeepers f1181a;
    private final MemoryDumper f1182b;
    private UncaughtExceptionHandler f1183c;

    public static com.facebook.common.errorreporting.memory.MemoryDumpHandler m2288a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1180d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.errorreporting.memory.MemoryDumpHandler.class;
        monitor-enter(r1);
        r0 = f1180d;	 Catch:{ all -> 0x003a }
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
        r0 = m2289b(r0);	 Catch:{ all -> 0x0035 }
        f1180d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1180d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.errorreporting.memory.MemoryDumpHandler.a(com.facebook.inject.InjectorLike):com.facebook.common.errorreporting.memory.MemoryDumpHandler");
    }

    private static MemoryDumpHandler m2289b(InjectorLike injectorLike) {
        return new MemoryDumpHandler(MemoryDumpingGatekeepers.m2290a(injectorLike), MemoryDumper.m2294a(injectorLike));
    }

    @Inject
    public MemoryDumpHandler(MemoryDumpingGatekeepers memoryDumpingGatekeepers, MemoryDumper memoryDumper) {
        this.f1182b = memoryDumper;
        this.f1181a = memoryDumpingGatekeepers;
    }

    public void init() {
        this.f1183c = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (this.f1181a.f1185a.m2189a(94, false) || (th instanceof OutOfMemoryError)) {
            this.f1182b.m2301a(th);
        }
        if (this.f1183c != null) {
            this.f1183c.uncaughtException(thread, th);
        }
    }
}
