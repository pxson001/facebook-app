package com.facebook.commerce.publishing.graphql;

import com.facebook.commerce.publishing.graphql.FetchAdminCommerceProductItemModels.FetchAdminCommerceProductItemModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: platform_configuration */
public final class FetchAdminCommerceProductItem {

    /* compiled from: platform_configuration */
    public class FetchAdminCommerceProductItemString extends TypedGraphQlQueryString<FetchAdminCommerceProductItemModel> {
        public FetchAdminCommerceProductItemString() {
            super(FetchAdminCommerceProductItemModel.class, false, "FetchAdminCommerceProductItem", "8533614239171f9d51885903e5d2adaa", "node", "10154387897281729", RegularImmutableSet.a);
        }

        public final String m10899a(String str) {
            switch (str.hashCode()) {
                case -1861560533:
                    return "3";
                case 109250890:
                    return "2";
                case 487593921:
                    return "1";
                case 1753008747:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
