package com.facebook.growth.friendfinder;

import com.facebook.api.growth.contactimporter.PhonebookLookupResultContact;
import com.facebook.friending.common.list.model.FriendListItemModel;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import javax.annotation.Nullable;

/* compiled from: pay_over_counter_info */
public class FriendFinderFriendCandidate implements FriendListItemModel {
    private final long f7198a;
    @Nullable
    private final String f7199b;
    private final String f7200c;
    private final int f7201d;
    private final boolean f7202e;
    private GraphQLFriendshipStatus f7203f;
    private GraphQLFriendshipStatus f7204g;

    /* compiled from: pay_over_counter_info */
    public class Builder<T extends Builder> {
        public long f7193a;
        @Nullable
        public String f7194b;
        public String f7195c;
        public int f7196d;
        public boolean f7197e;
    }

    private FriendFinderFriendCandidate(PhonebookLookupResultContact phonebookLookupResultContact, boolean z) {
        this.f7198a = phonebookLookupResultContact.userId;
        this.f7199b = phonebookLookupResultContact.profilePic;
        this.f7200c = phonebookLookupResultContact.name;
        this.f7201d = phonebookLookupResultContact.mutualFriends;
        this.f7202e = z;
        GraphQLFriendshipStatus graphQLFriendshipStatus = GraphQLFriendshipStatus.CAN_REQUEST;
        this.f7204g = graphQLFriendshipStatus;
        this.f7203f = graphQLFriendshipStatus;
    }

    public FriendFinderFriendCandidate(Builder builder) {
        this.f7198a = builder.f7193a;
        this.f7199b = builder.f7194b;
        this.f7200c = builder.f7195c;
        this.f7201d = builder.f7196d;
        this.f7202e = builder.f7197e;
        GraphQLFriendshipStatus graphQLFriendshipStatus = GraphQLFriendshipStatus.CAN_REQUEST;
        this.f7204g = graphQLFriendshipStatus;
        this.f7203f = graphQLFriendshipStatus;
    }

    public final long m7467a() {
        return this.f7198a;
    }

    @Nullable
    public final String m7472d() {
        return this.f7199b;
    }

    public final String m7469b() {
        return this.f7200c;
    }

    public final int m7473e() {
        return this.f7201d;
    }

    public final String m7476h() {
        return null;
    }

    public final GraphQLFriendshipStatus m7471c() {
        return this.f7203f;
    }

    public final void m7468a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
        this.f7203f = graphQLFriendshipStatus;
    }

    public final GraphQLFriendshipStatus m7474f() {
        return this.f7204g;
    }

    public final void m7470b(GraphQLFriendshipStatus graphQLFriendshipStatus) {
        this.f7203f = this.f7204g;
        this.f7204g = graphQLFriendshipStatus;
    }

    public final FriendingLocation m7475g() {
        return this.f7202e ? FriendingLocation.PYMK_FRIEND_FINDER : FriendingLocation.FRIEND_FINDER;
    }

    public static FriendFinderFriendCandidate m7465a(PhonebookLookupResultContact phonebookLookupResultContact) {
        return new FriendFinderFriendCandidate(phonebookLookupResultContact, false);
    }

    public static FriendFinderFriendCandidate m7466b(PhonebookLookupResultContact phonebookLookupResultContact) {
        return new FriendFinderFriendCandidate(phonebookLookupResultContact, true);
    }
}
