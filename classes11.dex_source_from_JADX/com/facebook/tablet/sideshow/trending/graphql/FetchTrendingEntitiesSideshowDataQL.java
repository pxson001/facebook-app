package com.facebook.tablet.sideshow.trending.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.tablet.sideshow.trending.graphql.FetchTrendingEntitiesSideshowDataQLModels.FetchTrendingEntitiesSideshowDataModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: og_action_id */
public final class FetchTrendingEntitiesSideshowDataQL {

    /* compiled from: og_action_id */
    public class FetchTrendingEntitiesSideshowDataString extends TypedGraphQlQueryString<FetchTrendingEntitiesSideshowDataModel> {
        public FetchTrendingEntitiesSideshowDataString() {
            super(FetchTrendingEntitiesSideshowDataModel.class, false, "FetchTrendingEntitiesSideshowData", "b47c2819c161625963f2857d5bcb970d", "viewer", "10153551448961729", RegularImmutableSet.a);
        }

        public final String m6076a(String str) {
            switch (str.hashCode()) {
                case 94851343:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
