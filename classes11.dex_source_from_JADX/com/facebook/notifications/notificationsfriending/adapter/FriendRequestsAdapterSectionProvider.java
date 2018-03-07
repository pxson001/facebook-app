package com.facebook.notifications.notificationsfriending.adapter;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.friending.jewel.adapter.FriendingRequestBinderProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.notificationsfriending.abtest.NotificationsFriendingExperimentController;
import com.facebook.notifications.notificationsfriending.logging.NotificationsFriendingAnalyticsLogger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: tileFetchedTime */
public class FriendRequestsAdapterSectionProvider extends AbstractAssistedProvider<FriendRequestsAdapterSection> {
    public final FriendRequestsAdapterSection m1339a(OnSectionUpdatedListener onSectionUpdatedListener) {
        return new FriendRequestsAdapterSection(NotificationsFriendingAnalyticsLogger.m1384a((InjectorLike) this), NotificationsFriendingExperimentController.a(this), (FbSharedPreferences) FbSharedPreferencesImpl.a(this), FbUriIntentHandler.a(this), (FriendingRequestBinderProvider) getOnDemandAssistedProviderForStaticDi(FriendingRequestBinderProvider.class), IdBasedProvider.a(this, 4442), ResourcesMethodAutoProvider.a(this), RTLUtil.a(this), onSectionUpdatedListener);
    }
}
