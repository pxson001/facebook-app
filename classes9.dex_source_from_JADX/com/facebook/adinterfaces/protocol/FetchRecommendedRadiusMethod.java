package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdGeoCircleModel;
import com.facebook.adinterfaces.protocol.FetchRecommendedRadiusQuery.FetchRecommendedRadiusQueryString;
import com.facebook.graphql.calls.RecommendedRadiusInputQueryParams;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import javax.inject.Inject;

/* compiled from: VideoId */
public class FetchRecommendedRadiusMethod {
    private final GraphQLQueryExecutor f22396a;
    private final AdInterfacesQueryBuilder f22397b;

    @Inject
    public FetchRecommendedRadiusMethod(GraphQLQueryExecutor graphQLQueryExecutor, AdInterfacesQueryBuilder adInterfacesQueryBuilder) {
        this.f22396a = graphQLQueryExecutor;
        this.f22397b = adInterfacesQueryBuilder;
    }

    public final GraphQLQueryFuture<GraphQLResult<AdGeoCircleModel>> m24235a(double d, double d2) {
        RecommendedRadiusInputQueryParams recommendedRadiusInputQueryParams = new RecommendedRadiusInputQueryParams();
        recommendedRadiusInputQueryParams.a("latitude", Double.valueOf(d));
        recommendedRadiusInputQueryParams.a("longitude", Double.valueOf(d2));
        return this.f22396a.a(GraphQLRequest.a((FetchRecommendedRadiusQueryString) new FetchRecommendedRadiusQueryString().a("coordinates", recommendedRadiusInputQueryParams)));
    }
}
