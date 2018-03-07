package com.facebook.contacts.pna.graphql;

import com.facebook.contacts.pna.graphql.AddPhoneNumberMutationModels.UserPhoneNumberAddCoreMutationFragmentModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: platform_context_id */
public final class AddPhoneNumberMutation {

    /* compiled from: platform_context_id */
    public class UserPhoneNumberAddCoreMutationString extends TypedGraphQLMutationString<UserPhoneNumberAddCoreMutationFragmentModel> {
        public UserPhoneNumberAddCoreMutationString() {
            super(UserPhoneNumberAddCoreMutationFragmentModel.class, false, "UserPhoneNumberAddCoreMutation", "dcbfcbc9b2190e511275ed3654c977c7", "user_phone_number_add", "0", "10154230784141729", RegularImmutableSet.a);
        }

        public final String m6848a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
