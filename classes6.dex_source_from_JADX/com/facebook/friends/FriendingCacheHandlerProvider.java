package com.facebook.friends;

import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ui.futures.TasksManager;

/* compiled from: me/privacy_edits */
public class FriendingCacheHandlerProvider extends AbstractAssistedProvider<FriendingCacheHandler> {
    public final FriendingCacheHandler m16710a(TasksManager tasksManager) {
        return new FriendingCacheHandler(GraphQLCacheManager.a(this), tasksManager);
    }
}
