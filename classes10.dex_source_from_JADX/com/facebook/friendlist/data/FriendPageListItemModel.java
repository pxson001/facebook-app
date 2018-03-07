package com.facebook.friendlist.data;

import com.facebook.friending.common.list.model.FriendListItemModel;
import com.facebook.friendlist.protocol.FetchFriendListGraphQLModels.UserFieldsModel;
import com.facebook.friendlist.protocol.FetchFriendListGraphQLModels.UserFieldsModel.StructuredNameModel;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLStructuredNamePart;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.model.GraphQLHelper;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: actor_photo */
public class FriendPageListItemModel implements FriendListItemModel {
    private final long f20299a;
    @Nullable
    private final String f20300b;
    private final String f20301c;
    @Nullable
    public final String f20302d;
    private final int f20303e;
    private GraphQLFriendshipStatus f20304f;
    private GraphQLFriendshipStatus f20305g;
    public GraphQLSubscribeStatus f20306h;
    public int f20307i;

    public FriendPageListItemModel(UserFieldsModel userFieldsModel) {
        Preconditions.checkNotNull(userFieldsModel);
        this.f20299a = Long.parseLong(userFieldsModel.m20781k());
        this.f20300b = userFieldsModel.m20784n() == null ? null : userFieldsModel.m20784n().b();
        this.f20301c = userFieldsModel.m20783m();
        this.f20303e = userFieldsModel.m20782l() == null ? 0 : userFieldsModel.m20782l().m20761a();
        this.f20304f = userFieldsModel.m20780j();
        this.f20305g = userFieldsModel.m20780j();
        this.f20306h = userFieldsModel.m20786p();
        this.f20307i = userFieldsModel.m20787q();
        StructuredNameModel o = userFieldsModel.m20785o();
        if (o == null) {
            this.f20302d = null;
        } else {
            this.f20302d = GraphQLHelper.a(GraphQLStructuredNamePart.FIRST, o.m20770a(), o.m20771j());
        }
    }

    public final long m20575a() {
        return this.f20299a;
    }

    @Nullable
    public final String m20580d() {
        return this.f20300b;
    }

    public final String m20577b() {
        return this.f20301c;
    }

    public final int m20581e() {
        return this.f20303e;
    }

    public final String m20584h() {
        return null;
    }

    public final GraphQLFriendshipStatus m20579c() {
        return this.f20304f;
    }

    public final void m20576a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
    }

    public final GraphQLFriendshipStatus m20582f() {
        return this.f20305g;
    }

    public final void m20578b(GraphQLFriendshipStatus graphQLFriendshipStatus) {
        this.f20304f = this.f20305g;
        this.f20305g = graphQLFriendshipStatus;
    }

    public final FriendingLocation m20583g() {
        return FriendingLocation.FRIENDS_TAB;
    }
}
