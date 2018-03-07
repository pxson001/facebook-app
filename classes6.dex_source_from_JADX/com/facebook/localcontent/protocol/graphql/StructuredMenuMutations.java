package com.facebook.localcontent.protocol.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.localcontent.protocol.graphql.StructuredMenuMutationsModels.MenuItemLikeMutationModel;
import com.facebook.localcontent.protocol.graphql.StructuredMenuMutationsModels.MenuItemUnlikeMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: keywords_events(%s) */
public final class StructuredMenuMutations {

    /* compiled from: keywords_events(%s) */
    public class MenuItemLikeMutationString extends TypedGraphQLMutationString<MenuItemLikeMutationModel> {
        public MenuItemLikeMutationString() {
            super(MenuItemLikeMutationModel.class, false, "MenuItemLikeMutation", "d2bdb7fb65e4bb29fd445bb353e79dfa", "page_product_like", "0", "10154346623631729", RegularImmutableSet.a);
        }

        public final String m18764a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: keywords_events(%s) */
    public class MenuItemUnlikeMutationString extends TypedGraphQLMutationString<MenuItemUnlikeMutationModel> {
        public MenuItemUnlikeMutationString() {
            super(MenuItemUnlikeMutationModel.class, false, "MenuItemUnlikeMutation", "4129620cb77afc7fa1d6324183436e72", "page_product_unlike", "0", "10154346623606729", RegularImmutableSet.a);
        }

        public final String m18765a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
