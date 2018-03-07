package com.facebook.nearby.v2.typeahead;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQL.FBNearbyPlacesPlacesAndTopicsQueryString;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQLModels.FBNearbyPlacesPlacesAndTopicsQueryModel;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQLModels.FBNearbyPlacesTypeaheadPlaceResultsConnectionFragmentModel.EdgesModel;
import com.facebook.nearby.v2.typeahead.model.NearbyPlacesPlacesAndTopicsResult;
import com.facebook.places.future.SimpleExecutor;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: pay_button_tapped_count */
public class NearbyPlacesPlacesAndTopicsTypeaheadRunner {
    private final GraphQLQueryExecutor f5179a;
    private final SimpleExecutor f5180b;

    @Inject
    public NearbyPlacesPlacesAndTopicsTypeaheadRunner(GraphQLQueryExecutor graphQLQueryExecutor, SimpleExecutor simpleExecutor) {
        this.f5179a = graphQLQueryExecutor;
        this.f5180b = simpleExecutor;
    }

    public final void m4651a(final NearbyPlacesTypeaheadParams nearbyPlacesTypeaheadParams, final FutureCallback<NearbyPlacesPlacesAndTopicsResult> futureCallback) {
        m4650a();
        GraphQlQueryString fBNearbyPlacesPlacesAndTopicsQueryString = new FBNearbyPlacesPlacesAndTopicsQueryString();
        fBNearbyPlacesPlacesAndTopicsQueryString.a("search_query", nearbyPlacesTypeaheadParams.f5202c);
        fBNearbyPlacesPlacesAndTopicsQueryString.a("scale", GraphQlQueryDefaults.a());
        if (!(nearbyPlacesTypeaheadParams.f5200a == 0.0d || nearbyPlacesTypeaheadParams.f5201b == 0.0d)) {
            fBNearbyPlacesPlacesAndTopicsQueryString.a("latitude", Double.valueOf(nearbyPlacesTypeaheadParams.f5200a));
            fBNearbyPlacesPlacesAndTopicsQueryString.a("longitude", Double.valueOf(nearbyPlacesTypeaheadParams.f5201b));
        }
        this.f5180b.a(GraphQLQueryExecutor.a(this.f5179a.a(GraphQLRequest.a(fBNearbyPlacesPlacesAndTopicsQueryString))), new FutureCallback<FBNearbyPlacesPlacesAndTopicsQueryModel>(this) {
            final /* synthetic */ NearbyPlacesPlacesAndTopicsTypeaheadRunner f5178c;

            public void onSuccess(Object obj) {
                FBNearbyPlacesPlacesAndTopicsQueryModel fBNearbyPlacesPlacesAndTopicsQueryModel = (FBNearbyPlacesPlacesAndTopicsQueryModel) obj;
                int i = 0;
                if (futureCallback != null && fBNearbyPlacesPlacesAndTopicsQueryModel != null) {
                    ArrayList arrayList = new ArrayList();
                    ImmutableList a = fBNearbyPlacesPlacesAndTopicsQueryModel.a();
                    for (int i2 = 0; i2 < a.size(); i2++) {
                        arrayList.add(a.get(i2));
                    }
                    if (!arrayList.isEmpty() || fBNearbyPlacesPlacesAndTopicsQueryModel.j() != null || !fBNearbyPlacesPlacesAndTopicsQueryModel.j().a().isEmpty()) {
                        a = fBNearbyPlacesPlacesAndTopicsQueryModel.j().a();
                        ArrayList arrayList2 = new ArrayList();
                        while (i < a.size()) {
                            EdgesModel edgesModel = (EdgesModel) a.get(i);
                            if (edgesModel.a() != null) {
                                arrayList2.add(edgesModel.a());
                            }
                            i++;
                        }
                        futureCallback.onSuccess(new NearbyPlacesPlacesAndTopicsResult(nearbyPlacesTypeaheadParams.f5202c, arrayList2, arrayList, fBNearbyPlacesPlacesAndTopicsQueryModel.j().j()));
                    }
                }
            }

            public void onFailure(Throwable th) {
                if (futureCallback != null) {
                    futureCallback.onFailure(th);
                }
            }
        });
    }

    public final void m4650a() {
        this.f5180b.c();
    }
}
