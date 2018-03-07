package com.facebook.identitygrowth.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.identitygrowth.protocol.ProfileInfoTypeaheadInferenceGraphQLModels.ProfileInfoCurrentCityPredictionQueryModel;
import com.facebook.identitygrowth.protocol.ProfileInfoTypeaheadInferenceGraphQLModels.ProfileInfoTypeaheadInferenceQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: mFirstSurveyOption */
public final class ProfileInfoTypeaheadInferenceGraphQL {

    /* compiled from: mFirstSurveyOption */
    public class ProfileInfoCurrentCityPredictionQueryString extends TypedGraphQlQueryString<ProfileInfoCurrentCityPredictionQueryModel> {
        public ProfileInfoCurrentCityPredictionQueryString() {
            super(ProfileInfoCurrentCityPredictionQueryModel.class, false, "ProfileInfoCurrentCityPredictionQuery", "90b35702589cc08ee8028a742372a0e0", "viewer", "10154405018071729", RegularImmutableSet.a);
        }

        public final String m17854a(String str) {
            switch (str.hashCode()) {
                case -1389427104:
                    return "0";
                case -519230531:
                    return "2";
                case 1704455739:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: mFirstSurveyOption */
    public class ProfileInfoTypeaheadInferenceQueryString extends TypedGraphQlQueryString<ProfileInfoTypeaheadInferenceQueryModel> {
        public ProfileInfoTypeaheadInferenceQueryString() {
            super(ProfileInfoTypeaheadInferenceQueryModel.class, false, "ProfileInfoTypeaheadInferenceQuery", "12c30832fd6b35c8e4ab752e0397fb91", "viewer", "10154358537666729", RegularImmutableSet.a);
        }

        public final String m17855a(String str) {
            switch (str.hashCode()) {
                case -519230531:
                    return "2";
                case -418339213:
                    return "1";
                case 35780175:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
