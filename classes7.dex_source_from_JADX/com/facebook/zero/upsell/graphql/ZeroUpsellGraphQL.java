package com.facebook.zero.upsell.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.zero.upsell.graphql.ZeroUpsellGraphQLModels.ZeroUpsellRecoModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: volume */
public final class ZeroUpsellGraphQL {

    /* compiled from: volume */
    public class ZeroUpsellRecoString extends TypedGraphQlQueryString<ZeroUpsellRecoModel> {
        public ZeroUpsellRecoString() {
            super(ZeroUpsellRecoModel.class, false, "ZeroUpsellReco", "8a7e441f6e03ed19d17f7a3a4340c0e5", "viewer", "10154661259566729", RegularImmutableSet.a);
        }

        public final String m269a(String str) {
            switch (str.hashCode()) {
                case -979207434:
                    return "1";
                case 3530753:
                    return "2";
                case 1901043637:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
