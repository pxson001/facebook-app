package com.facebook.timeline.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.timeline.protocol.ProfileNuxCancelMutationModels.ProfileNuxCancelButtonMutationModel;
import com.facebook.timeline.protocol.ProfileNuxCancelMutationModels.ProfileNuxStartMutationModel;
import com.facebook.timeline.protocol.ProfileNuxCancelMutationModels.ProfileNuxViewMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: debug_mode */
public final class ProfileNuxCancelMutation {

    /* compiled from: debug_mode */
    public class ProfileNuxCancelButtonMutationString extends TypedGraphQLMutationString<ProfileNuxCancelButtonMutationModel> {
        public ProfileNuxCancelButtonMutationString() {
            super(ProfileNuxCancelButtonMutationModel.class, false, "ProfileNuxCancelButtonMutation", "0737f137e7956657ba4c706d07c1dbd5", "profile_wizard_nux_dismiss", "0", "10154204805576729", RegularImmutableSet.a);
        }

        public final String m26275a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: debug_mode */
    public class ProfileNuxStartMutationString extends TypedGraphQLMutationString<ProfileNuxStartMutationModel> {
        public ProfileNuxStartMutationString() {
            super(ProfileNuxStartMutationModel.class, false, "ProfileNuxStartMutation", "bdefcad413fa6f3a2348e7539551ef74", "profile_wizard_nux_start", "0", "10154204805566729", RegularImmutableSet.a);
        }

        public final String m26276a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: debug_mode */
    public class ProfileNuxViewMutationString extends TypedGraphQLMutationString<ProfileNuxViewMutationModel> {
        public ProfileNuxViewMutationString() {
            super(ProfileNuxViewMutationModel.class, false, "ProfileNuxViewMutation", "a3427c6ecb0769e5b51f803527d2ab52", "profile_wizard_nux_view", "0", "10154204805556729", RegularImmutableSet.a);
        }

        public final String m26277a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
