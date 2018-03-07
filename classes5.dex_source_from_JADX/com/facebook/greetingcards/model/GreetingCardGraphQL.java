package com.facebook.greetingcards.model;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.greetingcards.model.GreetingCardGraphQLModels.FetchPrefilledGreetingCardQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: TRIGHT; */
public final class GreetingCardGraphQL {

    /* compiled from: TRIGHT; */
    public class FetchPrefilledGreetingCardQueryString extends TypedGraphQlQueryString<FetchPrefilledGreetingCardQueryModel> {
        public FetchPrefilledGreetingCardQueryString() {
            super(FetchPrefilledGreetingCardQueryModel.class, false, "FetchPrefilledGreetingCardQuery", "4e29b70ad9fd56d24040e3f4b264389c", "viewer", "10154358537331729", RegularImmutableSet.a);
        }

        public final String m22716a(String str) {
            switch (str.hashCode()) {
                case -1787807363:
                    return "0";
                case 444455283:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
