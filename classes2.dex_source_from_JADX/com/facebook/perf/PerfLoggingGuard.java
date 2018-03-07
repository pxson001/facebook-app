package com.facebook.perf;

import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.systrace.TraceConfig;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.collect.ImmutableSet;
import java.util.Random;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: tuzi_show_non_forsale_delete_intercept */
public class PerfLoggingGuard {
    private static final PerfSequence f2183a = new PerfSequence();
    private static volatile PerfLoggingGuard f2184f;
    public QuickPerformanceLogger f2185b;
    private PerformanceLogger f2186c;
    private SequenceLogger f2187d;
    private Random f2188e;

    /* compiled from: tuzi_show_non_forsale_delete_intercept */
    final class PerfSequence extends AbstractSequenceDefinition {
        public PerfSequence() {
            super(196612, "PerfSequence", false, ImmutableSet.of("PerfLogger"));
        }
    }

    public static com.facebook.perf.PerfLoggingGuard m4332a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2184f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.perf.PerfLoggingGuard.class;
        monitor-enter(r1);
        r0 = f2184f;	 Catch:{ all -> 0x003a }
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
        r0 = m4333b(r0);	 Catch:{ all -> 0x0035 }
        f2184f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2184f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.perf.PerfLoggingGuard.a(com.facebook.inject.InjectorLike):com.facebook.perf.PerfLoggingGuard");
    }

    private static PerfLoggingGuard m4333b(InjectorLike injectorLike) {
        return new PerfLoggingGuard(QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike), DelegatingPerformanceLogger.m2803a(injectorLike), SequenceLoggerImpl.m3464a(injectorLike), Random_InsecureRandomMethodAutoProvider.m2102a(injectorLike));
    }

    @Inject
    public PerfLoggingGuard(QuickPerformanceLogger quickPerformanceLogger, PerformanceLogger performanceLogger, SequenceLogger sequenceLogger, Random random) {
        this.f2185b = quickPerformanceLogger;
        this.f2186c = performanceLogger;
        this.f2187d = sequenceLogger;
        this.f2188e = random;
    }

    public final void m4336a() {
        if (!TraceConfig.a(4)) {
            switch (this.f2188e.nextInt(3)) {
                case 0:
                    short s = (short) 2;
                    long nanoTime = System.nanoTime();
                    this.f2185b.mo462b(196609);
                    boolean f = this.f2185b.mo480f(196609);
                    this.f2185b.mo468b(196609, (short) 2);
                    long nanoTime2 = System.nanoTime();
                    this.f2185b.markerStart(196611, 0, nanoTime);
                    QuickPerformanceLogger quickPerformanceLogger = this.f2185b;
                    if (!f) {
                        s = (short) 3;
                    }
                    quickPerformanceLogger.markerEnd(196611, 0, s, nanoTime2);
                    return;
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    m4334c();
                    return;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    m4335d();
                    return;
                default:
                    return;
            }
        }
    }

    private void m4334c() {
        long nanoTime = System.nanoTime();
        this.f2186c.mo392d(196610, "PerfLogger");
        boolean g = this.f2186c.mo399g(196610, "PerfLogger");
        this.f2186c.mo389c(196610, "PerfLogger");
        long nanoTime2 = System.nanoTime();
        this.f2185b.markerStart(196613, 0, nanoTime);
        this.f2185b.markerEnd(196613, 0, g ? (short) 2 : (short) 3, nanoTime2);
    }

    private void m4335d() {
        boolean z;
        long nanoTime = System.nanoTime();
        this.f2187d.mo510a(f2183a);
        Sequence e = this.f2187d.mo524e(f2183a);
        if (e != null) {
            SequenceLoggerDetour.a(e, "PerfLogger", 496986011);
            boolean f = e.mo631f("PerfLogger");
            SequenceLoggerDetour.b(e, "PerfLogger", 1941696589);
            this.f2187d.mo518b(f2183a);
            z = f;
        } else {
            z = false;
        }
        long nanoTime2 = System.nanoTime();
        this.f2185b.markerStart(196612, 0, nanoTime);
        this.f2185b.markerEnd(196612, 0, z ? (short) 2 : (short) 3, nanoTime2);
    }
}
