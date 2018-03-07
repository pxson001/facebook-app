package com.facebook.events.dashboard;

import com.facebook.inject.InjectorLike;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.RegularImmutableSet;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: com.google.android.gms.wearable.internal.IWearableService */
public class EventsDashboardSequenceLogger {
    private static final EventsDashboardStartSequenceDefinition f16758a = new EventsDashboardStartSequenceDefinition();
    private static volatile EventsDashboardSequenceLogger f16759d;
    private final SequenceLogger f16760b;
    private boolean f16761c;

    @VisibleForTesting
    /* compiled from: com.google.android.gms.wearable.internal.IWearableService */
    final class EventsDashboardStartSequenceDefinition extends AbstractSequenceDefinition {
        public EventsDashboardStartSequenceDefinition() {
            super(393225, "EventsDashboardLoadSequence", false, RegularImmutableSet.a);
        }
    }

    /* compiled from: com.google.android.gms.wearable.internal.IWearableService */
    public enum LoadingState {
        CREATE_VIEW,
        NETWORK_FETCH,
        DB_UPDATE,
        DB_FETCH,
        RENDERING
    }

    public static com.facebook.events.dashboard.EventsDashboardSequenceLogger m17147a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16759d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.events.dashboard.EventsDashboardSequenceLogger.class;
        monitor-enter(r1);
        r0 = f16759d;	 Catch:{ all -> 0x003a }
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
        r0 = m17148b(r0);	 Catch:{ all -> 0x0035 }
        f16759d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16759d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.dashboard.EventsDashboardSequenceLogger.a(com.facebook.inject.InjectorLike):com.facebook.events.dashboard.EventsDashboardSequenceLogger");
    }

    private static EventsDashboardSequenceLogger m17148b(InjectorLike injectorLike) {
        return new EventsDashboardSequenceLogger((SequenceLogger) SequenceLoggerImpl.a(injectorLike));
    }

    @Inject
    public EventsDashboardSequenceLogger(SequenceLogger sequenceLogger) {
        this.f16760b = sequenceLogger;
    }

    private Sequence<EventsDashboardStartSequenceDefinition> m17149c() {
        return this.f16760b.e(f16758a);
    }

    public final void m17150a() {
        this.f16761c = true;
        this.f16760b.a(f16758a);
    }

    public final void m17152b() {
        if (this.f16761c) {
            this.f16760b.b(f16758a);
        }
    }

    public final void m17151a(LoadingState loadingState) {
        if (this.f16761c) {
            Sequence c = m17149c();
            if (c != null) {
                SequenceLoggerDetour.a(c, loadingState.name(), 837874184);
            }
        }
    }

    public final void m17153b(LoadingState loadingState) {
        if (this.f16761c) {
            Sequence c = m17149c();
            if (c != null) {
                SequenceLoggerDetour.b(c, loadingState.name(), 530868480);
            }
        }
    }
}
