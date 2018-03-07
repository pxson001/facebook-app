package com.facebook.topics.data;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.calls.FeedTopicsClassificationInputQueryParams;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.topics.protocol.TopicClassificationQuery.TopicClassificationQueryString;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: mFeedUnitHeaderStyled */
public class TopicClassificationFetcher {
    public final GraphQLQueryExecutor f9517a;
    private final TasksManager f9518b;

    @Inject
    public TopicClassificationFetcher(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager) {
        this.f9517a = graphQLQueryExecutor;
        this.f9518b = tasksManager;
    }

    public final void m11209a(final FeedTopicsClassificationInputQueryParams feedTopicsClassificationInputQueryParams, AbstractDisposableFutureCallback abstractDisposableFutureCallback) {
        Preconditions.checkNotNull(feedTopicsClassificationInputQueryParams);
        this.f9518b.a("QUERY_TOPIC_FEEDS_CLASSIFICATIONS_KEY", new Callable<ListenableFuture>(this) {
            final /* synthetic */ TopicClassificationFetcher f9516b;

            public Object call() {
                GraphQlQueryString topicClassificationQueryString = new TopicClassificationQueryString();
                topicClassificationQueryString.a("query_params", feedTopicsClassificationInputQueryParams);
                return this.f9516b.f9517a.a(GraphQLRequest.a(topicClassificationQueryString));
            }
        }, abstractDisposableFutureCallback);
    }
}
