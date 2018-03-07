package com.facebook.auth.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: souvenir_db_model_version */
public final class GetLoggedInUserGraphQL {

    /* compiled from: souvenir_db_model_version */
    public class GetLoggedInUserQueryString extends TypedGraphQlQueryString<GetLoggedInUserGraphQLModels$GetLoggedInUserQueryModel> {
        public GetLoggedInUserQueryString() {
            super(GetLoggedInUserGraphQLModels$GetLoggedInUserQueryModel.class, false, "GetLoggedInUserQuery", "e4143fa6cdbeb3bfd00dd6ef82f0db33", "viewer", "10154688841806729", RegularImmutableSet.a);
        }

        public final String m2021a(String str) {
            switch (str.hashCode()) {
                case -1198366833:
                    return "0";
                case -563474474:
                    return "2";
                case 1505524220:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
