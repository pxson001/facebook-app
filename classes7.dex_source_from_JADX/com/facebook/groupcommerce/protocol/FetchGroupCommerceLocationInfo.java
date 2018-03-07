package com.facebook.groupcommerce.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groupcommerce.protocol.FetchGroupCommerceLocationInfoModels.StructuredLocationQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: registrationName */
public final class FetchGroupCommerceLocationInfo {

    /* compiled from: registrationName */
    public class StructuredLocationQueryString extends TypedGraphQlQueryString<StructuredLocationQueryModel> {
        public StructuredLocationQueryString() {
            super(StructuredLocationQueryModel.class, false, "StructuredLocationQuery", "787ab0fa0364c26a65afbadb47d3f9b3", "viewer", "10154358537326729", RegularImmutableSet.a);
        }

        public final String m5804a(String str) {
            switch (str.hashCode()) {
                case -1439978388:
                    return "0";
                case 137365935:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
