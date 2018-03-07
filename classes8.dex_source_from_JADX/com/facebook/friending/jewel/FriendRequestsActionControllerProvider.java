package com.facebook.friending.jewel;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.friending.jewel.adapter.FriendRequestsAdapter;
import com.facebook.friends.FriendingCacheHandlerProvider;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.controllers.FriendingExceptionHandler;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ui.futures.TasksManager;

/* compiled from: fit */
public class FriendRequestsActionControllerProvider extends AbstractAssistedProvider<FriendRequestsActionController> {
    public final FriendRequestsActionController m14824a(Context context, FriendingLocation friendingLocation, FriendRequestsAdapter friendRequestsAdapter, TasksManager tasksManager) {
        return new FriendRequestsActionController(AnalyticsLoggerMethodAutoProvider.a(this), FriendingClient.b(this), FriendingEventBus.a(this), FriendingExceptionHandler.b(this), (FriendingCacheHandlerProvider) getOnDemandAssistedProviderForStaticDi(FriendingCacheHandlerProvider.class), context, friendingLocation, friendRequestsAdapter, tasksManager);
    }
}
