package com.facebook.messaging.business.subscription.instantarticle.util;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.messaging.business.subscription.common.abtest.ExperimentsForBusinessSubscriptionAbtestModule;
import com.facebook.messaging.business.subscription.instantarticle.graphql.BusinessSubscriptionIAQueriesModels.BusinessSubscriptionMessengerContentSubscribedQueryModel;
import com.facebook.messaging.business.subscription.instantarticle.util.BusinessIASubscriptionBannerPresenter.C01511;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

/* compiled from: total_visible_time */
public class BusinessIASubscriptionLoader {
    public final AbstractFbErrorReporter f1481a;
    public final GraphQLQueryExecutor f1482b;
    public final TasksManager<IASubscriptionTask> f1483c;

    /* compiled from: total_visible_time */
    public class C01531 extends AbstractDisposableFutureCallback<GraphQLResult<BusinessSubscriptionMessengerContentSubscribedQueryModel>> {
        final /* synthetic */ C01511 f1479a;
        final /* synthetic */ BusinessIASubscriptionLoader f1480b;

        public C01531(BusinessIASubscriptionLoader businessIASubscriptionLoader, C01511 c01511) {
            this.f1480b = businessIASubscriptionLoader;
            this.f1479a = c01511;
        }

        protected final void m1673a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (this.f1479a == null) {
                return;
            }
            if (graphQLResult == null || graphQLResult.e == null) {
                this.f1480b.f1481a.a("BusinessIASubscriptionLoader", "GraphQL return invalid results");
                return;
            }
            C01511 c01511 = this.f1479a;
            if (!((BusinessSubscriptionMessengerContentSubscribedQueryModel) graphQLResult.e).m1663a() && c01511.f1466b.f1478m.a(ExperimentsForBusinessSubscriptionAbtestModule.a, false)) {
                BusinessIASubscriptionBannerPresenter.m1669b(c01511.f1466b, c01511.f1465a);
            }
        }

        protected final void m1674a(Throwable th) {
            this.f1480b.f1481a.a("BusinessIASubscriptionLoader", th);
        }
    }

    /* compiled from: total_visible_time */
    public enum IASubscriptionTask {
        IS_CONTENT_SUBSCRIBED
    }

    @Inject
    public BusinessIASubscriptionLoader(AbstractFbErrorReporter abstractFbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager) {
        this.f1481a = abstractFbErrorReporter;
        this.f1482b = graphQLQueryExecutor;
        this.f1483c = tasksManager;
    }
}
