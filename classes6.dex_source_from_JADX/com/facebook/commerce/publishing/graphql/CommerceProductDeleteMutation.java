package com.facebook.commerce.publishing.graphql;

import com.facebook.commerce.publishing.graphql.CommerceProductDeleteMutationModels.CommerceProductDeleteMutationModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: post_prompt */
public final class CommerceProductDeleteMutation {

    /* compiled from: post_prompt */
    public class CommerceProductDeleteMutationString extends TypedGraphQLMutationString<CommerceProductDeleteMutationModel> {
        public CommerceProductDeleteMutationString() {
            super(CommerceProductDeleteMutationModel.class, false, "CommerceProductDeleteMutation", "9a2fbfd6ec7d8875c1d328591096149e", "product_items_delete", "0", "10154204802626729", RegularImmutableSet.a);
        }

        public final String m10714a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
