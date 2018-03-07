package com.facebook.photos.albums.protocols;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideosUploadedByUserDetailQueryModel;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideosUploadedByUserSimpleQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: interstitial_always */
public final class VideosUploadedByUserGraphQL {

    /* compiled from: interstitial_always */
    public class VideosUploadedByUserDetailQueryString extends TypedGraphQlQueryString<VideosUploadedByUserDetailQueryModel> {
        public VideosUploadedByUserDetailQueryString() {
            super(VideosUploadedByUserDetailQueryModel.class, false, "VideosUploadedByUserDetailQuery", "205125d30d944a8ebf4c413c2ccaa189", "node", "10154561741391729", RegularImmutableSet.a);
        }

        public final String m19546a(String str) {
            switch (str.hashCode()) {
                case -1773565470:
                    return "5";
                case -1392885889:
                    return "1";
                case -631654088:
                    return "4";
                case -561505403:
                    return "9";
                case 92734940:
                    return "2";
                case 94851343:
                    return "3";
                case 421050507:
                    return "6";
                case 580042479:
                    return "8";
                case 651215103:
                    return "10";
                case 1939875509:
                    return "7";
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: interstitial_always */
    public class VideosUploadedByUserSimpleQueryString extends TypedGraphQlQueryString<VideosUploadedByUserSimpleQueryModel> {
        public VideosUploadedByUserSimpleQueryString() {
            super(VideosUploadedByUserSimpleQueryModel.class, false, "VideosUploadedByUserSimpleQuery", "1978e84b85e259735931ee05bb27a6cb", "node", "10154429039741729", RegularImmutableSet.a);
        }

        public final String m19547a(String str) {
            switch (str.hashCode()) {
                case -1773565470:
                    return "2";
                case 94851343:
                    return "1";
                case 421050507:
                    return "3";
                case 1939875509:
                    return "4";
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final VideosUploadedByUserDetailQueryString m19548a() {
        return new VideosUploadedByUserDetailQueryString();
    }
}
