package com.facebook.timeline.logging;

import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fav_photos_impression */
public class TimelineSequenceLogger {
    private static volatile TimelineSequenceLogger f14672d;
    public final SequenceLogger f14673a;
    public final InteractionTTILogger f14674b;
    public final MonotonicClock f14675c;

    public static com.facebook.timeline.logging.TimelineSequenceLogger m18621a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14672d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.logging.TimelineSequenceLogger.class;
        monitor-enter(r1);
        r0 = f14672d;	 Catch:{ all -> 0x003a }
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
        r0 = m18623b(r0);	 Catch:{ all -> 0x0035 }
        f14672d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14672d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.logging.TimelineSequenceLogger.a(com.facebook.inject.InjectorLike):com.facebook.timeline.logging.TimelineSequenceLogger");
    }

    private static TimelineSequenceLogger m18623b(InjectorLike injectorLike) {
        return new TimelineSequenceLogger((SequenceLogger) SequenceLoggerImpl.a(injectorLike), InteractionTTILogger.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public TimelineSequenceLogger(SequenceLogger sequenceLogger, InteractionTTILogger interactionTTILogger, MonotonicClock monotonicClock) {
        this.f14673a = sequenceLogger;
        this.f14674b = interactionTTILogger;
        this.f14675c = monotonicClock;
    }

    public final void m18626b() {
        m18622a(false, false);
    }

    public final void m18630c() {
        m18622a(true, false);
    }

    public final void m18632d() {
        m18622a(false, true);
    }

    private void m18622a(boolean z, boolean z2) {
        if (this.f14673a.e(TimelineSequences.f14676a) != null) {
            this.f14673a.b(TimelineSequences.f14676a, ImmutableMap.of("is_failed", String.valueOf(z), "is_cancelled", String.valueOf(z2)));
        }
    }

    public final void m18624a(String str) {
        Sequence e = this.f14673a.e(TimelineSequences.f14676a);
        if (e != null) {
            SequenceLoggerDetour.a(e, str, 1233037874);
        }
    }

    public final void m18625a(String str, ImmutableMap<String, String> immutableMap) {
        Sequence e = this.f14673a.e(TimelineSequences.f14676a);
        if (e != null) {
            SequenceLoggerDetour.a(e, str, null, immutableMap, this.f14675c.now(), 648885188);
        }
    }

    public final void m18627b(String str) {
        Sequence e = this.f14673a.e(TimelineSequences.f14676a);
        if (e != null) {
            SequenceLoggerDetour.b(e, str, -396732576);
        }
    }

    public final void m18629b(String str, ImmutableMap<String, String> immutableMap) {
        Sequence e = this.f14673a.e(TimelineSequences.f14676a);
        if (e != null) {
            SequenceLoggerDetour.b(e, str, null, immutableMap, this.f14675c.now(), 110037343);
        }
    }

    public final void m18628b(String str, long j) {
        Sequence e = this.f14673a.e(TimelineSequences.f14676a);
        if (e != null) {
            SequenceLoggerDetour.b(e, str, null, null, j, -1750804112);
        }
    }

    public final void m18631c(String str) {
        Sequence e = this.f14673a.e(TimelineSequences.f14676a);
        if (e != null) {
            SequenceLoggerDetour.d(e, str, 199667344);
        }
    }

    public final void m18633d(String str) {
        Sequence e = this.f14673a.e(TimelineSequences.f14676a);
        if (e != null) {
            SequenceLoggerDetour.c(e, str, 335393517);
        }
    }

    public final void m18634f(String str) {
        Sequence e = this.f14673a.e(TimelineSequences.f14676a);
        if (e != null) {
            SequenceLoggerDetour.e(e, str, -1406814050);
        }
    }
}
