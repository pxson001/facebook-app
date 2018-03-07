package com.facebook.search.logging.perf;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.api.NullStateStatus;
import com.facebook.search.model.CachedSuggestionList;
import com.facebook.search.model.SearchBoxQueryState;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.NoOpSequence;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: live_video_id */
public class NullStatePerformanceLogger {
    @VisibleForTesting
    public static final NullStatePerformanceSequenceDefinition f9258a = new NullStatePerformanceSequenceDefinition(458773, "NullStatePerfLogger");
    @VisibleForTesting
    public static final NullStatePerformanceSequenceDefinition f9259b = new NullStatePerformanceSequenceDefinition(458773, "GraphSearchNullStatePerfLogger");
    private static final Sequence f9260c = new NoOpSequence();
    private static volatile NullStatePerformanceLogger f9261j;
    private boolean f9262d = true;
    private final SequenceLogger f9263e;
    private final QuickPerformanceLogger f9264f;
    private final GatekeeperStoreImpl f9265g;
    private InFlightSequenceType f9266h = InFlightSequenceType.NONE;
    public NullStateStatus f9267i;

    @VisibleForTesting
    /* compiled from: live_video_id */
    public class NullStatePerformanceSequenceDefinition extends AbstractSequenceDefinition {
        private static final ImmutableSet<String> f9268a = ImmutableSet.of("com.facebook.search.suggestions.SuggestionsFragment", "com.facebook.search.fragment.GraphSearchFragment");

        public NullStatePerformanceSequenceDefinition(int i, String str) {
            super(i, str, false, f9268a);
        }
    }

    @VisibleForTesting
    /* compiled from: live_video_id */
    public enum InFlightSequenceType {
        COLD_START,
        WARM_START,
        NONE
    }

    public static com.facebook.search.logging.perf.NullStatePerformanceLogger m9623a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9261j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.logging.perf.NullStatePerformanceLogger.class;
        monitor-enter(r1);
        r0 = f9261j;	 Catch:{ all -> 0x003a }
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
        r0 = m9627b(r0);	 Catch:{ all -> 0x0035 }
        f9261j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9261j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.logging.perf.NullStatePerformanceLogger.a(com.facebook.inject.InjectorLike):com.facebook.search.logging.perf.NullStatePerformanceLogger");
    }

    private static NullStatePerformanceLogger m9627b(InjectorLike injectorLike) {
        return new NullStatePerformanceLogger((SequenceLogger) SequenceLoggerImpl.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public NullStatePerformanceLogger(SequenceLogger sequenceLogger, QuickPerformanceLogger quickPerformanceLogger, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f9263e = sequenceLogger;
        this.f9264f = quickPerformanceLogger;
        this.f9265g = gatekeeperStoreImpl;
    }

    public final void m9635a() {
        Sequence b = m9628b(InFlightSequenceType.COLD_START);
        m9626a(b, EntryAction.SEARCH_ICON_CLICKED);
        if (!b.f("pre_fetch")) {
            SequenceLoggerDetour.a(b, "pre_fetch", 789467872);
        }
    }

    public final void m9640b() {
        Sequence i = m9631i();
        if (i != null) {
            SequenceLoggerDetour.a(i, "activity_transition", -1766125266);
        }
    }

    public final void m9642c() {
        Sequence i = m9631i();
        if (i != null) {
            SequenceLoggerDetour.b(i, "activity_transition", -1801398103);
            SequenceLoggerDetour.a(i, "fragment_creation", -475452711);
        }
    }

    public final void m9644d() {
        Sequence i = m9631i();
        if (i != null) {
            SequenceLoggerDetour.b(i, "fragment_creation", 761993413);
            SequenceLoggerDetour.a(i, "create_view_hierarchy", -1407373555);
        }
    }

    public final void m9645e() {
        Sequence i = m9631i();
        if (i != null) {
            SequenceLoggerDetour.b(i, "create_view_hierarchy", 450144264);
            SequenceLoggerDetour.a(i, "after_view_creation", 1785800959);
        }
    }

    public final void m9646f() {
        Sequence i = m9631i();
        if (i != null && i.f("after_view_creation")) {
            SequenceLoggerDetour.b(i, "after_view_creation", -628059712);
            SequenceLoggerDetour.a(i, "on_resume", -1844258086);
        }
    }

    public final void m9647g() {
        m9626a(m9624a(InFlightSequenceType.WARM_START), EntryAction.BACK_PRESSED);
    }

    public final void m9639a(String str) {
        SequenceLoggerDetour.b(m9629d("pre_fetch"), "pre_fetch", -817603336);
        m9630e(str);
    }

    public final void m9637a(CachedSuggestionList cachedSuggestionList, String str) {
        SequenceLoggerDetour.b(m9629d(str), str, null, ImmutableBiMap.b("data_freshness", cachedSuggestionList.f11768c.name()), 2040786700);
    }

    public final void m9641b(String str) {
        SequenceLoggerDetour.c(m9629d(str), str, 1959264719);
    }

    public final void m9643c(String str) {
        SequenceLoggerDetour.b(m9629d(str), str, null, ImmutableBiMap.b("fetch_timeout", str), -1141888312);
    }

    public final void m9638a(@Nullable SearchBoxQueryState searchBoxQueryState) {
        SequenceLoggerDetour.b(m9629d("post_processing"), "post_processing", -1278138412);
        SequenceLoggerDetour.b(m9629d("end_to_end"), "end_to_end", null, ImmutableMap.of("query_state", searchBoxQueryState != null ? searchBoxQueryState.name() : "null", "is_first_sequence", Boolean.toString(this.f9262d)), -1631359311);
        m9632j();
        if (this.f9262d) {
            this.f9262d = false;
        }
    }

    public final void m9648h() {
        m9633k();
    }

    private void m9625a(InFlightSequenceType inFlightSequenceType, EntryAction entryAction) {
        Sequence a = m9624a(inFlightSequenceType);
        m9626a(a, entryAction);
        if (a.f("pre_fetch")) {
            SequenceLoggerDetour.b(a, "pre_fetch", 1945424166);
            if (a.f("on_resume")) {
                SequenceLoggerDetour.b(a, "on_resume", -2131376855);
            }
        }
        if (!a.f("post_processing")) {
            SequenceLoggerDetour.a(a, "post_processing", 928875800);
        }
    }

    private Sequence<NullStatePerformanceSequenceDefinition> m9624a(InFlightSequenceType inFlightSequenceType) {
        Sequence<NullStatePerformanceSequenceDefinition> e = this.f9263e.e(m9634l());
        if (e != null && this.f9266h == InFlightSequenceType.COLD_START) {
            return e;
        }
        m9633k();
        return m9628b(inFlightSequenceType);
    }

    @Nullable
    private Sequence<NullStatePerformanceSequenceDefinition> m9631i() {
        if (this.f9266h == InFlightSequenceType.COLD_START) {
            return this.f9263e.e(m9634l());
        }
        return null;
    }

    private Sequence<NullStatePerformanceSequenceDefinition> m9629d(String str) {
        Sequence<NullStatePerformanceSequenceDefinition> e = this.f9263e.e(m9634l());
        return (e == null || !e.f(str)) ? f9260c : e;
    }

    private void m9630e(String str) {
        Sequence e = this.f9263e.e(m9634l());
        if (e != null && !e.f(str)) {
            SequenceLoggerDetour.a(e, str, -1734501002);
        }
    }

    private static void m9626a(Sequence sequence, EntryAction entryAction) {
        if (!sequence.f("end_to_end")) {
            SequenceLoggerDetour.a(sequence, "end_to_end", null, ImmutableBiMap.b("entry_action", entryAction.name()), -1782139922);
        }
    }

    private Sequence<NullStatePerformanceSequenceDefinition> m9628b(InFlightSequenceType inFlightSequenceType) {
        this.f9266h = inFlightSequenceType;
        this.f9264f.b(458773);
        return this.f9263e.a(m9634l());
    }

    private void m9632j() {
        if (this.f9263e.e(m9634l()) != null) {
            this.f9263e.b(m9634l());
            this.f9264f.b(458773, (short) 2);
        }
        this.f9266h = InFlightSequenceType.NONE;
    }

    private void m9633k() {
        this.f9263e.d(m9634l());
        this.f9264f.b(458773, (short) 4);
        this.f9266h = InFlightSequenceType.NONE;
    }

    private NullStatePerformanceSequenceDefinition m9634l() {
        if (this.f9265g.a(SearchAbTestGatekeepers.f).asBoolean(false)) {
            return f9259b;
        }
        return f9258a;
    }

    public final void m9636a(NullStateStatus nullStateStatus) {
        Object obj;
        if (this.f9267i == NullStateStatus.PARTIAL && nullStateStatus == NullStateStatus.READY) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            m9625a(InFlightSequenceType.WARM_START, EntryAction.TYPEAHEAD_CLEARED);
        }
        this.f9267i = nullStateStatus;
    }
}
