package com.facebook.audiofingerprinting.graphql;

import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLInterfaces.RidgeSuggestionsQuery.SuggestedTaggableActivities;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLModels.RidgeSuggestionsQueryModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: update_info */
public class FetchSuggestionFromFingerprintRequest {
    public static final String f1076b = "32";
    public static final String f1077c = "60";
    public GraphQLQueryExecutor f1078a;

    /* compiled from: update_info */
    final class C01071 implements Function<GraphQLResult<RidgeSuggestionsQueryModel>, SuggestedTaggableActivities> {
        C01071() {
        }

        public final Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((RidgeSuggestionsQueryModel) graphQLResult.e).a() == null) {
                return null;
            }
            return ((RidgeSuggestionsQueryModel) graphQLResult.e).a();
        }
    }

    @Inject
    public FetchSuggestionFromFingerprintRequest(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f1078a = graphQLQueryExecutor;
    }

    @VisibleForTesting
    public static ListenableFuture<SuggestedTaggableActivities> m1036a(ListenableFuture<GraphQLResult<RidgeSuggestionsQueryModel>> listenableFuture) {
        return Futures.a(listenableFuture, new C01071(), MoreExecutors.a());
    }
}
