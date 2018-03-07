package com.facebook.structuredsurvey.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsModels.StructuredSurveyFragmentModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: download_origin */
public final class StructuredSurveyQuery {

    /* compiled from: download_origin */
    public class StructuredSurveyQueryString extends TypedGraphQlQueryString<StructuredSurveyFragmentModel> {
        public StructuredSurveyQueryString() {
            super(StructuredSurveyFragmentModel.class, false, "StructuredSurveyQuery", "85920b53c572a1fd019a730735d89df8", "node", "10154517212361729", RegularImmutableSet.a);
        }

        public final String m24823a(String str) {
            switch (str.hashCode()) {
                case 1917932576:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
