package com.facebook.securitycheckup.api;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.securitycheckup.api.SecurityCheckupLoggingMutationModels.SecurityCheckupLoggingMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: inbox2_vpv */
public final class SecurityCheckupLoggingMutation {

    /* compiled from: inbox2_vpv */
    public class SecurityCheckupLoggingMutationString extends TypedGraphQLMutationString<SecurityCheckupLoggingMutationModel> {
        public SecurityCheckupLoggingMutationString() {
            super(SecurityCheckupLoggingMutationModel.class, false, "SecurityCheckupLoggingMutation", "6d10142ac2d26f418de7a50234783457", "security_checkup_logging", "0", "10154204805401729", RegularImmutableSet.a);
        }

        public final String m9949a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
