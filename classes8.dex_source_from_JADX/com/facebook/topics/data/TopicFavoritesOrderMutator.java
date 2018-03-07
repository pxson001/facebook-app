package com.facebook.topics.data;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

/* compiled from: mFbPaymentCardType */
public class TopicFavoritesOrderMutator {
    public final TasksManager f9519a;
    public final GraphQLQueryExecutor f9520b;
    public final String f9521c;

    @Inject
    public TopicFavoritesOrderMutator(TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor, String str) {
        this.f9519a = tasksManager;
        this.f9520b = graphQLQueryExecutor;
        this.f9521c = str;
    }
}
