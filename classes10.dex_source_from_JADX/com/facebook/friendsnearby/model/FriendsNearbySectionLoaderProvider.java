package com.facebook.friendsnearby.model;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLBatchRequestProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;
import java.util.concurrent.Executor;

/* compiled from: _id = ? */
public class FriendsNearbySectionLoaderProvider extends AbstractAssistedProvider<FriendsNearbySectionLoader> {
    public final FriendsNearbySectionLoader m20974a(TasksManager tasksManager) {
        return new FriendsNearbySectionLoader(tasksManager, (GraphQLBatchRequestProvider) getOnDemandAssistedProviderForStaticDi(GraphQLBatchRequestProvider.class), GraphQLQueryExecutor.a(this), FriendsNearbyQueryBuilder.m20943a((InjectorLike) this), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this));
    }
}
