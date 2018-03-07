package com.facebook.nearby.v2.typeahead;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.InjectorLike;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQL.FBNearbyPlacesLocationSearchQueryString;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQLModels.FBNearbyPlacesLocationSearchQueryModel;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQLModels.FBNearbyPlacesLocationSearchQueryModel.LocationsModel;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQLModels.FBNearbyPlacesTypeaheadLocationResultsConnectionFragmentModel.EdgesModel;
import com.facebook.nearby.v2.typeahead.model.NearbyPlacesLocationResult;
import com.facebook.places.future.SimpleExecutor;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;

/* compiled from: payment_card_verification */
public class NearbyPlacesLocationTypeaheadRunner {
    private final GraphQLQueryExecutor f5171a;
    private final SimpleExecutor f5172b;

    public static NearbyPlacesLocationTypeaheadRunner m4645b(InjectorLike injectorLike) {
        return new NearbyPlacesLocationTypeaheadRunner(GraphQLQueryExecutor.a(injectorLike), SimpleExecutor.b(injectorLike));
    }

    @Inject
    public NearbyPlacesLocationTypeaheadRunner(GraphQLQueryExecutor graphQLQueryExecutor, SimpleExecutor simpleExecutor) {
        this.f5171a = graphQLQueryExecutor;
        this.f5172b = simpleExecutor;
    }

    public final void m4647a(final NearbyPlacesTypeaheadParams nearbyPlacesTypeaheadParams, final FutureCallback<NearbyPlacesLocationResult> futureCallback) {
        m4646a();
        GraphQlQueryString fBNearbyPlacesLocationSearchQueryString = new FBNearbyPlacesLocationSearchQueryString();
        fBNearbyPlacesLocationSearchQueryString.a("search_query", nearbyPlacesTypeaheadParams.f5202c);
        fBNearbyPlacesLocationSearchQueryString.a("scale", GraphQlQueryDefaults.a());
        if (!(nearbyPlacesTypeaheadParams.f5200a == 0.0d || nearbyPlacesTypeaheadParams.f5201b == 0.0d)) {
            fBNearbyPlacesLocationSearchQueryString.a("latitude", Double.valueOf(nearbyPlacesTypeaheadParams.f5200a));
            fBNearbyPlacesLocationSearchQueryString.a("longitude", Double.valueOf(nearbyPlacesTypeaheadParams.f5201b));
        }
        this.f5172b.a(GraphQLQueryExecutor.a(this.f5171a.a(GraphQLRequest.a(fBNearbyPlacesLocationSearchQueryString))), new FutureCallback<FBNearbyPlacesLocationSearchQueryModel>(this) {
            final /* synthetic */ NearbyPlacesLocationTypeaheadRunner f5170c;

            public void onSuccess(Object obj) {
                FBNearbyPlacesLocationSearchQueryModel fBNearbyPlacesLocationSearchQueryModel = (FBNearbyPlacesLocationSearchQueryModel) obj;
                if (futureCallback != null) {
                    Builder builder = new Builder();
                    LocationsModel a = fBNearbyPlacesLocationSearchQueryModel.a();
                    if (a != null) {
                        ImmutableList a2 = a.a();
                        if (!a2.isEmpty()) {
                            for (int i = 0; i < a2.size(); i++) {
                                EdgesModel edgesModel = (EdgesModel) a2.get(i);
                                if (edgesModel.a() != null) {
                                    builder.c(edgesModel.a());
                                }
                            }
                        }
                    }
                    futureCallback.onSuccess(new NearbyPlacesLocationResult(nearbyPlacesTypeaheadParams.f5202c, builder.b(), fBNearbyPlacesLocationSearchQueryModel.a().j()));
                }
            }

            public void onFailure(Throwable th) {
                if (futureCallback != null) {
                    futureCallback.onFailure(th);
                }
            }
        });
    }

    public final void m4646a() {
        this.f5172b.c();
    }
}
