package com.facebook.messaging.business.commerceui.views.retail;

import com.facebook.common.time.MonotonicClock;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.messaging.business.commerce.converters.ModelConverters;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel;
import com.facebook.messaging.business.commerceui.analytics.MessengerCommerceAnalyticsLogger;
import com.facebook.messaging.business.commerceui.analytics.MessengerCommerceAnalyticsLogger.CommerceNetworkRequestTypes;
import com.facebook.messaging.business.commerceui.views.CommerceOrderHistoryFragment;
import com.facebook.messaging.business.commerceui.views.CommerceOrderHistoryFragment.C09583;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: null error msg in CreateAccount response for subcode  */
public class CommerceOrderHistoryLoader {
    public final GraphQLQueryExecutor f8478a;
    public final ExecutorService f8479b;
    private final ModelConverters f8480c;
    public final MessengerCommerceAnalyticsLogger f8481d;
    public final MonotonicClock f8482e;
    @Nullable
    public DefaultPageInfoFields f8483f;
    public ListenableFuture<GraphQLResult<CommerceReceiptListQueryModel>> f8484g;
    @GuardedBy("ui-thread")
    public C09583 f8485h;

    /* compiled from: null error msg in CreateAccount response for subcode  */
    public class C09651 implements FutureCallback<GraphQLResult<CommerceReceiptListQueryModel>> {
        final /* synthetic */ long f8476a;
        final /* synthetic */ CommerceOrderHistoryLoader f8477b;

        public C09651(CommerceOrderHistoryLoader commerceOrderHistoryLoader, long j) {
            this.f8477b = commerceOrderHistoryLoader;
            this.f8476a = j;
        }

        public void onSuccess(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            this.f8477b.f8484g = null;
            if (!(graphQLResult == null || graphQLResult.e == null || ((CommerceReceiptListQueryModel) graphQLResult.e).j() == null || ((CommerceReceiptListQueryModel) graphQLResult.e).j().j() == null)) {
                this.f8477b.f8483f = ((CommerceReceiptListQueryModel) graphQLResult.e).j().j().j();
            }
            C09583 c09583 = this.f8477b.f8485h;
            ImmutableList a = ModelConverters.a((CommerceReceiptListQueryModel) graphQLResult.e);
            if (c09583.f8430a.f8438h != null) {
                c09583.f8430a.f8438h.mo313a();
            }
            c09583.f8430a.f8434d.f8426a.addAll(a);
            AdapterDetour.a(c09583.f8430a.f8434d, 1869394395);
            CommerceOrderHistoryFragment.as(c09583.f8430a);
            this.f8477b.f8481d.m8655a(CommerceNetworkRequestTypes.ORDER_HISTORY, true, this.f8477b.f8482e.now() - this.f8476a, null);
        }

        public void onFailure(Throwable th) {
            String str = null;
            C09583 c09583 = this.f8477b.f8485h;
            if (c09583.f8430a.f8438h != null) {
                c09583.f8430a.f8438h.mo314b();
            }
            CommerceOrderHistoryFragment.as(c09583.f8430a);
            this.f8477b.f8484g = null;
            MessengerCommerceAnalyticsLogger messengerCommerceAnalyticsLogger = this.f8477b.f8481d;
            CommerceNetworkRequestTypes commerceNetworkRequestTypes = CommerceNetworkRequestTypes.ORDER_HISTORY;
            long now = this.f8477b.f8482e.now() - this.f8476a;
            if (th != null) {
                str = th.getMessage();
            }
            messengerCommerceAnalyticsLogger.m8655a(commerceNetworkRequestTypes, false, now, str);
        }
    }

    @Inject
    public CommerceOrderHistoryLoader(GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, ModelConverters modelConverters, MessengerCommerceAnalyticsLogger messengerCommerceAnalyticsLogger, MonotonicClock monotonicClock) {
        this.f8478a = graphQLQueryExecutor;
        this.f8479b = executorService;
        this.f8480c = modelConverters;
        this.f8481d = messengerCommerceAnalyticsLogger;
        this.f8482e = monotonicClock;
    }
}
