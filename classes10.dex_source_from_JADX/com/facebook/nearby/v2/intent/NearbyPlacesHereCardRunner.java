package com.facebook.nearby.v2.intent;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.nearby.v2.model.NearbyPlacesPlaceModel;
import com.facebook.nearby.v2.network.NearbyPlacesHereCardSuggestionGraphQLModels.FBNearbyPlacesHereCardHugeResultCellQueryModel;
import com.facebook.nearby.v2.network.NearbyPlacesHereCardSuggestionGraphQLModels.FBNearbyPlacesHereCardHugeResultCellQueryModel.SuggestionsModel.EdgesModel;
import com.facebook.places.future.SimpleExecutor;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: people_you_may_message */
public class NearbyPlacesHereCardRunner {
    public final GraphQLQueryExecutor f5112a;
    public final SimpleExecutor f5113b;

    /* compiled from: people_you_may_message */
    public class C07031 implements FutureCallback<FBNearbyPlacesHereCardHugeResultCellQueryModel> {
        final /* synthetic */ FutureCallback f5110a;
        final /* synthetic */ NearbyPlacesHereCardRunner f5111b;

        public C07031(NearbyPlacesHereCardRunner nearbyPlacesHereCardRunner, FutureCallback futureCallback) {
            this.f5111b = nearbyPlacesHereCardRunner;
            this.f5110a = futureCallback;
        }

        public void onSuccess(Object obj) {
            FBNearbyPlacesHereCardHugeResultCellQueryModel fBNearbyPlacesHereCardHugeResultCellQueryModel = (FBNearbyPlacesHereCardHugeResultCellQueryModel) obj;
            if (this.f5110a != null && fBNearbyPlacesHereCardHugeResultCellQueryModel != null && fBNearbyPlacesHereCardHugeResultCellQueryModel.a() != null) {
                ImmutableList a = fBNearbyPlacesHereCardHugeResultCellQueryModel.a().a();
                if (!a.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < a.size(); i++) {
                        EdgesModel edgesModel = (EdgesModel) a.get(i);
                        if (!(edgesModel == null || edgesModel.a() == null)) {
                            arrayList.add(new NearbyPlacesPlaceModel(edgesModel.a()));
                        }
                    }
                    this.f5110a.onSuccess(arrayList);
                }
            }
        }

        public void onFailure(Throwable th) {
            if (this.f5110a != null) {
                this.f5110a.onFailure(th);
            }
        }
    }

    @Inject
    public NearbyPlacesHereCardRunner(GraphQLQueryExecutor graphQLQueryExecutor, SimpleExecutor simpleExecutor) {
        this.f5112a = graphQLQueryExecutor;
        this.f5113b = simpleExecutor;
    }

    public final void m4615a() {
        this.f5113b.c();
    }
}
