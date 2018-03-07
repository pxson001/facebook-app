package com.facebook.adsexperiencetool.protocol;

import com.facebook.adsexperiencetool.protocol.AdsExperienceMutationsModels.AdsExperienceDeclineMutationModel;
import com.facebook.adsexperiencetool.protocol.AdsExperienceMutationsModels.AdsExperienceInjectMutationModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: ephemeral_toggle */
public final class AdsExperienceMutations {

    /* compiled from: ephemeral_toggle */
    public class AdsExperienceDeclineMutationString extends TypedGraphQLMutationString<AdsExperienceDeclineMutationModel> {
        public AdsExperienceDeclineMutationString() {
            super(AdsExperienceDeclineMutationModel.class, false, "AdsExperienceDeclineMutation", "4c354858392008092c40e3f175ddf732", "ads_experience_decline", "0", "10154660598481729", RegularImmutableSet.a);
        }

        public final String m14521a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: ephemeral_toggle */
    public class AdsExperienceInjectMutationString extends TypedGraphQLMutationString<AdsExperienceInjectMutationModel> {
        public AdsExperienceInjectMutationString() {
            super(AdsExperienceInjectMutationModel.class, false, "AdsExperienceInjectMutation", "074e5eaf34f28778d50fa5d123a72dfb", "ads_experience_inject", "0", "10154660598526729", RegularImmutableSet.a);
        }

        public final String m14522a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
