package com.facebook.friending.jewel.adapter;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.friends.FriendingCacheHandlerProvider;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.controllers.FriendRequestController;
import com.facebook.friends.util.FriendRequestUtil;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.notifications.notificationsfriending.adapter.FriendRequestsAdapterSection.1;
import com.facebook.ui.futures.TasksManager;

/* compiled from: filter_value_selected_value */
public class FriendingRequestBinderProvider extends AbstractAssistedProvider<FriendingRequestBinder> {
    public final FriendingRequestBinder m14951a(FriendingLocation friendingLocation, 1 1) {
        return new FriendingRequestBinder(AllCapsTransformationMethod.b(this), (FriendingCacheHandlerProvider) getOnDemandAssistedProviderForStaticDi(FriendingCacheHandlerProvider.class), FriendRequestController.b(this), FriendRequestUtil.a(this), ResourcesMethodAutoProvider.a(this), TasksManager.b(this), friendingLocation, 1);
    }
}
