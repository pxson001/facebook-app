package com.facebook.stickers.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.stickers.graphql.FetchStickersGraphQLModels.FetchAvailableTaggedStickersWithPreviewsQueryModel;
import com.facebook.stickers.graphql.FetchStickersGraphQLModels.FetchDownloadedStickerPackIdsQueryModel;
import com.facebook.stickers.graphql.FetchStickersGraphQLModels.FetchDownloadedStickerPacksQueryModel;
import com.facebook.stickers.graphql.FetchStickersGraphQLModels.FetchOwnedStickerPackIdsQueryModel;
import com.facebook.stickers.graphql.FetchStickersGraphQLModels.FetchOwnedStickerPacksQueryModel;
import com.facebook.stickers.graphql.FetchStickersGraphQLModels.FetchStickerTagsQueryModel;
import com.facebook.stickers.graphql.FetchStickersGraphQLModels.FetchStickersWithPreviewsQueryModel;
import com.facebook.stickers.graphql.FetchStickersGraphQLModels.FetchStoreStickerPackIdsQueryModel;
import com.facebook.stickers.graphql.FetchStickersGraphQLModels.FetchStoreStickerPacksQueryModel;
import com.facebook.stickers.graphql.FetchStickersGraphQLModels.FetchTaggedStickersWithPreviewsQueryModel;
import com.facebook.stickers.graphql.FetchStickersGraphQLModels.FetchTrayTaggedStickersWithPreviewsQueryModel;
import com.facebook.stickers.graphql.FetchStickersGraphQLModels.SearchTaggedStickersQueryModel;
import com.facebook.stickers.graphql.FetchStickersGraphQLModels.StickerPackFieldsModel;
import com.google.common.collect.RegularImmutableSet;
import java.util.Map;

/* compiled from: eligible_hubs */
public final class FetchStickersGraphQL {

    /* compiled from: eligible_hubs */
    public class FetchAvailableTaggedStickersWithPreviewsQueryString extends TypedGraphQlQueryString<Map<String, FetchAvailableTaggedStickersWithPreviewsQueryModel>> {
        public FetchAvailableTaggedStickersWithPreviewsQueryString() {
            super(FetchAvailableTaggedStickersWithPreviewsQueryModel.class, true, "FetchAvailableTaggedStickersWithPreviewsQuery", "a9ebfbce6a4334d31b7972e4edc06a47", "nodes", "10154480925101729", RegularImmutableSet.a);
        }

        public final String m23961a(String str) {
            switch (str.hashCode()) {
                case -1362701800:
                    return "3";
                case -1187184943:
                    return "4";
                case 502623545:
                    return "1";
                case 1456163729:
                    return "0";
                case 1939875509:
                    return "2";
                case 1983661319:
                    return "5";
                default:
                    return str;
            }
        }
    }

    /* compiled from: eligible_hubs */
    public class FetchDownloadedStickerPackIdsQueryString extends TypedGraphQlQueryString<FetchDownloadedStickerPackIdsQueryModel> {
        public FetchDownloadedStickerPackIdsQueryString() {
            super(FetchDownloadedStickerPackIdsQueryModel.class, false, "FetchDownloadedStickerPackIdsQuery", "8b71d7d6fffdb19eb5b2d7ab3e9d2c1d", "viewer", "10154343228316729", RegularImmutableSet.a);
        }

        public final String m23962a(String str) {
            switch (str.hashCode()) {
                case 502623545:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: eligible_hubs */
    public class FetchDownloadedStickerPacksQueryString extends TypedGraphQlQueryString<FetchDownloadedStickerPacksQueryModel> {
        public FetchDownloadedStickerPacksQueryString() {
            super(FetchDownloadedStickerPacksQueryModel.class, false, "FetchDownloadedStickerPacksQuery", "8dae2c8002ff9b52d11d6a06ef5c5873", "viewer", "10154441560921729", RegularImmutableSet.a);
        }

        public final String m23963a(String str) {
            switch (str.hashCode()) {
                case 92734940:
                    return "1";
                case 97440432:
                    return "2";
                case 502623545:
                    return "0";
                case 1939875509:
                    return "4";
                case 1983661319:
                    return "3";
                default:
                    return str;
            }
        }
    }

    /* compiled from: eligible_hubs */
    public class FetchOwnedStickerPackIdsQueryString extends TypedGraphQlQueryString<FetchOwnedStickerPackIdsQueryModel> {
        public FetchOwnedStickerPackIdsQueryString() {
            super(FetchOwnedStickerPackIdsQueryModel.class, false, "FetchOwnedStickerPackIdsQuery", "59a7ac30e3db994afe86e6880e78ef7b", "viewer", "10154343228356729", RegularImmutableSet.a);
        }

        public final String m23964a(String str) {
            switch (str.hashCode()) {
                case -573446013:
                    return "1";
                case 502623545:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: eligible_hubs */
    public class FetchOwnedStickerPacksQueryString extends TypedGraphQlQueryString<FetchOwnedStickerPacksQueryModel> {
        public FetchOwnedStickerPacksQueryString() {
            super(FetchOwnedStickerPacksQueryModel.class, false, "FetchOwnedStickerPacksQuery", "1eccb5ec7db6f9b5e54f559407d8076d", "viewer", "10154441560936729", RegularImmutableSet.a);
        }

        public final String m23965a(String str) {
            switch (str.hashCode()) {
                case -573446013:
                    return "0";
                case 92734940:
                    return "2";
                case 97440432:
                    return "3";
                case 502623545:
                    return "1";
                case 1939875509:
                    return "5";
                case 1983661319:
                    return "4";
                default:
                    return str;
            }
        }
    }

    /* compiled from: eligible_hubs */
    public class FetchStickerPacksQueryString extends TypedGraphQlQueryString<Map<String, StickerPackFieldsModel>> {
        public FetchStickerPacksQueryString() {
            super(StickerPackFieldsModel.class, true, "FetchStickerPacksQuery", "5901da0f7c9be5ce0ce843bc5309d438", "nodes", "10154441560916729", RegularImmutableSet.a);
        }

        public final String m23966a(String str) {
            switch (str.hashCode()) {
                case 750810002:
                    return "0";
                case 1939875509:
                    return "2";
                case 1983661319:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: eligible_hubs */
    public class FetchStickerTagsQueryString extends TypedGraphQlQueryString<FetchStickerTagsQueryModel> {
        public FetchStickerTagsQueryString() {
            super(FetchStickerTagsQueryModel.class, false, "FetchStickerTagsQuery", "306fd59c2b3c001297c5b726c3cd810e", "viewer", "10154358539381729", RegularImmutableSet.a);
        }

        public final String m23967a(String str) {
            switch (str.hashCode()) {
                case -763807553:
                    return "0";
                case -195231062:
                    return "3";
                case 5553751:
                    return "2";
                case 759954292:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: eligible_hubs */
    public class FetchStickersWithPreviewsQueryString extends TypedGraphQlQueryString<Map<String, FetchStickersWithPreviewsQueryModel>> {
        public FetchStickersWithPreviewsQueryString() {
            super(FetchStickersWithPreviewsQueryModel.class, true, "FetchStickersWithPreviewsQuery", "786fe5df44626515857ecad225db1fef", "nodes", "10154686242696729", RegularImmutableSet.a);
        }

        public final String m23968a(String str) {
            switch (str.hashCode()) {
                case -1362701800:
                    return "2";
                case -1187184943:
                    return "3";
                case 1597040822:
                    return "0";
                case 1939875509:
                    return "1";
                case 1983661319:
                    return "4";
                default:
                    return str;
            }
        }
    }

    /* compiled from: eligible_hubs */
    public class FetchStoreStickerPackIdsQueryString extends TypedGraphQlQueryString<FetchStoreStickerPackIdsQueryModel> {
        public FetchStoreStickerPackIdsQueryString() {
            super(FetchStoreStickerPackIdsQueryModel.class, false, "FetchStoreStickerPackIdsQuery", "0d606cd23cc6936c8b8530b946256867", "viewer", "10154343228341729", RegularImmutableSet.a);
        }

        public final String m23969a(String str) {
            switch (str.hashCode()) {
                case -573446013:
                    return "1";
                case 502623545:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: eligible_hubs */
    public class FetchStoreStickerPacksQueryString extends TypedGraphQlQueryString<FetchStoreStickerPacksQueryModel> {
        public FetchStoreStickerPacksQueryString() {
            super(FetchStoreStickerPacksQueryModel.class, false, "FetchStoreStickerPacksQuery", "800ec3ebb98f13e8b61b16bcaf633314", "viewer", "10154441560931729", RegularImmutableSet.a);
        }

        public final String m23970a(String str) {
            switch (str.hashCode()) {
                case -1730642919:
                    return "1";
                case -1025689693:
                    return "2";
                case -573446013:
                    return "3";
                case 92734940:
                    return "5";
                case 97440432:
                    return "6";
                case 502623545:
                    return "4";
                case 1785469597:
                    return "0";
                case 1939875509:
                    return "8";
                case 1983661319:
                    return "7";
                default:
                    return str;
            }
        }
    }

    /* compiled from: eligible_hubs */
    public class FetchTaggedStickersWithPreviewsQueryString extends TypedGraphQlQueryString<Map<String, FetchTaggedStickersWithPreviewsQueryModel>> {
        public FetchTaggedStickersWithPreviewsQueryString() {
            super(FetchTaggedStickersWithPreviewsQueryModel.class, true, "FetchTaggedStickersWithPreviewsQuery", "509ad6e21a66f7711f38db2052cb3a0c", "nodes", "10154479018861729", RegularImmutableSet.a);
        }

        public final String m23971a(String str) {
            switch (str.hashCode()) {
                case -1362701800:
                    return "3";
                case -1187184943:
                    return "4";
                case 502623545:
                    return "1";
                case 1456163729:
                    return "0";
                case 1939875509:
                    return "2";
                case 1983661319:
                    return "5";
                default:
                    return str;
            }
        }
    }

    /* compiled from: eligible_hubs */
    public class FetchTrayTaggedStickersWithPreviewsQueryString extends TypedGraphQlQueryString<Map<String, FetchTrayTaggedStickersWithPreviewsQueryModel>> {
        public FetchTrayTaggedStickersWithPreviewsQueryString() {
            super(FetchTrayTaggedStickersWithPreviewsQueryModel.class, true, "FetchTrayTaggedStickersWithPreviewsQuery", "9f191fd4681c15d176bc7976b69cf6cb", "nodes", "10154480925116729", RegularImmutableSet.a);
        }

        public final String m23972a(String str) {
            switch (str.hashCode()) {
                case -1362701800:
                    return "3";
                case -1187184943:
                    return "4";
                case 502623545:
                    return "1";
                case 1456163729:
                    return "0";
                case 1939875509:
                    return "2";
                case 1983661319:
                    return "5";
                default:
                    return str;
            }
        }
    }

    /* compiled from: eligible_hubs */
    public class SearchTaggedStickersQueryString extends TypedGraphQlQueryString<SearchTaggedStickersQueryModel> {
        public SearchTaggedStickersQueryString() {
            super(SearchTaggedStickersQueryModel.class, false, "SearchTaggedStickersQuery", "2a54c09a8ceb06434462c099c0eb12c5", "sticker_search", "10154457337541729", RegularImmutableSet.a);
        }

        public final String m23973a(String str) {
            switch (str.hashCode()) {
                case -1187184943:
                    return "4";
                case 102976443:
                    return "3";
                case 461177713:
                    return "0";
                case 502623545:
                    return "1";
                case 560053423:
                    return "2";
                case 1939875509:
                    return "6";
                case 1983661319:
                    return "5";
                default:
                    return str;
            }
        }
    }

    public static final FetchStoreStickerPackIdsQueryString m23974j() {
        return new FetchStoreStickerPackIdsQueryString();
    }

    public static final FetchStoreStickerPacksQueryString m23975m() {
        return new FetchStoreStickerPacksQueryString();
    }
}
