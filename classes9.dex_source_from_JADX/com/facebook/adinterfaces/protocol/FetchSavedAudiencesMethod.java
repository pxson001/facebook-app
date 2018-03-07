package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountAudiencesModel;
import com.facebook.adinterfaces.protocol.FetchSavedAudiencesQuery.FetchSavedAudiencesQueryString;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition */
public class FetchSavedAudiencesMethod {
    private final GraphQLQueryExecutor f22398a;
    private final AdInterfacesQueryBuilder f22399b;

    @Inject
    public FetchSavedAudiencesMethod(GraphQLQueryExecutor graphQLQueryExecutor, AdInterfacesQueryBuilder adInterfacesQueryBuilder) {
        this.f22398a = graphQLQueryExecutor;
        this.f22399b = adInterfacesQueryBuilder;
    }

    public final ListenableFuture<GraphQLResult<AdAccountAudiencesModel>> m24237a(String str, String str2, int i) {
        Preconditions.checkNotNull(str);
        return this.f22398a.a(GraphQLRequest.a((FetchSavedAudiencesQueryString) new FetchSavedAudiencesQueryString().a("account_id", str).a("fetch_saved_audiences", Boolean.valueOf(true)).a("num_of_saved_audiences_to_fetch", Integer.valueOf(i)).a("saved_audience_cursor", str2)));
    }
}
