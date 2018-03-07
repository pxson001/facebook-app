package com.facebook.commerce.publishing.graphql;

import com.facebook.commerce.publishing.graphql.CommerceStoreDeleteMutationModels.CommerceStoreDeleteMutationModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: postRating */
public final class CommerceStoreDeleteMutation {

    /* compiled from: postRating */
    public class CommerceStoreDeleteMutationString extends TypedGraphQLMutationString<CommerceStoreDeleteMutationModel> {
        public CommerceStoreDeleteMutationString() {
            super(CommerceStoreDeleteMutationModel.class, false, "CommerceStoreDeleteMutation", "51979ecc4ac586ecfcaaa331223e14ba", "commerce_merchant_deactivate", "0", "10154204802646729", RegularImmutableSet.a);
        }

        public final String m10832a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
