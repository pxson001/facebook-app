package com.facebook.checkin.socialsearch.graphql;

import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLModels.PlaceListDetailsModel;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLModels.StoryConversionDetailsModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: uninitialized */
public final class SocialSearchGraphQL {

    /* compiled from: uninitialized */
    public class FetchPlaceListForMapQueryString extends TypedGraphQlQueryString<PlaceListDetailsModel> {
        public FetchPlaceListForMapQueryString() {
            super(PlaceListDetailsModel.class, false, "FetchPlaceListForMapQuery", "20a98aca0165a0cee37a4f88c665fded", "node", "10154501284931729", RegularImmutableSet.a);
        }

        public final String m1090a(String str) {
            switch (str.hashCode()) {
                case -1850008284:
                    return "0";
                case -1101600581:
                    return "1";
                case 689802720:
                    return "2";
                default:
                    return str;
            }
        }
    }

    /* compiled from: uninitialized */
    public class FetchStoryConversionInfoString extends TypedGraphQlQueryString<StoryConversionDetailsModel> {
        public FetchStoryConversionInfoString() {
            super(StoryConversionDetailsModel.class, false, "FetchStoryConversionInfo", "0dde7003806201a4a71199512fbb96a1", "node", "10154614162051729", RegularImmutableSet.a);
        }

        public final String m1091a(String str) {
            switch (str.hashCode()) {
                case 1717754021:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
