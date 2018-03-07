package com.facebook.groups.memberpicker.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.memberpicker.protocol.UserFriendsCollectionQueryModels.UserFriendsCollectionQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: escape_pps_style */
public final class UserFriendsCollectionQuery {

    /* compiled from: escape_pps_style */
    public class UserFriendsCollectionQueryString extends TypedGraphQlQueryString<UserFriendsCollectionQueryModel> {
        public UserFriendsCollectionQueryString() {
            super(UserFriendsCollectionQueryModel.class, false, "UserFriendsCollectionQuery", "f4817c3b63f3c1a1a75dd030a3932323", "node", "10154358997931729", RegularImmutableSet.a);
        }

        public final String m16849a(String str) {
            switch (str.hashCode()) {
                case -767546005:
                    return "3";
                case -381590603:
                    return "2";
                case -230346670:
                    return "1";
                case -147132913:
                    return "0";
                case 109250890:
                    return "5";
                case 120048402:
                    return "4";
                default:
                    return str;
            }
        }
    }
}
