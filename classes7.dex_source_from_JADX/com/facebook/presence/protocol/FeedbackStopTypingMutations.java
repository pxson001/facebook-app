package com.facebook.presence.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.presence.protocol.FeedbackStopTypingMutationsModels.FeedbackStopTypingCoreMutationFieldsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: ignore_zero_deltas */
public final class FeedbackStopTypingMutations {

    /* compiled from: ignore_zero_deltas */
    public class FeedbackStopTypingCoreMutationString extends TypedGraphQLMutationString<FeedbackStopTypingCoreMutationFieldsModel> {
        public FeedbackStopTypingCoreMutationString() {
            super(FeedbackStopTypingCoreMutationFieldsModel.class, false, "FeedbackStopTypingCoreMutation", "86ff4c339734a67f364ea4d31b9a5043", "feedback_stop_typing", "0", "10154343226811729", RegularImmutableSet.a);
        }

        public final String m13119a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
