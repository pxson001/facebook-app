package com.facebook.registration.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.registration.protocol.UserInfoMutationsModels.UserUpdateGenderCoreMutationFieldsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: joinable_mode_thread_summary */
public final class UserInfoMutations {

    /* compiled from: joinable_mode_thread_summary */
    public class UserUpdateGenderCoreMutationString extends TypedGraphQLMutationString<UserUpdateGenderCoreMutationFieldsModel> {
        public UserUpdateGenderCoreMutationString() {
            super(UserUpdateGenderCoreMutationFieldsModel.class, false, "UserUpdateGenderCoreMutation", "1e4b0d6e491161bc22f6b2ff963ca55a", "user_update_gender", "0", "10154343227176729", RegularImmutableSet.a);
        }

        public final String m8908a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final UserUpdateGenderCoreMutationString m8909a() {
        return new UserUpdateGenderCoreMutationString();
    }
}
