package com.facebook.saved.protocol.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.saved.protocol.graphql.FetchSavedItemsGraphQLModels.FetchSavedItemsGraphQLModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: int[] */
public final class FetchSavedItemsGraphQL {

    /* compiled from: int[] */
    public class FetchSavedItemsGraphQLString extends TypedGraphQlQueryString<FetchSavedItemsGraphQLModel> {
        public FetchSavedItemsGraphQLString() {
            super(FetchSavedItemsGraphQLModel.class, false, "FetchSavedItemsGraphQL", "71c2b50c5a2e637ea925b94b38513ac1", "viewer", "10154501383626729", RegularImmutableSet.a);
        }

        public final String m9278a(String str) {
            switch (str.hashCode()) {
                case -1460262781:
                    return "5";
                case -705314112:
                    return "2";
                case 16907033:
                    return "1";
                case 138216560:
                    return "4";
                case 650530900:
                    return "0";
                case 1126804829:
                    return "3";
                case 1139691781:
                    return "6";
                default:
                    return str;
            }
        }
    }
}
