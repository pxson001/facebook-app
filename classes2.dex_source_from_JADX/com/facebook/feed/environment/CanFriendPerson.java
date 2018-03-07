package com.facebook.feed.environment;

import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.controllers.interfaces.FriendingButtonControllerCallback;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.multirow.api.AnyEnvironment;
import javax.annotation.Nullable;

/* compiled from: nl */
public interface CanFriendPerson extends AnyEnvironment {
    FriendshipStatus mo2423a(String str, String str2, FriendingLocation friendingLocation, GraphQLFriendshipStatus graphQLFriendshipStatus, @Nullable FriendingButtonControllerCallback friendingButtonControllerCallback);
}
