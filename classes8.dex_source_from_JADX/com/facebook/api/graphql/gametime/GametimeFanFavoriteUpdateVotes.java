package com.facebook.api.graphql.gametime;

import com.facebook.api.graphql.gametime.GametimeFanFavoriteUpdateVotesModels.FBGametimeFanFavoriteUpdateVotesModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: lastFour */
public final class GametimeFanFavoriteUpdateVotes {

    /* compiled from: lastFour */
    public class FBGametimeFanFavoriteUpdateVotesString extends TypedGraphQLMutationString<FBGametimeFanFavoriteUpdateVotesModel> {
        public FBGametimeFanFavoriteUpdateVotesString() {
            super(FBGametimeFanFavoriteUpdateVotesModel.class, false, "FBGametimeFanFavoriteUpdateVotes", "e2c11b17824270dbfa4f6a989b19dc62", "media_question_add_vote", "0", "10154658520241729", RegularImmutableSet.a);
        }

        public final String m12220a(String str) {
            switch (str.hashCode()) {
                case 3355:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
