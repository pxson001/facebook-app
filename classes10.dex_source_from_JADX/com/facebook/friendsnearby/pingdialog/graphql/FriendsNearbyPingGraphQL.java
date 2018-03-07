package com.facebook.friendsnearby.pingdialog.graphql;

import com.facebook.friendsnearby.pingdialog.graphql.FriendsNearbyPingGraphQLModels.FriendsNearbyLocationPingToUserModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: [^0-9a-zA-Z _-] */
public final class FriendsNearbyPingGraphQL {

    /* compiled from: [^0-9a-zA-Z _-] */
    public class FriendsNearbyLocationPingToUserString extends TypedGraphQlQueryString<FriendsNearbyLocationPingToUserModel> {
        public FriendsNearbyLocationPingToUserString() {
            super(FriendsNearbyLocationPingToUserModel.class, false, "FriendsNearbyLocationPingToUser", "a2ce3b4d50f168415f08a35c28e2264c", "viewer", "10154343224466729", RegularImmutableSet.a);
        }

        public final String m21043a(String str) {
            switch (str.hashCode()) {
                case 115792:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
