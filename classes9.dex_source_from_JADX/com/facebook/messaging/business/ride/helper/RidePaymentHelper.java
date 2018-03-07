package com.facebook.messaging.business.ride.helper;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.ride.graphql.RideQueryFragmentsModels.RidePaymentQueryModel;
import com.facebook.messaging.business.ride.graphql.RideQueryFragmentsModels.RidePaymentQueryModel.MessengerCommerceModel.RideProvidersModel;
import com.facebook.messaging.business.ride.view.RideRequestFragment;
import com.facebook.messaging.business.ride.view.RideRequestFragment.AnonymousClass12;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: moments_app_synced_photos */
public class RidePaymentHelper {
    public final AbstractFbErrorReporter f9239a;
    public final GraphQLQueryExecutor f9240b;
    public final TasksManager<String> f9241c;

    /* compiled from: moments_app_synced_photos */
    public class C10651 extends AbstractDisposableFutureCallback<GraphQLResult<RidePaymentQueryModel>> {
        final /* synthetic */ AnonymousClass12 f9237a;
        final /* synthetic */ RidePaymentHelper f9238b;

        public C10651(RidePaymentHelper ridePaymentHelper, AnonymousClass12 anonymousClass12) {
            this.f9238b = ridePaymentHelper;
            this.f9237a = anonymousClass12;
        }

        protected final void m9737a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((RidePaymentQueryModel) graphQLResult.e).m9469a() == null || ((RidePaymentQueryModel) graphQLResult.e).m9469a().m9464a().isEmpty()) {
                this.f9238b.f9239a.a("RidePaymentHelper", "GraphQL return invalid results");
            } else if (this.f9237a != null) {
                RideProvidersModel rideProvidersModel = (RideProvidersModel) ((RidePaymentQueryModel) graphQLResult.e).m9469a().m9464a().get(0);
                AnonymousClass12 anonymousClass12 = this.f9237a;
                String j = rideProvidersModel.m9460j();
                boolean a = rideProvidersModel.m9459a();
                anonymousClass12.f9387a.aG = j;
                anonymousClass12.f9387a.ay = a;
                RideRequestFragment.aI(anonymousClass12.f9387a);
                if (Strings.isNullOrEmpty(j)) {
                    anonymousClass12.f9387a.aD.setActionText(anonymousClass12.f9387a.b(2131240757));
                } else {
                    RideRequestFragment.m9846a(anonymousClass12.f9387a, j);
                }
            }
        }

        protected final void m9738a(Throwable th) {
            this.f9238b.f9239a.a("RidePaymentHelper", th);
        }
    }

    public static RidePaymentHelper m9739b(InjectorLike injectorLike) {
        return new RidePaymentHelper((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public RidePaymentHelper(AbstractFbErrorReporter abstractFbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager) {
        this.f9239a = abstractFbErrorReporter;
        this.f9240b = graphQLQueryExecutor;
        this.f9241c = tasksManager;
    }

    public final void m9740a() {
        this.f9241c.c("task_key_fetch_payment_info");
    }
}
