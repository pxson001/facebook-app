package com.facebook.search.logging.perf;

import com.facebook.apptab.state.TabBarStateManager;
import com.facebook.apptab.state.abtest.NavImmersiveExperiment;
import com.facebook.inject.InjectorLike;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.collect.ImmutableBiMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: TYPE_CREATE_FLOW */
public class SearchWaterfallLogger {
    private static volatile SearchWaterfallLogger f22025e;
    private final SequenceLogger f22026a;
    private final TabBarStateManager f22027b;
    private final NavImmersiveExperiment f22028c;
    private boolean f22029d = false;

    public static com.facebook.search.logging.perf.SearchWaterfallLogger m25591a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f22025e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.logging.perf.SearchWaterfallLogger.class;
        monitor-enter(r1);
        r0 = f22025e;	 Catch:{ all -> 0x003a }
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
        r0 = m25593b(r0);	 Catch:{ all -> 0x0035 }
        f22025e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f22025e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.logging.perf.SearchWaterfallLogger.a(com.facebook.inject.InjectorLike):com.facebook.search.logging.perf.SearchWaterfallLogger");
    }

    private static SearchWaterfallLogger m25593b(InjectorLike injectorLike) {
        return new SearchWaterfallLogger((SequenceLogger) SequenceLoggerImpl.a(injectorLike), TabBarStateManager.a(injectorLike), NavImmersiveExperiment.a(injectorLike));
    }

    @Inject
    public SearchWaterfallLogger(SequenceLogger sequenceLogger, TabBarStateManager tabBarStateManager, NavImmersiveExperiment navImmersiveExperiment) {
        this.f22026a = sequenceLogger;
        this.f22027b = tabBarStateManager;
        this.f22028c = navImmersiveExperiment;
    }

    public final void m25597a() {
        m25595h();
        m25592a("entered_search_via_button");
    }

    public final void m25599b() {
        m25594g();
        m25592a("search_fragment_resumed");
    }

    public final void m25600c() {
        m25592a("search_fragment_paused");
    }

    public final void m25598a(int i) {
        if (i > 0) {
            m25592a("new_suggestions_loaded");
        }
    }

    public final void m25601d() {
        if (!this.f22029d) {
            this.f22029d = true;
            m25592a("showed_soft_input");
        }
    }

    public final void m25602e() {
        m25592a("exited_search_via_back_button");
        m25596i();
    }

    public final void m25603f() {
        m25592a("exited_search_via_search_result");
        m25596i();
    }

    private void m25594g() {
        if (this.f22026a.e(SearchSequences.f22024b) == null) {
            m25595h();
        }
    }

    private void m25595h() {
        this.f22029d = false;
        this.f22026a.a(SearchSequences.f22024b, ImmutableBiMap.b("immersive_views_on", "true"));
        Sequence e = this.f22026a.e(SearchSequences.f22024b);
        if (e != null) {
            NavImmersiveExperiment navImmersiveExperiment = this.f22028c;
            e.b("immersive_views_11_06", navImmersiveExperiment.a.c(navImmersiveExperiment).a);
        }
    }

    private void m25596i() {
        this.f22026a.b(SearchSequences.f22024b);
    }

    private void m25592a(String str) {
        Sequence e = this.f22026a.e(SearchSequences.f22024b);
        if (e != null) {
            SequenceLoggerDetour.e(e, str, -2038487814);
        }
    }
}
