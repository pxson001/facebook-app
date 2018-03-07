package com.facebook.messaging.business.subscription.common.utils;

import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.calls.MessengerContentPageSubscribeInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.blocking.BlockingUtils.2;
import com.facebook.messaging.business.subscription.common.analytics.BusinessSubscriptionAnalyticsLogger;
import com.facebook.messaging.business.subscription.common.graphql.BusinessSubscriptionMutations.ContentPageSubscribeMutationString;
import com.facebook.messaging.business.subscription.common.graphql.BusinessSubscriptionMutationsModels.ContentPageSubscribeMutationModel;
import com.facebook.messaging.business.subscription.common.graphql.BusinessSubscriptionMutationsModels.ContentPageUnsubscribeMutationModel;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: tracker_block_uuid */
public class BusinessSubscriptionMutationHelper {
    public final AbstractFbErrorReporter f1447a;
    public final GraphQLQueryExecutor f1448b;
    public final ExecutorService f1449c;
    private final BusinessSubscriptionAnalyticsLogger f1450d;
    private ListenableFuture<GraphQLResult<ContentPageSubscribeMutationModel>> f1451e;
    public ListenableFuture<GraphQLResult<ContentPageUnsubscribeMutationModel>> f1452f;

    /* compiled from: tracker_block_uuid */
    public class C01482 implements FutureCallback<GraphQLResult<ContentPageUnsubscribeMutationModel>> {
        final /* synthetic */ 2 f1445a;
        final /* synthetic */ BusinessSubscriptionMutationHelper f1446b;

        public C01482(BusinessSubscriptionMutationHelper businessSubscriptionMutationHelper, 2 2) {
            this.f1446b = businessSubscriptionMutationHelper;
            this.f1445a = 2;
        }

        public void onSuccess(@Nullable Object obj) {
            if (this.f1445a != null) {
                this.f1445a.a.a();
            }
        }

        public void onFailure(Throwable th) {
            this.f1446b.f1447a.a("BusinessSubscriptionMutationHelper", "Subscribe mutation request fails " + th.toString());
            if (this.f1445a != null) {
                this.f1445a.b();
            }
        }
    }

    /* compiled from: tracker_block_uuid */
    public interface SubscribeCallback {
        void mo65a();

        void mo66b();
    }

    public static BusinessSubscriptionMutationHelper m1637b(InjectorLike injectorLike) {
        return new BusinessSubscriptionMutationHelper((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), BusinessSubscriptionAnalyticsLogger.m1591b(injectorLike));
    }

    @Inject
    public BusinessSubscriptionMutationHelper(AbstractFbErrorReporter abstractFbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, BusinessSubscriptionAnalyticsLogger businessSubscriptionAnalyticsLogger) {
        this.f1447a = abstractFbErrorReporter;
        this.f1448b = graphQLQueryExecutor;
        this.f1449c = executorService;
        this.f1450d = businessSubscriptionAnalyticsLogger;
    }

    public final void m1638a(String str, @Nullable String str2, @Nullable final SubscribeCallback subscribeCallback) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(str));
        if (Strings.isNullOrEmpty(str2)) {
            this.f1447a.a("BusinessSubscriptionMutationHelper", "Subscribe page id is null");
            if (subscribeCallback != null) {
                subscribeCallback.mo66b();
            }
        }
        HoneyClientEventFast a = this.f1450d.f1434a.a("messenger_content_subscription_on_subscribe", false);
        if (a.a()) {
            a.a("source", str).a("page_id", str2).b();
        }
        MessengerContentPageSubscribeInputData messengerContentPageSubscribeInputData = new MessengerContentPageSubscribeInputData();
        messengerContentPageSubscribeInputData.a("page_id", str2);
        GraphQlQueryString contentPageSubscribeMutationString = new ContentPageSubscribeMutationString();
        contentPageSubscribeMutationString.a("input", messengerContentPageSubscribeInputData);
        this.f1451e = this.f1448b.a(GraphQLRequest.a(contentPageSubscribeMutationString));
        Futures.a(this.f1451e, new FutureCallback<GraphQLResult<ContentPageSubscribeMutationModel>>(this) {
            final /* synthetic */ BusinessSubscriptionMutationHelper f1444b;

            public void onSuccess(@Nullable Object obj) {
                if (subscribeCallback != null) {
                    subscribeCallback.mo65a();
                }
            }

            public void onFailure(Throwable th) {
                this.f1444b.f1447a.a("BusinessSubscriptionMutationHelper", "Subscribe mutation request fails. " + th.toString());
                if (subscribeCallback != null) {
                    subscribeCallback.mo66b();
                }
            }
        }, this.f1449c);
    }
}
