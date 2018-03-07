package com.facebook.messaging.business.ride.helper;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.messaging.business.ride.graphql.RideQueryFragmentsModels.RidePromoShareQueryModel;
import com.facebook.messaging.business.ride.graphql.RideQueryFragmentsModels.RidePromoShareQueryModel.MessengerCommerceModel.RideProvidersModel;
import com.facebook.messaging.business.ride.graphql.RideQueryFragmentsModels.RidePromoShareQueryModel.MessengerCommerceModel.RideProvidersModel.RideInviteModel;
import com.facebook.messaging.business.ride.uri.RidePromoUriHandler;
import com.facebook.messaging.business.ride.uri.RidePromoUriHandler.C10701;
import com.facebook.messaging.business.ride.uri.RidePromoUriHandler.C10712;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.database.handlers.DbFetchThreadsHandler;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Strings;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: moments_app_promotion */
public class RidePromoShareLoader {
    private final DataCache f9244a;
    private final DbFetchThreadsHandler f9245b;
    private final String f9246c;
    public final AbstractFbErrorReporter f9247d;
    public final GraphQLQueryExecutor f9248e;
    public final TasksManager<RidePromoTask> f9249f;

    /* compiled from: moments_app_promotion */
    public class C10662 extends AbstractDisposableFutureCallback<GraphQLResult<RidePromoShareQueryModel>> {
        final /* synthetic */ C10701 f9242a;
        final /* synthetic */ RidePromoShareLoader f9243b;

        public C10662(RidePromoShareLoader ridePromoShareLoader, C10701 c10701) {
            this.f9243b = ridePromoShareLoader;
            this.f9242a = c10701;
        }

        protected final void m9741a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (this.f9242a != null) {
                if (graphQLResult == null || graphQLResult.e == null || ((RidePromoShareQueryModel) graphQLResult.e).m9542a() == null || ((RidePromoShareQueryModel) graphQLResult.e).m9542a().m9537a().isEmpty() || ((RideProvidersModel) ((RidePromoShareQueryModel) graphQLResult.e).m9542a().m9537a().get(0)).m9533a() == null) {
                    this.f9243b.f9247d.a("RidePromoShareLoader", "GraphQL return invalid results");
                    this.f9242a.m9756a();
                    return;
                }
                Object obj2;
                C10701 c10701 = this.f9242a;
                RideInviteModel a = ((RideProvidersModel) ((RidePromoShareQueryModel) graphQLResult.e).m9542a().m9537a().get(0)).m9533a();
                RidePromoUriHandler ridePromoUriHandler = c10701.f9283c;
                String str = c10701.f9281a;
                String str2 = c10701.f9282b;
                if (Strings.isNullOrEmpty(a.m9526j()) || Strings.isNullOrEmpty(a.m9525a())) {
                    obj2 = null;
                } else {
                    new FbAlertDialogBuilder(ridePromoUriHandler.f9288a).a(a.m9526j()).b(a.m9525a()).a(2131230745, new C10712(ridePromoUriHandler, str, str2, a)).b();
                    obj2 = 1;
                }
                if (obj2 == null) {
                    RidePromoUriHandler.m9757a(c10701.f9283c, c10701.f9281a, c10701.f9282b, a);
                }
            }
        }

        protected final void m9742a(Throwable th) {
            if (this.f9242a != null) {
                this.f9242a.m9756a();
            }
            this.f9243b.f9247d.a("RidePromoShareLoader", th);
        }
    }

    /* compiled from: moments_app_promotion */
    public enum RidePromoTask {
        GET_RIDE_PROMO_SHARE
    }

    @Inject
    public RidePromoShareLoader(DataCache dataCache, DbFetchThreadsHandler dbFetchThreadsHandler, Provider<String> provider, FbErrorReporter fbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager) {
        this.f9244a = dataCache;
        this.f9245b = dbFetchThreadsHandler;
        this.f9246c = (String) provider.get();
        this.f9247d = fbErrorReporter;
        this.f9248e = graphQLQueryExecutor;
        this.f9249f = tasksManager;
    }
}
