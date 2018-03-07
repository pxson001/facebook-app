package com.facebook.composer.minutiae.graphql;

import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLModels.RidgeSuggestionsQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: address.full_address */
public final class MinutiaeSuggestionDefaultsGraphQL {

    /* compiled from: address.full_address */
    public class RidgeSuggestionsQueryString extends TypedGraphQlQueryString<RidgeSuggestionsQueryModel> {
        public RidgeSuggestionsQueryString() {
            super(RidgeSuggestionsQueryModel.class, false, "RidgeSuggestionsQuery", "39ed312e5f2dcf748d9000d8d0e8f38e", "viewer", "10154686241051729", RegularImmutableSet.a);
        }

        public final String m19540a(String str) {
            switch (str.hashCode()) {
                case -1777441434:
                    return "11";
                case -1363693170:
                    return "12";
                case -1355461064:
                    return "13";
                case -1256653634:
                    return "14";
                case -1101600581:
                    return "8";
                case -900029461:
                    return "1";
                case -579431816:
                    return "15";
                case 201381648:
                    return "5";
                case 351608024:
                    return "4";
                case 536922669:
                    return "7";
                case 623506394:
                    return "6";
                case 689802720:
                    return "9";
                case 1217697099:
                    return "0";
                case 1235171636:
                    return "2";
                case 1423926404:
                    return "10";
                case 1500369403:
                    return "3";
                default:
                    return str;
            }
        }
    }
}
