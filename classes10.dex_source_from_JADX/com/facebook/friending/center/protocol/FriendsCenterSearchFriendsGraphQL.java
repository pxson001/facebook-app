package com.facebook.friending.center.protocol;

import com.facebook.friending.center.protocol.FriendsCenterSearchFriendsGraphQLModels.FriendsCenterSearchFriendsQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: ads/mobile_preview? */
public final class FriendsCenterSearchFriendsGraphQL {

    /* compiled from: ads/mobile_preview? */
    public class FriendsCenterSearchFriendsQueryString extends TypedGraphQlQueryString<FriendsCenterSearchFriendsQueryModel> {
        public FriendsCenterSearchFriendsQueryString() {
            super(FriendsCenterSearchFriendsQueryModel.class, false, "FriendsCenterSearchFriendsQuery", "94eaf4b01666145e681038ee5753d801", "friending_search", "10154554070126729", RegularImmutableSet.a);
        }

        public final String m20305a(String str) {
            switch (str.hashCode()) {
                case -921706922:
                    return "0";
                case -693728706:
                    return "2";
                case 566144106:
                    return "1";
                case 1819236250:
                    return "3";
                default:
                    return str;
            }
        }
    }
}
