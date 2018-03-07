package com.facebook.growth.friendfinder;

import android.content.Context;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.friending.common.list.DefaultFriendListBinderProvider;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.navigator.NavigationEventBus;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.growth.logging.FriendFinderAnalyticsLogger;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: payload_size */
public class FriendFinderAddFriendsAdapterProvider extends AbstractAssistedProvider<FriendFinderAddFriendsAdapter> {
    public final FriendFinderAddFriendsAdapter m7438a(Context context) {
        return new FriendFinderAddFriendsAdapter(FbUriIntentHandler.a(this), FriendFinderAnalyticsLogger.a(this), FriendingEventBus.a(this), (DefaultFriendListBinderProvider) getOnDemandAssistedProviderForStaticDi(DefaultFriendListBinderProvider.class), NavigationEventBus.a(this), GatekeeperStoreImplMethodAutoProvider.a(this), context);
    }
}
