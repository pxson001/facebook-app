package com.facebook.crowdsourcing.protocol.graphql;

import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingPlaceQuestionMutationsModels.CrowdsourcingPlaceQuestionAnswerSubmitModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: tap_footer_comment */
public final class CrowdsourcingPlaceQuestionMutations {

    /* compiled from: tap_footer_comment */
    public class CrowdsourcingPlaceQuestionAnswerSubmitString extends TypedGraphQLMutationString<CrowdsourcingPlaceQuestionAnswerSubmitModel> {
        public CrowdsourcingPlaceQuestionAnswerSubmitString() {
            super(CrowdsourcingPlaceQuestionAnswerSubmitModel.class, false, "CrowdsourcingPlaceQuestionAnswerSubmit", "4e7a95bb8541ab429211b7df68214b97", "crowdsourcing_place_question_submit_answer", "0", "10154204802781729", RegularImmutableSet.a);
        }

        public final String m2258a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
