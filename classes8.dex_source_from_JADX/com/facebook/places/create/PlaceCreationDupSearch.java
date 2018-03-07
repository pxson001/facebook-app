package com.facebook.places.create;

import android.location.Location;
import com.facebook.graphql.calls.CheckinSearchQueryInputCheckinSearchQuery;
import com.facebook.graphql.calls.CheckinSearchQueryInputCheckinSearchQuery.ViewerCoordinates;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.places.future.SimpleExecutor;
import com.facebook.places.graphql.PlacesGraphQL;
import com.facebook.places.graphql.PlacesGraphQL.CheckinSearchQueryString;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinSearchQuery;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinSearchQueryModel;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinSearchQueryModel.PlaceResultsModel.EdgesModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import java.util.List;
import javax.inject.Inject;

/* compiled from: cb5ba7d2b053c359769f64269b884f07 */
public class PlaceCreationDupSearch {
    private SimpleExecutor f18208a;
    private GraphQLQueryExecutor f18209b;

    @Inject
    public PlaceCreationDupSearch(SimpleExecutor simpleExecutor, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f18208a = simpleExecutor;
        this.f18209b = graphQLQueryExecutor;
    }

    public final void m22172a(PlaceCreationDupSearchParams placeCreationDupSearchParams, final FutureCallback<PlaceCreationDupSearchResults> futureCallback) {
        CheckinSearchQueryString a = PlacesGraphQL.a();
        String str = "query";
        CheckinSearchQueryInputCheckinSearchQuery checkinSearchQueryInputCheckinSearchQuery = new CheckinSearchQueryInputCheckinSearchQuery();
        checkinSearchQueryInputCheckinSearchQuery.a(placeCreationDupSearchParams.f18210a);
        checkinSearchQueryInputCheckinSearchQuery.a("category", Integer.valueOf(placeCreationDupSearchParams.f18212c));
        Location location = placeCreationDupSearchParams.f18211b;
        if (location != null) {
            ViewerCoordinates viewerCoordinates = new ViewerCoordinates();
            viewerCoordinates.a(Double.valueOf(location.getLatitude()));
            viewerCoordinates.b(Double.valueOf(location.getLongitude()));
            if (location.getAccuracy() != 0.0f) {
                viewerCoordinates.c(Double.valueOf((double) location.getAccuracy()));
            }
            if (location.hasSpeed()) {
                viewerCoordinates.d(Double.valueOf((double) location.getSpeed()));
            }
            checkinSearchQueryInputCheckinSearchQuery.a(viewerCoordinates);
        }
        if (placeCreationDupSearchParams.f18213d != null) {
            checkinSearchQueryInputCheckinSearchQuery.a("address", placeCreationDupSearchParams.f18213d);
        }
        if (placeCreationDupSearchParams.f18214e != null) {
            checkinSearchQueryInputCheckinSearchQuery.a("city", placeCreationDupSearchParams.f18214e);
        }
        if (placeCreationDupSearchParams.f18215f != null) {
            checkinSearchQueryInputCheckinSearchQuery.a("website", placeCreationDupSearchParams.f18215f);
        }
        if (placeCreationDupSearchParams.f18216g != null) {
            checkinSearchQueryInputCheckinSearchQuery.a("phone", placeCreationDupSearchParams.f18216g);
        }
        a.a(str, checkinSearchQueryInputCheckinSearchQuery).a("search_context", "bellerophon");
        this.f18208a.a(GraphQLQueryExecutor.a(this.f18209b.a(GraphQLRequest.a(a))), new FutureCallback<CheckinSearchQuery>(this) {
            final /* synthetic */ PlaceCreationDupSearch f18207b;

            public void onSuccess(Object obj) {
                CheckinSearchQueryModel checkinSearchQueryModel = (CheckinSearchQueryModel) obj;
                List a = Lists.a();
                ImmutableList a2 = checkinSearchQueryModel.b().a();
                int size = a2.size();
                for (int i = 0; i < size; i++) {
                    a.add(((EdgesModel) a2.get(i)).a());
                }
                String d = checkinSearchQueryModel.d();
                PlaceCreationDupSearchResults placeCreationDupSearchResults = new PlaceCreationDupSearchResults(a);
                placeCreationDupSearchResults.f18218b = d;
                futureCallback.onSuccess(placeCreationDupSearchResults);
            }

            public void onFailure(Throwable th) {
                futureCallback.onFailure(th);
            }
        });
    }

    public final void m22171a() {
        this.f18208a.c();
    }
}
