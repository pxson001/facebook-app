package com.facebook.commerce.publishing.graphql;

import com.facebook.commerce.publishing.graphql.FetchCommerceStoreQueryModels.FetchCommerceStoreQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: platform.installdata */
public final class FetchCommerceStoreQuery {

    /* compiled from: platform.installdata */
    public class FetchCommerceStoreQueryString extends TypedGraphQlQueryString<FetchCommerceStoreQueryModel> {
        public FetchCommerceStoreQueryString() {
            super(FetchCommerceStoreQueryModel.class, false, "FetchCommerceStoreQuery", "d6021821dd6956e835b3e8217068bdad", "node", "10154358536286729", RegularImmutableSet.a);
        }

        public final String m10918a(String str) {
            switch (str.hashCode()) {
                case -1861560533:
                    return "3";
                case -803548981:
                    return "0";
                case -705314112:
                    return "5";
                case 16907033:
                    return "4";
                case 109250890:
                    return "2";
                case 487593921:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
