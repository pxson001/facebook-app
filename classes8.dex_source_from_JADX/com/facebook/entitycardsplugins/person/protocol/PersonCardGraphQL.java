package com.facebook.entitycardsplugins.person.protocol;

import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLModels.PersonCardModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: home_%s */
public final class PersonCardGraphQL {

    /* compiled from: home_%s */
    public class PersonCardFetchCardString extends TypedGraphQlQueryString<PersonCardModel> {
        public PersonCardFetchCardString() {
            super(PersonCardModel.class, false, "PersonCardFetchCard", "faa122162ef18f29dada7bd5d347ee01", "node", "10154453241486729", RegularImmutableSet.a);
        }

        public final String m13097a(String str) {
            switch (str.hashCode()) {
                case -1167837152:
                    return "2";
                case -1101600581:
                    return "1";
                case 3355:
                    return "0";
                case 123322600:
                    return "9";
                case 1223746134:
                    return "5";
                case 1241580535:
                    return "6";
                case 1372764642:
                    return "7";
                case 1831224761:
                    return "8";
                case 1839144577:
                    return "3";
                case 1939875509:
                    return "4";
                default:
                    return str;
            }
        }
    }
}
