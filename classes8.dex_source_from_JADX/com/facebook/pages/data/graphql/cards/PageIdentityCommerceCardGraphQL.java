package com.facebook.pages.data.graphql.cards;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.data.graphql.cards.PageIdentityCommerceCardGraphQLModels.PageIdentityCommerceCardQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: context_item */
public final class PageIdentityCommerceCardGraphQL {

    /* compiled from: context_item */
    public class PageIdentityCommerceCardQueryString extends TypedGraphQlQueryString<PageIdentityCommerceCardQueryModel> {
        public PageIdentityCommerceCardQueryString() {
            super(PageIdentityCommerceCardQueryModel.class, false, "PageIdentityCommerceCardQuery", "cfc81bbb54bae3f760592afccf48494c", "page", "10154405445506729", RegularImmutableSet.a);
        }

        public final String m20493a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                case 316618177:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
