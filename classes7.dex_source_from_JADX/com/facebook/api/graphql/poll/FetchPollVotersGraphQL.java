package com.facebook.api.graphql.poll;

import com.facebook.api.graphql.poll.FetchPollVotersGraphQLModels.FetchPollVotersModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: video_editing_exit */
public final class FetchPollVotersGraphQL {

    /* compiled from: video_editing_exit */
    public class FetchPollVotersString extends TypedGraphQlQueryString<FetchPollVotersModel> {
        public FetchPollVotersString() {
            super(FetchPollVotersModel.class, false, "FetchPollVoters", "634beffb42c916219dc65f0c3b69178b", "node", "10154429037821729", RegularImmutableSet.a);
        }

        public final String m635a(String str) {
            switch (str.hashCode()) {
                case -1615662096:
                    return "2";
                case -1101600581:
                    return "3";
                case 508432504:
                    return "1";
                case 689802720:
                    return "4";
                case 1619347621:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
