package com.facebook.commerce.storefront.graphql;

import com.facebook.commerce.storefront.graphql.FetchStorefrontCollectionQueryModels.FetchStorefrontCollectionQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: coverPhotoSelectorSuperState */
public final class FetchStorefrontCollectionQuery {

    /* compiled from: coverPhotoSelectorSuperState */
    public class FetchStorefrontCollectionQueryString extends TypedGraphQlQueryString<FetchStorefrontCollectionQueryModel> {
        public FetchStorefrontCollectionQueryString() {
            super(FetchStorefrontCollectionQueryModel.class, false, "FetchStorefrontCollectionQuery", "1a3e0e83c999f14a398e3c7200577e05", "node", "10154358996666729", RegularImmutableSet.a);
        }

        public final String m16209a(String str) {
            switch (str.hashCode()) {
                case -1861560533:
                    return "6";
                case -821242276:
                    return "0";
                case -585512691:
                    return "4";
                case -230346670:
                    return "1";
                case 94851343:
                    return "2";
                case 109250890:
                    return "5";
                case 487593921:
                    return "3";
                default:
                    return str;
            }
        }
    }
}
