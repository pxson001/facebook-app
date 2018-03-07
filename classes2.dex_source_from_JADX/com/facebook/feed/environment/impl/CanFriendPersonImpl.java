package com.facebook.feed.environment.impl;

import com.facebook.feed.environment.CanFriendPerson;
import com.facebook.feed.environment.CanFriendPerson.FriendshipStatus;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.controllers.FriendingButtonControllerWithCallback;
import com.facebook.friends.controllers.interfaces.FriendingButtonControllerCallback;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.proxygen.HTTPTransportCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: newsfeed_angora_attachment_view */
public class CanFriendPersonImpl implements CanFriendPerson {
    private final Lazy<FriendingButtonControllerWithCallback> f12289a;

    public static CanFriendPersonImpl m18307b(InjectorLike injectorLike) {
        return new CanFriendPersonImpl(IdBasedLazy.m1808a(injectorLike, 6686));
    }

    @Inject
    public CanFriendPersonImpl(Lazy<FriendingButtonControllerWithCallback> lazy) {
        this.f12289a = lazy;
    }

    public final FriendshipStatus mo2423a(String str, String str2, FriendingLocation friendingLocation, GraphQLFriendshipStatus graphQLFriendshipStatus, @Nullable FriendingButtonControllerCallback friendingButtonControllerCallback) {
        ((FriendingButtonControllerWithCallback) this.f12289a.get()).a(Long.parseLong(str), friendingLocation, graphQLFriendshipStatus, friendingButtonControllerCallback);
        switch (1.a[graphQLFriendshipStatus.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return new FriendshipStatus(GraphQLFriendshipStatus.CAN_REQUEST, false);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return new FriendshipStatus(GraphQLFriendshipStatus.OUTGOING_REQUEST, false);
            case 3:
                return new FriendshipStatus(GraphQLFriendshipStatus.ARE_FRIENDS, false);
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return new FriendshipStatus(GraphQLFriendshipStatus.CAN_REQUEST, true);
            default:
                throw new IllegalStateException("Unsupported Friending Status");
        }
    }

    public static CanFriendPersonImpl m18306a(InjectorLike injectorLike) {
        return m18307b(injectorLike);
    }
}
