package com.facebook.friending.newuserpromotion.friendrequests;

import android.content.Context;
import com.facebook.friending.newuserpromotion.NewUserFriendingAdapter;
import com.facebook.friends.FriendingCacheHandlerProvider;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.controllers.FriendingExceptionHandler;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ui.futures.TasksManager;

/* compiled from: ffabab0d2c77219656918068dd430ae2 */
public class NewUserFriendRequestsControllerProvider extends AbstractAssistedProvider<NewUserFriendRequestsController> {
    public final NewUserFriendRequestsController m15016a(Context context, FriendingLocation friendingLocation, NewUserFriendingAdapter newUserFriendingAdapter, TasksManager tasksManager) {
        return new NewUserFriendRequestsController(FriendingClient.b(this), FriendingExceptionHandler.b(this), (FriendingCacheHandlerProvider) getOnDemandAssistedProviderForStaticDi(FriendingCacheHandlerProvider.class), context, friendingLocation, newUserFriendingAdapter, tasksManager);
    }
}
