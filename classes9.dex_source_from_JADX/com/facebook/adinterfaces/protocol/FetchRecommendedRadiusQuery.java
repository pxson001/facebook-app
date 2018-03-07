package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdGeoCircleModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition.noPages */
public final class FetchRecommendedRadiusQuery {

    /* compiled from: VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition.noPages */
    public class FetchRecommendedRadiusQueryString extends TypedGraphQlQueryString<AdGeoCircleModel> {
        public FetchRecommendedRadiusQueryString() {
            super(AdGeoCircleModel.class, false, "FetchRecommendedRadiusQuery", "28918ffa3fc79ddcd369091f8602660a", "recommended_radius", "10153898510756729", RegularImmutableSet.a);
        }

        public final String m24236a(String str) {
            switch (str.hashCode()) {
                case 1871919611:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
