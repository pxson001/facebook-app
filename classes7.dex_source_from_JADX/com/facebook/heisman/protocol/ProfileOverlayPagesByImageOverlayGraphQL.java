package com.facebook.heisman.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.heisman.protocol.ProfileOverlayPagesByImageOverlayGraphQLModels.ProfileOverlayPagesByImageOverlayQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: playbackcomplete */
public final class ProfileOverlayPagesByImageOverlayGraphQL {

    /* compiled from: playbackcomplete */
    public class ProfileOverlayPagesByImageOverlayQueryString extends TypedGraphQlQueryString<ProfileOverlayPagesByImageOverlayQueryModel> {
        public ProfileOverlayPagesByImageOverlayQueryString() {
            super(ProfileOverlayPagesByImageOverlayQueryModel.class, false, "ProfileOverlayPagesByImageOverlayQuery", "673f7a2af4ed0be0211604e94a270e8a", "node", "10154578652451729", RegularImmutableSet.a);
        }

        public final String m7997a(String str) {
            switch (str.hashCode()) {
                case -1663499699:
                    return "2";
                case 680583374:
                    return "0";
                case 1369463909:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
