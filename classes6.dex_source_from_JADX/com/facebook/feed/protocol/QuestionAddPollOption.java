package com.facebook.feed.protocol;

import com.facebook.feed.protocol.QuestionAddPollOptionModels.QuestionAddResponseMutationModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: meta_data */
public final class QuestionAddPollOption {

    /* compiled from: meta_data */
    public class QuestionAddResponseMutationString extends TypedGraphQLMutationString<QuestionAddResponseMutationModel> {
        public QuestionAddResponseMutationString() {
            super(QuestionAddResponseMutationModel.class, false, "QuestionAddResponseMutation", "ce981aa2501a1056603abb2e9dd6116c", "question_add_option", "0", "10154429038496729", RegularImmutableSet.a);
        }

        public final String m16402a(String str) {
            switch (str.hashCode()) {
                case -907654098:
                    return "1";
                case -121039237:
                    return "2";
                case 100358090:
                    return "0";
                case 1091074225:
                    return "3";
                default:
                    return str;
            }
        }
    }
}
