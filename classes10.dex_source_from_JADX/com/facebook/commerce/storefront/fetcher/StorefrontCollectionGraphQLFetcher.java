package com.facebook.commerce.storefront.fetcher;

import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.CommerceMerchantPageFragmentModel;
import com.facebook.commerce.core.intent.MerchantInfoViewData;
import com.facebook.commerce.storefront.graphql.CommerceMerchantPageQuery.CommerceMerchantPageQueryString;
import com.facebook.commerce.storefront.graphql.FetchStorefrontCollectionQuery.FetchStorefrontCollectionQueryString;
import com.facebook.commerce.storefront.graphql.FetchStorefrontCollectionQueryModels.FetchStorefrontCollectionQueryModel;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: create-thread */
public class StorefrontCollectionGraphQLFetcher {
    private final GraphQLQueryExecutor f15709a;
    private final ExecutorService f15710b;

    /* compiled from: create-thread */
    class C21851 implements Function<GraphQLResult<CommerceMerchantPageFragmentModel>, MerchantInfoViewData> {
        final /* synthetic */ StorefrontCollectionGraphQLFetcher f15708a;

        C21851(StorefrontCollectionGraphQLFetcher storefrontCollectionGraphQLFetcher) {
            this.f15708a = storefrontCollectionGraphQLFetcher;
        }

        public Object apply(Object obj) {
            MerchantInfoViewData merchantInfoViewData;
            CommerceMerchantPageFragmentModel commerceMerchantPageFragmentModel = (CommerceMerchantPageFragmentModel) ((GraphQLResult) obj).e;
            if (!(commerceMerchantPageFragmentModel == null || commerceMerchantPageFragmentModel.n() == null)) {
                if (!(StringUtil.a(new CharSequence[]{commerceMerchantPageFragmentModel.n().a()}) || commerceMerchantPageFragmentModel.j() == null)) {
                    if (!(StringUtil.a(new CharSequence[]{(CharSequence) commerceMerchantPageFragmentModel.j().get(0)}) || commerceMerchantPageFragmentModel.m() == null)) {
                        merchantInfoViewData = new MerchantInfoViewData(commerceMerchantPageFragmentModel.l(), commerceMerchantPageFragmentModel.n().a(), (String) commerceMerchantPageFragmentModel.j().get(0), commerceMerchantPageFragmentModel.m().a(), commerceMerchantPageFragmentModel.k(), "");
                        return merchantInfoViewData;
                    }
                }
            }
            merchantInfoViewData = null;
            return merchantInfoViewData;
        }
    }

    public static StorefrontCollectionGraphQLFetcher m16149b(InjectorLike injectorLike) {
        return new StorefrontCollectionGraphQLFetcher(GraphQLQueryExecutor.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public StorefrontCollectionGraphQLFetcher(GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService) {
        this.f15709a = graphQLQueryExecutor;
        this.f15710b = executorService;
    }

    private static GraphQLRequest<CommerceMerchantPageFragmentModel> m16150b(long j) {
        GraphQlQueryString commerceMerchantPageQueryString = new CommerceMerchantPageQueryString();
        commerceMerchantPageQueryString.a("merchant_page_id", Long.valueOf(j));
        return GraphQLRequest.a(commerceMerchantPageQueryString).a(RequestPriority.INTERACTIVE).a(GraphQLCachePolicy.c);
    }

    public final void m16153a(@Nullable String str, long j, DisposableFutureCallback<MerchantInfoViewData> disposableFutureCallback, DisposableFutureCallback<GraphQLResult<FetchStorefrontCollectionQueryModel>> disposableFutureCallback2) {
        GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest("StorefrontCollection");
        ListenableFuture listenableFuture = null;
        if (str != null) {
            listenableFuture = graphQLBatchRequest.b(m16150b(Long.parseLong(str)));
        }
        ListenableFuture b = graphQLBatchRequest.b(m16151c(j));
        if (listenableFuture != null) {
            Futures.a(Futures.a(listenableFuture, new C21851(this), MoreExecutors.a()), disposableFutureCallback, this.f15710b);
        }
        Futures.a(b, disposableFutureCallback2, this.f15710b);
        this.f15709a.a(graphQLBatchRequest);
    }

    private static GraphQLRequest<FetchStorefrontCollectionQueryModel> m16151c(long j) {
        GraphQlQueryString fetchStorefrontCollectionQueryString = new FetchStorefrontCollectionQueryString();
        fetchStorefrontCollectionQueryString.a("collection_id", Long.valueOf(j));
        fetchStorefrontCollectionQueryString.a("COMMERCE_SMALL_IMAGE_SIZE", Integer.valueOf(50));
        fetchStorefrontCollectionQueryString.a("COMMERCE_MEDIUM_IMAGE_SIZE", Integer.valueOf(230));
        fetchStorefrontCollectionQueryString.a("count", Integer.valueOf(40));
        return GraphQLRequest.a(fetchStorefrontCollectionQueryString).a(RequestPriority.INTERACTIVE).a(GraphQLCachePolicy.c);
    }

    public final ListenableFuture<FetchStorefrontCollectionQueryModel> m16152a(long j) {
        return GraphQLQueryExecutor.a(this.f15709a.a(m16151c(j)));
    }
}
