package com.facebook.crowdsourcing.loader;

import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.SuggestEditsHeader;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.SuggestEditsSections;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsHeaderModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsSectionsModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.base.Function;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT */
public class FetchSuggestEditsGraphQLRequest {
    public final GraphQLQueryExecutor f17432a;
    public final ListeningExecutorService f17433b;

    /* compiled from: com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT */
    public class C14351 implements Function<GraphQLResult<SuggestEditsSectionsModel>, SuggestEditsSections> {
        final /* synthetic */ FetchSuggestEditsGraphQLRequest f17430a;

        public C14351(FetchSuggestEditsGraphQLRequest fetchSuggestEditsGraphQLRequest) {
            this.f17430a = fetchSuggestEditsGraphQLRequest;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            return graphQLResult == null ? null : (SuggestEditsSectionsModel) graphQLResult.e;
        }
    }

    /* compiled from: com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT */
    public class C14362 implements Function<GraphQLResult<SuggestEditsHeaderModel>, SuggestEditsHeader> {
        final /* synthetic */ FetchSuggestEditsGraphQLRequest f17431a;

        public C14362(FetchSuggestEditsGraphQLRequest fetchSuggestEditsGraphQLRequest) {
            this.f17431a = fetchSuggestEditsGraphQLRequest;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            return graphQLResult == null ? null : (SuggestEditsHeaderModel) graphQLResult.e;
        }
    }

    @Inject
    public FetchSuggestEditsGraphQLRequest(GraphQLQueryExecutor graphQLQueryExecutor, ListeningExecutorService listeningExecutorService) {
        this.f17432a = graphQLQueryExecutor;
        this.f17433b = listeningExecutorService;
    }
}
