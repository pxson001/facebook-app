package com.facebook.events.permalink.guestlist;

import com.facebook.graphql.enums.GraphQLFriendshipStatus;

/* compiled from: boyfktqqqUCKfkbq2qBIGvjqbcdjcnkkkguyjhgwbzquihtqjdfBOYQWEXXXcbvdbxzsx */
public enum EventGuestListGuestButtonType {
    EDIT(2130840013, -4341303, 2131237152),
    MESSAGE(2130839685, -4341303, 2131237150),
    CAN_REQUEST(2130839877, -4341303, 2131233228),
    INCOMING_REQUEST(2130839879, -4341303, 2131233231),
    OUTGOING_REQUEST(2130839892, -10972929, 2131233230);
    
    private final int mGuestButtonColorResId;
    private final int mGuestButtonDescriptionResId;
    private final int mGuestButtonDrawableResId;

    /* compiled from: boyfktqqqUCKfkbq2qBIGvjqbcdjcnkkkguyjhgwbzquihtqjdfBOYQWEXXXcbvdbxzsx */
    /* synthetic */ class C26081 {
        static final /* synthetic */ int[] f18387a = null;

        static {
            f18387a = new int[GraphQLFriendshipStatus.values().length];
            try {
                f18387a[GraphQLFriendshipStatus.ARE_FRIENDS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18387a[GraphQLFriendshipStatus.CAN_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18387a[GraphQLFriendshipStatus.INCOMING_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f18387a[GraphQLFriendshipStatus.OUTGOING_REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private EventGuestListGuestButtonType(int i, int i2, int i3) {
        this.mGuestButtonDrawableResId = i;
        this.mGuestButtonColorResId = i2;
        this.mGuestButtonDescriptionResId = i3;
    }

    public final int getGuestButtonDrawableResId() {
        return this.mGuestButtonDrawableResId;
    }

    public final int getGuestButtonColorResId() {
        return this.mGuestButtonColorResId;
    }

    public final int getGuestButtonDescriptionResId() {
        return this.mGuestButtonDescriptionResId;
    }

    public static EventGuestListGuestButtonType getEventGuestListButton(GraphQLFriendshipStatus graphQLFriendshipStatus, boolean z) {
        if (z) {
            return EDIT;
        }
        switch (C26081.f18387a[graphQLFriendshipStatus.ordinal()]) {
            case 1:
                return MESSAGE;
            case 2:
                return CAN_REQUEST;
            case 3:
                return INCOMING_REQUEST;
            case 4:
                return OUTGOING_REQUEST;
            default:
                return null;
        }
    }
}
