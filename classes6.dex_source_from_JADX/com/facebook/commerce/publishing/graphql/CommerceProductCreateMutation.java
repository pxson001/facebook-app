package com.facebook.commerce.publishing.graphql;

import com.facebook.commerce.publishing.graphql.CommerceProductCreateMutationModels.CommerceProductCreateMutationFieldsModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: post_sets */
public final class CommerceProductCreateMutation {

    /* compiled from: post_sets */
    public class CommerceProductCreateMutationString extends TypedGraphQLMutationString<CommerceProductCreateMutationFieldsModel> {
        public CommerceProductCreateMutationString() {
            super(CommerceProductCreateMutationFieldsModel.class, false, "CommerceProductCreateMutation", "f9da9d0b569b8700251787da5e1a9433", "commerce_product_item_create", "0", "10154358536261729", RegularImmutableSet.a);
        }

        public final String m10707a(String str) {
            switch (str.hashCode()) {
                case -1861560533:
                    return "3";
                case 100358090:
                    return "0";
                case 109250890:
                    return "2";
                case 487593921:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
