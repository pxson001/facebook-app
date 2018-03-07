package com.facebook.commerce.storefront.graphql;

import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.CommerceMerchantPageFragmentModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: cover_image_high_res_size */
public final class CommerceMerchantPageQuery {

    /* compiled from: cover_image_high_res_size */
    public class CommerceMerchantPageQueryString extends TypedGraphQlQueryString<CommerceMerchantPageFragmentModel> {
        public CommerceMerchantPageQueryString() {
            super(CommerceMerchantPageFragmentModel.class, false, "CommerceMerchantPageQuery", "e50b42763475099e86f400020d44e39e", "page", "10154405445051729", RegularImmutableSet.a);
        }

        public final String m16208a(String str) {
            switch (str.hashCode()) {
                case -588332180:
                    return "1";
                case 109250890:
                    return "2";
                case 1579809108:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
