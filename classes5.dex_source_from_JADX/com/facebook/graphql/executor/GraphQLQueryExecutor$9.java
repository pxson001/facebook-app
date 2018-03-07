package com.facebook.graphql.executor;

import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.RegularImmutableBiMap;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: lightweight_place_picker_search_results_id */
final class GraphQLQueryExecutor$9 implements Function<GraphQLResult, Map<String, T>> {
    GraphQLQueryExecutor$9() {
    }

    public final Object apply(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult == null) {
            return RegularImmutableBiMap.a;
        }
        Collection e = graphQLResult.e();
        Builder builder = ImmutableMap.builder();
        for (Object next : e) {
            if (next != null) {
                if (next instanceof GraphQLPersistableNode) {
                    String a = ((GraphQLPersistableNode) next).a();
                    if (a != null) {
                        builder.b(a, (GraphQLPersistableNode) next);
                    }
                } else {
                    throw new IllegalArgumentException("Not compatible with model types that don't have an ID");
                }
            }
        }
        return builder.b();
    }
}
