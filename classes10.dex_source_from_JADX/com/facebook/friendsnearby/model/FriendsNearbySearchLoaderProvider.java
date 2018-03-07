package com.facebook.friendsnearby.model;

import android.content.Context;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ui.futures.TasksManager;

/* compiled from: _logTime */
public class FriendsNearbySearchLoaderProvider extends AbstractAssistedProvider<FriendsNearbySearchLoader> {
    public final FriendsNearbySearchLoader m20955a(TasksManager tasksManager) {
        return new FriendsNearbySearchLoader(tasksManager, ResourcesMethodAutoProvider.a(this), GraphQLQueryExecutor.a(this), (Context) getInstance(Context.class), (FriendsNearbyNewListRowProvider) getOnDemandAssistedProviderForStaticDi(FriendsNearbyNewListRowProvider.class));
    }
}
