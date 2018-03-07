package com.facebook.pages.common.surface.calltoaction.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.common.surface.calltoaction.graphql.PageCallToActionAutoFillGraphQLModels.PageCallToActionAutoFillQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: createBitmap */
public final class PageCallToActionAutoFillGraphQL {

    /* compiled from: createBitmap */
    public class PageCallToActionAutoFillQueryString extends TypedGraphQlQueryString<PageCallToActionAutoFillQueryModel> {
        public PageCallToActionAutoFillQueryString() {
            super(PageCallToActionAutoFillQueryModel.class, false, "PageCallToActionAutoFillQuery", "9b416fa315a1fbb7643397b9fb8e5a55", "pages_platform_autofill", "10154614095021729", RegularImmutableSet.a);
        }

        public final String m19956a(String str) {
            switch (str.hashCode()) {
                case -1803759168:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
