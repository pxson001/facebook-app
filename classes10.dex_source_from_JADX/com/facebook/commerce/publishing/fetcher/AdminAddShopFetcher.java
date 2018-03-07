package com.facebook.commerce.publishing.fetcher;

import android.support.v4.util.Pair;
import com.facebook.commerce.core.util.CommerceCurrencyUtil;
import com.facebook.commerce.publishing.event.CommercePublishingEventBus;
import com.facebook.commerce.publishing.event.CommercePublishingMutationEvent.Method;
import com.facebook.commerce.publishing.event.CommerceShopMutationEvent;
import com.facebook.commerce.publishing.graphql.CommerceStoreCreateMutationModels.CommerceStoreCreateMutationModel;
import com.facebook.commerce.publishing.graphql.FetchAdminAddShopQuery.FetchAdminAddShopQueryString;
import com.facebook.commerce.publishing.graphql.FetchAdminAddShopQueryModels.FetchAdminAddShopQueryModel;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: d2ddc1e7ff628fec7d89456d3979b84d */
public class AdminAddShopFetcher {
    public final GraphQLQueryExecutor f15516a;
    public final ListeningExecutorService f15517b;
    public final CommerceCurrencyUtil f15518c;
    public final GraphQLCacheManager f15519d;
    public final CommercePublishingEventBus f15520e;

    /* compiled from: d2ddc1e7ff628fec7d89456d3979b84d */
    public class C21411 implements FutureCallback<CommerceStoreCreateMutationModel> {
        final /* synthetic */ AdminAddShopFetcher f15510a;

        public C21411(AdminAddShopFetcher adminAddShopFetcher) {
            this.f15510a = adminAddShopFetcher;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f15510a.f15519d.a(ImmutableSet.of("GraphQLCommerceRequestTag"));
            this.f15510a.f15520e.a(CommerceShopMutationEvent.a(Method.CREATE));
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: d2ddc1e7ff628fec7d89456d3979b84d */
    public class C21422 implements Callable<AdminAddShopFields> {
        final /* synthetic */ long f15511a;
        final /* synthetic */ AdminAddShopFetcher f15512b;

        public C21422(AdminAddShopFetcher adminAddShopFetcher, long j) {
            this.f15512b = adminAddShopFetcher;
            this.f15511a = j;
        }

        public Object call() {
            boolean z = false;
            ImmutableList a = this.f15512b.f15518c.a();
            Builder builder = new Builder();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                String str = (String) a.get(i);
                String a2 = this.f15512b.f15518c.a(str);
                if (a2 != null) {
                    builder.c(Pair.a(str, a2));
                }
            }
            a = builder.b();
            FetchAdminAddShopQueryModel fetchAdminAddShopQueryModel = (FetchAdminAddShopQueryModel) FutureDetour.a(GraphQLQueryExecutor.a(this.f15512b.f15516a.a(GraphQLRequest.a((FetchAdminAddShopQueryString) new FetchAdminAddShopQueryString().a("page_id", Long.toString(this.f15511a))).a(GraphQLCachePolicy.c))), 1395970530);
            boolean z2 = fetchAdminAddShopQueryModel.j() != null;
            if (fetchAdminAddShopQueryModel.a() != null) {
                z = fetchAdminAddShopQueryModel.a().a();
            }
            return new AdminAddShopFields(a, z2, z);
        }
    }

    /* compiled from: d2ddc1e7ff628fec7d89456d3979b84d */
    public class AdminAddShopFields {
        public final ImmutableList<Pair<String, String>> f15513a;
        public final boolean f15514b;
        public final boolean f15515c;

        public AdminAddShopFields(ImmutableList<Pair<String, String>> immutableList, boolean z, boolean z2) {
            this.f15513a = immutableList;
            this.f15514b = z;
            this.f15515c = z2;
        }
    }

    @Inject
    public AdminAddShopFetcher(GraphQLQueryExecutor graphQLQueryExecutor, ListeningExecutorService listeningExecutorService, CommerceCurrencyUtil commerceCurrencyUtil, GraphQLCacheManager graphQLCacheManager, CommercePublishingEventBus commercePublishingEventBus) {
        this.f15516a = graphQLQueryExecutor;
        this.f15517b = listeningExecutorService;
        this.f15518c = commerceCurrencyUtil;
        this.f15519d = graphQLCacheManager;
        this.f15520e = commercePublishingEventBus;
    }
}
