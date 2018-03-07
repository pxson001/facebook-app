package com.facebook.commerce.publishing.graphql;

import com.facebook.commerce.publishing.graphql.CommerceProductEditMutationModels.CommerceProductEditMutationFieldsModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: post_options_picker_started */
public final class CommerceProductEditMutation {

    /* compiled from: post_options_picker_started */
    public class CommerceProductEditMutationString extends TypedGraphQLMutationString<CommerceProductEditMutationFieldsModel> {
        public CommerceProductEditMutationString() {
            super(CommerceProductEditMutationFieldsModel.class, false, "CommerceProductEditMutation", "80d024c486f7bc4c88eab102d49519c9", "commerce_product_item_update", "0", "10154358536236729", RegularImmutableSet.a);
        }

        public final String m10721a(String str) {
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
