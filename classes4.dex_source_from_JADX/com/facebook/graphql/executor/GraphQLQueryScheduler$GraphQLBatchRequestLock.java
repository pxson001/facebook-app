package com.facebook.graphql.executor;

import com.facebook.graphql.executor.GraphQLQueryScheduler.GraphQLRequestLock;

/* compiled from: sd_free_space */
public class GraphQLQueryScheduler$GraphQLBatchRequestLock extends GraphQLRequestLock {
    final /* synthetic */ GraphQLQueryScheduler f2985a;

    public GraphQLQueryScheduler$GraphQLBatchRequestLock(GraphQLQueryScheduler graphQLQueryScheduler, GraphQLReadMutex graphQLReadMutex) {
        this.f2985a = graphQLQueryScheduler;
        super(graphQLQueryScheduler, graphQLReadMutex);
    }
}
