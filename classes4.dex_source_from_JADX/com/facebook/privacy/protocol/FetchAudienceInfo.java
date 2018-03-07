package com.facebook.privacy.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: sms_initial_enroll_time */
public final class FetchAudienceInfo {

    /* compiled from: sms_initial_enroll_time */
    public class FetchAudienceInfoForLoginString extends TypedGraphQlQueryString<FetchAudienceInfoModels$FetchAudienceInfoForLoginModel> {
        public FetchAudienceInfoForLoginString() {
            super(FetchAudienceInfoModels$FetchAudienceInfoForLoginModel.class, false, "FetchAudienceInfoForLogin", "af3037e2d2f89c2e082dc25ab6f6ea48", "viewer", "10154343226761729", RegularImmutableSet.a);
        }
    }

    /* compiled from: sms_initial_enroll_time */
    public class FetchAudienceInfoString extends TypedGraphQlQueryString<FetchAudienceInfoModels$FetchAudienceInfoModel> {
        public FetchAudienceInfoString() {
            super(FetchAudienceInfoModels$FetchAudienceInfoModel.class, false, "FetchAudienceInfo", "711e0308433d960350b45e89a76ffdf6", "viewer", "10154343226741729", RegularImmutableSet.a);
        }

        public final TriState m3564g() {
            return TriState.NO;
        }
    }
}
