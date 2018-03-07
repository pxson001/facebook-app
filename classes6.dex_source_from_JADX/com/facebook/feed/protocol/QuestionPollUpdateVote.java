package com.facebook.feed.protocol;

import com.facebook.feed.protocol.QuestionPollUpdateVoteModels.QuestionAddVoteMutationModel;
import com.facebook.feed.protocol.QuestionPollUpdateVoteModels.QuestionRemoveVoteMutationModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: messenger_optin_interstitial_old */
public final class QuestionPollUpdateVote {

    /* compiled from: messenger_optin_interstitial_old */
    public class QuestionAddVoteMutationString extends TypedGraphQLMutationString<QuestionAddVoteMutationModel> {
        public QuestionAddVoteMutationString() {
            super(QuestionAddVoteMutationModel.class, false, "QuestionAddVoteMutation", "e4ec0640abc7cc6bac566766eec5870e", "question_add_vote", "0", "10154429038741729", RegularImmutableSet.a);
        }

        public final String m16406a(String str) {
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

    /* compiled from: messenger_optin_interstitial_old */
    public class QuestionRemoveVoteMutationString extends TypedGraphQLMutationString<QuestionRemoveVoteMutationModel> {
        public QuestionRemoveVoteMutationString() {
            super(QuestionRemoveVoteMutationModel.class, false, "QuestionRemoveVoteMutation", "9bbd226507398e1b82dabe49e684bbd3", "question_remove_vote", "0", "10154429038746729", RegularImmutableSet.a);
        }

        public final String m16407a(String str) {
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
