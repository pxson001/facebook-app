package com.facebook.platform.perflogging;

import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: stickers_list */
public class PlatformPerformanceLogger {
    private static volatile PlatformPerformanceLogger f4108f;
    public boolean f4109a = true;
    private final AppStateManager f4110b;
    private final MonotonicClock f4111c;
    public final SequenceLogger f4112d;
    public final Set<AbstractPlatformLaunchSequenceDefinition> f4113e;

    public static com.facebook.platform.perflogging.PlatformPerformanceLogger m6022a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4108f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.platform.perflogging.PlatformPerformanceLogger.class;
        monitor-enter(r1);
        r0 = f4108f;	 Catch:{ all -> 0x003a }
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
        r0 = m6023b(r0);	 Catch:{ all -> 0x0035 }
        f4108f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4108f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.platform.perflogging.PlatformPerformanceLogger.a(com.facebook.inject.InjectorLike):com.facebook.platform.perflogging.PlatformPerformanceLogger");
    }

    private static PlatformPerformanceLogger m6023b(InjectorLike injectorLike) {
        return new PlatformPerformanceLogger(AppStateManager.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (SequenceLogger) SequenceLoggerImpl.a(injectorLike), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new C0227x5fd6f45a(injectorLike)));
    }

    @Inject
    public PlatformPerformanceLogger(AppStateManager appStateManager, MonotonicClock monotonicClock, SequenceLogger sequenceLogger, Set<AbstractPlatformLaunchSequenceDefinition> set) {
        this.f4110b = appStateManager;
        this.f4111c = monotonicClock;
        this.f4112d = sequenceLogger;
        this.f4113e = set;
    }

    public final void m6024a(long j, boolean z, Map<String, String> map) {
        if (j > 0) {
            Builder a = new Builder().a(PlatformPerformanceUtility.m6027a(j, this.f4111c, this.f4110b, z));
            if (map != null) {
                a.a(map);
            }
            for (AbstractPlatformLaunchSequenceDefinition a2 : this.f4113e) {
                SequenceLoggerDetour.a(this.f4112d.a(a2, a.b(), j), "PlatformLaunchPhase", null, null, j, -1891347331);
            }
        }
    }

    public final <T extends AbstractPlatformLaunchSequenceDefinition> void m6025a(T t) {
        Sequence e = this.f4112d.e(t);
        if (e != null) {
            SequenceLoggerDetour.b(e, "PlatformLaunchPhase", 578838709);
        }
        for (T t2 : this.f4113e) {
            if (t2 != t) {
                this.f4112d.d(t2);
            }
        }
    }
}
