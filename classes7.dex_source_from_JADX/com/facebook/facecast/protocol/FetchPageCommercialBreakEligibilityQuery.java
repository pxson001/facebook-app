package com.facebook.facecast.protocol;

import com.facebook.facecast.protocol.FetchPageCommercialBreakEligibilityQueryModels.FetchPageCommercialBreakEligibilityQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: back_button */
public final class FetchPageCommercialBreakEligibilityQuery {

    /* compiled from: back_button */
    public class FetchPageCommercialBreakEligibilityQueryString extends TypedGraphQlQueryString<FetchPageCommercialBreakEligibilityQueryModel> {
        public FetchPageCommercialBreakEligibilityQueryString() {
            super(FetchPageCommercialBreakEligibilityQueryModel.class, false, "FetchPageCommercialBreakEligibilityQuery", "40ab8c2a933034c2f73e662392c7cd87", "page", "10154681963446729", RegularImmutableSet.a);
        }

        public final String m22391a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
