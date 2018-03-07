package com.facebook.pages.launchpoint.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.launchpoint.graphql.FetchPagesLaunchpointDiscoverGraphQLModels.FetchPagesLaunchpointDiscoverQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: page_contact_us_leads */
public final class FetchPagesLaunchpointDiscoverGraphQL {

    /* compiled from: page_contact_us_leads */
    public class FetchPagesLaunchpointDiscoverQueryString extends TypedGraphQlQueryString<FetchPagesLaunchpointDiscoverQueryModel> {
        public FetchPagesLaunchpointDiscoverQueryString() {
            super(FetchPagesLaunchpointDiscoverQueryModel.class, false, "FetchPagesLaunchpointDiscoverQuery", "c1508da31fa2d46f5f4426b3839bca9a", "viewer", "10154595440366729", RegularImmutableSet.a);
        }

        public final String m5288a(String str) {
            switch (str.hashCode()) {
                case -1349119146:
                    return "0";
                case -588332180:
                    return "2";
                case 94851343:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
