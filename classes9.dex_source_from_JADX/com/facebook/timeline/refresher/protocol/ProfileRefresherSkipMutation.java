package com.facebook.timeline.refresher.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.timeline.refresher.protocol.ProfileRefresherSkipMutationModels.ProfileRefresherStepSkipMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: unified_thread_sync */
public final class ProfileRefresherSkipMutation {

    /* compiled from: unified_thread_sync */
    public class ProfileRefresherStepSkipMutationString extends TypedGraphQLMutationString<ProfileRefresherStepSkipMutationModel> {
        public ProfileRefresherStepSkipMutationString() {
            super(ProfileRefresherStepSkipMutationModel.class, false, "ProfileRefresherStepSkipMutation", "10f6202d4296ad118094dbb004fc5e93", "profile_wizard_refresher_step_skip", "0", "10154204805696729", RegularImmutableSet.a);
        }

        public final String m1174a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
