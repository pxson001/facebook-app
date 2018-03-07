package com.facebook.groupcommerce.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groupcommerce.protocol.FetchGroupCommerceZipcodeModels.StructuredLocationZipcodeQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: recommendation_unlike_success */
public final class FetchGroupCommerceZipcode {

    /* compiled from: recommendation_unlike_success */
    public class StructuredLocationZipcodeQueryString extends TypedGraphQlQueryString<StructuredLocationZipcodeQueryModel> {
        public StructuredLocationZipcodeQueryString() {
            super(StructuredLocationZipcodeQueryModel.class, false, "StructuredLocationZipcodeQuery", "e2ab9d66cd645c0a358c519a7fc7c434", "viewer", "10154406920436729", RegularImmutableSet.a);
        }

        public final String m5862a(String str) {
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
