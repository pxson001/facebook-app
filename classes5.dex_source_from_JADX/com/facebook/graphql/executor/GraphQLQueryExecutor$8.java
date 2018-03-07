package com.facebook.graphql.executor;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: lightweight_place_picker_search_results_id */
final class GraphQLQueryExecutor$8 implements Function<GraphQLResult, List<T>> {
    GraphQLQueryExecutor$8() {
    }

    public final Object apply(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult == null) {
            return RegularImmutableList.a;
        }
        Builder builder = ImmutableList.builder();
        for (Object next : graphQLResult.e()) {
            if (next != null) {
                builder.c(next);
            }
        }
        return builder.b();
    }
}
