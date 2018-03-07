package com.facebook.heisman.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.heisman.protocol.ProfileOverlayCategoryGraphQLModels.ProfileOverlayCategoryFieldsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: playlist_id */
public final class ProfileOverlayPagesByCategoryGraphQL {

    /* compiled from: playlist_id */
    public class ProfileOverlayPagesCategoryQueryString extends TypedGraphQlQueryString<ProfileOverlayCategoryFieldsModel> {
        public ProfileOverlayPagesCategoryQueryString() {
            super(ProfileOverlayCategoryFieldsModel.class, false, "ProfileOverlayPagesCategoryQuery", "18d9ad0dfaecd2cfc0664d05b9c7a329", "node", "10154578652461729", RegularImmutableSet.a);
        }

        public final String m7996a(String str) {
            switch (str.hashCode()) {
                case -1663499699:
                    return "2";
                case 1369463909:
                    return "1";
                case 1537780732:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
