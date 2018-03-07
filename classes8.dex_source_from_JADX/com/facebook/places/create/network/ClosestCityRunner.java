package com.facebook.places.create.network;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.places.future.SimpleExecutor;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.FBCheckinNearbyCityQuery;
import com.facebook.places.graphql.PlacesGraphQLModels.FBCheckinNearbyCityQueryModel;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;

/* compiled from: card_form_input_controller_fragment */
public class ClosestCityRunner {
    public SimpleExecutor f18362a;
    public GraphQLQueryExecutor f18363b;

    /* compiled from: card_form_input_controller_fragment */
    public class C20081 implements FutureCallback<FBCheckinNearbyCityQuery> {
        final /* synthetic */ FutureCallback f18360a;
        final /* synthetic */ ClosestCityRunner f18361b;

        public C20081(ClosestCityRunner closestCityRunner, FutureCallback futureCallback) {
            this.f18361b = closestCityRunner;
            this.f18360a = futureCallback;
        }

        public void onSuccess(Object obj) {
            this.f18360a.onSuccess(((FBCheckinNearbyCityQueryModel) obj).a());
        }

        public void onFailure(Throwable th) {
            this.f18360a.onFailure(th);
        }
    }

    @Inject
    public ClosestCityRunner(SimpleExecutor simpleExecutor, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f18362a = simpleExecutor;
        this.f18363b = graphQLQueryExecutor;
    }

    public final void m22311a() {
        this.f18362a.c();
    }
}
