package com.facebook.groups.groupsgrid.mutations;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.groups.groupsgrid.mutations.FavoriteGroupsMutationsModels.GroupsBookmarkAddToFavoritesMutationModel;
import com.facebook.groups.groupsgrid.mutations.FavoriteGroupsMutationsModels.GroupsBookmarkRemoveFromFavoritesMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: protile_type */
public final class FavoriteGroupsMutations {

    /* compiled from: protile_type */
    public class GroupsBookmarkAddToFavoritesMutationString extends TypedGraphQLMutationString<GroupsBookmarkAddToFavoritesMutationModel> {
        public GroupsBookmarkAddToFavoritesMutationString() {
            super(GroupsBookmarkAddToFavoritesMutationModel.class, false, "GroupsBookmarkAddToFavoritesMutation", "141f4fb1c114b2c26be47aa1986cdc01", "bookmark_add_to_favorites", "0", "10154346623366729", RegularImmutableSet.a);
        }

        public final String m7036a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: protile_type */
    public class GroupsBookmarkRemoveFromFavoritesMutationString extends TypedGraphQLMutationString<GroupsBookmarkRemoveFromFavoritesMutationModel> {
        public GroupsBookmarkRemoveFromFavoritesMutationString() {
            super(GroupsBookmarkRemoveFromFavoritesMutationModel.class, false, "GroupsBookmarkRemoveFromFavoritesMutation", "06bca1284b66ab97683fb79e0b13f8da", "bookmark_remove_from_favorites", "0", "10154346623351729", RegularImmutableSet.a);
        }

        public final String m7037a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
