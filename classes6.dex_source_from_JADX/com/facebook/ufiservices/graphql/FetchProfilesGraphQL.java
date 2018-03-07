package com.facebook.ufiservices.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.ufiservices.graphql.FetchProfilesGraphQLModels.FetchProfilesQueryModel;
import com.google.common.collect.RegularImmutableSet;
import java.util.Map;

/* compiled from: current_city_predictions */
public final class FetchProfilesGraphQL {

    /* compiled from: current_city_predictions */
    public class FetchProfilesQueryString extends TypedGraphQlQueryString<Map<String, FetchProfilesQueryModel>> {
        public FetchProfilesQueryString() {
            super(FetchProfilesQueryModel.class, true, "FetchProfilesQuery", "4782f5f0da72874a234e33bab1990ca8", "nodes", "10154429040276729", RegularImmutableSet.a);
        }

        public final String m26755a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "1";
                case 178017058:
                    return "0";
                case 689802720:
                    return "2";
                default:
                    return str;
            }
        }
    }
}
