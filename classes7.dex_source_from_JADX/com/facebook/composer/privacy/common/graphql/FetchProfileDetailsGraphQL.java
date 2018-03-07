package com.facebook.composer.privacy.common.graphql;

import com.facebook.composer.privacy.common.graphql.FetchProfileDetailsGraphQLModels.ProfileDetailsModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: tapped_page_about */
public final class FetchProfileDetailsGraphQL {

    /* compiled from: tapped_page_about */
    public class ProfileDetailsQueryString extends TypedGraphQlQueryString<ProfileDetailsModel> {
        public ProfileDetailsQueryString() {
            super(ProfileDetailsModel.class, false, "ProfileDetailsQuery", "bb13383f4344186edf6f9abc17d8ba40", "node", "10154339187501729", RegularImmutableSet.a);
        }

        public final String m2044a(String str) {
            switch (str.hashCode()) {
                case -1102636175:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
