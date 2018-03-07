package com.facebook.photos.albums.protocols;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.photos.albums.protocols.VideoListVideosGraphQLModels.VideosInVideoListDetailQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: interval */
public final class VideoListVideosGraphQL {

    /* compiled from: interval */
    public class VideosInVideoListDetailQueryString extends TypedGraphQlQueryString<VideosInVideoListDetailQueryModel> {
        public VideosInVideoListDetailQueryString() {
            super(VideosInVideoListDetailQueryModel.class, false, "VideosInVideoListDetailQuery", "fce7a5bb68b92e4f93615836d4dd1087", "node", "10154561741396729", RegularImmutableSet.a);
        }

        public final String m19523a(String str) {
            switch (str.hashCode()) {
                case -2086296424:
                    return "0";
                case -1773565470:
                    return "5";
                case -1606466720:
                    return "3";
                case -631654088:
                    return "4";
                case -561505403:
                    return "9";
                case 420666299:
                    return "1";
                case 421050507:
                    return "6";
                case 571910232:
                    return "2";
                case 580042479:
                    return "8";
                case 651215103:
                    return "10";
                case 1939875509:
                    return "7";
                default:
                    return str;
            }
        }
    }
}
