package com.facebook.pages.common.surface.tabs.tabbar.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.pages.common.surface.tabs.tabbar.graphql.PageServicesSectionMutationModels.PageServicesSectionMutationFragmentModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: research_poll_interaction */
public final class PageServicesSectionMutation {

    /* compiled from: research_poll_interaction */
    public class PageServicesSectionMutationString extends TypedGraphQLMutationString<PageServicesSectionMutationFragmentModel> {
        public PageServicesSectionMutationString() {
            super(PageServicesSectionMutationFragmentModel.class, false, "PageServicesSectionMutation", "bd6c7f33f322be6288d4bc4c599acf5a", "page_services_section", "0", "10154487870931729", RegularImmutableSet.a);
        }

        public final String m3472a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
