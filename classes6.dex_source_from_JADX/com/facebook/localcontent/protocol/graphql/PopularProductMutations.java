package com.facebook.localcontent.protocol.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.localcontent.protocol.graphql.PopularProductMutationsModels.PageProductLikeMutationFieldsModel;
import com.facebook.localcontent.protocol.graphql.PopularProductMutationsModels.PageProductUnlikeMutationFieldsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: keywords_places(%s) */
public final class PopularProductMutations {

    /* compiled from: keywords_places(%s) */
    public class PageProductLikeMutationString extends TypedGraphQLMutationString<PageProductLikeMutationFieldsModel> {
        public PageProductLikeMutationString() {
            super(PageProductLikeMutationFieldsModel.class, false, "PageProductLikeMutation", "e22cbab8bb29240b16720b39a58c4fe3", "page_product_like", "0", "10154343225166729", RegularImmutableSet.a);
        }

        public final String m18695a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: keywords_places(%s) */
    public class PageProductUnlikeMutationString extends TypedGraphQLMutationString<PageProductUnlikeMutationFieldsModel> {
        public PageProductUnlikeMutationString() {
            super(PageProductUnlikeMutationFieldsModel.class, false, "PageProductUnlikeMutation", "042e1f4c55c779aa9c6b2ca4040986eb", "page_product_unlike", "0", "10154343225141729", RegularImmutableSet.a);
        }

        public final String m18696a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
