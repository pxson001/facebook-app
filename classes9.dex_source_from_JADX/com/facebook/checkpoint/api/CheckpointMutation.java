package com.facebook.checkpoint.api;

import com.facebook.checkpoint.api.CheckpointMutationModels.CheckpointCancelMutationFragmentModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: raw_amount_fb_discount */
public final class CheckpointMutation {

    /* compiled from: raw_amount_fb_discount */
    public class CheckpointCancelMutationString extends TypedGraphQLMutationString<CheckpointCancelMutationFragmentModel> {
        public CheckpointCancelMutationString() {
            super(CheckpointCancelMutationFragmentModel.class, false, "CheckpointCancelMutation", "aa6858001fd6f9ce42a8453ce88a9d6e", "checkpoint_cancel", "0", "10154204802641729", RegularImmutableSet.a);
        }

        public final String m6091a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
