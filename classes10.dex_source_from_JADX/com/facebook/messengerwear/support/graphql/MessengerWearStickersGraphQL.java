package com.facebook.messengerwear.support.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.messengerwear.support.graphql.MessengerWearStickersGraphQLModels.FetchRecentlyUsedStickersQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: phone_for_alerts */
public final class MessengerWearStickersGraphQL {

    /* compiled from: phone_for_alerts */
    public class FetchRecentlyUsedStickersQueryString extends TypedGraphQlQueryString<FetchRecentlyUsedStickersQueryModel> {
        public FetchRecentlyUsedStickersQueryString() {
            super(FetchRecentlyUsedStickersQueryModel.class, false, "FetchRecentlyUsedStickersQuery", "a1342d59122c0491ba28113fa76d41b2", "viewer", "10154390438336729", RegularImmutableSet.a);
        }

        public final String m4586a(String str) {
            switch (str.hashCode()) {
                case 1447697293:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
