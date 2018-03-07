package com.facebook.crowdsourcing.protocol.graphql;

import com.facebook.crowdsourcing.protocol.graphql.PlaceQuestionMutationsModels.PlaceQuestionAnswerSubmitModel;
import com.facebook.crowdsourcing.protocol.graphql.PlaceQuestionMutationsModels.PlaceQuestionSkipModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: taggableActivityId */
public final class PlaceQuestionMutations {

    /* compiled from: taggableActivityId */
    public class PlaceQuestionAnswerSubmitString extends TypedGraphQLMutationString<PlaceQuestionAnswerSubmitModel> {
        public PlaceQuestionAnswerSubmitString() {
            super(PlaceQuestionAnswerSubmitModel.class, false, "PlaceQuestionAnswerSubmit", "0e9a4eca7774c596da75945c9cfa0641", "place_question_submit_answer", "0", "10154204803956729", RegularImmutableSet.a);
        }

        public final String m2485a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: taggableActivityId */
    public class PlaceQuestionSkipString extends TypedGraphQLMutationString<PlaceQuestionSkipModel> {
        public PlaceQuestionSkipString() {
            super(PlaceQuestionSkipModel.class, false, "PlaceQuestionSkip", "3694fd7f4a1c4b06588095e88ea05605", "place_question_skip", "0", "10154204803926729", RegularImmutableSet.a);
        }

        public final String m2486a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
