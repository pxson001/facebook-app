package com.facebook.commerce.publishing.graphql;

import com.facebook.commerce.publishing.graphql.CommerceStoreUpdateMutationModels.CommerceStoreUpdateMutationModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: portrait_position */
public final class CommerceStoreUpdateMutation {

    /* compiled from: portrait_position */
    public class CommerceStoreUpdateMutationString extends TypedGraphQLMutationString<CommerceStoreUpdateMutationModel> {
        public CommerceStoreUpdateMutationString() {
            super(CommerceStoreUpdateMutationModel.class, false, "CommerceStoreUpdateMutation", "a46f81f74fddb21f7094d901dbbe29b7", "commerce_store_update", "0", "10154358536271729", RegularImmutableSet.a);
        }

        public final String m10839a(String str) {
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
