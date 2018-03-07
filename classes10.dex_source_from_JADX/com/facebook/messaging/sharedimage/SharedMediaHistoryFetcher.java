package com.facebook.messaging.sharedimage;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.sharedimage.gqlrequest.SharedMediaHistoryRequestFactory;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

/* compiled from: quick_cam */
public class SharedMediaHistoryFetcher {
    private final GraphQLQueryExecutor f4020a;
    private final SharedMediaHistoryRequestFactory f4021b;
    private final TasksManager<String> f4022c;

    private static SharedMediaHistoryFetcher m3734b(InjectorLike injectorLike) {
        return new SharedMediaHistoryFetcher(GraphQLQueryExecutor.a(injectorLike), SharedMediaHistoryRequestFactory.b(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public SharedMediaHistoryFetcher(GraphQLQueryExecutor graphQLQueryExecutor, SharedMediaHistoryRequestFactory sharedMediaHistoryRequestFactory, TasksManager tasksManager) {
        this.f4020a = graphQLQueryExecutor;
        this.f4021b = sharedMediaHistoryRequestFactory;
        this.f4022c = tasksManager;
    }
}
