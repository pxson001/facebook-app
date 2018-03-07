package com.facebook.survey.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.survey.graphql.FetchSurveyConfigModels.FetchSurveyConfigModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: disable_event_logging */
public final class FetchSurveyConfig {

    /* compiled from: disable_event_logging */
    public class FetchSurveyConfigString extends TypedGraphQlQueryString<FetchSurveyConfigModel> {
        public FetchSurveyConfigString() {
            super(FetchSurveyConfigModel.class, false, "FetchSurveyConfig", "11df02aee4d12532f470e7305efbd5df", "node", "10154341710591729", RegularImmutableSet.a);
        }

        public final String m24987a(String str) {
            switch (str.hashCode()) {
                case -1573000044:
                    return "1";
                case -881604461:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
