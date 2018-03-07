package com.facebook.goodfriends.protocol;

import com.facebook.goodfriends.protocol.FetchAllFriendsAndGoodFriendsModels.GoodFriendsAudienceQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: mShouldFlipHorizontally */
public final class FetchAllFriendsAndGoodFriends {

    /* compiled from: mShouldFlipHorizontally */
    public class GoodFriendsAudienceQueryString extends TypedGraphQlQueryString<GoodFriendsAudienceQueryModel> {
        public GoodFriendsAudienceQueryString() {
            super(GoodFriendsAudienceQueryModel.class, false, "GoodFriendsAudienceQuery", "54aed8d54e5e55e8e4d72a47467bed6a", "viewer", "10154676189926729", RegularImmutableSet.a);
        }

        public final String m17460a(String str) {
            switch (str.hashCode()) {
                case 3530753:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
