package com.facebook.pages.common.models.bookmark_favorites;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.pages.common.models.bookmark_favorites.PageFavoriteBookmarksGraphQLModels.FBBookmarkAddToFavoritesMutationModel;
import com.facebook.pages.common.models.bookmark_favorites.PageFavoriteBookmarksGraphQLModels.FBBookmarkRemoveFromFavoritesMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: sha1_checksum_of_apk */
public final class PageFavoriteBookmarksGraphQL {

    /* compiled from: sha1_checksum_of_apk */
    public class FBBookmarkAddToFavoritesMutationString extends TypedGraphQLMutationString<FBBookmarkAddToFavoritesMutationModel> {
        public FBBookmarkAddToFavoritesMutationString() {
            super(FBBookmarkAddToFavoritesMutationModel.class, false, "FBBookmarkAddToFavoritesMutation", "389f7cf45ff742f84af553cc78ebb201", "bookmark_add_to_favorites", "0", "10154204804676729", RegularImmutableSet.a);
        }

        public final String m2470a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: sha1_checksum_of_apk */
    public class FBBookmarkRemoveFromFavoritesMutationString extends TypedGraphQLMutationString<FBBookmarkRemoveFromFavoritesMutationModel> {
        public FBBookmarkRemoveFromFavoritesMutationString() {
            super(FBBookmarkRemoveFromFavoritesMutationModel.class, false, "FBBookmarkRemoveFromFavoritesMutation", "14edb0509c313326de08c0ad782657cb", "bookmark_remove_from_favorites", "0", "10154204804626729", RegularImmutableSet.a);
        }

        public final String m2471a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
