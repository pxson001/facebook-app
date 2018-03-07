package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.ReachEstimateDataQueryModels.ReachEstimateQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: Video Home prefetch metadata query succeeded but result was null. */
public final class ReachEstimateDataQuery {

    /* compiled from: Video Home prefetch metadata query succeeded but result was null. */
    public class ReachEstimateQueryString extends TypedGraphQlQueryString<ReachEstimateQueryModel> {
        public ReachEstimateQueryString() {
            super(ReachEstimateQueryModel.class, false, "ReachEstimateQuery", "31a3b743d3975d4e4372d824f8971511", "node", "10153831077676729", RegularImmutableSet.a);
        }

        public final String m24246a(String str) {
            switch (str.hashCode()) {
                case -1464007031:
                    return "1";
                case -803333011:
                    return "0";
                case -117607801:
                    return "2";
                default:
                    return str;
            }
        }
    }
}
