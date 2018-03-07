package com.facebook.friending.center.protocol;

import com.facebook.friending.center.protocol.FriendsCenterFetchFriendsGraphQLModels.FriendsCenterFetchFriendsQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: af1c83545c5b18cec72868fb46054fef */
public final class FriendsCenterFetchFriendsGraphQL {

    /* compiled from: af1c83545c5b18cec72868fb46054fef */
    public class FriendsCenterFetchFriendsQueryString extends TypedGraphQlQueryString<FriendsCenterFetchFriendsQueryModel> {
        public FriendsCenterFetchFriendsQueryString() {
            super(FriendsCenterFetchFriendsQueryModel.class, false, "FriendsCenterFetchFriendsQuery", "04c3ede6966b4eb20ee1c5b3c2c3fdcc", "me", "10154554070141729", RegularImmutableSet.a);
        }

        public final boolean m20211l() {
            return true;
        }

        public final int[][] m20212m() {
            return new int[][]{new int[]{1, 1, Integer.MIN_VALUE, 1}, new int[]{185, 1, Integer.MIN_VALUE, 0}};
        }

        public final String m20210a(String str) {
            switch (str.hashCode()) {
                case -693728706:
                    return "2";
                case 566144106:
                    return "1";
                case 1819236250:
                    return "3";
                case 1969934428:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final FriendsCenterFetchFriendsQueryString m20213a() {
        return new FriendsCenterFetchFriendsQueryString();
    }
}
