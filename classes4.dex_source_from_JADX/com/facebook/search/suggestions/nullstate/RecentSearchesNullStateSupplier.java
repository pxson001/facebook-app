package com.facebook.search.suggestions.nullstate;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.FilterInputMode;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.NullStateStatus;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.logging.perf.NullStatePerformanceLogger;
import com.facebook.search.model.CachedSuggestionList;
import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.model.NullStateSuggestionTypeaheadUnit;
import com.facebook.search.model.SeeMoreResultPageUnit;
import com.facebook.search.model.ShortcutTypeaheadUnit;
import com.facebook.search.model.SuggestionGroup.Type;
import com.facebook.search.suggestions.nullstate.mutator.RecentSearchCacheMutator;
import com.facebook.ui.typeahead.OnFetchStateChangedListener;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: load_self_raw_video */
public class RecentSearchesNullStateSupplier extends NullStateSupplier implements RecentSearchesMutator {
    private static volatile RecentSearchesNullStateSupplier f9223s;
    private final RecentSearchesLoader f9224a;
    private final RecentSearchesHelper f9225b;
    private final NullStateCachePolicy f9226c;
    private final QeAccessor f9227d;
    private final Provider<Boolean> f9228e;
    private final GatekeeperStoreImpl f9229f;
    public final GraphSearchErrorReporter f9230g;
    private final Lazy<ScheduledExecutorService> f9231h;
    private final Lazy<RecentSearchCacheMutator> f9232i;
    private final ExecutorService f9233j;
    private final Clock f9234k;
    private final ContentDiscoveryNullStateSupplier f9235l;
    @GuardedBy("this")
    public ListenableFuture<CachedSuggestionList> f9236m;
    @GuardedBy("this")
    private CachedSuggestionList f9237n;
    private ScheduledFuture<?> f9238o;
    public boolean f9239p;
    private NullStateSupplier$NullStateStatusListener f9240q;
    public int f9241r = 0;

    /* compiled from: load_self_raw_video */
    class C05511 implements Runnable {
        final /* synthetic */ RecentSearchesNullStateSupplier f11404a;

        C05511(RecentSearchesNullStateSupplier recentSearchesNullStateSupplier) {
            this.f11404a = recentSearchesNullStateSupplier;
        }

        public void run() {
            if (RecentSearchesNullStateSupplier.m9578o(this.f11404a)) {
                this.f11404a.j();
            }
        }
    }

    /* compiled from: load_self_raw_video */
    class C05522 implements FutureCallback<CachedSuggestionList> {
        final /* synthetic */ RecentSearchesNullStateSupplier f11405a;

        C05522(RecentSearchesNullStateSupplier recentSearchesNullStateSupplier) {
            this.f11405a = recentSearchesNullStateSupplier;
        }

        public void onSuccess(Object obj) {
            CachedSuggestionList cachedSuggestionList = (CachedSuggestionList) obj;
            RecentSearchesNullStateSupplier.m9579p(this.f11405a);
            this.f11405a.a(cachedSuggestionList);
            RecentSearchesNullStateSupplier.m9575a(this.f11405a, cachedSuggestionList.f11766a);
            this.f11405a.f9236m = null;
        }

        public void onFailure(Throwable th) {
            RecentSearchesNullStateSupplier.m9579p(this.f11405a);
            this.f11405a.i();
            this.f11405a.f9230g.a(GraphSearchError.FETCH_NULL_STATE_RECENT_SEARCHES_FAIL, th);
            this.f11405a.f9236m = null;
        }
    }

    public static com.facebook.search.suggestions.nullstate.RecentSearchesNullStateSupplier m9574a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9223s;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.suggestions.nullstate.RecentSearchesNullStateSupplier.class;
        monitor-enter(r1);
        r0 = f9223s;	 Catch:{ all -> 0x003a }
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
        r0 = m9576b(r0);	 Catch:{ all -> 0x0035 }
        f9223s = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9223s;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.suggestions.nullstate.RecentSearchesNullStateSupplier.a(com.facebook.inject.InjectorLike):com.facebook.search.suggestions.nullstate.RecentSearchesNullStateSupplier");
    }

    private static RecentSearchesNullStateSupplier m9576b(InjectorLike injectorLike) {
        return new RecentSearchesNullStateSupplier(RecentSearchesLoader.m9604a(injectorLike), RecentSearchesHelper.m9612a(injectorLike), NullStatePerformanceLogger.m9623a(injectorLike), NullStateCachePolicy.m9649a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4323), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), GraphSearchErrorReporter.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 4529), IdBasedLazy.a(injectorLike, 10862), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), ContentDiscoveryNullStateSupplier.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    public final void mo741a(SeeMoreResultPageUnit seeMoreResultPageUnit) {
        m9577b(NullStateSuggestionTypeaheadUnit.a(seeMoreResultPageUnit.a));
    }

    @Inject
    public RecentSearchesNullStateSupplier(RecentSearchesLoader recentSearchesLoader, RecentSearchesHelper recentSearchesHelper, NullStatePerformanceLogger nullStatePerformanceLogger, NullStateCachePolicy nullStateCachePolicy, QeAccessor qeAccessor, Provider<Boolean> provider, GatekeeperStore gatekeeperStore, GraphSearchErrorReporter graphSearchErrorReporter, Lazy<ScheduledExecutorService> lazy, Lazy<RecentSearchCacheMutator> lazy2, ExecutorService executorService, ContentDiscoveryNullStateSupplier contentDiscoveryNullStateSupplier, Clock clock) {
        super(nullStatePerformanceLogger);
        this.f9224a = recentSearchesLoader;
        this.f9225b = recentSearchesHelper;
        this.f9226c = nullStateCachePolicy;
        this.f9227d = qeAccessor;
        this.f9228e = provider;
        this.f9229f = gatekeeperStore;
        this.f9230g = graphSearchErrorReporter;
        this.f9231h = lazy;
        this.f9232i = lazy2;
        this.f9233j = executorService;
        this.f9234k = clock;
        this.f9235l = contentDiscoveryNullStateSupplier;
        this.f9239p = m9596m();
    }

    public final boolean m9590a() {
        return !this.f9227d.a(ExperimentsForSearchAbTestModule.aQ, false);
    }

    public final void m9581a(@Nullable CallerContext callerContext, NullStateSupplier$RefreshPolicy nullStateSupplier$RefreshPolicy) {
        m9580a(callerContext, nullStateSupplier$RefreshPolicy == NullStateSupplier$RefreshPolicy.NETWORK_ONLY ? GraphQLCachePolicy.d : GraphQLCachePolicy.a, 259200);
    }

    public Object get() {
        Object of;
        synchronized (this) {
            if (this.f9237n == null || this.f9237n.m12345d()) {
                this.f9241r = 0;
                of = ImmutableList.of();
            } else {
                int size = this.f9237n.m12343a().size();
                int a = (this.f9235l.d() || !((Boolean) this.f9228e.get()).booleanValue()) ? 15 : this.f9227d.a(ExperimentsForSearchAbTestModule.aO, 3);
                this.f9241r = this.f9239p ? size : Math.min(size, a);
                if (this.f9227d.a(ExperimentsForSearchAbTestModule.aL, false)) {
                    of = this.f9225b.m9614a(Type.RECENT, this.f9237n);
                } else {
                    of = this.f9225b.m9615a(Type.RECENT, this.f9237n, this.f9239p, this.f9241r);
                }
            }
        }
        return of;
    }

    public final synchronized void m9591b() {
        this.f9237n = null;
    }

    public final synchronized NullStateStatus m9592c() {
        NullStateStatus nullStateStatus;
        if (this.f9237n == null || !this.f9226c.m9651a(3600, this.f9237n.m12344b())) {
            nullStateStatus = NullStateStatus.NOT_READY;
        } else {
            nullStateStatus = NullStateStatus.READY;
        }
        return nullStateStatus;
    }

    public final void m9589a(NullStateSupplier$NullStateStatusListener nullStateSupplier$NullStateStatusListener, OnFetchStateChangedListener onFetchStateChangedListener) {
        this.f9240q = nullStateSupplier$NullStateStatusListener;
    }

    public final void m9588a(Type type) {
        if (type == Type.RECENT) {
            this.f9239p = true;
        }
    }

    public final void m9582a(GraphSearchQuery graphSearchQuery) {
    }

    public final void mo738a(EntityTypeaheadUnit entityTypeaheadUnit) {
        m9577b(NullStateSuggestionTypeaheadUnit.a(entityTypeaheadUnit));
    }

    public final void mo742a(ShortcutTypeaheadUnit shortcutTypeaheadUnit) {
        m9577b(NullStateSuggestionTypeaheadUnit.a(shortcutTypeaheadUnit));
    }

    public final void mo740a(NullStateSuggestionTypeaheadUnit nullStateSuggestionTypeaheadUnit) {
        m9577b(NullStateSuggestionTypeaheadUnit.a(nullStateSuggestionTypeaheadUnit));
    }

    public final void mo739a(KeywordTypeaheadUnit keywordTypeaheadUnit) {
        m9577b(NullStateSuggestionTypeaheadUnit.a(keywordTypeaheadUnit));
    }

    public final void mo743d() {
        if (!m9596m()) {
            this.f9239p = false;
        }
    }

    public final ListenableFuture<Void> mo744e() {
        b();
        return ((RecentSearchCacheMutator) this.f9232i.get()).a("recent_search_cache_tag");
    }

    public static synchronized boolean m9578o(RecentSearchesNullStateSupplier recentSearchesNullStateSupplier) {
        boolean z = true;
        synchronized (recentSearchesNullStateSupplier) {
            if (recentSearchesNullStateSupplier.f9236m == null || recentSearchesNullStateSupplier.f9236m.isDone()) {
                z = false;
            } else {
                recentSearchesNullStateSupplier.f9236m.cancel(true);
                recentSearchesNullStateSupplier.f9236m = null;
            }
        }
        return z;
    }

    public final synchronized ListenableFuture<CachedSuggestionList> m9580a(@Nullable CallerContext callerContext, GraphQLCachePolicy graphQLCachePolicy, long j) {
        ListenableFuture<CachedSuggestionList> listenableFuture;
        if (this.f9236m != null) {
            listenableFuture = this.f9236m;
        } else {
            FilterInputMode filterInputMode = (!this.f9229f.a(SearchAbTestGatekeepers.f).asBoolean(false) || this.f9229f.a(SearchAbTestGatekeepers.u, false) || this.f9227d.a(ExperimentsForSearchAbTestModule.aJ, false)) ? FilterInputMode.ENTITY_ONLY : FilterInputMode.ALL;
            h();
            this.f9236m = this.f9224a.m9606a("recent_search_cache_tag", filterInputMode, 15, callerContext, graphQLCachePolicy, j);
            this.f9238o = ((ScheduledExecutorService) this.f9231h.get()).schedule(new C05511(this), 10, TimeUnit.SECONDS);
            Futures.a(this.f9236m, new C05522(this), this.f9233j);
            listenableFuture = this.f9236m;
        }
        return listenableFuture;
    }

    protected final String m9595g() {
        return "recent_searches_network";
    }

    public static synchronized void m9575a(RecentSearchesNullStateSupplier recentSearchesNullStateSupplier, ImmutableList immutableList) {
        synchronized (recentSearchesNullStateSupplier) {
            recentSearchesNullStateSupplier.f9237n = new CachedSuggestionList(ImmutableList.copyOf(immutableList), recentSearchesNullStateSupplier.f9234k.a());
            if (recentSearchesNullStateSupplier.f9240q != null) {
                recentSearchesNullStateSupplier.f9240q.mo745a(NullStateStatus.READY);
            }
        }
    }

    private synchronized void m9577b(NullStateSuggestionTypeaheadUnit nullStateSuggestionTypeaheadUnit) {
        if (!(this.f9227d.a(ExperimentsForSearchAbTestModule.aJ, false) && nullStateSuggestionTypeaheadUnit.z())) {
            m9575a(this, this.f9225b.m9616a("recent_search_cache_tag", nullStateSuggestionTypeaheadUnit, this.f9237n));
        }
    }

    public static void m9579p(RecentSearchesNullStateSupplier recentSearchesNullStateSupplier) {
        if (recentSearchesNullStateSupplier.f9238o != null) {
            recentSearchesNullStateSupplier.f9238o.cancel(true);
            recentSearchesNullStateSupplier.f9238o = null;
        }
    }

    public final boolean m9596m() {
        return this.f9227d.a(ExperimentsForSearchAbTestModule.aM, false) || this.f9227d.a(ExperimentsForSearchAbTestModule.H, false);
    }
}
