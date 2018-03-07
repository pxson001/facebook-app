package com.facebook.identitygrowth.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.identitygrowth.protocol.ProfileInfoTypeaheadSearchGraphQLModels.ProfileInfoTypeaheadSearchQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: mDismissSurveyId */
public final class ProfileInfoTypeaheadSearchGraphQL {

    /* compiled from: mDismissSurveyId */
    public class ProfileInfoTypeaheadSearchQueryString extends TypedGraphQlQueryString<ProfileInfoTypeaheadSearchQueryModel> {
        public ProfileInfoTypeaheadSearchQueryString() {
            super(ProfileInfoTypeaheadSearchQueryModel.class, false, "ProfileInfoTypeaheadSearchQuery", "7d1c666c7531e218a7966c1fe07b3c5e", "viewer", "10154358537646729", RegularImmutableSet.a);
        }

        public final String m17900a(String str) {
            switch (str.hashCode()) {
                case -519230531:
                    return "3";
                case 35780175:
                    return "0";
                case 412346332:
                    return "2";
                case 461177713:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
