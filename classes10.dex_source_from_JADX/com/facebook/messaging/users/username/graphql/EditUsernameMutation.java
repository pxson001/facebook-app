package com.facebook.messaging.users.username.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.messaging.users.username.graphql.EditUsernameMutationModels.EditUsernameMutationFieldsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: pingActions */
public final class EditUsernameMutation {

    /* compiled from: pingActions */
    public class EditUsernameMutationString extends TypedGraphQLMutationString<EditUsernameMutationFieldsModel> {
        public EditUsernameMutationString() {
            super(EditUsernameMutationFieldsModel.class, false, "EditUsernameMutation", "d4ccb2eae9933b0ea9547c624cd75814", "user_change_username", "0", "10154561204256729", RegularImmutableSet.a);
        }

        public final String m4456a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
