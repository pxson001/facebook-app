package com.facebook.universalfeedback.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.universalfeedback.graphql.UniversalFeedbackSubmissionMutationModels.FBUniversalFeedbackSubmissionMutationFragmentModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: education_nux */
public final class UniversalFeedbackSubmissionMutation {

    /* compiled from: education_nux */
    public class FBUniversalFeedbackGiveFeedbackMutationString extends TypedGraphQLMutationString<FBUniversalFeedbackSubmissionMutationFragmentModel> {
        public FBUniversalFeedbackGiveFeedbackMutationString() {
            super(FBUniversalFeedbackSubmissionMutationFragmentModel.class, false, "FBUniversalFeedbackGiveFeedbackMutation", "c1406925ceeaaa1fc5e6e0de5f95bd34", "universal_feedback_give_feedback", "0", "10154343228661729", RegularImmutableSet.a);
        }

        public final String m19362a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
