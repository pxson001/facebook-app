package com.facebook.search.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.search.protocol.FetchSimpleSearchEntitiesGraphQLModels.FetchSimpleSearchEntitiesQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: network_info */
public final class FetchSimpleSearchEntitiesGraphQL {

    /* compiled from: network_info */
    public class FetchSimpleSearchEntitiesQueryString extends TypedGraphQlQueryString<FetchSimpleSearchEntitiesQueryModel> {
        public FetchSimpleSearchEntitiesQueryString() {
            super(FetchSimpleSearchEntitiesQueryModel.class, false, "FetchSimpleSearchEntitiesQuery", "c61c70011cef6724ea64218d0dc2cf52", "entities_named", "10154429040006729", RegularImmutableSet.a);
        }

        public final String m8777a(String str) {
            switch (str.hashCode()) {
                case 3575610:
                    return "1";
                case 92734940:
                    return "3";
                case 94851343:
                    return "4";
                case 107944136:
                    return "0";
                case 692733304:
                    return "5";
                case 1661853540:
                    return "2";
                default:
                    return str;
            }
        }
    }
}
