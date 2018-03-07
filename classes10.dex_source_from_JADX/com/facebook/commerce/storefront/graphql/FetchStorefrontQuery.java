package com.facebook.commerce.storefront.graphql;

import com.facebook.commerce.storefront.graphql.FetchStorefrontQueryModels.FetchStorefrontQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: count_messaged */
public final class FetchStorefrontQuery {

    /* compiled from: count_messaged */
    public class FetchStorefrontQueryString extends TypedGraphQlQueryString<FetchStorefrontQueryModel> {
        public FetchStorefrontQueryString() {
            super(FetchStorefrontQueryModel.class, false, "FetchStorefrontQuery", "9beb6c4d87a6a089368b8bdd7d4f381f", "node", "10154686240981729", RegularImmutableSet.a);
        }

        public final String m16235a(String str) {
            switch (str.hashCode()) {
                case -1861560533:
                    return "5";
                case -1500023762:
                    return "6";
                case -803548981:
                    return "0";
                case -588332180:
                    return "1";
                case -585512691:
                    return "4";
                case 109250890:
                    return "2";
                case 487593921:
                    return "3";
                default:
                    return str;
            }
        }
    }
}
