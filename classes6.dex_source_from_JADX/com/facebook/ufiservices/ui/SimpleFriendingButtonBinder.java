package com.facebook.ufiservices.ui;

import android.view.View;
import com.facebook.friends.ui.FriendingButton;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;

/* compiled from: crowdsourcing_create */
public class SimpleFriendingButtonBinder implements ProfileListFriendingButtonBinder<FriendingButton> {
    public final void mo1389a(View view, GraphQLFriendshipStatus graphQLFriendshipStatus) {
        ((FriendingButton) view).m17420a(graphQLFriendshipStatus);
    }
}
