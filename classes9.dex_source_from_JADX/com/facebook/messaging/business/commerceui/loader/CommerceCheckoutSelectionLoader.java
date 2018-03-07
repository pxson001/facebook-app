package com.facebook.messaging.business.commerceui.loader;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.MessengerCommerceFetchProductGroupQueryModel;
import com.facebook.messaging.business.commerceui.analytics.MessengerCommerceAnalyticsLogger;
import com.facebook.messaging.business.commerceui.analytics.MessengerCommerceAnalyticsLogger.CommerceNetworkRequestTypes;
import com.facebook.messaging.business.commerceui.views.retail.CommerceCheckoutSelectionAdapter;
import com.facebook.messaging.business.commerceui.views.retail.CommerceCheckoutSelectionFragment.C09622;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: num_videos */
public class CommerceCheckoutSelectionLoader {
    public final GraphQLQueryExecutor f8381a;
    public final ExecutorService f8382b;
    public final MessengerCommerceAnalyticsLogger f8383c;
    public final MonotonicClock f8384d;
    public final AbstractFbErrorReporter f8385e;
    public ListenableFuture<GraphQLResult<MessengerCommerceFetchProductGroupQueryModel>> f8386f;
    @GuardedBy("ui-thread")
    public C09622 f8387g;

    /* compiled from: num_videos */
    public class C09491 implements FutureCallback<GraphQLResult<MessengerCommerceFetchProductGroupQueryModel>> {
        final /* synthetic */ String f8378a;
        final /* synthetic */ long f8379b;
        final /* synthetic */ CommerceCheckoutSelectionLoader f8380c;

        public C09491(CommerceCheckoutSelectionLoader commerceCheckoutSelectionLoader, String str, long j) {
            this.f8380c = commerceCheckoutSelectionLoader;
            this.f8378a = str;
            this.f8379b = j;
        }

        public void onSuccess(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null) {
                this.f8380c.f8385e.a("CommerceCheckoutSelectionLoader", "Load selection list returns empty result, product id: " + this.f8378a);
                return;
            }
            C09622 c09622 = this.f8380c.f8387g;
            MessengerCommerceFetchProductGroupQueryModel messengerCommerceFetchProductGroupQueryModel = (MessengerCommerceFetchProductGroupQueryModel) graphQLResult.e;
            if (messengerCommerceFetchProductGroupQueryModel != null) {
                CommerceCheckoutSelectionAdapter commerceCheckoutSelectionAdapter = c09622.f8460a.f8463a;
                if (messengerCommerceFetchProductGroupQueryModel != null) {
                    commerceCheckoutSelectionAdapter.f8454a.m8680a(messengerCommerceFetchProductGroupQueryModel);
                    commerceCheckoutSelectionAdapter.f8458e = messengerCommerceFetchProductGroupQueryModel.d();
                    if (messengerCommerceFetchProductGroupQueryModel.b() != null) {
                        commerceCheckoutSelectionAdapter.f8457d = messengerCommerceFetchProductGroupQueryModel.b().a();
                    }
                    CommerceCheckoutSelectionAdapter.m8715f(commerceCheckoutSelectionAdapter);
                }
                c09622.f8460a.f8463a.notifyDataSetChanged();
                c09622.f8460a.f8471i.setVisibility(8);
                c09622.f8460a.f8469g.setVisibility(0);
            }
            this.f8380c.f8383c.m8655a(CommerceNetworkRequestTypes.CHECKOUT_SELECTIONS, true, this.f8380c.f8384d.now() - this.f8379b, null);
        }

        public void onFailure(Throwable th) {
            if (!this.f8380c.f8386f.isCancelled()) {
                this.f8380c.f8385e.a("CommerceCheckoutSelectionLoader", "Load selection list fails, product id: " + this.f8378a);
                this.f8380c.f8387g.f8460a.f8465c.a("CommerceCheckoutSelectionFragment", "CommerceCheckoutSelectionLoader fails");
                this.f8380c.f8383c.m8655a(CommerceNetworkRequestTypes.CHECKOUT_SELECTIONS, false, this.f8380c.f8384d.now() - this.f8379b, th != null ? th.getMessage() : null);
            }
        }
    }

    public static CommerceCheckoutSelectionLoader m8669b(InjectorLike injectorLike) {
        return new CommerceCheckoutSelectionLoader(GraphQLQueryExecutor.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), MessengerCommerceAnalyticsLogger.m8651b(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public CommerceCheckoutSelectionLoader(GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, MessengerCommerceAnalyticsLogger messengerCommerceAnalyticsLogger, MonotonicClock monotonicClock, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f8381a = graphQLQueryExecutor;
        this.f8382b = executorService;
        this.f8383c = messengerCommerceAnalyticsLogger;
        this.f8384d = monotonicClock;
        this.f8385e = abstractFbErrorReporter;
    }

    public final void m8670a() {
        if (this.f8386f != null && !this.f8386f.isDone() && !this.f8386f.isCancelled()) {
            this.f8386f.cancel(true);
        }
    }
}
