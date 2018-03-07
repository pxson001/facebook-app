package com.facebook.widget.friendshipbutton;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.google.common.collect.ImmutableMap;

/* compiled from: extbrowser */
public class FriendshipStatusButton extends ImageView {
    private static final ImmutableMap<GraphQLFriendshipStatus, Integer> f12987a = ImmutableMap.of(GraphQLFriendshipStatus.ARE_FRIENDS, Integer.valueOf(2130840457), GraphQLFriendshipStatus.CAN_REQUEST, Integer.valueOf(2130840456), GraphQLFriendshipStatus.OUTGOING_REQUEST, Integer.valueOf(2130840457));
    private static final ImmutableMap<GraphQLFriendshipStatus, Integer> f12988b = ImmutableMap.of(GraphQLFriendshipStatus.ARE_FRIENDS, Integer.valueOf(2131233361), GraphQLFriendshipStatus.CAN_REQUEST, Integer.valueOf(2131233212), GraphQLFriendshipStatus.OUTGOING_REQUEST, Integer.valueOf(2131233362));

    public FriendshipStatusButton(Context context) {
        this(context, null);
    }

    public FriendshipStatusButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundResource(2130840441);
        setScaleType(ScaleType.CENTER_INSIDE);
        setFriendshipStatus(GraphQLFriendshipStatus.CANNOT_REQUEST);
    }

    public void setFriendshipStatus(GraphQLFriendshipStatus graphQLFriendshipStatus) {
        if (f12987a.containsKey(graphQLFriendshipStatus)) {
            setImageResource(((Integer) f12987a.get(graphQLFriendshipStatus)).intValue());
            setContentDescription(getContext().getString(((Integer) f12988b.get(graphQLFriendshipStatus)).intValue()));
            setVisibility(0);
            return;
        }
        setVisibility(8);
    }
}
