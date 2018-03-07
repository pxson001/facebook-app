package com.facebook.pages.common.surface.protocol.headerfetcher;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.earlyfetch.EarlyFetchResult;
import com.facebook.earlyfetch.EarlyFetcher;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLBatchRequest.EndpointScheduler;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.pages.common.abtest.qe.PagesExperimentUtils;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.FetchPageHeaderQueryModel;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.reaction.ReactionSessionManager;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: restore_button_nux_completed */
public class PageHeaderEarlyFetcher extends EarlyFetcher<PageHeaderEarlyFetchIdentifier, PageHeaderEarlyFetchFuturesHolder> {
    private static volatile PageHeaderEarlyFetcher f2483k;
    private final FbAppType f2484a;
    private final Lazy<PageHeaderFetchQueryExecutor> f2485b;
    private final Lazy<FbErrorReporter> f2486c;
    private final Lazy<PageReactionInitialFetcher> f2487d;
    private final PagesExperimentUtils f2488e;
    public final QuickPerformanceLogger f2489f;
    @Nullable
    private DisposableFutureCallback f2490g;
    @Nullable
    private DisposableFutureCallback f2491h;
    public boolean f2492i;
    public boolean f2493j;

    /* compiled from: restore_button_nux_completed */
    class C03281 extends AbstractDisposableFutureCallback<GraphQLResult<FetchPageHeaderQueryModel>> {
        final /* synthetic */ PageHeaderEarlyFetcher f2481a;

        C03281(PageHeaderEarlyFetcher pageHeaderEarlyFetcher) {
            this.f2481a = pageHeaderEarlyFetcher;
        }

        protected final void m3435a(Object obj) {
            this.f2481a.f2489f.a(1245314, (short) 121);
            this.f2481a.f2492i = true;
            if (this.f2481a.f2493j) {
                this.f2481a.f2489f.a(1245314, "OutOfOrder");
            }
            PageHeaderEarlyFetcher.m3443g(this.f2481a);
        }

        protected final void m3436a(Throwable th) {
            this.f2481a.f2489f.b(1245314, (short) 3);
            PageHeaderEarlyFetcher.m3441e(this.f2481a);
        }
    }

    /* compiled from: restore_button_nux_completed */
    class C03292 extends AbstractDisposableFutureCallback {
        final /* synthetic */ PageHeaderEarlyFetcher f2482a;

        C03292(PageHeaderEarlyFetcher pageHeaderEarlyFetcher) {
            this.f2482a = pageHeaderEarlyFetcher;
        }

        protected final void m3437a(Object obj) {
            this.f2482a.f2489f.a(1245314, (short) 122);
            this.f2482a.f2493j = true;
            PageHeaderEarlyFetcher.m3443g(this.f2482a);
        }

        protected final void m3438a(Throwable th) {
            this.f2482a.f2489f.b(1245314, (short) 3);
            PageHeaderEarlyFetcher.m3441e(this.f2482a);
        }
    }

    public static com.facebook.pages.common.surface.protocol.headerfetcher.PageHeaderEarlyFetcher m3439a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2483k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.pages.common.surface.protocol.headerfetcher.PageHeaderEarlyFetcher.class;
        monitor-enter(r1);
        r0 = f2483k;	 Catch:{ all -> 0x003a }
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
        r0 = m3440b(r0);	 Catch:{ all -> 0x0035 }
        f2483k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2483k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.surface.protocol.headerfetcher.PageHeaderEarlyFetcher.a(com.facebook.inject.InjectorLike):com.facebook.pages.common.surface.protocol.headerfetcher.PageHeaderEarlyFetcher");
    }

    private static PageHeaderEarlyFetcher m3440b(InjectorLike injectorLike) {
        return new PageHeaderEarlyFetcher((FbAppType) injectorLike.getInstance(FbAppType.class), IdBasedLazy.a(injectorLike, 8998), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedSingletonScopeProvider.b(injectorLike, 8999), PagesExperimentUtils.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike));
    }

    protected final void m3445a(Object obj) {
        PageHeaderEarlyFetchFuturesHolder pageHeaderEarlyFetchFuturesHolder = (PageHeaderEarlyFetchFuturesHolder) obj;
        m3441e(this);
        if (pageHeaderEarlyFetchFuturesHolder != null) {
            if (pageHeaderEarlyFetchFuturesHolder.f2476a != null) {
                pageHeaderEarlyFetchFuturesHolder.f2476a.cancel(true);
                pageHeaderEarlyFetchFuturesHolder.f2477b.cancel(true);
            }
            if (pageHeaderEarlyFetchFuturesHolder.f2478c != null) {
                PageReactionInitialFetcher pageReactionInitialFetcher = (PageReactionInitialFetcher) this.f2487d.get();
                ((ReactionSessionManager) pageReactionInitialFetcher.f2538c.get()).g(pageHeaderEarlyFetchFuturesHolder.f2478c);
            }
        }
    }

    @Inject
    public PageHeaderEarlyFetcher(FbAppType fbAppType, Lazy<PageHeaderFetchQueryExecutor> lazy, Lazy<FbErrorReporter> lazy2, Lazy<PageReactionInitialFetcher> lazy3, PagesExperimentUtils pagesExperimentUtils, QuickPerformanceLogger quickPerformanceLogger) {
        this.f2484a = fbAppType;
        this.f2485b = lazy;
        this.f2486c = lazy2;
        this.f2487d = lazy3;
        this.f2488e = pagesExperimentUtils;
        this.f2489f = quickPerformanceLogger;
    }

    protected final EarlyFetchResult<PageHeaderEarlyFetchIdentifier, PageHeaderEarlyFetchFuturesHolder> m3444a(Context context, Intent intent) {
        String str = null;
        Bundle extras = intent.getExtras();
        if (extras == null || extras.getLong("com.facebook.katana.profile.id", -1) == -1) {
            ((AbstractFbErrorReporter) this.f2486c.get()).b(getClass().getName(), "No PageId available in early fetcher");
            return null;
        }
        ListenableFuture listenableFuture;
        String str2;
        Long valueOf = Long.valueOf(extras.getLong("com.facebook.katana.profile.id", -1));
        ListenableFuture a = ((PageHeaderFetchQueryExecutor) this.f2485b.get()).m3451a(valueOf, GraphQLCachePolicy.b);
        GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest("PageReactionHeaderAndFirstCardBatchRequest");
        graphQLBatchRequest.j = EndpointScheduler.PHASED;
        if (this.f2488e.e()) {
            PageReactionInitialFetcher pageReactionInitialFetcher = (PageReactionInitialFetcher) this.f2487d.get();
            String f = pageReactionInitialFetcher.f2537b.c(PageReactionInitialFetcher.f2535a, PageReactionInitialFetcher.m3470b(valueOf)).f();
            GraphQLRequest b = ((PageHeaderFetchQueryExecutor) this.f2485b.get()).m3452b(valueOf, GraphQLCachePolicy.d);
            b.y = 0;
            ListenableFuture b2 = graphQLBatchRequest.b(b);
            m3442f();
            Futures.a(b2, this.f2490g, MoreExecutors.b());
            str = ((PageReactionInitialFetcher) this.f2487d.get()).m3471a(valueOf, graphQLBatchRequest, 1, this.f2491h, MoreExecutors.b(), true).f();
            listenableFuture = b2;
            str2 = f;
        } else {
            listenableFuture = ((PageHeaderFetchQueryExecutor) this.f2485b.get()).m3451a(valueOf, GraphQLCachePolicy.d);
            str2 = null;
        }
        return new EarlyFetchResult(new PageHeaderEarlyFetchIdentifier(valueOf.longValue()), new PageHeaderEarlyFetchFuturesHolder(a, listenableFuture, str, str2));
    }

    protected final boolean m3446b() {
        return this.f2484a.j == Product.FB4A;
    }

    public static void m3441e(PageHeaderEarlyFetcher pageHeaderEarlyFetcher) {
        if (pageHeaderEarlyFetcher.f2490g != null) {
            pageHeaderEarlyFetcher.f2490g.jc_();
            pageHeaderEarlyFetcher.f2490g = null;
        }
        if (pageHeaderEarlyFetcher.f2491h != null) {
            pageHeaderEarlyFetcher.f2491h.jc_();
            pageHeaderEarlyFetcher.f2491h = null;
        }
        pageHeaderEarlyFetcher.f2492i = false;
        pageHeaderEarlyFetcher.f2493j = false;
    }

    private void m3442f() {
        m3441e(this);
        this.f2489f.b(1245314);
        this.f2490g = new C03281(this);
        this.f2491h = new C03292(this);
    }

    public static void m3443g(PageHeaderEarlyFetcher pageHeaderEarlyFetcher) {
        if (pageHeaderEarlyFetcher.f2492i && pageHeaderEarlyFetcher.f2493j) {
            pageHeaderEarlyFetcher.f2489f.b(1245314, (short) 2);
        }
    }
}
