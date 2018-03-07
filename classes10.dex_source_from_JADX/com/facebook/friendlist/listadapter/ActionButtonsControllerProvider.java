package com.facebook.friendlist.listadapter;

import android.content.Context;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.friendlist.constants.FriendListSource;
import com.facebook.friendlist.constants.FriendListType;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.controllers.FriendingExceptionHandler;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: action_name */
public class ActionButtonsControllerProvider extends AbstractAssistedProvider<ActionButtonsController> {
    public final ActionButtonsController m20644a(Context context, FriendListType friendListType, FriendListSource friendListSource) {
        return new ActionButtonsController(context, friendListType, friendListSource, FriendingClient.b(this), FriendingEventBus.a(this), DefaultAndroidThreadUtil.b(this), FriendingExceptionHandler.b(this), FbUriIntentHandler.a(this));
    }
}
