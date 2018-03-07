package com.facebook.friends.protocol;

import com.facebook.friends.protocol.FetchFriendRequestsGraphQLModels.FriendRequestQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: map_source */
public final class FetchFriendRequestsGraphQL {

    /* compiled from: map_source */
    public class FriendRequestQueryString extends TypedGraphQlQueryString<FriendRequestQueryModel> {
        public FriendRequestQueryString() {
            super(FriendRequestQueryModel.class, false, "FriendRequestQuery", "37cce1f393f631c4b0f480685494f1de", "viewer", "10154358537236729", RegularImmutableSet.a);
        }

        public final boolean m16932l() {
            return true;
        }

        public final int[][] m16933m() {
            return new int[][]{new int[]{1, 0, Integer.MIN_VALUE, 1, 1}, new int[]{185, 0, Integer.MIN_VALUE, 1, 0}};
        }

        public final String m16931a(String str) {
            switch (str.hashCode()) {
                case -785864030:
                    return "3";
                case -693728706:
                    return "1";
                case 566144106:
                    return "0";
                case 1939875509:
                    return "2";
                default:
                    return str;
            }
        }
    }
}
