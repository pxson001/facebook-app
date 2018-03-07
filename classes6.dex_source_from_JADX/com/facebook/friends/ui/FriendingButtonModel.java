package com.facebook.friends.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.facebook.R;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.google.common.base.Preconditions;

/* compiled from: mStringSource */
public class FriendingButtonModel {
    private int f10849a;
    private int f10850b;
    private Boolean f10851c;
    public int f10852d = -1;
    public int f10853e = -1;

    public final void m17424a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
        if (this.f10852d == -1 || this.f10853e == -1) {
            throw new RuntimeException("Resource for active and inactive button is needed");
        }
        this.f10851c = Boolean.TRUE;
        if (graphQLFriendshipStatus == GraphQLFriendshipStatus.CAN_REQUEST) {
            this.f10849a = this.f10853e;
            this.f10850b = 2131233228;
        } else if (graphQLFriendshipStatus == GraphQLFriendshipStatus.OUTGOING_REQUEST) {
            this.f10849a = this.f10852d;
            this.f10850b = 2131233230;
        } else if (graphQLFriendshipStatus == GraphQLFriendshipStatus.INCOMING_REQUEST) {
            this.f10849a = this.f10853e;
            this.f10850b = 2131233231;
        } else if (graphQLFriendshipStatus == GraphQLFriendshipStatus.ARE_FRIENDS) {
            this.f10849a = this.f10852d;
            this.f10850b = 2131233229;
        } else {
            this.f10849a = -1;
            this.f10851c = Boolean.FALSE;
        }
    }

    public final void m17423a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FriendingButton);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
        obtainStyledAttributes.recycle();
        if (resourceId != -1) {
            this.f10852d = resourceId;
        }
        if (resourceId2 != -1) {
            this.f10853e = resourceId2;
        }
    }

    public final void m17422a(int i) {
        this.f10852d = i;
    }

    public final void m17426b(int i) {
        this.f10853e = i;
    }

    public final int m17421a() {
        Preconditions.checkState(m17427c(), "The button should not be shown.");
        return this.f10850b;
    }

    public final int m17425b() {
        Preconditions.checkState(m17427c(), "The button should not be shown.");
        return this.f10849a;
    }

    public final boolean m17427c() {
        Preconditions.checkNotNull(this.f10851c, "Must call #setFromFriendshipStatus first");
        return this.f10851c.booleanValue();
    }
}
