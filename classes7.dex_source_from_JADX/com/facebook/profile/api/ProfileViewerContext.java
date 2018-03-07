package com.facebook.profile.api;

import android.os.ParcelUuid;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.google.common.base.Objects;
import javax.annotation.Nullable;

/* compiled from: id= */
public class ProfileViewerContext {
    public final String f11210a;
    public final String f11211b;
    public final GraphQLFriendshipStatus f11212c;
    public final GraphQLSubscribeStatus f11213d;
    public ParcelUuid f11214e;

    public ProfileViewerContext(String str, String str2, @Nullable GraphQLFriendshipStatus graphQLFriendshipStatus, @Nullable GraphQLSubscribeStatus graphQLSubscribeStatus) {
        this.f11210a = str;
        this.f11211b = str2;
        if (graphQLFriendshipStatus == null) {
            graphQLFriendshipStatus = GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        this.f11212c = graphQLFriendshipStatus;
        if (graphQLSubscribeStatus == null) {
            graphQLSubscribeStatus = GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        this.f11213d = graphQLSubscribeStatus;
    }

    public ProfileViewerContext(long j, long j2, @Nullable GraphQLFriendshipStatus graphQLFriendshipStatus, @Nullable GraphQLSubscribeStatus graphQLSubscribeStatus) {
        this(String.valueOf(j), String.valueOf(j2), graphQLFriendshipStatus, graphQLSubscribeStatus);
    }

    public ProfileViewerContext(long j, long j2) {
        this(j, j2, null, null);
    }

    public final String m13137a() {
        return this.f11210a;
    }

    public final boolean m13138f() {
        return this.f11210a != null && this.f11210a.equals(this.f11211b);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("profileId", this.f11210a).add("viewerId", this.f11211b).add("friendshipStatus", this.f11212c.toString()).add("subscribeStatus", this.f11213d.toString()).toString();
    }

    public final RelationshipType m13139g() {
        return RelationshipType.getRelationshipType(m13138f(), this.f11212c, this.f11213d);
    }
}
