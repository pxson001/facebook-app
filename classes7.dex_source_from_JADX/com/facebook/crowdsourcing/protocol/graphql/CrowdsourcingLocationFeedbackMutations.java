package com.facebook.crowdsourcing.protocol.graphql;

import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingLocationFeedbackMutationsModels.CrowdsourcingUnknownRegionClaimModel;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingLocationFeedbackMutationsModels.CrowdsourcingWrongRegionReportModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: tap_listening_to_button */
public final class CrowdsourcingLocationFeedbackMutations {

    /* compiled from: tap_listening_to_button */
    public class CrowdsourcingUnknownRegionClaimString extends TypedGraphQLMutationString<CrowdsourcingUnknownRegionClaimModel> {
        public CrowdsourcingUnknownRegionClaimString() {
            super(CrowdsourcingUnknownRegionClaimModel.class, false, "CrowdsourcingUnknownRegionClaim", "fccf35175bf19b23626f1e7ebbcd8f87", "crowdsourcing_create_claim", "0", "10154276168146729", RegularImmutableSet.a);
        }

        public final String m2244a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: tap_listening_to_button */
    public class CrowdsourcingWrongRegionReportString extends TypedGraphQLMutationString<CrowdsourcingWrongRegionReportModel> {
        public CrowdsourcingWrongRegionReportString() {
            super(CrowdsourcingWrongRegionReportModel.class, false, "CrowdsourcingWrongRegionReport", "1d18d0796deabf7786d7d252be63da50", "crowdsourcing_region_report_incorrect", "0", "10154276583356729", RegularImmutableSet.a);
        }

        public final String m2245a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
