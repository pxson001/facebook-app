package com.facebook.nearby.v2.network;

import android.location.Location;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.GraphQLGeoRectangle;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQL.NearbyPlacesOldBrowseOldResultsSearchQueryString;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPlacesOldBrowseOldResultsSearchQueryModel;
import com.facebook.places.future.SimpleExecutor;
import com.google.common.base.Functions.ToStringFunction;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;

/* compiled from: detectedphotos */
public class BrowseNearbyPlacesRunner {
    public final SimpleExecutor f15705a;
    private GraphQLQueryExecutor f15706b;

    @Inject
    public BrowseNearbyPlacesRunner(SimpleExecutor simpleExecutor, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f15705a = simpleExecutor;
        this.f15706b = graphQLQueryExecutor;
    }

    public final void m18413a(BrowseNearbyPlacesParams browseNearbyPlacesParams, FutureCallback<NearbyPlacesOldBrowseOldResultsSearchQueryModel> futureCallback) {
        if (browseNearbyPlacesParams != null) {
            GraphQlQueryString nearbyPlacesOldBrowseOldResultsSearchQueryString = new NearbyPlacesOldBrowseOldResultsSearchQueryString();
            Location location = browseNearbyPlacesParams.f15698e;
            if (location != null) {
                String valueOf = String.valueOf(location.getLatitude());
                String valueOf2 = String.valueOf(location.getLongitude());
                nearbyPlacesOldBrowseOldResultsSearchQueryString.a("user_latitude", valueOf).a("user_longitude", valueOf2).a("horizontal_accuracy", String.valueOf(browseNearbyPlacesParams.f15699f)).a("stale_time", String.valueOf(browseNearbyPlacesParams.f15700g)).a("latitude", valueOf).a("longitude", valueOf2);
            }
            GraphQLGeoRectangle graphQLGeoRectangle = browseNearbyPlacesParams.f15696c;
            if (graphQLGeoRectangle == null) {
                nearbyPlacesOldBrowseOldResultsSearchQueryString.a("altitude", "0").a("vertical_accuracy", "0").a("speed", "0");
            } else {
                nearbyPlacesOldBrowseOldResultsSearchQueryString.a("topic", String.valueOf(browseNearbyPlacesParams.m18412i())).a("altitude", String.valueOf(browseNearbyPlacesParams.f15701h)).a("vertical_accuracy", String.valueOf(browseNearbyPlacesParams.f15702i)).a("heading", String.valueOf(browseNearbyPlacesParams.f15703j)).a("speed", String.valueOf(browseNearbyPlacesParams.f15695b)).a("north_latitude", String.valueOf(graphQLGeoRectangle.j())).a("west_longitude", String.valueOf(graphQLGeoRectangle.l())).a("south_latitude", String.valueOf(graphQLGeoRectangle.k())).a("east_longitude", String.valueOf(graphQLGeoRectangle.a())).a("zoom", String.valueOf(browseNearbyPlacesParams.f15697d));
                ImmutableList i = browseNearbyPlacesParams.m18412i();
                if (i != null) {
                    nearbyPlacesOldBrowseOldResultsSearchQueryString.a("topic", Lists.a(i, ToStringFunction.INSTANCE));
                }
            }
            this.f15705a.a(GraphQLQueryExecutor.a(this.f15706b.a(GraphQLRequest.a(nearbyPlacesOldBrowseOldResultsSearchQueryString))), futureCallback);
        }
    }
}
