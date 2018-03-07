package com.facebook.events.permalink.perf;

import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.inject.InjectorLike;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableSet;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: background_transparent */
public class EventPermalinkSequenceLogger {
    private static final EventPermalinkSequenceSequenceDefinition f18768a = new EventPermalinkSequenceSequenceDefinition();
    private static volatile EventPermalinkSequenceLogger f18769j;
    private final MonotonicClock f18770b;
    private final SequenceLogger f18771c;
    public final InteractionTTILogger f18772d;
    private final QeAccessor f18773e;
    private boolean f18774f = false;
    private boolean f18775g = false;
    private boolean f18776h = false;
    private boolean f18777i = false;

    /* compiled from: background_transparent */
    final class EventPermalinkSequenceSequenceDefinition extends AbstractSequenceDefinition {
        public EventPermalinkSequenceSequenceDefinition() {
            super(393226, "EventPermalinkLoadSequence", false, RegularImmutableSet.a);
        }
    }

    /* compiled from: background_transparent */
    public enum LoadingState {
        EARLY_FETCH,
        CREATE_VIEW,
        DB_FETCH,
        NETWORK_FETCH,
        RENDERING,
        REACTION_FIRST_PAGE_NETWORK_FETCH,
        CACHED_STORIES_INITIAL_FETCH,
        FRESH_STORIES_INITIAL_FETCH
    }

    public static com.facebook.events.permalink.perf.EventPermalinkSequenceLogger m19070a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f18769j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.events.permalink.perf.EventPermalinkSequenceLogger.class;
        monitor-enter(r1);
        r0 = f18769j;	 Catch:{ all -> 0x003a }
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
        r0 = m19072b(r0);	 Catch:{ all -> 0x0035 }
        f18769j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18769j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.permalink.perf.EventPermalinkSequenceLogger.a(com.facebook.inject.InjectorLike):com.facebook.events.permalink.perf.EventPermalinkSequenceLogger");
    }

    private static EventPermalinkSequenceLogger m19072b(InjectorLike injectorLike) {
        return new EventPermalinkSequenceLogger((MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (SequenceLogger) SequenceLoggerImpl.a(injectorLike), InteractionTTILogger.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public EventPermalinkSequenceLogger(MonotonicClock monotonicClock, SequenceLogger sequenceLogger, InteractionTTILogger interactionTTILogger, QeAccessor qeAccessor) {
        this.f18770b = monotonicClock;
        this.f18771c = sequenceLogger;
        this.f18772d = interactionTTILogger;
        this.f18773e = qeAccessor;
    }

    private Sequence<EventPermalinkSequenceSequenceDefinition> m19073d() {
        return this.f18771c.e(f18768a);
    }

    public final void m19077a() {
        this.f18775g = true;
        m19075f();
    }

    public final void m19080a(String str) {
        if (this.f18773e.a(ExperimentsForEventsGatingModule.f, false)) {
            this.f18776h = true;
            this.f18777i = true;
        }
        this.f18771c.a(f18768a, ImmutableBiMap.b("navigation_source", str), this.f18770b.now());
    }

    private void m19074e() {
        this.f18774f = false;
        this.f18775g = false;
        this.f18776h = false;
        this.f18777i = false;
    }

    public final void m19082c() {
        m19074e();
        this.f18771c.d(f18768a);
    }

    public final long m19076a(LoadingState loadingState) {
        return m19071b(loadingState, null);
    }

    private long m19071b(LoadingState loadingState, @Nullable ImmutableMap<String, String> immutableMap) {
        Sequence d = m19073d();
        long now = this.f18770b.now();
        if (d != null) {
            SequenceLoggerDetour.a(d, loadingState.name(), null, immutableMap, now, 1520786087);
        }
        return now;
    }

    public final void m19081b(LoadingState loadingState) {
        Sequence d = m19073d();
        if (d != null) {
            SequenceLoggerDetour.a(d, loadingState.name(), null, this.f18770b.now(), 509139107);
        }
    }

    public final void m19083c(LoadingState loadingState) {
        Sequence d = m19073d();
        if (d != null) {
            SequenceLoggerDetour.c(d, loadingState.name(), null, null, this.f18770b.now(), 56378100);
        }
    }

    public final void m19084d(LoadingState loadingState) {
        m19079a(loadingState, null);
    }

    public final void m19079a(LoadingState loadingState, @Nullable ImmutableMap<String, String> immutableMap) {
        Sequence d = m19073d();
        if (d != null) {
            SequenceLoggerDetour.b(d, loadingState.name(), null, immutableMap, this.f18770b.now(), 1760450253);
            if (loadingState == LoadingState.RENDERING) {
                this.f18774f = true;
                m19075f();
            } else if (loadingState == LoadingState.REACTION_FIRST_PAGE_NETWORK_FETCH) {
                this.f18775g = true;
                m19075f();
            } else if (loadingState == LoadingState.CACHED_STORIES_INITIAL_FETCH) {
                this.f18776h = true;
                m19075f();
            } else if (loadingState == LoadingState.FRESH_STORIES_INITIAL_FETCH) {
                this.f18777i = true;
                m19075f();
            }
        }
    }

    private void m19075f() {
        if (this.f18774f && this.f18775g && this.f18776h && this.f18777i) {
            m19074e();
            this.f18771c.b(f18768a, null, this.f18770b.now());
        }
    }

    public final void m19078a(LoadingState loadingState, long j) {
        Sequence d = m19073d();
        if (d != null) {
            SequenceLoggerDetour.b(d, loadingState.name(), null, null, j, -1354833053);
        }
    }
}
