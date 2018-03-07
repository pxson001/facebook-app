package com.facebook.commerce.publishing.graphql;

import com.facebook.commerce.publishing.graphql.FetchAdminCommerceProductCreationFieldsModels.PageShopProductCreationFieldsModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: player_id */
public final class FetchAdminCommerceProductCreationFields {

    /* compiled from: player_id */
    public class FetchAdminCommerceProductCreationFieldsString extends TypedGraphQlQueryString<PageShopProductCreationFieldsModel> {
        public FetchAdminCommerceProductCreationFieldsString() {
            super(PageShopProductCreationFieldsModel.class, false, "FetchAdminCommerceProductCreationFields", "b7511fb42cbc3f7423d91aff6b01357b", "node", "10154387897286729", RegularImmutableSet.a);
        }

        public final String m10872a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
