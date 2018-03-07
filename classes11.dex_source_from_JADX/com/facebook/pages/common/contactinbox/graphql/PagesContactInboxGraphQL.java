package com.facebook.pages.common.contactinbox.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: state_layout_manager */
public final class PagesContactInboxGraphQL {

    /* compiled from: state_layout_manager */
    public class PagesContactInboxGraphQLString extends TypedGraphQlQueryString<PagesContactInboxGraphQLModel> {
        public PagesContactInboxGraphQLString() {
            super(PagesContactInboxGraphQLModel.class, false, "PagesContactInboxGraphQL", "85def9ab0307979c2dd1f2623b8e0c3d", "page", "10154405445411729", RegularImmutableSet.a);
        }

        public final String m2052a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                case -705314112:
                    return "2";
                case 16907033:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
