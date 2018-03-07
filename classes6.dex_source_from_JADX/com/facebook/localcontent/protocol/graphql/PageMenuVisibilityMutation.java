package com.facebook.localcontent.protocol.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.localcontent.protocol.graphql.PageMenuVisibilityMutationModels.PageMenuVisibilityMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: keywords_topic_trending\(([^\)]*)\) */
public final class PageMenuVisibilityMutation {

    /* compiled from: keywords_topic_trending\(([^\)]*)\) */
    public class PageMenuVisibilityMutationString extends TypedGraphQLMutationString<PageMenuVisibilityMutationModel> {
        public PageMenuVisibilityMutationString() {
            super(PageMenuVisibilityMutationModel.class, false, "PageMenuVisibilityMutation", "b81558a818db7629b04185f88df223ea", "page_menu_visibility_edit", "0", "10154343225146729", RegularImmutableSet.a);
        }

        public final String m18639a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
