package com.facebook.groups.photos.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.photos.protocol.FetchGroupAlbumsModels.FetchGroupAlbumsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: TOXICLE_INVITED_BY_BAR */
public final class FetchGroupAlbums {

    /* compiled from: TOXICLE_INVITED_BY_BAR */
    public class FetchGroupAlbumsString extends TypedGraphQlQueryString<FetchGroupAlbumsModel> {
        public FetchGroupAlbumsString() {
            super(FetchGroupAlbumsModel.class, false, "FetchGroupAlbums", "afb6a54ae46aae2987a2d42a0b3eaef9", "group_address", "10154358537481729", RegularImmutableSet.a);
        }

        public final String m24269a(String str) {
            switch (str.hashCode()) {
                case -2088416789:
                    return "7";
                case -620205220:
                    return "4";
                case -283133711:
                    return "3";
                case -107613711:
                    return "2";
                case -77796550:
                    return "1";
                case 98629247:
                    return "0";
                case 223693954:
                    return "6";
                case 1296394143:
                    return "5";
                default:
                    return str;
            }
        }
    }
}
