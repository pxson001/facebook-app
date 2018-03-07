package com.facebook.pages.data.graphql.cards;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.data.graphql.cards.PageIdentityNuxCardQueryModels.PageIdentityNuxCardQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: contentType */
public final class PageIdentityNuxCardQuery {

    /* compiled from: contentType */
    public class PageIdentityNuxCardQueryString extends TypedGraphQlQueryString<PageIdentityNuxCardQueryModel> {
        public PageIdentityNuxCardQueryString() {
            super(PageIdentityNuxCardQueryModel.class, false, "PageIdentityNuxCardQuery", "613fea5202c68da5f222b8675f7de31b", "page", "10154405445491729", RegularImmutableSet.a);
        }

        public final String m20573a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
