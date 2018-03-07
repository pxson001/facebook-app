package com.facebook.structuredsurvey.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: download_attempts */
public final class SurveyNotificationQuery {

    /* compiled from: download_attempts */
    public class FetchNotificationForSurveyString extends TypedGraphQlQueryString<FetchNotificationForSurveyModel> {
        public FetchNotificationForSurveyString() {
            super(FetchNotificationForSurveyModel.class, false, "FetchNotificationForSurvey", "bdba422b1cb4de82e6d64685ff181045", "node", "10154139593926729", RegularImmutableSet.a);
        }

        public final String m24827a(String str) {
            switch (str.hashCode()) {
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
