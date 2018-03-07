package com.facebook.search.bootstrap.db;

import com.facebook.inject.InjectorLike;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.ui.typeahead.TypeaheadRequest;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableSet;
import java.util.HashMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: extra_ComposerLaunchActivity_session_id */
public class DbBootstrapPerformanceLogger {
    @VisibleForTesting
    static final SearchBootstrapLoadSequenceDefinition f15631a = new SearchBootstrapLoadSequenceDefinition();
    static final SearchBootstrapFetchSequenceDefinition f15632b = new SearchBootstrapFetchSequenceDefinition();
    static final SearchBootstrapIndexLoadSequenceDefinition f15633c = new SearchBootstrapIndexLoadSequenceDefinition();
    static final SearchBootstrapPrefetchLoadSequenceDefinition f15634d = new SearchBootstrapPrefetchLoadSequenceDefinition();
    static final SearchBootstrapDeltaLoadSequenceDefinition f15635e = new SearchBootstrapDeltaLoadSequenceDefinition();
    static final SearchBootstrapRecentSearchDeltaSequenceDefinition f15636f = new SearchBootstrapRecentSearchDeltaSequenceDefinition();
    private static volatile DbBootstrapPerformanceLogger f15637k;
    private int f15638g = 0;
    private final HashMap<TypeaheadRequest, Integer> f15639h = Maps.c();
    @GuardedBy("this")
    private final SequenceLogger f15640i;
    @GuardedBy("this")
    private boolean f15641j = false;

    @VisibleForTesting
    /* compiled from: extra_ComposerLaunchActivity_session_id */
    final class SearchBootstrapDeltaLoadSequenceDefinition extends AbstractSequenceDefinition {
        public SearchBootstrapDeltaLoadSequenceDefinition() {
            super(458778, "SearchDbBootstrapDeltaLoad", false, RegularImmutableSet.a);
        }
    }

    @VisibleForTesting
    /* compiled from: extra_ComposerLaunchActivity_session_id */
    final class SearchBootstrapFetchSequenceDefinition extends AbstractSequenceDefinition {
        public SearchBootstrapFetchSequenceDefinition() {
            super(458775, "SearchDbBootstrapFetch", false, RegularImmutableSet.a);
        }
    }

    @VisibleForTesting
    /* compiled from: extra_ComposerLaunchActivity_session_id */
    final class SearchBootstrapIndexLoadSequenceDefinition extends AbstractSequenceDefinition {
        public SearchBootstrapIndexLoadSequenceDefinition() {
            super(458776, "SearchDbBootstrapIndexLoad", false, RegularImmutableSet.a);
        }
    }

    @VisibleForTesting
    /* compiled from: extra_ComposerLaunchActivity_session_id */
    final class SearchBootstrapLoadSequenceDefinition extends AbstractSequenceDefinition {
        public SearchBootstrapLoadSequenceDefinition() {
            super(458774, "SearchDbBootstrapLoad", false, RegularImmutableSet.a);
        }
    }

    @VisibleForTesting
    /* compiled from: extra_ComposerLaunchActivity_session_id */
    final class SearchBootstrapPrefetchLoadSequenceDefinition extends AbstractSequenceDefinition {
        public SearchBootstrapPrefetchLoadSequenceDefinition() {
            super(458777, "SearchDbBootstrapPrefetchLoad", false, RegularImmutableSet.a);
        }
    }

    @VisibleForTesting
    /* compiled from: extra_ComposerLaunchActivity_session_id */
    final class SearchBootstrapRecentSearchDeltaSequenceDefinition extends AbstractSequenceDefinition {
        public SearchBootstrapRecentSearchDeltaSequenceDefinition() {
            super(458779, "SearchDbBootstrapRecentSearchDelta", false, RegularImmutableSet.a);
        }
    }

    public static com.facebook.search.bootstrap.db.DbBootstrapPerformanceLogger m23345a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15637k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.bootstrap.db.DbBootstrapPerformanceLogger.class;
        monitor-enter(r1);
        r0 = f15637k;	 Catch:{ all -> 0x003a }
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
        r0 = m23347b(r0);	 Catch:{ all -> 0x0035 }
        f15637k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15637k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.bootstrap.db.DbBootstrapPerformanceLogger.a(com.facebook.inject.InjectorLike):com.facebook.search.bootstrap.db.DbBootstrapPerformanceLogger");
    }

    private static DbBootstrapPerformanceLogger m23347b(InjectorLike injectorLike) {
        return new DbBootstrapPerformanceLogger((SequenceLogger) SequenceLoggerImpl.a(injectorLike));
    }

    @Inject
    public DbBootstrapPerformanceLogger(SequenceLogger sequenceLogger) {
        this.f15640i = sequenceLogger;
    }

    public final synchronized void m23361a(boolean z) {
        this.f15641j = z;
    }

    public final synchronized void m23356a() {
        Sequence j = m23352j();
        SequenceLoggerDetour.a(j, "time_to_load_bootstrap_from_search_button_clicked", 1457790223);
        if (this.f15641j) {
            SequenceLoggerDetour.b(j, "time_to_load_bootstrap_from_search_button_clicked", -502713026);
            this.f15640i.b(f15631a);
        }
    }

    public final synchronized void m23357a(long j, String str) {
        SequenceLoggerDetour.a(m23352j(), str, null, ImmutableBiMap.b("time_since_last_fetch", String.valueOf(j)), 594536831);
    }

    public final void m23359a(String str) {
        Sequence f = m23348f();
        if (f != null) {
            SequenceLoggerDetour.a(f, str, -1058723394);
        }
    }

    public final void m23365b(String str) {
        Sequence f = m23348f();
        if (f != null) {
            SequenceLoggerDetour.b(f, str, -1188875048);
        }
    }

    public final synchronized void m23368c(String str) {
        this.f15641j = true;
        Sequence f = m23348f();
        if (f != null) {
            SequenceLoggerDetour.b(f, str, 1369864129);
            if (f.f("time_to_load_bootstrap_from_search_button_clicked")) {
                SequenceLoggerDetour.b(f, "time_to_load_bootstrap_from_search_button_clicked", 1779231482);
            }
            this.f15640i.b(f15631a);
        }
    }

    public final synchronized void m23362a(boolean z, Exception exception, String str) {
        Sequence f = m23348f();
        if (f != null) {
            SequenceLoggerDetour.c(f, str, null, ImmutableMap.of("delta_sync", String.valueOf(z), "error", exception.getMessage() == null ? exception.toString() : exception.getMessage()), 1571307975);
            SequenceLoggerDetour.c(f, str, null, ImmutableBiMap.b("source", "post_fetch"), -1732516851);
            if (f.f("time_to_load_bootstrap_from_search_button_clicked")) {
                SequenceLoggerDetour.c(f, "time_to_load_bootstrap_from_search_button_clicked", -233645231);
            }
            this.f15640i.b(f15631a);
        }
    }

    public final synchronized void m23370d(String str) {
        Sequence f = m23348f();
        if (f != null) {
            SequenceLoggerDetour.c(f, str, null, ImmutableBiMap.b("source", "network"), -554095216);
            if (f.f("time_to_load_bootstrap_from_search_button_clicked")) {
                SequenceLoggerDetour.c(f, "time_to_load_bootstrap_from_search_button_clicked", 95426919);
            }
            this.f15640i.b(f15631a);
        }
    }

    public final void m23358a(TypeaheadRequest typeaheadRequest) {
        int i = this.f15638g;
        this.f15638g++;
        if (this.f15639h.get(typeaheadRequest) == null) {
            this.f15639h.put(typeaheadRequest, Integer.valueOf(i));
            SequenceLoggerDetour.a(m23353k(), "executor_waiting_time", String.valueOf(i), null, -1703766696);
        }
    }

    public final synchronized void m23363b() {
        SequenceLoggerDetour.a(m23354l(), "time_to_prefetch_bootstrap", -1824098903);
    }

    public final synchronized void m23366c() {
        SequenceLoggerDetour.b(m23354l(), "time_to_prefetch_bootstrap", 2109012274);
        this.f15640i.b(f15634d);
    }

    public final synchronized void m23369d() {
        Sequence h = m23350h();
        if (h != null) {
            SequenceLoggerDetour.c(h, "time_to_prefetch_bootstrap", -930329686);
            this.f15640i.b(f15634d);
        }
    }

    public final synchronized void m23372e(String str) {
        SequenceLoggerDetour.a(m23355m(), "time_to_delta_load_bootstrap", str, null, 922696922);
    }

    public final synchronized void m23360a(String str, @Nullable ImmutableMap<String, String> immutableMap) {
        SequenceLoggerDetour.b(m23355m(), "time_to_delta_load_bootstrap", str, immutableMap, 718902601);
        this.f15640i.b(f15635e);
    }

    public final synchronized void m23373f(String str) {
        Sequence i = m23351i();
        if (i != null) {
            SequenceLoggerDetour.c(i, "time_to_delta_load_bootstrap", str, null, -1379508231);
            this.f15640i.b(f15635e);
        }
    }

    public final void m23364b(TypeaheadRequest typeaheadRequest) {
        m23346a("result_parsing_time", "ui_thread_waiting_time", typeaheadRequest);
    }

    public final void m23367c(TypeaheadRequest typeaheadRequest) {
        m23346a("ui_thread_waiting_time", null, typeaheadRequest);
    }

    private void m23346a(String str, @Nullable String str2, TypeaheadRequest typeaheadRequest) {
        Sequence g = m23349g();
        Integer num = (Integer) this.f15639h.get(typeaheadRequest);
        if (g != null && num != null) {
            SequenceLoggerDetour.b(g, str, String.valueOf(num), null, -2037851604);
            if (str2 != null) {
                SequenceLoggerDetour.a(g, str2, String.valueOf(num), null, -936831760);
            }
        }
    }

    public final synchronized void m23371e() {
        if (m23349g() != null) {
            this.f15640i.b(f15632b);
        }
    }

    private synchronized Sequence<?> m23348f() {
        return this.f15640i.e(f15631a);
    }

    private synchronized Sequence<?> m23349g() {
        return this.f15640i.e(f15632b);
    }

    private synchronized Sequence<?> m23350h() {
        return this.f15640i.e(f15634d);
    }

    private synchronized Sequence<?> m23351i() {
        return this.f15640i.e(f15635e);
    }

    private synchronized Sequence<?> m23352j() {
        Sequence<?> f;
        f = m23348f();
        if (f == null) {
            f = this.f15640i.a(f15631a);
        }
        return f;
    }

    private synchronized Sequence<?> m23353k() {
        Sequence<?> g;
        g = m23349g();
        if (g == null) {
            g = this.f15640i.a(f15632b);
        }
        return g;
    }

    private synchronized Sequence<?> m23354l() {
        Sequence<?> h;
        h = m23350h();
        if (h == null) {
            h = this.f15640i.a(f15634d);
        }
        return h;
    }

    private synchronized Sequence<?> m23355m() {
        Sequence<?> i;
        i = m23351i();
        if (i == null) {
            i = this.f15640i.a(f15635e);
        }
        return i;
    }
}
