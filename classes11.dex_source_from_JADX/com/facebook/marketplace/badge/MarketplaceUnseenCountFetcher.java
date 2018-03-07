package com.facebook.marketplace.badge;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.fbreact.instance.FbReactInstanceHolder;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.marketplace.badge.MarketplaceBadgeCountQuery.MarketplaceBadgeCountQueryString;
import com.facebook.marketplace.badge.MarketplaceBadgeCountQueryModels.MarketplaceBadgeCountQueryModel;
import com.facebook.marketplace.badge.MarketplaceBadgeCountQueryModels.MarketplaceBadgeCountQueryModel.MarketplaceBadgeCountModel;
import com.facebook.marketplace.badge.MarketplaceBadgeCountQueryModels.MarketplaceBadgeCountQueryModel.NotifReadnessModel;
import com.facebook.notifications.common.JewelCounters;
import com.facebook.notifications.common.JewelCounters.Jewel;
import com.facebook.notifications.util.MarketplaceBadgeCountManager;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: user_location_stale_time */
public class MarketplaceUnseenCountFetcher implements MarketplaceBadgeCountManager {
    public static final String f291a = MarketplaceUnseenCountFetcher.class.getName();
    private final ExecutorService f292b;
    private final GraphQLQueryExecutor f293c;
    public final JewelCounters f294d;
    public final Lazy<FbErrorReporter> f295e;
    public final FbReactInstanceHolder f296f;

    /* compiled from: user_location_stale_time */
    class C00451 implements FutureCallback<GraphQLResult<MarketplaceBadgeCountQueryModel>> {
        final /* synthetic */ MarketplaceUnseenCountFetcher f290a;

        C00451(MarketplaceUnseenCountFetcher marketplaceUnseenCountFetcher) {
            this.f290a = marketplaceUnseenCountFetcher;
        }

        public void onSuccess(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((MarketplaceBadgeCountQueryModel) graphQLResult.e).m361a() == null || ((MarketplaceBadgeCountQueryModel) graphQLResult.e).m362j() == null) {
                ((AbstractFbErrorReporter) this.f290a.f295e.get()).a(MarketplaceUnseenCountFetcher.f291a, "Illegal result format for unseen batch request.");
                return;
            }
            MarketplaceBadgeCountModel a = ((MarketplaceBadgeCountQueryModel) graphQLResult.e).m361a();
            NotifReadnessModel j = ((MarketplaceBadgeCountQueryModel) graphQLResult.e).m362j();
            int size = (j.m357a() != null ? j.m357a().size() : 0) + (a.m341j() + a.m337a());
            this.f290a.f294d.a(Jewel.MARKETPLACE, size);
            if (this.f290a.f294d.a(Jewel.MARKETPLACE) != size) {
                MarketplaceUnseenCountFetcher marketplaceUnseenCountFetcher = this.f290a;
                if (marketplaceUnseenCountFetcher.f296f.a()) {
                    ReactContext j2 = marketplaceUnseenCountFetcher.f296f.c().j();
                    if (j2 != null) {
                        ((RCTNativeAppEventEmitter) j2.a(RCTNativeAppEventEmitter.class)).emit("MarketplaceNotificationsUpdate", null);
                    }
                }
            }
        }

        public void onFailure(Throwable th) {
            ((AbstractFbErrorReporter) this.f290a.f295e.get()).a(MarketplaceUnseenCountFetcher.f291a, "Badge count query request failed");
        }
    }

    public static MarketplaceUnseenCountFetcher m372b(InjectorLike injectorLike) {
        return new MarketplaceUnseenCountFetcher((ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), JewelCounters.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), FbReactInstanceHolder.a(injectorLike));
    }

    public final void m373a() {
        Futures.a(this.f293c.a(GraphQLRequest.a(new MarketplaceBadgeCountQueryString())), new C00451(this), this.f292b);
    }

    @Inject
    public MarketplaceUnseenCountFetcher(ExecutorService executorService, GraphQLQueryExecutor graphQLQueryExecutor, JewelCounters jewelCounters, Lazy<FbErrorReporter> lazy, FbReactInstanceHolder fbReactInstanceHolder) {
        this.f292b = executorService;
        this.f293c = graphQLQueryExecutor;
        this.f294d = jewelCounters;
        this.f295e = lazy;
        this.f296f = fbReactInstanceHolder;
    }

    public final void m374b() {
        this.f294d.a(Jewel.MARKETPLACE, 0);
    }
}
