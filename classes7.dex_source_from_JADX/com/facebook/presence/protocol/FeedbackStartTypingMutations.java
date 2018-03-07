package com.facebook.presence.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.presence.protocol.FeedbackStartTypingMutationsModels.FeedbackStartTypingCoreMutationFieldsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: image uri is empty or null */
public final class FeedbackStartTypingMutations {

    /* compiled from: image uri is empty or null */
    public class FeedbackStartTypingCoreMutationString extends TypedGraphQLMutationString<FeedbackStartTypingCoreMutationFieldsModel> {
        public FeedbackStartTypingCoreMutationString() {
            super(FeedbackStartTypingCoreMutationFieldsModel.class, false, "FeedbackStartTypingCoreMutation", "21248e740747f7ded30a16b74c5dc409", "feedback_start_typing", "0", "10154343226771729", RegularImmutableSet.a);
        }

        public final String m13101a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
