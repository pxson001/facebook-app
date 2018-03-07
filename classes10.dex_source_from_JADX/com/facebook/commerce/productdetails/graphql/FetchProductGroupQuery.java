package com.facebook.commerce.productdetails.graphql;

import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.FetchProductGroupQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: delay_since_push_ms */
public final class FetchProductGroupQuery {

    /* compiled from: delay_since_push_ms */
    public class FetchProductGroupQueryString extends TypedGraphQlQueryString<FetchProductGroupQueryModel> {
        public FetchProductGroupQueryString() {
            super(FetchProductGroupQueryModel.class, false, "FetchProductGroupQuery", "af1c83545c5b18cec72868fb46054fef", "node", "10154436252641729", RegularImmutableSet.a);
        }

        public final String m15686a(String str) {
            switch (str.hashCode()) {
                case -2021484338:
                    return "1";
                case -588332180:
                    return "4";
                case -129574375:
                    return "3";
                case 109250890:
                    return "5";
                case 261607031:
                    return "0";
                case 316618177:
                    return "2";
                default:
                    return str;
            }
        }
    }
}
