package com.facebook.crowdsourcing.protocol.graphql;

import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingPlaceQuestionQueriesModels.FBCrowdsourcingPlaceQuestionsQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: tap_composer_post */
public final class CrowdsourcingPlaceQuestionQueries {

    /* compiled from: tap_composer_post */
    public class FBCrowdsourcingPlaceQuestionsQueryString extends TypedGraphQlQueryString<FBCrowdsourcingPlaceQuestionsQueryModel> {
        public FBCrowdsourcingPlaceQuestionsQueryString() {
            super(FBCrowdsourcingPlaceQuestionsQueryModel.class, false, "FBCrowdsourcingPlaceQuestionsQuery", "49410d50a24cd2a54f9c60e52248e993", "page", "10154405445046729", RegularImmutableSet.a);
        }

        public final String m2265a(String str) {
            switch (str.hashCode()) {
                case -1891177610:
                    return "3";
                case -803548981:
                    return "0";
                case -656813482:
                    return "2";
                case 576861023:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
