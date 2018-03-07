package com.facebook.entitycardsplugins.person.widget.actionbar;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.constants.FriendRequestMakeRef;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.controllers.FriendingExceptionHandler;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.cache.TimelineUserDataCleaner;
import java.util.concurrent.ExecutorService;

/* compiled from: heisman_open_pivot_from_camera */
public class PersonCardFriendingControllerProvider extends AbstractAssistedProvider<PersonCardFriendingController> {
    public final PersonCardFriendingController m13285a(FriendingLocation friendingLocation, FriendRequestMakeRef friendRequestMakeRef) {
        return new PersonCardFriendingController(friendingLocation, friendRequestMakeRef, FriendingClient.b(this), PersonCardFriendingDialogs.m13287a((InjectorLike) this), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), IdBasedProvider.a(this, 4442), TimelineUserDataCleaner.a(this), FriendingExceptionHandler.b(this), FriendingEventBus.a(this));
    }
}
