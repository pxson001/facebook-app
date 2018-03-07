package com.facebook.messaging.business.commerceui.loader;

import com.facebook.common.time.MonotonicClock;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.messaging.business.commerce.converters.ModelConverters;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceShoppingTrendingQueryModel;
import com.facebook.messaging.business.commerceui.analytics.MessengerCommerceAnalyticsLogger;
import com.facebook.messaging.business.commerceui.analytics.MessengerCommerceAnalyticsLogger.CommerceNetworkRequestTypes;
import com.facebook.messaging.business.commerceui.views.retail.CommerceShoppingTrendingFragment.C09661;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: num_unread */
public class CommerceShoppingTrendingLoader {
    public final GraphQLQueryExecutor f8390a;
    public final ExecutorService f8391b;
    public final MessengerCommerceAnalyticsLogger f8392c;
    public final MonotonicClock f8393d;
    public ListenableFuture<GraphQLResult<CommerceShoppingTrendingQueryModel>> f8394e;
    @GuardedBy("ui-thread")
    public C09661 f8395f;

    /* compiled from: num_unread */
    public class C09501 implements FutureCallback<GraphQLResult<CommerceShoppingTrendingQueryModel>> {
        final /* synthetic */ long f8388a;
        final /* synthetic */ CommerceShoppingTrendingLoader f8389b;

        public C09501(CommerceShoppingTrendingLoader commerceShoppingTrendingLoader, long j) {
            this.f8389b = commerceShoppingTrendingLoader;
            this.f8388a = j;
        }

        public void onSuccess(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            this.f8389b.f8394e = null;
            C09661 c09661 = this.f8389b.f8395f;
            ImmutableList a = ModelConverters.a((CommerceShoppingTrendingQueryModel) graphQLResult.e);
            c09661.f8489a.f8498g.setVisibility(4);
            c09661.f8489a.f8497f.setVisibility(0);
            if (c09661.f8489a.f8495d != null) {
                c09661.f8489a.f8495d.mo313a();
            }
            c09661.f8489a.f8493b.f8487a = a;
            c09661.f8489a.f8493b.notifyDataSetChanged();
            this.f8389b.f8392c.m8655a(CommerceNetworkRequestTypes.TRENDING_ITEMS, true, this.f8389b.f8393d.now() - this.f8388a, null);
        }

        public void onFailure(Throwable th) {
            String str = null;
            C09661 c09661 = this.f8389b.f8395f;
            c09661.f8489a.f8498g.setVisibility(4);
            c09661.f8489a.f8497f.setVisibility(0);
            if (c09661.f8489a.f8495d != null) {
                c09661.f8489a.f8495d.mo314b();
            }
            this.f8389b.f8394e = null;
            MessengerCommerceAnalyticsLogger messengerCommerceAnalyticsLogger = this.f8389b.f8392c;
            CommerceNetworkRequestTypes commerceNetworkRequestTypes = CommerceNetworkRequestTypes.TRENDING_ITEMS;
            long now = this.f8389b.f8393d.now() - this.f8388a;
            if (th != null) {
                str = th.getMessage();
            }
            messengerCommerceAnalyticsLogger.m8655a(commerceNetworkRequestTypes, false, now, str);
        }
    }

    @Inject
    public CommerceShoppingTrendingLoader(GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, MessengerCommerceAnalyticsLogger messengerCommerceAnalyticsLogger, MonotonicClock monotonicClock) {
        this.f8390a = graphQLQueryExecutor;
        this.f8391b = executorService;
        this.f8392c = messengerCommerceAnalyticsLogger;
        this.f8393d = monotonicClock;
    }
}
