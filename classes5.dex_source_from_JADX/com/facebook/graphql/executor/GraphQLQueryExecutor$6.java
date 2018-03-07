package com.facebook.graphql.executor;

import com.google.common.base.Function;
import javax.annotation.Nullable;

/* compiled from: lightweight_place_picker_search_results_id */
final class GraphQLQueryExecutor$6 implements Function<GraphQLResult<T>, T> {
    GraphQLQueryExecutor$6() {
    }

    public final Object apply(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult == null) {
            return null;
        }
        return graphQLResult.e;
    }
}
