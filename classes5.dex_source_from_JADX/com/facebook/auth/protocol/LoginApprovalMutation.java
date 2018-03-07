package com.facebook.auth.protocol;

import com.facebook.auth.protocol.LoginApprovalMutationModels.LoginApprovalMutationModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: suggestion_message */
public final class LoginApprovalMutation {

    /* compiled from: suggestion_message */
    public class LoginApprovalMutationString extends TypedGraphQLMutationString<LoginApprovalMutationModel> {
        public LoginApprovalMutationString() {
            super(LoginApprovalMutationModel.class, false, "LoginApprovalMutation", "fd0a564b249e69d478e9bf01c1877ae8", "user_login_approval", "0", "10154204802666729", RegularImmutableSet.a);
        }

        public final String m3236a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final LoginApprovalMutationString m3237a() {
        return new LoginApprovalMutationString();
    }
}
