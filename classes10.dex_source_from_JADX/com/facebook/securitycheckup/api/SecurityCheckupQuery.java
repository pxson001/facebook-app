package com.facebook.securitycheckup.api;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.securitycheckup.api.SecurityCheckupQueryModels.SecurityCheckupQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: in_rollout */
public final class SecurityCheckupQuery {

    /* compiled from: in_rollout */
    public class SecurityCheckupQueryString extends TypedGraphQlQueryString<SecurityCheckupQueryModel> {
        public SecurityCheckupQueryString() {
            super(SecurityCheckupQueryModel.class, false, "SecurityCheckupQuery", "51c7fb40491c51eec4488c23dcb0b162", "viewer", "10154057594201729", RegularImmutableSet.a);
        }
    }
}
