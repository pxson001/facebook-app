package com.facebook.commerce.publishing.graphql;

import com.facebook.commerce.publishing.graphql.CommerceStoreCreateMutationModels.CommerceStoreCreateMutationModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: post_channel_feedback_state */
public final class CommerceStoreCreateMutation {

    /* compiled from: post_channel_feedback_state */
    public class CommerceStoreCreateMutationString extends TypedGraphQLMutationString<CommerceStoreCreateMutationModel> {
        public CommerceStoreCreateMutationString() {
            super(CommerceStoreCreateMutationModel.class, false, "CommerceStoreCreateMutation", "93290141b987f10c4d4598ed3fabc490", "commerce_contact_merchant_store_create", "0", "10154358536256729", RegularImmutableSet.a);
        }

        public final String m10825a(String str) {
            switch (str.hashCode()) {
                case -1861560533:
                    return "3";
                case -705314112:
                    return "5";
                case 16907033:
                    return "4";
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
