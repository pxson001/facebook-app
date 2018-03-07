package com.facebook.pages.common.surface.calltoaction.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.PageAdminCallToActionModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: create_card */
public final class PageAdminCallToActionGraphQL {

    /* compiled from: create_card */
    public class PageAdminCallToActionString extends TypedGraphQlQueryString<PageAdminCallToActionModel> {
        public PageAdminCallToActionString() {
            super(PageAdminCallToActionModel.class, false, "PageAdminCallToAction", "e482bef3b53627dcdb2b059d1b5ac3a3", "page", "10154695172151729", RegularImmutableSet.a);
        }

        public final String m19741a(String str) {
            switch (str.hashCode()) {
                case -1911057517:
                    return "2";
                case -803548981:
                    return "0";
                case 2016569496:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
