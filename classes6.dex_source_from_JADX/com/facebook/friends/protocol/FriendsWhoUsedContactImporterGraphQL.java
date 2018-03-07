package com.facebook.friends.protocol;

import com.facebook.friends.protocol.FriendsWhoUsedContactImporterGraphQLModels.FriendsWhoUsedContactImporterQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: mVideoTaggingInfo */
public final class FriendsWhoUsedContactImporterGraphQL {

    /* compiled from: mVideoTaggingInfo */
    public class FriendsWhoUsedContactImporterQueryString extends TypedGraphQlQueryString<FriendsWhoUsedContactImporterQueryModel> {
        public FriendsWhoUsedContactImporterQueryString() {
            super(FriendsWhoUsedContactImporterQueryModel.class, false, "FriendsWhoUsedContactImporterQuery", "a5d41cdf444464a97b93e7c886408ff4", "me", "10154358997596729", RegularImmutableSet.a);
        }

        public final String m17367a(String str) {
            switch (str.hashCode()) {
                case -785864030:
                    return "3";
                case 97440432:
                    return "1";
                case 1234304744:
                    return "0";
                case 1939875509:
                    return "2";
                default:
                    return str;
            }
        }
    }
}
