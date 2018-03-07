package com.facebook.places.create.citypicker;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.calls.CheckinSearchQueryInputCheckinSearchQuery;
import com.facebook.graphql.calls.CheckinSearchQueryInputCheckinSearchQuery.ViewerCoordinates;
import com.facebook.graphql.calls.ContextInputSearchType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.places.future.SimpleExecutor;
import com.facebook.places.graphql.PlacesGraphQL.FBCitySearchQueryString;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinPlace;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.FBCitySearchQuery;
import com.facebook.places.graphql.PlacesGraphQLModels.FBCitySearchQueryModel;
import com.facebook.places.graphql.PlacesGraphQLModels.FBCitySearchQueryModel.PlaceResultsModel.EdgesModel;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: see_more_impression */
public class FetchCityRunner {
    private static final Class<?> f3571a;
    private static final CallerContext f3572b;
    private final SimpleExecutor f3573c;
    private GraphQLQueryExecutor f3574d;

    public static FetchCityRunner m3486b(InjectorLike injectorLike) {
        return new FetchCityRunner(SimpleExecutor.b(injectorLike), GraphQLQueryExecutor.a(injectorLike));
    }

    static {
        Class cls = FetchCityRunner.class;
        f3571a = cls;
        f3572b = CallerContext.a(cls);
    }

    @Inject
    public FetchCityRunner(SimpleExecutor simpleExecutor, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f3573c = simpleExecutor;
        this.f3574d = graphQLQueryExecutor;
    }

    public final void m3488a(FetchCityParam fetchCityParam, final FutureCallback<ArrayList<CheckinPlace>> futureCallback) {
        if (fetchCityParam != null) {
            CheckinSearchQueryInputCheckinSearchQuery checkinSearchQueryInputCheckinSearchQuery = new CheckinSearchQueryInputCheckinSearchQuery();
            if (fetchCityParam.f3568b != null) {
                ViewerCoordinates viewerCoordinates = new ViewerCoordinates();
                viewerCoordinates.a(Double.valueOf(fetchCityParam.f3568b.getLatitude()));
                viewerCoordinates.b(Double.valueOf(fetchCityParam.f3568b.getLongitude()));
                viewerCoordinates.c(Double.valueOf((double) fetchCityParam.f3568b.getAccuracy()));
                if (fetchCityParam.f3568b.hasSpeed()) {
                    viewerCoordinates.d(Double.valueOf((double) fetchCityParam.f3568b.getSpeed()));
                }
                checkinSearchQueryInputCheckinSearchQuery.a(viewerCoordinates);
            }
            if (fetchCityParam.f3567a != null) {
                checkinSearchQueryInputCheckinSearchQuery.a(fetchCityParam.f3567a);
            }
            GraphQlQueryString fBCitySearchQueryString = new FBCitySearchQueryString();
            fBCitySearchQueryString.a("query_data", checkinSearchQueryInputCheckinSearchQuery).a("num_nearby_places", Integer.valueOf(20)).a("search_context", ContextInputSearchType.CITY_SEARCH);
            this.f3573c.a(GraphQLQueryExecutor.a(this.f3574d.a(GraphQLRequest.a(fBCitySearchQueryString))), new FutureCallback<FBCitySearchQuery>(this) {
                final /* synthetic */ FetchCityRunner f3570b;

                public void onSuccess(Object obj) {
                    ArrayList a = Lists.a(((FBCitySearchQueryModel) obj).a().a());
                    ArrayList a2 = Lists.a();
                    int size = a.size();
                    for (int i = 0; i < size; i++) {
                        EdgesModel edgesModel = (EdgesModel) a.get(i);
                        if (edgesModel != null) {
                            a2.add(edgesModel.a());
                        }
                    }
                    futureCallback.onSuccess(a2);
                }

                public void onFailure(Throwable th) {
                    futureCallback.onFailure(th);
                }
            });
        }
    }

    public final void m3487a() {
        this.f3573c.c();
    }
}
