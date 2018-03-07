package com.facebook.pages.data.graphql.cards;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.data.graphql.cards.VideoCardGraphQLModels.VideoCardQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: confirmation_logout_click */
public final class VideoCardGraphQL {

    /* compiled from: confirmation_logout_click */
    public class VideoCardQueryString extends TypedGraphQlQueryString<VideoCardQueryModel> {
        public VideoCardQueryString() {
            super(VideoCardQueryModel.class, false, "VideoCardQuery", "a675785bc622c0d83714f4012a1a6af2", "page", "10154561741346729", RegularImmutableSet.a);
        }

        public final String m20831a(String str) {
            switch (str.hashCode()) {
                case -1773565470:
                    return "3";
                case -803548981:
                    return "0";
                case -631654088:
                    return "2";
                case -561505403:
                    return "7";
                case 421050507:
                    return "4";
                case 580042479:
                    return "6";
                case 651215103:
                    return "8";
                case 909456372:
                    return "1";
                case 1939875509:
                    return "5";
                default:
                    return str;
            }
        }
    }
}
