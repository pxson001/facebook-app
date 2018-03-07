package com.facebook.search.suggestions.nullstate;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.graphql.calls.FilterInputMode;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.NullStateStatus;
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
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: limit */
public class RecentVideoSearchesNullStateSupplier extends NullStateSupplier implements RecentSearchesMutator {
    private static volatile RecentVideoSearchesNullStateSupplier f9327o;
    private final RecentSearchesLoader f9328a;
    private final RecentSearchesHelper f9329b;
    private final NullStateCachePolicy f9330c;
    public final GraphSearchErrorReporter f9331d;
    private final Lazy<ScheduledExecutorService> f9332e;
    private final Lazy<RecentSearchCacheMutator> f9333f;
    private final ExecutorService f9334g;
    private final Clock f9335h;
    @GuardedBy("this")
    public ListenableFuture<CachedSuggestionList> f9336i;
    @GuardedBy("this")
    private CachedSuggestionList f9337j;
    private ScheduledFuture<?> f9338k;
    private boolean f9339l = false;
    private NullStateSupplier$NullStateStatusListener f9340m;
    private final QeAccessor f9341n;

    public static com.facebook.search.suggestions.nullstate.RecentVideoSearchesNullStateSupplier m9721a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9327o;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.suggestions.nullstate.RecentVideoSearchesNullStateSupplier.class;
        monitor-enter(r1);
        r0 = f9327o;	 Catch:{ all -> 0x003a }
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
        r0 = m9724b(r0);	 Catch:{ all -> 0x0035 }
        f9327o = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9327o;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.suggestions.nullstate.RecentVideoSearchesNullStateSupplier.a(com.facebook.inject.InjectorLike):com.facebook.search.suggestions.nullstate.RecentVideoSearchesNullStateSupplier");
    }

    private static RecentVideoSearchesNullStateSupplier m9724b(InjectorLike injectorLike) {
        return new RecentVideoSearchesNullStateSupplier(RecentSearchesLoader.m9604a(injectorLike), RecentSearchesHelper.m9612a(injectorLike), NullStatePerformanceLogger.m9623a(injectorLike), NullStateCachePolicy.m9649a(injectorLike), GraphSearchErrorReporter.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 4529), IdBasedLazy.a(injectorLike, 10862), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final void mo741a(SeeMoreResultPageUnit seeMoreResultPageUnit) {
        m9725b(NullStateSuggestionTypeaheadUnit.a(seeMoreResultPageUnit.a));
    }

    @Inject
    public RecentVideoSearchesNullStateSupplier(RecentSearchesLoader recentSearchesLoader, RecentSearchesHelper recentSearchesHelper, NullStatePerformanceLogger nullStatePerformanceLogger, NullStateCachePolicy nullStateCachePolicy, GraphSearchErrorReporter graphSearchErrorReporter, Lazy<ScheduledExecutorService> lazy, Lazy<RecentSearchCacheMutator> lazy2, ExecutorService executorService, Clock clock, QeAccessor qeAccessor) {
        super(nullStatePerformanceLogger);
        this.f9328a = recentSearchesLoader;
        this.f9329b = recentSearchesHelper;
        this.f9330c = nullStateCachePolicy;
        this.f9331d = graphSearchErrorReporter;
        this.f9332e = lazy;
        this.f9333f = lazy2;
        this.f9334g = executorService;
        this.f9335h = clock;
        this.f9341n = qeAccessor;
    }

    public final boolean m9736a() {
        return true;
    }

    public final void m9727a(@Nullable CallerContext callerContext, NullStateSupplier$RefreshPolicy nullStateSupplier$RefreshPolicy) {
        m9722a(callerContext, nullStateSupplier$RefreshPolicy == NullStateSupplier$RefreshPolicy.NETWORK_ONLY ? GraphQLCachePolicy.d : GraphQLCachePolicy.a, 259200);
    }

    public Object get() {
        Object of;
        synchronized (this) {
            if (this.f9337j == null || this.f9337j.m12345d()) {
                of = ImmutableList.of();
            } else {
                int size = this.f9337j.m12343a().size();
                if (!this.f9339l) {
                    size = Math.min(size, this.f9341n.a(ExperimentsForSearchAbTestModule.aO, 3));
                }
                of = this.f9329b.m9615a(Type.RECENT_VIDEOS, this.f9337j, this.f9339l, size);
            }
        }
        return of;
    }

    public final synchronized void m9737b() {
        this.f9337j = null;
    }

    public final synchronized NullStateStatus m9738c() {
        NullStateStatus nullStateStatus;
        if (this.f9337j == null || !this.f9330c.m9651a(3600, this.f9337j.m12344b())) {
            nullStateStatus = NullStateStatus.NOT_READY;
        } else {
            nullStateStatus = NullStateStatus.READY;
        }
        return nullStateStatus;
    }

    public final void m9735a(NullStateSupplier$NullStateStatusListener nullStateSupplier$NullStateStatusListener, OnFetchStateChangedListener onFetchStateChangedListener) {
        this.f9340m = nullStateSupplier$NullStateStatusListener;
    }

    public final void m9734a(Type type) {
        if (type == Type.RECENT_VIDEOS) {
            this.f9339l = true;
        }
    }

    public final void m9728a(GraphSearchQuery graphSearchQuery) {
    }

    public final void mo743d() {
        this.f9339l = false;
    }

    public final void mo738a(EntityTypeaheadUnit entityTypeaheadUnit) {
        m9725b(NullStateSuggestionTypeaheadUnit.a(entityTypeaheadUnit));
    }

    public final void mo742a(ShortcutTypeaheadUnit shortcutTypeaheadUnit) {
        m9725b(NullStateSuggestionTypeaheadUnit.a(shortcutTypeaheadUnit));
    }

    public final void mo740a(NullStateSuggestionTypeaheadUnit nullStateSuggestionTypeaheadUnit) {
        m9725b(NullStateSuggestionTypeaheadUnit.a(nullStateSuggestionTypeaheadUnit));
    }

    public final void mo739a(KeywordTypeaheadUnit keywordTypeaheadUnit) {
        m9725b(NullStateSuggestionTypeaheadUnit.a(keywordTypeaheadUnit));
    }

    public final ListenableFuture<Void> mo744e() {
        b();
        return ((RecentSearchCacheMutator) this.f9333f.get()).a("recent_video_search_cache_tag");
    }

    public final synchronized boolean m9742k() {
        boolean z = true;
        synchronized (this) {
            if (this.f9336i == null || this.f9336i.isDone()) {
                z = false;
            } else {
                this.f9336i.cancel(true);
                this.f9336i = null;
            }
        }
        return z;
    }

    private synchronized ListenableFuture<CachedSuggestionList> m9722a(@Nullable CallerContext callerContext, GraphQLCachePolicy graphQLCachePolicy, long j) {
        ListenableFuture<CachedSuggestionList> listenableFuture;
        if (this.f9336i != null) {
            listenableFuture = this.f9336i;
        } else {
            h();
            this.f9336i = this.f9328a.m9606a("recent_video_search_cache_tag", FilterInputMode.VIDEO_SEARCH, 15, callerContext, graphQLCachePolicy, j);
            this.f9338k = ((ScheduledExecutorService) this.f9332e.get()).schedule(new 1(this), 10, TimeUnit.SECONDS);
            Futures.a(this.f9336i, new 2(this), this.f9334g);
            listenableFuture = this.f9336i;
        }
        return listenableFuture;
    }

    protected final String m9741g() {
        return "recent_video_searches_network";
    }

    public static synchronized void m9723a(RecentVideoSearchesNullStateSupplier recentVideoSearchesNullStateSupplier, ImmutableList immutableList) {
        synchronized (recentVideoSearchesNullStateSupplier) {
            recentVideoSearchesNullStateSupplier.f9337j = new CachedSuggestionList(ImmutableList.copyOf(immutableList), recentVideoSearchesNullStateSupplier.f9335h.a());
            if (recentVideoSearchesNullStateSupplier.f9340m != null) {
                recentVideoSearchesNullStateSupplier.f9340m.mo745a(NullStateStatus.READY);
            }
        }
    }

    private synchronized void m9725b(NullStateSuggestionTypeaheadUnit nullStateSuggestionTypeaheadUnit) {
        m9723a(this, this.f9329b.m9616a("recent_video_search_cache_tag", nullStateSuggestionTypeaheadUnit, this.f9337j));
    }

    public static void m9726m(RecentVideoSearchesNullStateSupplier recentVideoSearchesNullStateSupplier) {
        if (recentVideoSearchesNullStateSupplier.f9338k != null) {
            recentVideoSearchesNullStateSupplier.f9338k.cancel(true);
            recentVideoSearchesNullStateSupplier.f9338k = null;
        }
    }
}
