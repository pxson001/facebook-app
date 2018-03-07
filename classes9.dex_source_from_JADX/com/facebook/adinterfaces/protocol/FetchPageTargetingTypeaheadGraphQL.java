package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.FetchPageTargetingTypeaheadGraphQLModels.FetchPageTargetingTypeaheadInterestQueryModel;
import com.facebook.adinterfaces.protocol.FetchPageTargetingTypeaheadGraphQLModels.FetchPageTargetingTypeaheadLocationQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: WA */
public final class FetchPageTargetingTypeaheadGraphQL {

    /* compiled from: WA */
    public class FetchPageTargetingTypeaheadInterestQueryString extends TypedGraphQlQueryString<FetchPageTargetingTypeaheadInterestQueryModel> {
        public FetchPageTargetingTypeaheadInterestQueryString() {
            super(FetchPageTargetingTypeaheadInterestQueryModel.class, false, "FetchPageTargetingTypeaheadInterestQuery", "7a9329b5c157f970da980f5ed023cd15", "entities_named", "10154339186811729", RegularImmutableSet.a);
        }

        public final String m24176a(String str) {
            switch (str.hashCode()) {
                case 102976443:
                    return "1";
                case 107944136:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: WA */
    public class FetchPageTargetingTypeaheadLocationQueryString extends TypedGraphQlQueryString<FetchPageTargetingTypeaheadLocationQueryModel> {
        public FetchPageTargetingTypeaheadLocationQueryString() {
            super(FetchPageTargetingTypeaheadLocationQueryModel.class, false, "FetchPageTargetingTypeaheadLocationQuery", "21f37b7fa56f05ddd9859be53ab6fef3", "entities_named", "10154429293611729", RegularImmutableSet.a);
        }

        public final String m24177a(String str) {
            switch (str.hashCode()) {
                case 102976443:
                    return "2";
                case 107944136:
                    return "0";
                case 110844025:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
