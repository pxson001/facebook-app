package com.facebook.graphql.executor.cache;

import com.facebook.graphql.executor.GraphQLRequest;

/* compiled from: legacyStoryId */
class GraphQLCacheManager$1 implements Runnable {
    final /* synthetic */ GraphQLRequest f3244a;
    final /* synthetic */ GraphQLCacheManager f3245b;

    GraphQLCacheManager$1(GraphQLCacheManager graphQLCacheManager, GraphQLRequest graphQLRequest) {
        this.f3245b = graphQLCacheManager;
        this.f3244a = graphQLRequest;
    }

    public void run() {
        this.f3245b.a.c(this.f3244a);
    }
}
