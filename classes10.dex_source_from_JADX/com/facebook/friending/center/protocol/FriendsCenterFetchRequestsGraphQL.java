package com.facebook.friending.center.protocol;

import com.facebook.friending.center.protocol.FriendsCenterFetchRequestsGraphQLModels.FriendsCenterFetchRequestsQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: advertiser_id */
public final class FriendsCenterFetchRequestsGraphQL {

    /* compiled from: advertiser_id */
    public class FriendsCenterFetchRequestsQueryString extends TypedGraphQlQueryString<FriendsCenterFetchRequestsQueryModel> {
        public FriendsCenterFetchRequestsQueryString() {
            super(FriendsCenterFetchRequestsQueryModel.class, false, "FriendsCenterFetchRequestsQuery", "a5985aebd32600a9b66364c114347454", "viewer", "10154554070146729", RegularImmutableSet.a);
        }

        public final boolean m20232l() {
            return true;
        }

        public final int[][] m20233m() {
            return new int[][]{new int[]{1, 0, Integer.MIN_VALUE, 0, 1}, new int[]{185, 0, Integer.MIN_VALUE, 0, 0}};
        }

        public final String m20231a(String str) {
            switch (str.hashCode()) {
                case -693728706:
                    return "1";
                case 566144106:
                    return "0";
                case 1819236250:
                    return "2";
                default:
                    return str;
            }
        }
    }
}
