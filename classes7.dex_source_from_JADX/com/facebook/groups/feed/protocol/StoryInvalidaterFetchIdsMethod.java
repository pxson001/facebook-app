package com.facebook.groups.feed.protocol;

import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: reaction_feed_title */
public interface StoryInvalidaterFetchIdsMethod<T> {
    GraphQLRequest<T> mo284a();

    ImmutableList<String> mo285a(T t);

    FutureCallback<GraphQLResult<T>> mo286b();
}
