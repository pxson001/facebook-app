package com.facebook.commerce.publishing.graphql;

import com.facebook.commerce.publishing.graphql.FetchAdminAddShopQueryModels.FetchAdminAddShopQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: plugin_config */
public final class FetchAdminAddShopQuery {

    /* compiled from: plugin_config */
    public class FetchAdminAddShopQueryString extends TypedGraphQlQueryString<FetchAdminAddShopQueryModel> {
        public FetchAdminAddShopQueryString() {
            super(FetchAdminAddShopQueryModel.class, false, "FetchAdminAddShopQuery", "66b618c338a179687a0512ab15c81d8e", "page", "10154405445021729", RegularImmutableSet.a);
        }

        public final String m10846a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
