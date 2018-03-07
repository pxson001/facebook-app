package com.facebook.graphql.executor.cache;

import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;

/* compiled from: saved_item_pic_width */
public interface GraphQLRequestDiskCache {
    <T> GraphQLResult<T> mo1448b(GraphQLRequest<T> graphQLRequest);

    <T> void mo1449b(GraphQLRequest<T> graphQLRequest, GraphQLResult<T> graphQLResult);

    boolean mo1447d(GraphQLRequest graphQLRequest);
}
