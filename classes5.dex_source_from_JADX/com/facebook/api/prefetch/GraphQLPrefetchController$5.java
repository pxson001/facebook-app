package com.facebook.api.prefetch;

import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.base.Function;

/* compiled from: android_place_picker_edit_menu */
public final class GraphQLPrefetchController$5 implements Function<GraphQLResult<T>, GraphQLPrefetchResult<T>> {
    final /* synthetic */ boolean f10251a;

    public GraphQLPrefetchController$5(boolean z) {
        this.f10251a = z;
    }

    public final Object apply(Object obj) {
        return GraphQLPrefetchController.b((GraphQLResult) obj, this.f10251a);
    }
}
