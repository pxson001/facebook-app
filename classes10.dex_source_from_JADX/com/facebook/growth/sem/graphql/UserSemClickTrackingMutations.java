package com.facebook.growth.sem.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.growth.sem.graphql.UserSemClickTrackingMutationsModels.UserSemClickTrackingMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: voice_clips */
public final class UserSemClickTrackingMutations {

    /* compiled from: voice_clips */
    public class UserSemClickTrackingMutationString extends TypedGraphQLMutationString<UserSemClickTrackingMutationModel> {
        public UserSemClickTrackingMutationString() {
            super(UserSemClickTrackingMutationModel.class, false, "UserSemClickTrackingMutation", "b5e0246e51741958635a2646904dc829", "user_sem_click_tracking", "0", "10154228586986729", RegularImmutableSet.a);
        }

        public final String m487a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
