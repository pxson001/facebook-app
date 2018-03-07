package com.facebook.search.protocol.sports;

import com.facebook.common.util.TriState;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: month_text_color */
public final class FetchSportMatchDataGraphQL {

    /* compiled from: month_text_color */
    public class FetchSportMatchDataGraphQLString extends TypedGraphQlQueryString<GraphQLPage> {
        public FetchSportMatchDataGraphQLString() {
            super(GraphQLPage.class, false, "FetchSportMatchDataGraphQL", "1f6603c43496a6cd64012810f5a35755", "page", "10154439284766729", RegularImmutableSet.a);
        }

        public final TriState m9552g() {
            return TriState.NO;
        }

        public final String m9551a(String str) {
            switch (str.hashCode()) {
                case -1780769805:
                    return "8";
                case -1745741354:
                    return "10";
                case -1663499699:
                    return "6";
                case -1230853545:
                    return "2";
                case -1150725321:
                    return "9";
                case -1101600581:
                    return "3";
                case -968655752:
                    return "0";
                case -812310319:
                    return "1";
                case -461877888:
                    return "7";
                case -317710003:
                    return "12";
                case 169846802:
                    return "5";
                case 557908192:
                    return "11";
                case 1939875509:
                    return "4";
                default:
                    return str;
            }
        }
    }
}
