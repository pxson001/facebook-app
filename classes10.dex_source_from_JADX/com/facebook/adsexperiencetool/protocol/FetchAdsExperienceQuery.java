package com.facebook.adsexperiencetool.protocol;

import com.facebook.adsexperiencetool.protocol.FetchAdsExperienceQueryModels.AdsExperienceFragmentModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: end_sessions */
public final class FetchAdsExperienceQuery {

    /* compiled from: end_sessions */
    public class FetchAdsExperienceQueryString extends TypedGraphQlQueryString<AdsExperienceFragmentModel> {
        public FetchAdsExperienceQueryString() {
            super(AdsExperienceFragmentModel.class, false, "FetchAdsExperienceQuery", "a72d26c1855cedf439f2a5657142345b", "node", "10154633847491729", RegularImmutableSet.a);
        }

        public final String m14596a(String str) {
            switch (str.hashCode()) {
                case -625627131:
                    return "0";
                case 109250890:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
