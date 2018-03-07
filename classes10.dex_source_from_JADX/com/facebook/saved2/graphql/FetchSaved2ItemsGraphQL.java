package com.facebook.saved2.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.saved2.graphql.FetchSaved2ItemsGraphQLModels.FetchSaved2ItemsGraphQLModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: instant_shopping_document_id */
public final class FetchSaved2ItemsGraphQL {

    /* compiled from: instant_shopping_document_id */
    public class FetchSaved2ItemsGraphQLString extends TypedGraphQlQueryString<FetchSaved2ItemsGraphQLModel> {
        public FetchSaved2ItemsGraphQLString() {
            super(FetchSaved2ItemsGraphQLModel.class, false, "FetchSaved2ItemsGraphQL", "fe61b85006dc5373c8818a51cba90d5d", "viewer", "10154668438866729", RegularImmutableSet.a);
        }

        public final String m9536a(String str) {
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

    public static final FetchSaved2ItemsGraphQLString m9537a() {
        return new FetchSaved2ItemsGraphQLString();
    }
}
