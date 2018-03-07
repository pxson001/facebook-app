package com.facebook.feed.data;

import android.os.Handler;
import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feed.xconfig.AsyncFeedXConfigReader;
import com.facebook.api.feedcache.db.DBFeedRerankHandler;
import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedcache.db.FeedDbMutationService;
import com.facebook.common.executors.C0115xfdf5bd2;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.feed.loader.FeedFetcherCache;
import com.facebook.graphql.executor.RequestObserver;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.util.concurrent.ListenableScheduledFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

/* compiled from: offers/detail/?offer_id=%s&share_id=%s&notif_trigger=%s&notif_medium=%s&rule=%s */
public class FeedDataLoaderReranker {
    public static final Class<FeedDataLoaderReranker> f11594a = FeedDataLoaderReranker.class;
    public final ListeningScheduledExecutorService f11595b;
    public final FeedDbMutationService f11596c;
    private final FeedFetcherProcessor f11597d;
    private final Lazy<FeedFetcherCache> f11598e;
    private final Handler f11599f;
    public final AtomicReference<ListenableScheduledFuture<?>> f11600g = new AtomicReference(null);
    public final AtomicReference<ListenableScheduledFuture<?>> f11601h = new AtomicReference(null);
    private final QeAccessor f11602i;
    private final DBFeedRerankHandler f11603j;
    public final DbFeedHomeStoriesHandler f11604k;
    private final AsyncFeedXConfigReader f11605l;

    public static FeedDataLoaderReranker m16900b(InjectorLike injectorLike) {
        return new FeedDataLoaderReranker(C0115xfdf5bd2.m3569a(injectorLike), FeedDbMutationService.m9091a(injectorLike), FeedFetcherProcessor.m10525a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1417), Handler_ForUiThreadMethodAutoProvider.m1701b(injectorLike), DBFeedRerankHandler.m9321a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), DbFeedHomeStoriesHandler.m9120a(injectorLike), AsyncFeedXConfigReader.m9332a(injectorLike));
    }

    public static FeedDataLoaderReranker m16898a(InjectorLike injectorLike) {
        return m16900b(injectorLike);
    }

    @Inject
    public FeedDataLoaderReranker(ListeningScheduledExecutorService listeningScheduledExecutorService, FeedDbMutationService feedDbMutationService, FeedFetcherProcessor feedFetcherProcessor, Lazy<FeedFetcherCache> lazy, Handler handler, DBFeedRerankHandler dBFeedRerankHandler, QeAccessor qeAccessor, DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler, AsyncFeedXConfigReader asyncFeedXConfigReader) {
        this.f11602i = qeAccessor;
        this.f11595b = listeningScheduledExecutorService;
        this.f11596c = feedDbMutationService;
        this.f11597d = feedFetcherProcessor;
        this.f11598e = lazy;
        this.f11599f = handler;
        this.f11603j = dBFeedRerankHandler;
        this.f11604k = dbFeedHomeStoriesHandler;
        this.f11605l = asyncFeedXConfigReader;
    }

    public final void m16903b(FetchFeedParams fetchFeedParams, RequestObserver<FetchFeedResult> requestObserver, long j) {
        this.f11601h.set(this.f11595b.mo310a(new 3(this, fetchFeedParams, requestObserver), j, TimeUnit.SECONDS));
    }

    public final void m16902a() {
        this.f11603j.m9330a(m16909j());
    }

    public final boolean m16904d() {
        return true;
    }

    public final boolean m16907h() {
        return true;
    }

    public final boolean m16905e() {
        return m16901l();
    }

    public final boolean m16906f() {
        return m16901l();
    }

    private boolean m16901l() {
        if (1 == 0 || !this.f11605l.m9356h(false)) {
            return false;
        }
        return true;
    }

    public final boolean m16908i() {
        return m16901l();
    }

    public final String m16909j() {
        return this.f11605l.m9339a("sort_key");
    }

    public static void m16899a(FeedDataLoaderReranker feedDataLoaderReranker, FetchFeedResult fetchFeedResult, RequestObserver requestObserver) {
        ((FeedFetcherCache) feedDataLoaderReranker.f11598e.get()).m10537c(feedDataLoaderReranker.f11597d.m10527a(fetchFeedResult));
        HandlerDetour.a(feedDataLoaderReranker.f11599f, new 4(feedDataLoaderReranker, requestObserver, fetchFeedResult), -2100803155);
    }
}
