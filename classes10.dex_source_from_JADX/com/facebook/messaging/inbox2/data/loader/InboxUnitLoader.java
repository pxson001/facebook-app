package com.facebook.messaging.inbox2.data.loader;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.loader.AbstractListenableFutureFbLoader;
import com.facebook.common.loader.AbstractListenableFutureFbLoader.LoaderResult;
import com.facebook.common.loader.AbstractListenableFutureFbLoader.LoaderResultType;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.inbox2.data.common.InboxUnitFetcher;
import com.facebook.messaging.inbox2.data.common.InboxUnitParams;
import com.facebook.messaging.inbox2.data.common.InboxUnitResult;
import com.facebook.messaging.inbox2.data.common.InboxUnitSnapshot;
import com.facebook.messaging.inbox2.data.common.InboxUnitsToFetch;
import com.facebook.messaging.inbox2.data.loader.InboxUnitManager.CachedResult;
import com.facebook.messaging.inbox2.items.InboxUnitItem;
import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: service_disabled */
public class InboxUnitLoader extends AbstractListenableFutureFbLoader<Params, InboxUnitSnapshot> {
    private final InboxUnitManager f2764a;
    public final InboxUnitFetcher f2765b;
    public final Clock f2766c;
    public long f2767d;

    /* compiled from: service_disabled */
    public enum LoadBehavior {
        FORCE_SERVER_FETCH,
        DEFAULT,
        DEFAULT_WITH_TOP_UNITS_FIRST
    }

    /* compiled from: service_disabled */
    public class Params {
        public final LoadBehavior f2763a;

        public Params(LoadBehavior loadBehavior) {
            this.f2763a = loadBehavior;
        }
    }

    public static InboxUnitLoader m2717b(InjectorLike injectorLike) {
        return new InboxUnitLoader(InboxUnitManager.m2728a(injectorLike), InboxUnitFetcherMethodAutoProvider.m2715b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    protected final LoaderResult m2719b(Object obj) {
        if (((Params) obj).f2763a == LoadBehavior.FORCE_SERVER_FETCH) {
            return AbstractListenableFutureFbLoader.a;
        }
        CachedResult a = this.f2764a.m2737a();
        if (a == null) {
            return AbstractListenableFutureFbLoader.a;
        }
        Object obj2;
        InboxUnitSnapshot a2 = a.f2773a.mo75a();
        if (!a.f2774b) {
            Object obj3;
            if (this.f2766c.a() - a2.f2756c > 1200000) {
                obj3 = 1;
            } else {
                obj3 = null;
            }
            if (obj3 == null && a2.f2754a != DataFreshnessResult.FROM_CACHE_STALE) {
                obj2 = 1;
                return obj2 == null ? LoaderResult.b(a2) : LoaderResult.a(a2);
            }
        }
        obj2 = null;
        if (obj2 == null) {
        }
    }

    protected final ListenableFuture m2720b(Object obj, LoaderResult loaderResult) {
        DataFreshnessParam dataFreshnessParam;
        InboxUnitsToFetch inboxUnitsToFetch;
        Params params = (Params) obj;
        if (params.f2763a == LoadBehavior.FORCE_SERVER_FETCH) {
            dataFreshnessParam = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
            inboxUnitsToFetch = InboxUnitsToFetch.ALL;
        } else if (loaderResult != null && loaderResult.b == LoaderResultType.INTERMEDIATE) {
            dataFreshnessParam = DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE;
            inboxUnitsToFetch = InboxUnitsToFetch.ALL;
        } else if (params.f2763a == LoadBehavior.DEFAULT_WITH_TOP_UNITS_FIRST) {
            dataFreshnessParam = DataFreshnessParam.DO_NOT_CHECK_SERVER;
            inboxUnitsToFetch = InboxUnitsToFetch.TOP;
        } else {
            dataFreshnessParam = DataFreshnessParam.STALE_DATA_OKAY;
            inboxUnitsToFetch = InboxUnitsToFetch.ALL;
        }
        return Futures.a(this.f2764a.m2738a(new InboxUnitParams(dataFreshnessParam, inboxUnitsToFetch)), new Function<InboxUnitResult, LoaderResult<InboxUnitSnapshot>>(this) {
            final /* synthetic */ InboxUnitLoader f2762c;

            @Nullable
            public Object apply(@Nullable Object obj) {
                InboxUnitResult inboxUnitResult = (InboxUnitResult) obj;
                if (inboxUnitResult == null) {
                    return LoaderResult.b(null);
                }
                if (dataFreshnessParam == DataFreshnessParam.STALE_DATA_OKAY && inboxUnitResult.mo75a().f2754a == DataFreshnessResult.FROM_CACHE_STALE) {
                    return LoaderResult.a(inboxUnitResult.mo75a());
                }
                if (inboxUnitsToFetch == InboxUnitsToFetch.TOP) {
                    return LoaderResult.a(inboxUnitResult.mo75a());
                }
                return LoaderResult.b(inboxUnitResult.mo75a());
            }
        });
    }

    public static InboxUnitLoader m2716a(InjectorLike injectorLike) {
        return m2717b(injectorLike);
    }

    @Inject
    InboxUnitLoader(InboxUnitManager inboxUnitManager, InboxUnitFetcher inboxUnitFetcher, Clock clock, Executor executor) {
        super(executor);
        this.f2764a = inboxUnitManager;
        this.f2765b = inboxUnitFetcher;
        this.f2766c = clock;
    }

    public final void m2718a(InboxUnitItem inboxUnitItem) {
        this.f2765b.mo80a(inboxUnitItem);
    }

    protected final void m2721c() {
        this.f2767d = this.f2766c.a();
    }
}
