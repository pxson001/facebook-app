package com.facebook.feedplugins.placetips.graphql;

import com.facebook.feedplugins.placetips.graphql.SuggestifierQuestionVoteMutationModels.SuggestifierQuestionVoteMutationModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: friend_requests_restrict_audience */
public final class SuggestifierQuestionVoteMutation {

    /* compiled from: friend_requests_restrict_audience */
    public class SuggestifierQuestionVoteMutationString extends TypedGraphQLMutationString<SuggestifierQuestionVoteMutationModel> {
        public SuggestifierQuestionVoteMutationString() {
            super(SuggestifierQuestionVoteMutationModel.class, false, "SuggestifierQuestionVoteMutation", "a001562e1702811e00a2f7a4ea1295e7", "suggestifier_question_vote", "0", "10154227900176729", RegularImmutableSet.a);
        }

        public final String m14664a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
