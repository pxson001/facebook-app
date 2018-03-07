package com.facebook.commerce.publishing.fetcher;

import com.facebook.commerce.publishing.event.CommercePublishingEventBus;
import com.facebook.commerce.publishing.event.CommercePublishingMutationEvent.Method;
import com.facebook.commerce.publishing.event.CommerceShopMutationEvent;
import com.facebook.commerce.publishing.graphql.CommerceStoreDeleteMutationModels.CommerceStoreDeleteMutationModel;
import com.facebook.commerce.publishing.graphql.CommerceStoreUpdateMutationModels.CommerceStoreUpdateMutationModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: cymk_view_loaded */
public class AdminEditShopFetcher {
    public final GraphQLQueryExecutor f15523a;
    private final GraphQLCacheManager f15524b;
    public final CommercePublishingEventBus f15525c;

    /* compiled from: cymk_view_loaded */
    public class C21431 implements FutureCallback<CommerceStoreDeleteMutationModel> {
        final /* synthetic */ AdminEditShopFetcher f15521a;

        public C21431(AdminEditShopFetcher adminEditShopFetcher) {
            this.f15521a = adminEditShopFetcher;
        }

        public void onSuccess(@Nullable Object obj) {
            AdminEditShopFetcher.m16027a(this.f15521a);
            this.f15521a.f15525c.a(CommerceShopMutationEvent.a(Method.DELETE));
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: cymk_view_loaded */
    public class C21442 implements FutureCallback<CommerceStoreUpdateMutationModel> {
        final /* synthetic */ AdminEditShopFetcher f15522a;

        public C21442(AdminEditShopFetcher adminEditShopFetcher) {
            this.f15522a = adminEditShopFetcher;
        }

        public void onSuccess(@Nullable Object obj) {
            AdminEditShopFetcher.m16027a(this.f15522a);
            this.f15522a.f15525c.a(CommerceShopMutationEvent.a(Method.EDIT));
        }

        public void onFailure(Throwable th) {
        }
    }

    @Inject
    public AdminEditShopFetcher(GraphQLQueryExecutor graphQLQueryExecutor, GraphQLCacheManager graphQLCacheManager, CommercePublishingEventBus commercePublishingEventBus) {
        this.f15523a = graphQLQueryExecutor;
        this.f15524b = graphQLCacheManager;
        this.f15525c = commercePublishingEventBus;
    }

    public static void m16027a(AdminEditShopFetcher adminEditShopFetcher) {
        adminEditShopFetcher.f15524b.a(ImmutableSet.of("GraphQLCommerceRequestTag"));
    }
}
