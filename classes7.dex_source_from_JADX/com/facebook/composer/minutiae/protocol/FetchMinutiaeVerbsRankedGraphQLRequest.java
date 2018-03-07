package com.facebook.composer.minutiae.protocol;

import com.facebook.composer.minutiae.graphql.FetchTaggableActivitiesGraphQLModels.FetchRankedVerbsQueryModel;
import com.facebook.composer.minutiae.graphql.FetchTaggableActivitiesGraphQLModels.FetchRankedVerbsQueryModel.MinutiaeSuggestionsModel.NodesModel;
import com.facebook.composer.minutiae.protocol.MinutiaeVerbsFetcher.VerbResult;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: timeline_fetch_section */
public class FetchMinutiaeVerbsRankedGraphQLRequest {
    public final GraphQLQueryExecutor f1649a;

    /* compiled from: timeline_fetch_section */
    public class C01551 implements Function<GraphQLResult<FetchRankedVerbsQueryModel>, VerbResult> {
        final /* synthetic */ FetchMinutiaeVerbsRankedGraphQLRequest f1648a;

        public C01551(FetchMinutiaeVerbsRankedGraphQLRequest fetchMinutiaeVerbsRankedGraphQLRequest) {
            this.f1648a = fetchMinutiaeVerbsRankedGraphQLRequest;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null) {
                return null;
            }
            Builder builder = new Builder();
            for (NodesModel minutiaeVerbModelEdge : ((FetchRankedVerbsQueryModel) graphQLResult.e).a().a()) {
                builder.c(new MinutiaeVerbModelEdge(minutiaeVerbModelEdge));
            }
            return new VerbResult(builder.b(), graphQLResult.freshness);
        }
    }

    @Inject
    public FetchMinutiaeVerbsRankedGraphQLRequest(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f1649a = graphQLQueryExecutor;
    }
}
