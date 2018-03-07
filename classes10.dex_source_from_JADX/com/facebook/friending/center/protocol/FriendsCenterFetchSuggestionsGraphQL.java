package com.facebook.friending.center.protocol;

import com.facebook.friending.center.protocol.FriendsCenterFetchSuggestionsGraphQLModels.FriendsCenterFetchSuggestionsQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: ads_experience_id */
public final class FriendsCenterFetchSuggestionsGraphQL {

    /* compiled from: ads_experience_id */
    public class FriendsCenterFetchSuggestionsQueryString extends TypedGraphQlQueryString<FriendsCenterFetchSuggestionsQueryModel> {
        public FriendsCenterFetchSuggestionsQueryString() {
            super(FriendsCenterFetchSuggestionsQueryModel.class, false, "FriendsCenterFetchSuggestionsQuery", "3c50693703193533a427a28a19869cb0", "viewer", "10154554070136729", RegularImmutableSet.a);
        }

        public final boolean m20288l() {
            return true;
        }

        public final int[][] m20289m() {
            return new int[][]{new int[]{1, 0, Integer.MIN_VALUE, 1}, new int[]{185, 0, Integer.MIN_VALUE, 0}};
        }

        public final String m20287a(String str) {
            switch (str.hashCode()) {
                case 107876:
                    return "1";
                case 92734940:
                    return "2";
                case 97440432:
                    return "3";
                case 1819236250:
                    return "4";
                case 1901043637:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final FriendsCenterFetchSuggestionsQueryString m20290a() {
        return new FriendsCenterFetchSuggestionsQueryString();
    }
}
