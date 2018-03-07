package com.facebook.securitycheckup.api;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.securitycheckup.api.SecurityCheckupLoginAlertsMutationModels.SecurityCheckupLoginAlertsMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: inbox2_click */
public final class SecurityCheckupLoginAlertsMutation {

    /* compiled from: inbox2_click */
    public class SecurityCheckupLoginAlertsMutationString extends TypedGraphQLMutationString<SecurityCheckupLoginAlertsMutationModel> {
        public SecurityCheckupLoginAlertsMutationString() {
            super(SecurityCheckupLoginAlertsMutationModel.class, false, "SecurityCheckupLoginAlertsMutation", "53cfd6fc9f2d868a6d84161839e295ce", "security_checkup_login_alerts", "0", "10154204805441729", RegularImmutableSet.a);
        }

        public final String m9956a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
