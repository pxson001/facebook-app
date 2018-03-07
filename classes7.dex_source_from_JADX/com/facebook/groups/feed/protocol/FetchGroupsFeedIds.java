package com.facebook.groups.feed.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedPendingPostIdsModel;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedPinnedPostIdsModel;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsStoriesMallIdsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: query_media_type */
public final class FetchGroupsFeedIds {

    /* compiled from: query_media_type */
    public class FetchGroupsFeedAuthoredAvailableForSalePostIdsString extends TypedGraphQlQueryString<FetchGroupsFeedAuthoredAvailableForSalePostIdsModel> {
        public FetchGroupsFeedAuthoredAvailableForSalePostIdsString() {
            super(FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.class, false, "FetchGroupsFeedAuthoredAvailableForSalePostIds", "4e67db4f9a20572c206ddc0ebd3e9f48", "group_address", "10154097398621729", RegularImmutableSet.a);
        }

        public final String m6530a(String str) {
            switch (str.hashCode()) {
                case -2085228958:
                    return "1";
                case 506361563:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: query_media_type */
    public class FetchGroupsFeedAuthoredExpiredForSalePostIdsString extends TypedGraphQlQueryString<FetchGroupsFeedAuthoredExpiredForSalePostIdsModel> {
        public FetchGroupsFeedAuthoredExpiredForSalePostIdsString() {
            super(FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.class, false, "FetchGroupsFeedAuthoredExpiredForSalePostIds", "948b08b56dbf5b702f666900c0ec369b", "group_address", "10154097398661729", RegularImmutableSet.a);
        }

        public final String m6531a(String str) {
            switch (str.hashCode()) {
                case -2085228958:
                    return "1";
                case 506361563:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: query_media_type */
    public class FetchGroupsFeedAuthoredSoldForSalePostIdsString extends TypedGraphQlQueryString<FetchGroupsFeedAuthoredSoldForSalePostIdsModel> {
        public FetchGroupsFeedAuthoredSoldForSalePostIdsString() {
            super(FetchGroupsFeedAuthoredSoldForSalePostIdsModel.class, false, "FetchGroupsFeedAuthoredSoldForSalePostIds", "6bb7d881e2b9b83f067aca0b9cfdc872", "group_address", "10154097398636729", RegularImmutableSet.a);
        }

        public final String m6532a(String str) {
            switch (str.hashCode()) {
                case -2085228958:
                    return "1";
                case 506361563:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: query_media_type */
    public class FetchGroupsFeedAvailableForSalePostIdsString extends TypedGraphQlQueryString<FetchGroupsFeedAvailableForSalePostIdsModel> {
        public FetchGroupsFeedAvailableForSalePostIdsString() {
            super(FetchGroupsFeedAvailableForSalePostIdsModel.class, false, "FetchGroupsFeedAvailableForSalePostIds", "e1dfef2b47c02fa08ad57cc126437d61", "group_address", "10154097398656729", RegularImmutableSet.a);
        }

        public final String m6533a(String str) {
            switch (str.hashCode()) {
                case -2085228958:
                    return "1";
                case 506361563:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: query_media_type */
    public class FetchGroupsFeedPendingPostIdsString extends TypedGraphQlQueryString<FetchGroupsFeedPendingPostIdsModel> {
        public FetchGroupsFeedPendingPostIdsString() {
            super(FetchGroupsFeedPendingPostIdsModel.class, false, "FetchGroupsFeedPendingPostIds", "de5d0d34f15eb81a4800f5c09331fbbf", "group_address", "10154097398631729", RegularImmutableSet.a);
        }

        public final String m6534a(String str) {
            switch (str.hashCode()) {
                case -2085228958:
                    return "1";
                case 506361563:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: query_media_type */
    public class FetchGroupsFeedPinnedPostIdsString extends TypedGraphQlQueryString<FetchGroupsFeedPinnedPostIdsModel> {
        public FetchGroupsFeedPinnedPostIdsString() {
            super(FetchGroupsFeedPinnedPostIdsModel.class, false, "FetchGroupsFeedPinnedPostIds", "8d9d3bba9d23eeac26dfe2ecd507df56", "group_address", "10154097398641729", RegularImmutableSet.a);
        }

        public final String m6535a(String str) {
            switch (str.hashCode()) {
                case -2085228958:
                    return "1";
                case 506361563:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: query_media_type */
    public class FetchGroupsStoriesMallIdsString extends TypedGraphQlQueryString<FetchGroupsStoriesMallIdsModel> {
        public FetchGroupsStoriesMallIdsString() {
            super(FetchGroupsStoriesMallIdsModel.class, false, "FetchGroupsStoriesMallIds", "c3dd0c69136e578332a0662c045a38d9", "group_address", "10154097398626729", RegularImmutableSet.a);
        }

        public final String m6536a(String str) {
            switch (str.hashCode()) {
                case -2085228958:
                    return "1";
                case 506361563:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
