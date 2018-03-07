package com.facebook.trace;

import android.os.Debug;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: segment_end_time */
public class DebugTracer {
    private static final Class<?> f5087a = DebugTracer.class;
    private static volatile DebugTracer f5088f;
    private final TraceFileFlag f5089b;
    public int f5090c;
    public int f5091d;
    public int f5092e;

    public static com.facebook.trace.DebugTracer m7843a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5088f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.trace.DebugTracer.class;
        monitor-enter(r1);
        r0 = f5088f;	 Catch:{ all -> 0x003a }
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
        r0 = m7844b(r0);	 Catch:{ all -> 0x0035 }
        f5088f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5088f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.trace.DebugTracer.a(com.facebook.inject.InjectorLike):com.facebook.trace.DebugTracer");
    }

    private static DebugTracer m7844b(InjectorLike injectorLike) {
        return new DebugTracer(TraceFileFlag.a(injectorLike));
    }

    @Inject
    public DebugTracer(TraceFileFlag traceFileFlag) {
        this.f5089b = traceFileFlag;
    }

    public final boolean m7846a(String str) {
        if (!this.f5089b.a()) {
            return false;
        }
        try {
            if (this.f5092e == 0) {
                Debug.startMethodTracingSampling(str, this.f5090c, this.f5091d);
            } else {
                Debug.startMethodTracing(str, this.f5090c);
            }
            return true;
        } catch (Throwable e) {
            BLog.a(f5087a, e, "RuntimeException while starting trace", new Object[0]);
            this.f5089b.b();
            return false;
        }
    }

    public final boolean m7845a() {
        try {
            Debug.stopMethodTracing();
        } catch (Throwable e) {
            BLog.a(f5087a, e, "RuntimeException while trying to stop trace", new Object[0]);
            return false;
        } finally {
            this.f5089b.b();
        }
        return true;
    }
}
