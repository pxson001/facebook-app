package com.facebook.timeline.profilemedia.sync.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.timeline.profilemedia.sync.protocol.FetchProfilePicGraphQLModels.FetchProfilePicGraphQLModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: mSummary */
public final class FetchProfilePicGraphQL {

    /* compiled from: mSummary */
    public class FetchProfilePicGraphQLString extends TypedGraphQlQueryString<FetchProfilePicGraphQLModel> {
        public FetchProfilePicGraphQLString() {
            super(FetchProfilePicGraphQLModel.class, false, "FetchProfilePicGraphQL", "675e08f9d4330023e1a2c7100bce57de", "viewer", "10154648483866729", RegularImmutableSet.a);
        }

        public final String m10961a(String str) {
            switch (str.hashCode()) {
                case -1198366833:
                    return "0";
                case -563474474:
                    return "2";
                case 1505524220:
                    return "1";
                case 1819236250:
                    return "3";
                default:
                    return str;
            }
        }
    }
}
