package com.facebook.topics.data;

import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

/* compiled from: mExpiryYear */
public class TopicFavoritesToggleMutator {
    private final TasksManager f9522a;
    private final GraphQLQueryExecutor f9523b;
    private final String f9524c;

    private static TopicFavoritesToggleMutator m11210b(InjectorLike injectorLike) {
        return new TopicFavoritesToggleMutator(TasksManager.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), String_LoggedInUserIdMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public TopicFavoritesToggleMutator(TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor, String str) {
        this.f9522a = tasksManager;
        this.f9523b = graphQLQueryExecutor;
        this.f9524c = str;
    }
}
