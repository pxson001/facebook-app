package com.facebook.search.suggestions.nullstate;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.api.NullStateStatus;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.logging.perf.NullStatePerformanceLogger;
import com.facebook.search.model.CachedSuggestionList;
import com.facebook.search.model.SuggestionGroup.Builder;
import com.facebook.search.model.SuggestionGroup.Type;
import com.facebook.search.suggestions.SuggestionsListRowItemFactory;
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
/* compiled from: listsToLoad */
public class PYMKNullStateSupplier extends NullStateSupplier {
    private static volatile PYMKNullStateSupplier f9296o;
    private final Resources f9297a;
    private final GatekeeperStoreImpl f9298b;
    private final NullStateCachePolicy f9299c;
    private final SuggestionsListRowItemFactory f9300d;
    private final PYMKLoader f9301e;
    private final Lazy<ScheduledExecutorService> f9302f;
    private final Clock f9303g;
    public final GraphSearchErrorReporter f9304h;
    private final ExecutorService f9305i;
    @GuardedBy("this")
    private ListenableFuture<CachedSuggestionList> f9306j;
    @GuardedBy("this")
    private CachedSuggestionList f9307k;
    private ScheduledFuture<?> f9308l;
    private NullStateSupplier$NullStateStatusListener f9309m;
    public int f9310n;

    public static com.facebook.search.suggestions.nullstate.PYMKNullStateSupplier m9676a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9296o;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.suggestions.nullstate.PYMKNullStateSupplier.class;
        monitor-enter(r1);
        r0 = f9296o;	 Catch:{ all -> 0x003a }
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
        r0 = m9679b(r0);	 Catch:{ all -> 0x0035 }
        f9296o = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9296o;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.suggestions.nullstate.PYMKNullStateSupplier.a(com.facebook.inject.InjectorLike):com.facebook.search.suggestions.nullstate.PYMKNullStateSupplier");
    }

    private static PYMKNullStateSupplier m9679b(InjectorLike injectorLike) {
        return new PYMKNullStateSupplier(ResourcesMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), NullStateCachePolicy.m9649a(injectorLike), SuggestionsListRowItemFactory.m9618a(injectorLike), NullStatePerformanceLogger.m9623a(injectorLike), PYMKLoader.m9689a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 4529), (Clock) SystemClockMethodAutoProvider.a(injectorLike), GraphSearchErrorReporter.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PYMKNullStateSupplier(Resources resources, GatekeeperStore gatekeeperStore, NullStateCachePolicy nullStateCachePolicy, SuggestionsListRowItemFactory suggestionsListRowItemFactory, NullStatePerformanceLogger nullStatePerformanceLogger, PYMKLoader pYMKLoader, Lazy<ScheduledExecutorService> lazy, Clock clock, GraphSearchErrorReporter graphSearchErrorReporter, ExecutorService executorService) {
        super(nullStatePerformanceLogger);
        this.f9297a = resources;
        this.f9298b = gatekeeperStore;
        this.f9299c = nullStateCachePolicy;
        this.f9300d = suggestionsListRowItemFactory;
        this.f9301e = pYMKLoader;
        this.f9302f = lazy;
        this.f9303g = clock;
        this.f9304h = graphSearchErrorReporter;
        this.f9305i = executorService;
    }

    public final boolean m9685a() {
        return this.f9298b.a(SearchAbTestGatekeepers.c).asBoolean(false);
    }

    public final void m9683a(@Nullable CallerContext callerContext, NullStateSupplier$RefreshPolicy nullStateSupplier$RefreshPolicy) {
        m9680b(callerContext, nullStateSupplier$RefreshPolicy);
    }

    public static synchronized boolean m9681d(PYMKNullStateSupplier pYMKNullStateSupplier) {
        boolean z = true;
        synchronized (pYMKNullStateSupplier) {
            if (pYMKNullStateSupplier.f9306j == null || pYMKNullStateSupplier.f9306j.isDone()) {
                z = false;
            } else {
                pYMKNullStateSupplier.f9306j.cancel(true);
                pYMKNullStateSupplier.f9306j = null;
            }
        }
        return z;
    }

    public Object get() {
        Object of;
        synchronized (this) {
            if (this.f9307k == null || this.f9307k.m12345d() || this.f9310n == 0) {
                of = ImmutableList.of();
            } else {
                of = SuggestionsListRowItemFactory.m9621b(ImmutableList.of(new Builder().a(Type.PYMK).a(this.f9297a.getString(2131233210)).a(this.f9307k.m12346e() > this.f9310n ? this.f9307k.m12343a().subList(0, this.f9310n) : this.f9307k.m12343a()).a()));
            }
        }
        return of;
    }

    public final synchronized void m9686b() {
        this.f9307k = null;
    }

    public final synchronized NullStateStatus m9687c() {
        NullStateStatus nullStateStatus;
        if (this.f9307k == null || this.f9307k.m12345d() || !this.f9299c.m9651a(86400, this.f9307k.m12344b())) {
            nullStateStatus = NullStateStatus.NOT_READY;
        } else {
            nullStateStatus = NullStateStatus.READY;
        }
        return nullStateStatus;
    }

    public final void m9684a(NullStateSupplier$NullStateStatusListener nullStateSupplier$NullStateStatusListener, OnFetchStateChangedListener onFetchStateChangedListener) {
        this.f9309m = nullStateSupplier$NullStateStatusListener;
    }

    private synchronized ListenableFuture<CachedSuggestionList> m9680b(@Nullable CallerContext callerContext, NullStateSupplier$RefreshPolicy nullStateSupplier$RefreshPolicy) {
        ListenableFuture<CachedSuggestionList> listenableFuture;
        if (this.f9306j != null) {
            listenableFuture = this.f9306j;
        } else {
            h();
            this.f9306j = this.f9301e.m9691a(callerContext, nullStateSupplier$RefreshPolicy == NullStateSupplier$RefreshPolicy.NETWORK_ONLY ? GraphQLCachePolicy.d : GraphQLCachePolicy.a);
            this.f9308l = ((ScheduledExecutorService) this.f9302f.get()).schedule(new 1(this), 10, TimeUnit.SECONDS);
            Futures.a(this.f9306j, new 2(this), this.f9305i);
            listenableFuture = this.f9306j;
        }
        return listenableFuture;
    }

    protected final String m9688g() {
        return "pymk_network";
    }

    public static void m9682k(PYMKNullStateSupplier pYMKNullStateSupplier) {
        if (pYMKNullStateSupplier.f9308l != null) {
            pYMKNullStateSupplier.f9308l.cancel(true);
            pYMKNullStateSupplier.f9308l = null;
        }
    }

    public static synchronized void m9678a(PYMKNullStateSupplier pYMKNullStateSupplier, ImmutableList immutableList) {
        synchronized (pYMKNullStateSupplier) {
            pYMKNullStateSupplier.f9307k = new CachedSuggestionList(ImmutableList.copyOf(immutableList), pYMKNullStateSupplier.f9303g.a());
            if (pYMKNullStateSupplier.f9309m != null) {
                pYMKNullStateSupplier.f9309m.mo745a(NullStateStatus.READY);
            }
        }
    }
}
