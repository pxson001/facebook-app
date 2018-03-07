package com.facebook.messaging.business.ride.helper;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.ride.graphql.RideQueryFragmentsModels.RideEstimateQueryModel;
import com.facebook.messaging.business.ride.graphql.RideQueryFragmentsModels.RideEstimateQueryModel.MessengerCommerceModel.RideProvidersModel;
import com.facebook.messaging.business.ride.graphql.RideQueryFragmentsModels.RideEstimateQueryModel.MessengerCommerceModel.RideProvidersModel.RideEstimateInformationModel;
import com.facebook.messaging.business.ride.view.RideMultiOptionsView;
import com.facebook.messaging.business.ride.view.RideRequestFragment.C10965;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: moneyPennyPlaceOrderParams */
public class RideEstimateHelper {
    public static final String f9153a = RideEstimateHelper.class.getSimpleName();
    public final AbstractFbErrorReporter f9154b;
    public final GraphQLQueryExecutor f9155c;
    public final ExecutorService f9156d;
    public ListenableFuture<GraphQLResult<RideEstimateQueryModel>> f9157e;
    @GuardedBy("ui-thread")
    public C10965 f9158f;

    /* compiled from: moneyPennyPlaceOrderParams */
    public class C10501 implements FutureCallback<GraphQLResult<RideEstimateQueryModel>> {
        final /* synthetic */ RideEstimateHelper f9152a;

        public C10501(RideEstimateHelper rideEstimateHelper) {
            this.f9152a = rideEstimateHelper;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((RideEstimateQueryModel) graphQLResult.e).m9449a() == null || ((RideEstimateQueryModel) graphQLResult.e).m9449a().m9444a().isEmpty()) {
                this.f9152a.f9154b.a(RideEstimateHelper.f9153a, "GraphQL return invalid results");
                return;
            }
            C10965 c10965 = this.f9152a.f9158f;
            RideEstimateInformationModel a = ((RideProvidersModel) ((RideEstimateQueryModel) graphQLResult.e).m9449a().m9444a().get(0)).m9440a();
            if (a != null && c10965.f9398a.mx_()) {
                if (a.m9431a() != 0) {
                    c10965.f9398a.aB.setSelectedSubText(c10965.f9398a.a(2131240747, new Object[]{Integer.valueOf(a.m9431a() / 60)}));
                } else {
                    c10965.f9398a.aB.m9818a();
                }
                if (Strings.isNullOrEmpty(a.m9436k()) || Strings.isNullOrEmpty(a.m9435j())) {
                    c10965.f9398a.aC.m9818a();
                } else {
                    String a2;
                    RideMultiOptionsView rideMultiOptionsView = c10965.f9398a.aC;
                    if (a.m9436k().equals(a.m9435j())) {
                        a2 = c10965.f9398a.a(2131240749, new Object[]{a.m9436k()});
                    } else {
                        a2 = c10965.f9398a.a(2131240748, new Object[]{a.m9436k(), a.m9435j()});
                    }
                    rideMultiOptionsView.setSelectedSubText(a2);
                }
            }
        }

        public void onFailure(Throwable th) {
            if (!this.f9152a.f9157e.isCancelled()) {
                this.f9152a.f9154b.a(RideEstimateHelper.f9153a, th);
            }
        }
    }

    public static RideEstimateHelper m9697b(InjectorLike injectorLike) {
        return new RideEstimateHelper((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public RideEstimateHelper(AbstractFbErrorReporter abstractFbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService) {
        this.f9154b = abstractFbErrorReporter;
        this.f9155c = graphQLQueryExecutor;
        this.f9156d = executorService;
    }

    public final void m9698a() {
        if (this.f9157e != null && !this.f9157e.isDone() && !this.f9157e.isCancelled()) {
            this.f9157e.cancel(true);
        }
    }
}
