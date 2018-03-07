package com.facebook.friending.center.model;

import com.facebook.friending.common.list.model.FriendListItemModel;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import javax.annotation.Nullable;

/* compiled from: age_ms */
public class FriendsCenterListItemModel implements FriendListItemModel {
    protected GraphQLFriendshipStatus f20001a;
    private final long f20002b;
    @Nullable
    private final String f20003c;
    private final String f20004d;
    private final int f20005e;
    private final FriendingLocation f20006f;
    private GraphQLFriendshipStatus f20007g;
    public boolean f20008h;

    /* compiled from: age_ms */
    public class Builder<T extends Builder> {
        public long f19993a;
        @Nullable
        public String f19994b;
        public String f19995c;
        public int f19996d;
        public FriendingLocation f19997e;
        public GraphQLFriendshipStatus f19998f;

        public FriendsCenterListItemModel mo892b() {
            return new FriendsCenterListItemModel(this);
        }
    }

    protected FriendsCenterListItemModel(Builder builder) {
        this.f20002b = builder.f19993a;
        this.f20003c = builder.f19994b;
        this.f20004d = builder.f19995c;
        this.f20005e = builder.f19996d;
        this.f20006f = builder.f19997e;
        GraphQLFriendshipStatus graphQLFriendshipStatus = builder.f19998f;
        this.f20001a = graphQLFriendshipStatus;
        this.f20007g = graphQLFriendshipStatus;
    }

    public final long m20172a() {
        return this.f20002b;
    }

    @Nullable
    public final String m20177d() {
        return this.f20003c;
    }

    public final String m20174b() {
        return this.f20004d;
    }

    public int mo893e() {
        return this.f20005e;
    }

    public String mo894h() {
        return null;
    }

    public final GraphQLFriendshipStatus m20176c() {
        return this.f20007g;
    }

    public final void m20173a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
        this.f20007g = graphQLFriendshipStatus;
    }

    public final GraphQLFriendshipStatus m20179f() {
        return this.f20001a;
    }

    public final void m20175b(GraphQLFriendshipStatus graphQLFriendshipStatus) {
        this.f20007g = this.f20001a;
        this.f20001a = graphQLFriendshipStatus;
    }

    public final void m20182m() {
        this.f20008h = true;
    }

    public final FriendingLocation m20180g() {
        return this.f20006f;
    }
}
