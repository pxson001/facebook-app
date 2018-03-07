package com.facebook.timeline.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.timeline.protocol.ProfileIntroCardMutationModels.ProfileIntroCardBioMutationModel;
import com.facebook.timeline.protocol.ProfileIntroCardMutationModels.ProfileIntroCardFavPhotosMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: decode input file */
public final class ProfileIntroCardMutation {

    /* compiled from: decode input file */
    public class ProfileIntroCardBioMutationString extends TypedGraphQLMutationString<ProfileIntroCardBioMutationModel> {
        public ProfileIntroCardBioMutationString() {
            super(ProfileIntroCardBioMutationModel.class, false, "ProfileIntroCardBioMutation", "bb6d97d51dcdee769865b6e2a7e47403", "profile_intro_card_set", "0", "10154343228511729", RegularImmutableSet.a);
        }

        public final String m26225a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: decode input file */
    public class ProfileIntroCardFavPhotosMutationString extends TypedGraphQLMutationString<ProfileIntroCardFavPhotosMutationModel> {
        public ProfileIntroCardFavPhotosMutationString() {
            super(ProfileIntroCardFavPhotosMutationModel.class, false, "ProfileIntroCardFavPhotosMutation", "111147690db32ec9522158a6ce74b8c5", "profile_intro_card_photos_set", "0", "10154348325551729", RegularImmutableSet.a);
        }

        public final String m26226a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
