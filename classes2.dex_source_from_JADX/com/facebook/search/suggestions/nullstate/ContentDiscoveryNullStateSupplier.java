package com.facebook.search.suggestions.nullstate;

import android.os.Handler;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationCache;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.api.EdgeRoutingConfig;
import com.facebook.search.api.NullStateStatus;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.model.NullStateModuleCollectionUnit;
import com.facebook.search.model.converter.NullStateModuleConverter;
import com.facebook.search.model.nullstate.NullStateModuleData;
import com.facebook.search.suggestions.nullstate.NullStateSupplier.NullStateStatusListener;
import com.facebook.search.suggestions.nullstate.NullStateSupplier.RefreshPolicy;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.typeahead.OnFetchStateChangedListener;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: reviews/?review_id=%s */
public class ContentDiscoveryNullStateSupplier extends NullStateSupplier {
    private static volatile ContentDiscoveryNullStateSupplier f19614p;
    public final GraphSearchErrorReporter f19615a;
    private final ExecutorService f19616b;
    private final SearchNullStateModuleLoader f19617c;
    private final QeAccessor f19618d;
    private final Handler f19619e;
    public final List<String> f19620f;
    public final Clock f19621g;
    public long f19622h = -1;
    public final long f19623i;
    public final long f19624j;
    @GuardedBy("this")
    private NullStateModuleData f19625k;
    @GuardedBy("this")
    private ListenableFuture<NullStateModuleData> f19626l;
    private NullStateStatusListener f19627m;
    public NewNullStateModuleSuggestionsListener f19628n;
    private boolean f19629o = false;

    /* compiled from: reviews/?review_id=%s */
    public interface NewNullStateModuleSuggestionsListener {
        void G_(int i);
    }

    public static com.facebook.search.suggestions.nullstate.ContentDiscoveryNullStateSupplier m27332a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19614p;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.suggestions.nullstate.ContentDiscoveryNullStateSupplier.class;
        monitor-enter(r1);
        r0 = f19614p;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m27337b(r0);	 Catch:{ all -> 0x0035 }
        f19614p = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19614p;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.suggestions.nullstate.ContentDiscoveryNullStateSupplier.a(com.facebook.inject.InjectorLike):com.facebook.search.suggestions.nullstate.ContentDiscoveryNullStateSupplier");
    }

    private static ContentDiscoveryNullStateSupplier m27337b(InjectorLike injectorLike) {
        GraphSearchErrorReporter a = GraphSearchErrorReporter.m27358a(injectorLike);
        ExecutorService a2 = ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(injectorLike);
        SearchNullStateModuleLoader searchNullStateModuleLoader = new SearchNullStateModuleLoader(new NullStateModuleConverter(GraphSearchErrorReporter.m27358a(injectorLike)), GraphQLQueryExecutor.m10435a(injectorLike), FbLocationCache.m8244b(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
        searchNullStateModuleLoader.f19648d = EdgeRoutingConfig.m27381b(injectorLike);
        return new ContentDiscoveryNullStateSupplier(a, a2, searchNullStateModuleLoader, QeInternalImplMethodAutoProvider.m3744a(injectorLike), Handler_ForUiThreadMethodAutoProvider.m1701b(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike));
    }

    @Inject
    public ContentDiscoveryNullStateSupplier(GraphSearchErrorReporter graphSearchErrorReporter, ExecutorService executorService, SearchNullStateModuleLoader searchNullStateModuleLoader, QeAccessor qeAccessor, Handler handler, Clock clock) {
        this.f19615a = graphSearchErrorReporter;
        this.f19616b = executorService;
        this.f19617c = searchNullStateModuleLoader;
        this.f19618d = qeAccessor;
        this.f19619e = handler;
        this.f19620f = Arrays.asList(this.f19618d.mo581a(ExperimentsForSearchAbTestModule.aY, "").split(","));
        this.f19621g = clock;
        this.f19623i = (long) (this.f19618d.mo572a(ExperimentsForSearchAbTestModule.bd, 3600) * 1000);
        this.f19624j = (long) (this.f19618d.mo572a(ExperimentsForSearchAbTestModule.bc, 3600) * 1000);
    }

    public final boolean mo3111a() {
        return true;
    }

    public final synchronized void mo3109a(@Nullable CallerContext callerContext, RefreshPolicy refreshPolicy) {
        m27336a(this, this.f19620f, 10, callerContext, refreshPolicy == RefreshPolicy.NETWORK_ONLY ? GraphQLCachePolicy.f7112d : GraphQLCachePolicy.f7109a);
    }

    public static synchronized void m27336a(ContentDiscoveryNullStateSupplier contentDiscoveryNullStateSupplier, List list, @Nullable int i, CallerContext callerContext, GraphQLCachePolicy graphQLCachePolicy) {
        synchronized (contentDiscoveryNullStateSupplier) {
            if (contentDiscoveryNullStateSupplier.f19626l == null) {
                contentDiscoveryNullStateSupplier.f19626l = contentDiscoveryNullStateSupplier.f19617c.m27376a(list, i, callerContext, graphQLCachePolicy);
                Futures.m2458a(contentDiscoveryNullStateSupplier.f19626l, new 1(contentDiscoveryNullStateSupplier, callerContext), contentDiscoveryNullStateSupplier.f19616b);
            }
        }
    }

    public final synchronized void mo3112b() {
        this.f19625k = null;
    }

    public final synchronized NullStateStatus mo3113c() {
        NullStateStatus nullStateStatus;
        if (this.f19625k == null || this.f19625k.a() || this.f19621g.mo211a() - this.f19622h > this.f19623i) {
            nullStateStatus = NullStateStatus.NOT_READY;
        } else {
            nullStateStatus = NullStateStatus.READY;
        }
        return nullStateStatus;
    }

    public final void mo3110a(NullStateStatusListener nullStateStatusListener, OnFetchStateChangedListener onFetchStateChangedListener) {
        this.f19627m = nullStateStatusListener;
    }

    public Object get() {
        ImmutableList b;
        synchronized (this) {
            b = this.f19625k.b();
        }
        return b;
    }

    public final boolean m27343d() {
        return this.f19629o;
    }

    public final synchronized void m27344e() {
        if (this.f19628n != null) {
            NewNullStateModuleSuggestionsListener newNullStateModuleSuggestionsListener = this.f19628n;
            this.f19625k.c();
            newNullStateModuleSuggestionsListener.G_(0);
        }
        this.f19625k.g();
    }

    public static synchronized void m27335a(ContentDiscoveryNullStateSupplier contentDiscoveryNullStateSupplier, NullStateModuleData nullStateModuleData) {
        synchronized (contentDiscoveryNullStateSupplier) {
            contentDiscoveryNullStateSupplier.f19625k = nullStateModuleData;
            if (nullStateModuleData.b() == null || nullStateModuleData.b().isEmpty()) {
                contentDiscoveryNullStateSupplier.f19629o = true;
            } else {
                int e;
                contentDiscoveryNullStateSupplier.f19629o = false;
                if (contentDiscoveryNullStateSupplier.f19625k == null) {
                    e = nullStateModuleData.e();
                } else {
                    e = contentDiscoveryNullStateSupplier.f19625k.a((NullStateModuleCollectionUnit) nullStateModuleData.b().get(0));
                }
                if (contentDiscoveryNullStateSupplier.f19618d.mo596a(ExperimentsForSearchAbTestModule.bi, false) && contentDiscoveryNullStateSupplier.f19628n != null) {
                    contentDiscoveryNullStateSupplier.f19625k.a(nullStateModuleData, Math.min(e, nullStateModuleData.e()));
                    NewNullStateModuleSuggestionsListener newNullStateModuleSuggestionsListener = contentDiscoveryNullStateSupplier.f19628n;
                    nullStateModuleData.c();
                    newNullStateModuleSuggestionsListener.G_(Math.min(e, nullStateModuleData.e()));
                }
                if (contentDiscoveryNullStateSupplier.f19627m != null) {
                    contentDiscoveryNullStateSupplier.f19627m.a(NullStateStatus.READY);
                }
            }
        }
    }

    public static void m27334a(@Nullable ContentDiscoveryNullStateSupplier contentDiscoveryNullStateSupplier, @Nullable CallerContext callerContext, NullStateModuleData nullStateModuleData) {
        if (contentDiscoveryNullStateSupplier.f19618d.mo596a(ExperimentsForSearchAbTestModule.bi, false) && nullStateModuleData.c() != null) {
            HandlerDetour.b(contentDiscoveryNullStateSupplier.f19619e, new 2(contentDiscoveryNullStateSupplier, nullStateModuleData, callerContext), (long) (contentDiscoveryNullStateSupplier.f19618d.mo572a(ExperimentsForSearchAbTestModule.bk, 10) * 1000), -1893769784);
        }
    }
}
