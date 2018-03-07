package com.facebook.feed.rows.sections.inlinesurvey.protocol;

import com.facebook.feed.rows.sections.inlinesurvey.protocol.InlineSurveySubmitMutationModels.InlineSurveySubmitMutationFieldsModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: UfiLoadMoreComments */
public final class InlineSurveySubmitMutation {

    /* compiled from: UfiLoadMoreComments */
    public class InlineSurveySubmitMutationString extends TypedGraphQLMutationString<InlineSurveySubmitMutationFieldsModel> {
        public InlineSurveySubmitMutationString() {
            super(InlineSurveySubmitMutationFieldsModel.class, false, "InlineSurveySubmitMutation", "384f06e83e74100c639069033da658da", "inline_survey_submit", "0", "10154662738746729", RegularImmutableSet.a);
        }

        public final String m24158a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
