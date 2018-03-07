package com.facebook.crowdsourcing.protocol.graphql;

import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingViewerClaimsQueriesModels.CrowdsourcingClaimCountQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: tap_app_button */
public final class CrowdsourcingViewerClaimsQueries {

    /* compiled from: tap_app_button */
    public class CrowdsourcingClaimCountQueryString extends TypedGraphQlQueryString<CrowdsourcingClaimCountQueryModel> {
        public CrowdsourcingClaimCountQueryString() {
            super(CrowdsourcingClaimCountQueryModel.class, false, "CrowdsourcingClaimCountQuery", "638ba9dbaa6901d438f8f73276a7397f", "page", "10154405445031729", RegularImmutableSet.a);
        }

        public final String m2352a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                case 576861023:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
