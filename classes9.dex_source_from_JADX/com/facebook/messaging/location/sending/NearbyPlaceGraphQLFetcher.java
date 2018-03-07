package com.facebook.messaging.location.sending;

import android.content.res.Resources;
import android.location.Location;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.calls.CheckinSearchQueryInputCheckinSearchQuery;
import com.facebook.graphql.calls.CheckinSearchQueryInputCheckinSearchQuery.ViewerCoordinates;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.messaging.location.sending.graphql.NearbyPlacesGraphQL;
import com.facebook.messaging.location.sending.graphql.NearbyPlacesGraphQL.NearbyPlacesQueryString;
import com.facebook.messaging.location.sending.graphql.NearbyPlacesGraphQLModels.NearbyPlacesQueryModel;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mMediaCodec is null when release. */
public class NearbyPlaceGraphQLFetcher {
    private static final CallerContext f11450a = CallerContext.a(NearbyPlaceGraphQLFetcher.class);
    private final GraphQLQueryExecutor f11451b;
    public final Resources f11452c;

    @Inject
    public NearbyPlaceGraphQLFetcher(GraphQLQueryExecutor graphQLQueryExecutor, Resources resources) {
        this.f11451b = graphQLQueryExecutor;
        this.f11452c = resources;
    }

    public final ListenableFuture<NearbyPlacesQueryModel> m12052a(Location location, @Nullable String str) {
        Preconditions.checkNotNull(location);
        NearbyPlacesQueryString a = NearbyPlacesGraphQL.m12103a();
        CheckinSearchQueryInputCheckinSearchQuery checkinSearchQueryInputCheckinSearchQuery = new CheckinSearchQueryInputCheckinSearchQuery();
        if (!StringUtil.a(str)) {
            checkinSearchQueryInputCheckinSearchQuery.a(str);
        }
        ViewerCoordinates viewerCoordinates = new ViewerCoordinates();
        viewerCoordinates.a(Double.valueOf(location.getLatitude()));
        viewerCoordinates.b(Double.valueOf(location.getLongitude()));
        viewerCoordinates.c(Double.valueOf((double) location.getAccuracy()));
        if (location.hasSpeed()) {
            viewerCoordinates.d(Double.valueOf((double) location.getSpeed()));
        }
        checkinSearchQueryInputCheckinSearchQuery.a(viewerCoordinates);
        a.a("search_params", checkinSearchQueryInputCheckinSearchQuery);
        a.a("profile_picture_size", String.valueOf(this.f11452c.getDimensionPixelSize(2131433708)));
        GraphQLRequest a2 = GraphQLRequest.a(NearbyPlacesGraphQL.m12103a()).a(a.j()).a(GraphQLCachePolicy.a).a(300);
        a2.f = f11450a;
        return GraphQLQueryExecutor.a(this.f11451b.a(a2));
    }
}
