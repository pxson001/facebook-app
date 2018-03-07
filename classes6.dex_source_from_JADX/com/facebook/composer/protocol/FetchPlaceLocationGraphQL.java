package com.facebook.composer.protocol;

import com.facebook.composer.protocol.FetchPlaceLocationGraphQLModels.FetchPlaceLocationQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: place_attachment_setting */
public final class FetchPlaceLocationGraphQL {

    /* compiled from: place_attachment_setting */
    public class FetchPlaceLocationQueryString extends TypedGraphQlQueryString<FetchPlaceLocationQueryModel> {
        public FetchPlaceLocationQueryString() {
            super(FetchPlaceLocationQueryModel.class, false, "FetchPlaceLocationQuery", "b57530ef22c8f425465c6a859bb287ed", "node", "10154339187491729", RegularImmutableSet.a);
        }

        public final String m11437a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final FetchPlaceLocationQueryString m11438a() {
        return new FetchPlaceLocationQueryString();
    }
}
