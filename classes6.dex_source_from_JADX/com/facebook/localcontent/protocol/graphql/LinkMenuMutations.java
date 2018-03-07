package com.facebook.localcontent.protocol.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.localcontent.protocol.graphql.LinkMenuMutationsModels.PageLinkMenuCreateMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: language_dialect */
public final class LinkMenuMutations {

    /* compiled from: language_dialect */
    public class PageLinkMenuCreateMutationString extends TypedGraphQLMutationString<PageLinkMenuCreateMutationModel> {
        public PageLinkMenuCreateMutationString() {
            super(PageLinkMenuCreateMutationModel.class, false, "PageLinkMenuCreateMutation", "6af6c5cf84e8d5fae5bd411dd430a118", "page_link_menu_create", "0", "10154346623616729", RegularImmutableSet.a);
        }

        public final String m18573a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
