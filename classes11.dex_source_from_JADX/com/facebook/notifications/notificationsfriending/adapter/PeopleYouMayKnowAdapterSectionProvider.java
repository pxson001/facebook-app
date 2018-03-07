package com.facebook.notifications.notificationsfriending.adapter;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.friending.jewel.adapter.FriendingPYMKBinder;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.notifications.notificationsfriending.abtest.NotificationsFriendingExperimentController;

/* compiled from: tigon_handlers */
public class PeopleYouMayKnowAdapterSectionProvider extends AbstractAssistedProvider<PeopleYouMayKnowAdapterSection> {
    public final PeopleYouMayKnowAdapterSection m1383a(OnSectionUpdatedListener onSectionUpdatedListener) {
        return new PeopleYouMayKnowAdapterSection(NotificationsFriendingExperimentController.a(this), FbUriIntentHandler.a(this), FriendingPYMKBinder.b(this), ResourcesMethodAutoProvider.a(this), onSectionUpdatedListener);
    }
}
