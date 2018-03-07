package com.facebook.securitycheckup.api;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.securitycheckup.api.PasswordChangeMutationModels.PasswordChangeMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: inbox_banner_dismissed */
public final class PasswordChangeMutation {

    /* compiled from: inbox_banner_dismissed */
    public class PasswordChangeMutationString extends TypedGraphQLMutationString<PasswordChangeMutationModel> {
        public PasswordChangeMutationString() {
            super(PasswordChangeMutationModel.class, false, "PasswordChangeMutation", "dd2839cf220218e22d4a07bda27da940", "password_change", "0", "10154204805406729", RegularImmutableSet.a);
        }

        public final String m9942a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
