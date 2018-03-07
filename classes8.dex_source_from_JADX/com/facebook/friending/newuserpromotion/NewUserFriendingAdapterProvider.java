package com.facebook.friending.newuserpromotion;

import android.content.Context;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.friending.newuserpromotion.friendrequests.NewUserFriendRequestsBinder;
import com.facebook.friending.newuserpromotion.friendrequests.NewUserFriendRequestsControllerProvider;
import com.facebook.friending.newuserpromotion.pymk.NewUserPYMKBinder;
import com.facebook.friending.newuserpromotion.pymk.NewUserPYMKControllerProvider;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ui.futures.TasksManager;

/* compiled from: fillViewport */
public class NewUserFriendingAdapterProvider extends AbstractAssistedProvider<NewUserFriendingAdapter> {
    public final NewUserFriendingAdapter m14998a(Context context, TasksManager tasksManager, FriendingLocation friendingLocation) {
        return new NewUserFriendingAdapter((NewUserFriendRequestsControllerProvider) getOnDemandAssistedProviderForStaticDi(NewUserFriendRequestsControllerProvider.class), new NewUserFriendRequestsBinder(AllCapsTransformationMethod.b(this), ResourcesMethodAutoProvider.a(this)), (NewUserPYMKControllerProvider) getOnDemandAssistedProviderForStaticDi(NewUserPYMKControllerProvider.class), NewUserPYMKBinder.m15017b(this), context, tasksManager, friendingLocation);
    }
}
