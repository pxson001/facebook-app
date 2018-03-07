package com.facebook.photos.data.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.photos.data.protocol.PhotosLocationTagSuggestionMutationsModels.AcceptPlaceSuggestionMutationModel;
import com.facebook.photos.data.protocol.PhotosLocationTagSuggestionMutationsModels.RejectPlaceSuggestionMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: suggested_cover_photos */
public final class PhotosLocationTagSuggestionMutations {

    /* compiled from: suggested_cover_photos */
    public class AcceptPlaceSuggestionMutationString extends TypedGraphQLMutationString<AcceptPlaceSuggestionMutationModel> {
        public AcceptPlaceSuggestionMutationString() {
            super(AcceptPlaceSuggestionMutationModel.class, false, "AcceptPlaceSuggestionMutation", "a54c8be3e6cc0a5b1b38525d6ada6f15", "user_accept_place_suggestion", "0", "10154343226501729", RegularImmutableSet.a);
        }

        public final String m4793a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: suggested_cover_photos */
    public class RejectPlaceSuggestionMutationString extends TypedGraphQLMutationString<RejectPlaceSuggestionMutationModel> {
        public RejectPlaceSuggestionMutationString() {
            super(RejectPlaceSuggestionMutationModel.class, false, "RejectPlaceSuggestionMutation", "15e09980197d101a61e0fd69d2173bd2", "user_reject_place_suggestion", "0", "10154343226496729", RegularImmutableSet.a);
        }

        public final String m4794a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
