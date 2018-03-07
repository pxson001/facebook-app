package com.facebook.pages.data.graphql.cards;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.data.graphql.cards.PageContextItemInfoCardGraphQLModels.PageInfoCardContextItemQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: context_item_image_size */
public final class PageContextItemInfoCardGraphQL {

    /* compiled from: context_item_image_size */
    public class PageInfoCardContextItemQueryString extends TypedGraphQlQueryString<PageInfoCardContextItemQueryModel> {
        public PageInfoCardContextItemQueryString() {
            super(PageInfoCardContextItemQueryModel.class, false, "PageInfoCardContextItemQuery", "1416bc061949cb0aa57bede7df1ad28d", "page", "10154407313331729", RegularImmutableSet.a);
        }

        public final String m20456a(String str) {
            switch (str.hashCode()) {
                case -1700233621:
                    return "4";
                case -1484664976:
                    return "2";
                case -977529797:
                    return "3";
                case -803548981:
                    return "0";
                case -194679286:
                    return "1";
                case 109250890:
                    return "5";
                default:
                    return str;
            }
        }
    }
}
