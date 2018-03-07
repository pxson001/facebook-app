package com.facebook.search.logging.perf;

import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.inject.InjectorLike;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceDefinition;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: Tapping a trigger will show the eligible QP Interstitial */
public class GraphSearchPerformanceLogger implements OnDrawListener {
    private static volatile GraphSearchPerformanceLogger f22012c;
    public final SequenceLogger f22013a;
    private final MonotonicClock f22014b;

    public static com.facebook.search.logging.perf.GraphSearchPerformanceLogger m25549a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f22012c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.logging.perf.GraphSearchPerformanceLogger.class;
        monitor-enter(r1);
        r0 = f22012c;	 Catch:{ all -> 0x003a }
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
        r0 = m25553b(r0);	 Catch:{ all -> 0x0035 }
        f22012c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f22012c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.logging.perf.GraphSearchPerformanceLogger.a(com.facebook.inject.InjectorLike):com.facebook.search.logging.perf.GraphSearchPerformanceLogger");
    }

    private static GraphSearchPerformanceLogger m25553b(InjectorLike injectorLike) {
        return new GraphSearchPerformanceLogger((SequenceLogger) SequenceLoggerImpl.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public GraphSearchPerformanceLogger(SequenceLogger sequenceLogger, MonotonicClock monotonicClock) {
        this.f22013a = sequenceLogger;
        this.f22014b = monotonicClock;
    }

    public final boolean gD_() {
        m25556h();
        m25564e();
        return true;
    }

    public final void m25559a() {
        m25557i();
        m25555g();
    }

    public final void m25563c() {
        m25558j();
        m25555g();
    }

    public final void m25560a(ImmutableList<GraphQLGraphSearchResultsDisplayStyle> immutableList) {
        m25550a(SearchSequences.f22023a, (ImmutableList) immutableList, true);
    }

    public final void m25562b(ImmutableList<GraphQLGraphSearchResultsDisplayStyle> immutableList) {
        m25550a(SearchSequences.f22023a, (ImmutableList) immutableList, false);
    }

    public final void m25564e() {
        if (this.f22013a.e(SearchSequences.f22023a) != null) {
            this.f22013a.b(SearchSequences.f22023a);
        }
    }

    private void m25555g() {
        m25551a(SearchSequences.f22023a, "post_processing");
    }

    private void m25556h() {
        m25554b(SearchSequences.f22023a, "post_processing");
    }

    public final void m25565f() {
        m25551a(SearchSequences.f22023a, "network_operation");
    }

    private void m25557i() {
        m25554b(SearchSequences.f22023a, "network_operation");
    }

    private void m25558j() {
        m25552a(SearchSequences.f22023a, "network_operation", true);
    }

    public final void m25561b() {
        String str = "network_operation";
        Sequence e = this.f22013a.e(SearchSequences.f22023a);
        if (e != null) {
            SequenceLoggerDetour.c(e, str, -111025634);
        }
        m25555g();
    }

    private void m25550a(SequenceDefinition sequenceDefinition, ImmutableList<GraphQLGraphSearchResultsDisplayStyle> immutableList, boolean z) {
        this.f22013a.a(sequenceDefinition, ImmutableMap.of("results_display_styles", immutableList.toString(), "initial_fetch", String.valueOf(z)), this.f22014b.now());
    }

    private void m25551a(AbstractSequenceDefinition abstractSequenceDefinition, String str) {
        Sequence e = this.f22013a.e(abstractSequenceDefinition);
        if (e != null) {
            SequenceLoggerDetour.a(e, str, 269141958);
        }
    }

    private void m25554b(AbstractSequenceDefinition abstractSequenceDefinition, String str) {
        m25552a(abstractSequenceDefinition, str, false);
    }

    private void m25552a(AbstractSequenceDefinition abstractSequenceDefinition, String str, boolean z) {
        Sequence e = this.f22013a.e(abstractSequenceDefinition);
        if (e != null) {
            ImmutableMap b;
            if (z) {
                b = ImmutableBiMap.b("canceled", String.valueOf(z));
            } else {
                b = null;
            }
            SequenceLoggerDetour.b(e, str, null, b, 1149770350);
        }
    }
}
