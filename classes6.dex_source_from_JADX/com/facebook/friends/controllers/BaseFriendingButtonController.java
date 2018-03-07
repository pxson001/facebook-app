package com.facebook.friends.controllers;

import com.facebook.friends.FriendingClient;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEvent;
import com.facebook.friends.events.FriendingEvents.SubscribeStatusChangedEvent;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;

/* compiled from: me/blacklisted_pymk_users */
public abstract class BaseFriendingButtonController {
    public final FriendingClient f10560a;
    protected final FriendingExceptionHandler f10561b;
    public final FriendingEventBus f10562c;
    public boolean f10563d = false;

    public BaseFriendingButtonController(FriendingClient friendingClient, FriendingEventBus friendingEventBus, FriendingExceptionHandler friendingExceptionHandler) {
        this.f10560a = friendingClient;
        this.f10562c = friendingEventBus;
        this.f10561b = friendingExceptionHandler;
    }

    public final void m16717a(Throwable th) {
        if (!this.f10563d) {
            this.f10561b.a(th);
        }
    }

    protected final void m16715a(long j, GraphQLFriendshipStatus graphQLFriendshipStatus, boolean z) {
        this.f10562c.a(new FriendshipStatusChangedEvent(j, graphQLFriendshipStatus, z));
    }

    protected final void m16716a(long j, GraphQLSubscribeStatus graphQLSubscribeStatus, GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus, boolean z) {
        this.f10562c.a(new SubscribeStatusChangedEvent(j, graphQLSubscribeStatus, graphQLSecondarySubscribeStatus, z));
    }
}
